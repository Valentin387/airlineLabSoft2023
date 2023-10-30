<template>
  <spinner :showSpinner="showSpinner"></spinner>
  <div class="container light-style flex-grow-1 container-p-y">
    
    <div class="card card-large">
      <div class="row no-gutters row-bordered row-border-light">
        <div class="col-md-2 pt-0">
          <div class="list-group list-group-flush account-settings-links">
            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#account-general">Información Personal</a>
          </div>
        </div>
        <div class="col-md-9">
          <div class="tab-content">
            <div @submit="updateProfile" class="tab-pane fade active show" id="account-general">
              <div class="card-body media align-items-center">
                <img :src="profile.profileImage" required alt="Imagen de perfil" width="100" height="100">
                <div class="media-body ml-3">
                  <button @click="showAvatarGallery" class="btn btn-outline-primary">Cambiar Foto de perfil</button>
                  <div v-if="showGallery" class="avatar-gallery">
                    <img
                      v-for="(avatar, index) in avatarOptions"
                      :key="index"
                      :src="avatar"
                      @click="selectAvatar(avatar)"
                      alt="Avatar"
                    />
                  </div>
                </div>
              </div>
              <hr class="border-light m-0">
              <div class="card-body">
                <div class="form-group">
                  <label class="form-label">Usuario</label>
                  <input type="text" class="form-control" v-model="profile.username" required>
                  <!-- <p v-if="profile.username.length > 25">El usuario no puede tener más de 25 caracteres</p> -->
                </div>
                <div class="form-group">
                  <label class="form-label">Nombre</label>
                  <input type="text" class="form-control" v-model="profile.firstName" required>
                  <p v-if="!isValidFirstName">El nombre no es válido</p>
                </div>
                <div class="form-group">
                  <label class="form-label">Apellido</label>
                  <input type="text" class="form-control" v-model="profile.lastName" required>
                  <p v-if="!profile.lastName || profile.lastName.length > 25">El apellido no puede tener más de 25 caracteres</p>
                </div>
                <div class="form-group">
                  <label class="form-label">Correo Electrónico</label>
                  <input type="email" class="form-control" v-model="profile.email" required>
                  <p v-if="!profile.email || profile.email.length > 80">El correo electrónico no puede tener más de 30 caracteres</p>
                </div>
                <div class="form-group">
                  <label class="form-label">Fecha de Nacimiento</label>
                  <input type="label" class="form-control" v-model="formattedBirthday" required readonly>
                  <input type="date" class="form-control" v-model="profile.birthday" @input="validateBirthdate" required>
                  <p v-if="!isValidBirthday">{{ birthdateError }}</p>
                  
                </div>
                <div class="form-group">
                  <label class="form-label">Lugar de Nacimiento</label>
                  <input type="text" class="form-control" v-model="profile.birthPlace" required>
                </div>
                <div class="form-group">
                  <label class="form-label">Dirección de Facturación</label>
                  <input type="text" class="form-control" v-model="profile.billingAddress" required>
                </div>
                <div class="form-group">
                  <label class="form-label">DNI</label>
                  <input type="text" class="form-control" v-model="profile.dni" required>
                  <p v-if="!profile.dni || profile.dni.length > 10">El DNI no puede tener más de 10 caracteres</p>
                </div>
                <div class="form-group">
                  <label class="form-label">Género</label>
                  <select  class="form-control" id="gender" placeholder="Género" v-model="profile.gender">
                    <option value="male">Masculino</option>
                    <option value="female">Femenino</option>
                    <option value="Other">Otro</option>
                  </select>
                </div>
                <div class="form-group">
                  <div class="switch-button">
                    <label class="form-label">Suscribirse al módulo de noticias</label>
                    <input
                      type="checkbox"
                      name="switch-button"
                      id="switch-label"
                      class="switch-button__checkbox"
                      v-model="profile.subscribedToFeed"
                      required
                    />
                    <label for="switch-label" class="switch-button__label"></label>
                  </div>
                </div>
              </div>
              <div class="text-right mt-3 bt-3">
                <button type="submit" class="btn btn-primary" @click="updateProfile" required>Guardar Cambios</button>&nbsp;
                <button type="button" @click="redirectToPerfil" class="btn btn-outline-primary">Volver al perfil</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div style="margin-bottom: 20px;"></div>
    </div>
