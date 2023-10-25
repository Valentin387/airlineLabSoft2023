<template>
 

        <div class="container light-style flex-grow-1 container-p-y">
            <div class="card card-large">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-2 pt-0">
                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action active" data-toggle="list"
                                href="#account-general">Información Personal</a>
                         
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content">
                            <div  @submit="updateProfile" class="tab-pane fade active show" id="account-general">
                                <div class="card-body media align-items-center">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="d-block ui-w-80">
                                    <div class="media-body ml-3">
                                        <label class="btn btn-outline-primary">
                                            Foto de perfil
                                            <input type="file" class="account-settings-fileinput" >
                                        </label> &nbsp;
                                        
                                        <div class="text-light small mt-1">Permitido JPG, GIF or PNG. Tamaño máximo 800K</div>
                                    </div>
                                </div>
                                <hr class="border-light m-0">
                                <div class="card-body">
                                    <div class="form-group ">
                                        <label class="form-label" >Usuario</label>
                                        <input type="text" class="form-control"  v-model="profile.username" required >
                                        <p v-if="profile.username.length > 25">El usuario no puede tener más de 25 caracteres</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Nombre</label>
                                        <input type="text" class="form-control"  v-model="profile.firstName" required >
                                        <p v-if="!isValidFirstName">El nombre no es válido</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Apellido</label>
                                        <input type="text" class="form-control" v-model="profile.lastName" required >
                                        <p v-if="profile.lastName.length > 25">El apellido no puede tener más de 25 caracteres</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Correo Electrónico</label>
                                        <input type="email" class="form-control mb-1"  v-model="profile.email" required >
                                        <p v-if="profile.email.length > 80">El correo electrónico no puede tener más de 30 caracteres</p>
                                       <!-- <div class="alert alert-warning mt-3">
                                            Tu correo no ha sido confirmado. Verifica tu bandeja de entrada.<br>
                                            <a href="javascript:void(0)">Reenviar confirmación</a>
                                        </div> --> 
                                    </div>


                                    <div class="form-group"> 
                                        <label class="form-label">Fecha de Nacimiento</label> 
                                        <input type="date" class="form-control" v-model="formattedBirthday" required > 
                                    </div> 
                                    <div class="form-group">
                                        <label class="form-label">Lugar de Nacimiento</label>
                                        <input type="text" class="form-control" v-model="profile.birthPlace" required >
                                    </div>

                                    <div class="form-group">
                                        <label class="form-label">Dirección de Facturación</label>
                                        <input type="text" class="form-control" v-model="profile.billingAddress" required >
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">DNI</label>
                                        <input type="text" class="form-control" v-model="profile.dni" required >
                                        <p v-if="profile.dni.length > 10">El DNI no puede tener más de 10 caracteres</p>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Género</label> <br>
                                        <select id="gender" placeholder="Género" v-model="profile.gender">
                                            <option value="male">Masculino</option>
                                            <option value="female">Femenino</option>
                                            <option value="Other">Otro</option>
                                        </select>
                                          
                                        <!--    <select class="custom-select" v-model="profile.gender" required readonly>
                                            <option selected> </option>
                                            <option>Hombre</option>
                                            <option>Mujer</option>
                                            <option>Prefiero no decirlo</option>  -->
                                    </div>

                                    <div class="form-group" >
                                        <div class="switch-button">
                                            <label class="form-label">Suscribirse al módulo de noticias</label>
                                            <!-- Checkbox -->
                                            <input
                                                type="checkbox"
                                                name="switch-button"
                                                id="switch-label"
                                                class="switch-button__checkbox"
                                                v-model="profile.subscribedToFeed"
                                                required
                                            />
                                            <!-- Botón -->
                                            <label for="switch-label" class="switch-button__label"></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-right mt-3 bt-3">
                                    <button type="submit" class="btn btn-primary"  @click="updateProfile" required>Guardar Cambios</button>&nbsp;
                                    <button type="button" @click="redirectToPerfil" class="btn btn-default">Volver al perfil</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
               
                <div style="margin-bottom: 20px;"></div> 
            </div>
            <footer class="footer">
                    <div class="box-container">
                        <div class="box"  >
                            <h3 href="/" class="logo"><i class="fas fa-paper-plane"></i>AirTravel</h3>
                            <p> Elige más que un tiquete; elige una experiencia de viaje excepcional con nosotros.</p>
                            <div class="compartir">
                                <a href="#" class="fab fa-facebook-f"></a>
                                <a href="#" class="fab fa-twitter"></a>
                                <a href="#" class="fab fa-instagram"></a>
                                <a href="#" class="fab fa-github"></a>
                            </div>
                        </div>

                        <div class="box">
                            <h3>Links</h3>
                            <a href="/" class="links"><i class="material-symbols-outlined">chevron_right</i>Inicio</a>
                            <a href="/Check-In" class="links"><i class="material-symbols-outlined">chevron_right</i>Confirmar Check-in</a>
                            <a href="/Ayuda" class="links"><i class="material-symbols-outlined">chevron_right</i>Ayuda</a>
                                <a href="/Contactanos" class="links"><i class="material-symbols-outlined">chevron_right</i> contáctanos</a>

                        </div>
                        <div class="box">
                            <h3> Información de contacto </h3>
                            <p><i class="material-symbols-outlined">map</i>Pereira, Colombia</p>
                            <p><i class="material-symbols-outlined">call</i>+57 123-456-7890</p>
                            <p><i class="material-symbols-outlined">mail</i>airtravellabsoft@gmail.com</p>
                        </div>
                        <div class="box">
                            <h3>Boletín informativo</h3>
                            <p>Suscríbete para conocer las últimas actualizaciones</p>
                            <form action = "">
                                <input type="email" placeholder="Ingrese su correo" class="email" id="">
                                <input type="submit" value="Suscribirse" class="btn">
                            </form>
                        </div>
                    </div>
            </footer>
            <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
        </div>
    <!------------------------------------------------FOOTER------------------------------------------->

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
    
</style>

<script>
import updateProfileService from "@/services/userService/updateProfileService.js";
import { format } from 'date-fns'; // Importa la función de formato de date-fns
import viewProfileService from "@/services/userService/viewProfileService.js";
import errorModal from "@/components/ErrorModal.vue";


export default {
    data() { 
      return {
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
        originalProfile: {}, // To store the original profile before editing
        errorMessage: "",
        showErrorMessage: false,
        isValidFirstName: true,
      };
    },
    computed: {
        formattedBirthday() {
        // Formatea la fecha en un formato legible (por ejemplo, 'dd/MM/yyyy')
        return this.profile.birthday ? format(new Date(this.profile.birthday), 'yyyy-MM-dd') : '';
        },
    },
  
    created() {
    // Get the user ID from the JWT token in sessionStorage
        const token = window.sessionStorage.getItem('JWTtoken');
        const tokenData = JSON.parse(atob(token.split('.')[1]));
        const id = tokenData.ID;

        // Fetch user data and populate the profile object
        viewProfileService.viewProfile(id)
        .then(response => {
            this.profile = response.data;
            if (response.status == 200){
                console.log("User Profile", response.data);
                
                // You can redirect the user or perform other actions here.
          }
        })
        .catch(error => {
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
                this.errorMessage = error.response.data.message || "Error fetching user data";
                this.showErrorMessage = true;
        });
  },
    methods: {

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

                        console.log("User Profile updated!!", response.data);
                        // You can redirect the user or perform other actions here.
                    }
                })
                .catch(error => {
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
                        this.errorMessage = error.response.data.message || "Error fetching user data";
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
  },     
};
</script>