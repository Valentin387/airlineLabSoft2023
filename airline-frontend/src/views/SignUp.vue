<template>
  <div class="registration-box">
    <spinner :showSpinner="showSpinner"></spinner>
    <div class="registration-container">
        <h1 class ="title">Crear Cuenta</h1>
      <form id="registration-form" @submit.prevent="createAccount">
        <div class="card-body media align-items-center">
          <img :src="profileImage" required alt="Imagen de perfil" width="100" height="100">
          <div class="media-body ml-3">
            <button @click="showAvatarGallery" class="btn btn-outline-primary">Agregar foto de perfil</button>
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
            <!-- Nombre Completo -->
            <input type="text" id="firstName" placeholder="Nombre" v-model="firstName" required>
            <p v-if="!isValidFirstName">El nombre no es válido</p>
            
            <!-- Apellido -->
            <input type="text" id="lastName" placeholder="Apellido" v-model="lastName" required>
            <p v-if="lastName.length > 25">El apellido no puede tener más de 25 caracteres</p>

            <!-- Lugar de Nacimiento -->
            <input type="text" id="birth-place" placeholder="Lugar de Nacimiento" v-model="birthPlace" required>

            <!-- Fecha de Nacimiento -->
            <input type="date" class="birth-place" v-model="birthDate" @input="validateBirthdate" required>
             <p v-if="!isValidBirthday">{{ birthdateError }}</p>

            <!-- Direccion de Facturacion -->
            <input type="text" id="billing-address" placeholder="Dirección de Facturación" v-model="billingAddress" required>

            <!-- DNI -->
            <input type="text" id="DNI" placeholder="Documento" v-model="DNI" required>
            <p v-if="DNI.length > 10">El DNI no puede tener más de 10 caracteres</p>

            <!-- Género -->
            <select id="gender" placeholder="Género" v-model="gender">
              <option value="male">Masculino</option>
              <option value="female">Femenino</option>
              <option value="Other">Otro</option>
            </select>

            <!-- Email -->
            <input type="email" id="email" placeholder="Correo Electrónico" v-model="email" required>
            <p v-if="email.length > 80">El correo electrónico no puede tener más de 30 caracteres</p>

            <!-- Usuario -->
            <input type="text" id="username" placeholder="Usuario" v-model="username" required>
            <p v-if="username.length > 25">El usuario no puede tener más de 25 caracteres</p>

            <!-- Contraseña -->
            <input type="password" id="password" placeholder="Contraseña" v-model="password" required>
            <p v-if="password.length < 8 || password.length > 30">La contraseña debe tener entre 8 y 30 caracteres</p>
          </div>
        </div>
  
        <button id="create-account" class="create-account" @submit.prevent="createAccount" type="submit">Crear Cuenta</button>
        </form>
        <p id="text1">o</p>
        <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
        <p>¿Ya tienes una cuenta?</p>
        <button id="login" class="login" @click.prevent="redirectToLogin">Iniciar sesión</button>
    </div>
  </div>
  <!------------------------------------------------FOOTER------------------------------------------->
  <Footer></Footer>
</template>
  