<!------------------------------------------------FOOTER------------------------------------------->
    <Footer></Footer>
    <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
    <success-modal :show-note="showSuccessMessage" :success-message="successMessage" @close="showSuccessMessage = false" />
  </div>
</template>
<style lang="scss">
     $light-color:#312c02;
     $degradado: rgba(149, 168, 238, 0.11);
     $bg:rgba(6, 31, 14, 0.947);
     $azul-claro: #CFE0EB;
     $gris:#F7F7F7;
     $verde: #00BD8E;
     $azul: #0D629B;
     $blanco: #FFFFFF;
     $negro:#1A1320;
     $accent:#0B97F4;
     $secondary:#ceeafd;
     html{
        /* 
        Estilo CSS para la vista Home.vue del proyecto Vue.js. 
        La propiedad font-size establece el tamaño de fuente base en 10px, lo que equivale a 62.5% del tamaño de fuente predeterminado del navegador. 
        La propiedad overflow-x:hidden oculta el desplazamiento horizontal de la página. 
        La propiedad scroll-behavior: smooth agrega un efecto de desplazamiento suave al hacer clic en los enlaces internos de la página. 
        La propiedad scroll-padding-top establece la cantidad de espacio de relleno en la parte superior de la página para compensar la barra de navegación fija. 
        */
        font-size: 62.5%;
        overflow-x:hidden;
        scroll-behavior: smooth;
        scroll-padding-top:9rem;

        /* 
        Estilos para la barra de desplazamiento en la vista Home.vue.
        Se utiliza el selector de pseudo-elemento &:: para aplicar estilos a la barra de desplazamiento.
        */
        &::-webkit-scrollbar{
            width:1rem;
        }

        &::-webkit-scrollbar-track{
            background: $accent;
        }

        &::-webkit-scrollbar-thumb{
            background-color: $azul;
        }

      }
     .container light-style flex-grow-1 container-p-y{
         background: #3B5998;
        }
   @mixin grid($val){
        display:grid;
        grid-template-columns: repeat(auto-fit, minmax($val, 1fr));
        gap:1.5rem;
    }

  /* Estilo para pantallas pequeñas */
    @media (min-width: 500px) {
        .ui-w-80 {
            width: 30% !important; /* Toma el ancho completo en pantallas pequeñas */
        }
        .card {
            margin-right: -5rem; /* Márgenes más amplios en pantallas de laptop */
            width: 100%; 
        }
    }

    @media (min-width: 700px) {
        .ui-w-80 {
            width: 30% !important; /* Toma el ancho completo en pantallas pequeñas */
        }
        .card {
            margin-right: -1rem; /* Márgenes más amplios en pantallas de laptop */
            width: 80%; 
        }
      
  
    }

    /* Estilo para pantallas de laptop (por ejemplo, 15.6 pulgadas) */
    @media (min-width: 992px) {
        .ui-w-80 {
         width: 8rem !important;
        }
        .card {
           
            width: 100%; 
            margin-right: -5rem; 
        }
    }

    @media (min-width: 1024px) {
        .ui-w-80 {
        width: 8rem !important;
        }
        .card {
            width: 100%; /* Márgenes más amplios en pantallas de laptop */
            margin-left: -1rem;
           
        }
    }
    .ui-w-80 {
        width: 8rem !important;
    }
    

    .btn-default {
        border-color: rgba(24, 28, 33, 0.1);
        background: rgba(195, 173, 173, 0);
        color: #222426;
    }

    

    label.btn {
        margin-bottom: 10;
    }

    .btn-outline-primary {
        border-color: $accent;
        background: transparent;
        color: $accent;
    }



    .btn {
        cursor: pointer;
    }

    .text-light {
        color:$azul!important;
    }

   

    .card{
        background-clip: padding-box;
        box-shadow: 0 6px 6px rgba(6, 6, 6, 0.1);
        
        background: $secondary;//FONDO DE LA CARD
        margin-top: 10rem;
        width:90vw;
        margin-right: -10%; 
    }

    .row-bordered {
        overflow: hidden;
    }

    .account-settings-fileinput {
        position: absolute;
        visibility: hidden;
        width: 1rem;
        height: 1rem;
        opacity: 0;
    }

    .account-settings-links .list-group-item.active {
        font-weight: bold !important;
    }

    html:not(.dark-style) .account-settings-links .list-group-item.active {
        background: transparent !important;
    }

    .account-settings-multiselect~.select2-container {
        width: 100% !important;
    }

    .light-style .account-settings-links .list-group-item {
        padding     : 0.85rem 1.5rem;
        border-color: rgba(24, 28, 33, 0.03) !important;
    }


    .light-style .account-settings-links .list-group-item.active {
    color: #0c0c0c !important;
    border: 1px solid #1363ae !important;
    border-radius: 1px !important;
    box-shadow: 0px 0px 5px rgba(19, 99, 174, 0.5) !important;
    background-color: #f5f5f5 !important;
    transition: all 0.3s ease-in-out !important;
}



    .light-style .account-settings-links .list-group-item {
        padding     : 0.85rem 1.5rem;
        border-color: rgba(24, 28, 33, 0.03) !important;
    }

 
    /* Aumenta el tamaño de las etiquetas en los formularios */
    .form-label {
        font-size: 1.8rem; /* Ajusta el tamaño según tus preferencias */
    }

    .form-group {
        font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
        input{
         font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
        }
        option{
            font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
        }
        select{
          font-size: 1.5rem;
        }
    }
    
    .custom-select{
        font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
    }
    .text-right .btn {
        margin-right: 1rem; /* Ajusta este valor según tus preferencias */
        padding: 0.5rem 2rem; /* Ajusta el relleno según tus preferencias */
    }
   

  //BOTÓN DESLIANTE 
    .switch-button {
        display: inline-block;
       
    }
    .switch-button .switch-button__checkbox {
        display: none;
    }
    .switch-button .switch-button__label {//BOTÓN INACTIVO
        background-color: $azul;//Color de fondo del botón deslizante
        width: 5rem;
        height: 3rem;
        border-radius: 3rem;
        display: inline-block;
        position: relative;
        
        
    }
    .switch-button .switch-button__label:before {
        transition: .2s;
        display: block;
        position: absolute;
        width: 3rem;
        height: 3rem;
        background-color: $blanco;//Color del circulo deslizante
        content: '';
        border-radius: 50%;
        box-shadow: inset 0px 0px 0px 1px $negro;
        
    }
    .switch-button .switch-button__checkbox:checked + .switch-button__label {
        background-color: $verde;//Color de fondo del botón deslizante
    }
    .switch-button .switch-button__checkbox:checked + .switch-button__label:before {
        transform: translateX(2rem);//Movimiento del circulo blanco 
   
    }

    
    .footer{  
        .box-container{
            @include grid(25rem);
            background:$secondary;
            padding: 3rem 2rem;
            margin-top: 10rem;
            width:90vw;
            
            .box{
                padding: 1rem 0;
                background:$secondary;
                .logo{
                    color:$negro;
                }
                h3{
                    font-size: 2.2rem;
                    color:$azul;
                    font-weight: bolder;
                    padding:1rem 0;
                    text-transform: capitalize;

                }

                p{
                    font-size: 1.4rem;
                    color:$negro;
                    padding:1rem 0;
                    line-height: 2;
                    i{//Iconos de informacion de contacto
                        padding-right:.5rem ;
                        color:$accent;
                    }

                    
                }

                .compartir{ //Seccion de redes sociales 
                    padding:1rem 0;

                    a{
                        
                        height: 4.5rem;
                        width: 4.5rem;
                        line-height:4rem;
                        font-size:2rem;
                        border-radius:50%;
                        font-size:1.7rem;
                        border: $accent .2rem solid;
                        color:$negro;
                        margin-right:1rem;
                        text-align:center ;

                        &:hover{
                            background:$azul;
                            color:$blanco;
                            border: $azul .2rem solid;
                            text-decoration-line: none;
                        }

                    }
                }
                .links{ //Links rapidos a secciones de la pagina
                    font-size: 1.4rem;
                    color: $negro;
                    padding: 1rem 0 ;
                    display: block;
                    text-transform: capitalize;
                    font-weight: bolder;

                    &:hover{
                        background-color: transparent;
                        color:$verde;
                        text-decoration: none;
                        i{
                        padding-right: 2rem;
                        }
                    }

                    i{
                        padding-right:.5rem ;
                        color:$accent;
                    }
                }
                form .email{
                    width: 100%;
                    border-radius: 5rem;
                    border:$accent solid .1rem;
                    background: none;
                    font-size:1.5rem;
                    text-transform: none;
                    color:$negro;
                    margin-top: 1rem;
                    padding: 1.4rem 1.4rem;


                }
            }

        }
    }
    .credit{//Autores de la pagina
        background: $secondary;
        text-align: center;
        font-size: 2rem;
        padding: 2rem 1rem;
        color: $verde;
        font-weight: bolder;
        margin-top: 5rem;

        span{ 
            color: $negro;
        }
    }
    
    .avatar-gallery {
        display: flex;
        flex-wrap: wrap;
    }

    .avatar-gallery img {
        width: 100px;
        height: 100px;
        margin: 5px;
        cursor: pointer;
    }
    