<style lang="scss" scoped >
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

  
    .registration-box {
      
      width: 90vw; 
      margin: 2vw auto; /* Centrar horizontalmente */ 
      margin-top: 10rem; /* Centrar verticalmente */ 
      border-radius: 10px; 
      display: flex; 
      justify-content: space-between; 
      overflow: hidden; 
      text-align: center; 


      .form-group {
        margin: 10px 0;
        padding: 20px;
      }

      .title {
        text-transform: capitalize;
        font-size: 2.25rem;
        font-weight: 600;
        letter-spacing: 1px;
        color: $azul;
      }
      
      label {
          display: block;
          font-weight: bold;
      }
      
      input, select {
      
          width: 70%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
      }
      
      .create-account {
          width: 40%;
          padding: 7px;
          background-color: #007bff;
          color: #fff;
          border: none;
          border-radius: 5px;
          cursor: pointer;
      }
      
      .login{
          width: 30%;
          padding: 7px;
          background-color: #676d72;
          color: #fff;
          border: none;
          border-radius: 5px;
          cursor: pointer;
      }

      .login-link:hover {
          text-decoration: underline;
      }

      .profile-picture {
          width: 30px;
      }

      .text1{
          font-family: 'Courier New', Courier, monospace;
          font-size: small;
          text-align: center;
          margin-top: 30px;
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



    }

   

    @media screen and (max-width: 1000px) {
        .registration-box {
            width: 70%;
            margin-top: 10rem;
        }
        .registration-container {
            width: 100%;
            border-radius: 5px;
        }
    }

    @media screen and (max-width: 650px) {
        .registration-box {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .registration-box{
            height: 100%;
            margin-top:10rem;
        }

        .registration-container {
           .texto{
                margin-top:5rem ;
            }
        }
    }
</style>

<script>
import registerService from "@/services/authenticationService/registerService.js";
import errorModal from "@/components/ErrorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from '@/components/footer.vue';

export default {
  components: {
    errorModal,
    spinner,
    Footer,
  },
  data() {
    return {
      isValidBirthday: true,
      birthdateError: "",

      firstName: "",
      lastName: "",
      birthPlace: "",
      birthDate: "",
      billingAddress: "",
      DNI: "",
      gender: "",
      email: "",
      username: "",
      password: "",
      profileImage: "",
      errorMessage: "",
      showErrorMessage: false,
      isValidFirstName: true,
      showSpinner: false,

      showGallery: false,
        selectedAvatar: null,
        avatarOptions: [
            "https://bootdey.com/img/Content/avatar/avatar1.png",
            "https://bootdey.com/img/Content/avatar/avatar2.png",
            "https://bootdey.com/img/Content/avatar/avatar3.png",
            "https://bootdey.com/img/Content/avatar/avatar8.png",
            // Agrega más URLs de avatares según sea necesario
        ],
    };
  },

  methods: {

    validateBirthdate() {
      const userBirthdate = this.birthDate;
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
        this.profileImage = avatar;
        console.log("Avatar seleccionado:", avatar);
        this.showGallery = false;
    },

    createAccount() {
      this.showSpinner = true;
      if (this.password.length < 8 || this.password.length > 30) {
        console.log("La contraseña no esta dentro del limite");
        this.errorMessage =  "La contraseña debe ser menor a 30 y mayor a 8 carácteres";
        this.showErrorMessage = true;
        this.showSpinner = false;
        return;
      }

      if(!this.isValidFirstName || !this.isValidBirthday){
        this.errorMessage = "Datos no válidos, revisa que hayas llenado correctamente todos los campos";
        this.showErrorMessage = true;
        return;
      }

      if (isNaN(this.firstName) && this.firstName.length <= 25) {
        this.isValidFirstName = true;

      // Recopila todos los datos del formulario y crea un objeto con ellos
      const { DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender,  username, profileImage, errorMessage } = this;
      // Llama al servicio de registro para crear la cuenta
      registerService.register(DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender,  username, profileImage)
        .then((response) => {
          this.showSpinner = false;
          // Maneja la respuesta exitosa aquí
          if (response.status === 200) {
            console.log("Cuenta creada exitosamente:", response.data);
            const token = response.data.token;
            window.sessionStorage.setItem("JWTtoken", token);
            // Redirige al usuario o realiza otras acciones según tus necesidades
            this.$router.push('/');
          }
        })
        .catch((error) => {
          this.showSpinner = false;
          if (error.response.status == 401){
            console.log("Login failed:", error.response.status, error);
            this.errorMessage =  "Signup failed.Error 401";
            this.showErrorMessage = true;
          } 
          if (error.response.status == 403){
            console.log("User not found sorry:", error.response.status, error);
            this.errorMessage =  "Signup failed.Error 403";
            this.showErrorMessage = true;
          }
          else {
            // You can redirect the user or perform other actions here.
            this.errorMessage = "Error en el registro, revisa los campos, si el error persiste, cierra sesión y vuelve a iniciar sesión por favor";
            this.showErrorMessage = true;
            console.error("Something happened:", error);
          }
        });

      } else {
        console.log("El nombre no puede ser un numero o no esta dentro del limite");
        this.isValidFirstName = false;
        this.errorMessage =  "El nombre no puede ser un numero o no esta dentro del limite";
        this.showErrorMessage = true;
      }
    },
    /*uploadProfilePicture(event) {
      const file = event.target.files[0];
      this.profilePicture = file;
      // Puedes agregar lógica adicional aquí para manejar la imagen del perfil si es necesario
    },*/
    redirectToLogin() {
      console.log("Redirigiendo a la página de inicio de sesión");
      this.$router.push('/login');
    }
  }
};
</script>