</style>

<script>
import updateProfileService from "@/services/userService/updateProfileService.js";
import { format } from 'date-fns'; // Importa la función de formato de date-fns
import viewProfileService from "@/services/userService/viewProfileService.js";
import errorModal from "@/components/ErrorModal.vue";
import spinner from "@/components/spinner.vue";
import successModal from "@/components/successModal.vue";
import { is } from "date-fns/locale";
import Footer from '@/components/footer.vue';

export default {
    data() { 
      return {
        showSpinner: false, // Initialize as hidden
        profile:{ 
            id: "",
            email: "",
            dni: "",
            firstName: "",
            lastName: "",
            birthday: "",
            birthPlace: "",
            billingAddress: "",
            gender: "",
            role: "",
            username: "",
            profileImage: "",
            active: "",
            subscribedToFeed: "",
            errorMessage: "",
        },
        isEditing:{
            id: "0",
            email: "0",
            dni: "0",
            firstName: "0",
            lastName: "0",
            birthday: "0",
            birthPlace: "0",
            billingAddress: "0",
            gender: "0",
            role: "0",
            username: "0",
            profileImage: "0",
            active: "",
            subscribedToFeed: "0",
            errorMessage: "",
        },
        showGallery: false,
        selectedAvatar: null,
        avatarOptions: [
            "https://bootdey.com/img/Content/avatar/avatar1.png",
            "https://bootdey.com/img/Content/avatar/avatar2.png",
            "https://bootdey.com/img/Content/avatar/avatar3.png",
            "https://bootdey.com/img/Content/avatar/avatar8.png",
            // Agrega más URLs de avatares según sea necesario
        ],
        originalProfile: {}, // To store the original profile before editing
        errorMessage: "",
        showErrorMessage: false,
        isValidFirstName: true,
        isValidBirthday: true,
        birthdateError: "",
        successMessage: "",
        showSuccessMessage: false,
      };
    },
    computed: {
        formattedBirthday() {
        // Formatea la fecha en un formato legible (por ejemplo, 'dd/MM/yyyy')
        return this.profile.birthday ? format(new Date(this.profile.birthday), 'yyyy-MM-dd') : '';
        },
    },
  
    created() {
        this.showSpinner = true;
    // Get the user ID from the JWT token in sessionStorage
        const token = window.sessionStorage.getItem('JWTtoken');
        const tokenData = JSON.parse(atob(token.split('.')[1]));
        const id = tokenData.ID;

        // Fetch user data and populate the profile object
        viewProfileService.viewProfile(id)
        .then(response => {
            this.profile = response.data;
            if (response.status == 200){
                this.showSpinner = false;
                console.log("User Profile", response.data);
                
                // You can redirect the user or perform other actions here.
          }
        })
        .catch(error => {
            this.showSpinner = false;
            // Handle login errors here
            if (error.response.status == 403){
                console.log("User not found sorry:", error.response.status, error);
                this.errorMessage = error.response.data.message || "User not found";
                this.showErrorMessage = true;
            }
            else {
                // You can redirect the user or perform other actions here.
                console.error("Something happened:", error);
                this.errorMessage = error.response.data.message || "Something happened";
                this.showErrorMessage = true;
            }
            // Display an error message to the user or take appropriate action.
                console.error('Error fetching user data:', error);
                this.errorMessage = error.response.data.message || "Error. Sesión expirada, cierra sesión y vuelve a iniciar sesión por favor";
                this.showErrorMessage = true;
        });
  },
    methods: {
        validateBirthdate() {
          const userBirthdate = this.profile.birthday;
          const currentDate = new Date();
          const currentDateString = currentDate.toISOString().split('T')[0];
          const eighteenYearsAgo = new Date();
          // Subtract 18 years from the current date
          eighteenYearsAgo.setFullYear(currentDate.getFullYear() - 18);
          const eighteenYearsAgoString = eighteenYearsAgo.toISOString().split('T')[0];

          if (userBirthdate > currentDateString) {
            //console.log("¡Ten cuidado McFly!, no puedes nacer en el futuro");
            this.birthdateError = "¡Ten cuidado McFly!, no puedes nacer en el futuro";
            this.isValidBirthday = false;
          } 
          else if (userBirthdate > eighteenYearsAgoString){
            this.birthdateError = "¡Ten cuidado McFly!, debes ser mayor de edad para registrarte";
            this.isValidBirthday = false;
          } else{
            this.birthdateError = '';
            this.isValidBirthday = true;
          }
        },

        showAvatarGallery() {
         this.showGallery = true;
        },
        selectAvatar(avatar) {
            this.selectedAvatar = avatar;
            // Aquí puedes guardar el avatar seleccionado en tu perfil
            this.profile.profileImage = avatar;
            console.log("Avatar seleccionado:", avatar);
            this.showGallery = false;
        },

        redirectToPerfil(){
            this.$router.push('/Perfil');
        },

        updateSubscribedToFeed() {
            // Actualizar el valor de subscribedToFeed aquí cuando se cambie el botón deslizante
            // Puedes establecerlo en true ya que se activa
            this.profile.subscribedToFeed = true;

            // Realizar una solicitud para actualizar el estado en la base de datos
        },
       
        toggleEdit(field) {
            this.isEditing[field] = !this.isEditing[field];
            if (this.isEditing[field]) {
                // Save the original value before editing
                this.originalProfile[field] = this.profile[field];
            } else {
                // Restore the original value if editing is canceled
                this.profile[field] = this.originalProfile[field];
            }
        },
        updateProfile() {

          if(!this.isValidFirstName || !this.isValidBirthday){
            this.errorMessage = "Datos no válidos, revisa que hayas llenado correctamente todos los campos";
                this.showErrorMessage = true;
                return;
            }
            this.showSpinner = true;
            //this.showSpinner = true;
            const token = window.sessionStorage.getItem("JWTtoken");
            const tokenData = JSON.parse(atob(token.split('.')[1]));

            // Assuming the token contains a field named 'id' with the user's ID
            const id = tokenData.ID;
            // Here, you can implement the logic to save changes to the backend or perform any necessary actions.
            // For now, we'll just disable editing.


            updateProfileService.updateProfile(id, this.profile.email, this.profile.dni, this.profile.firstName, this.profile.lastName, this.profile.birthday, this.profile.birthPlace, this.profile.billingAddress, this.profile.gender, this.profile.role, this.profile.username, this.profile.profileImage, this.profile.active, this.profile.subscribedToFeed)
                .then(response => {
                // Handle success
                    if (response.status == 200){
                        //confirm("User Profile updated");
                        //delete "password" value in response.data
                        delete response.data.password;
                        console.log("User Profile updated!!", response.data);
                        this.successMessage =  "Datos actualizados correctamente, si cambiaste tu email, te pedimos que vuelvas a iniciar sesión por favor";
                        this.showSuccessMessage = true;
                        this.showSpinner = false;
                        // You can redirect the user or perform other actions here.
                    }
                })
                .catch(error => {
                    this.showSpinner = false;
                    // Handle login errors here
                    if (error.response.status == 403){
                        console.log("User not found sorry:", error.response.status, error);
                        this.errorMessage = error.response.data.message || "User not found";
                        this.showErrorMessage = true;
                    }
                    else {
                        // You can redirect the user or perform other actions here.
                        console.error("Something happened:", error);
                        this.errorMessage = error.response.data.message || "Something happened";
                        this.showErrorMessage = true;
                    }
                    // Display an error message to the user or take appropriate action.
                        console.error('Error fetching user data, logout and login again please:', error);
                        this.errorMessage = error.response.data.message || "Error en la actualización, revisa los campos, si el error persiste, cierra sesión y vuelve a iniciar sesión por favor";
                        this.showErrorMessage = true;
                });

            
        },
        cancelChanges() {
            // Cancel editing and revert changes to the original values
                Object.keys(this.isEditing).forEach((field) => {
                    this.isEditing[field] = false;
                    this.profile[field] = this.originalProfile[field];
                });
            },
    }, 
    components: {
        errorModal,
        spinner,
        Footer,
        successModal,
  },     
};
</script>