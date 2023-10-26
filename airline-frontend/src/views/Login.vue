<template>
  <div class="page-container">
    <spinner :showSpinner="showSpinner"></spinner>
    <div class="left-content">
      <img class="imageReset-container" alt="">
      <div class="left-content-inner">
        <hr>
          <h1 class="tittle">Bienvenido a AirTravel</h1>
          <hr>
          <div class="text-login">
            <p>Somos tu pasaporte hacia el mundo de la aviación. Con una amplia gama de destinos, ofertas irresistibles y un servicio excepcional, estamos aquí para hacer realidad tus sueños de viaje. Descubre vuelos asequibles, reserva con facilidad y despega hacia tus aventuras. En AirTravel, volamos alto para que tú también lo hagas. ¡Prepara tus maletas y comencemos a explorar el mundo juntos!</p>
          </div>
          
      </div>
     
    </div>
    <div class="login-container">
      <hr>
        <h1>Iniciar Sesión</h1>
        <hr><hr>
        <form @submit.prevent="login" id="login-form">
            <input type="email" id="email" placeholder="Email" v-model="email" required>
            <input type="password" id="password" placeholder="Password" v-model="password" required>
            <div class="box-recovery-password">
              <button id="recovery-password" class="recovery-password" @click.prevent="redirectToRecoverPassword">¿Olvidaste tu contraseña?</button>
            </div>
            <button id="login" class="login"  type="submit">Iniciar Sesión</button>
        </form>



        <hr>
        <p id="text2" class="text">o</p>
        <!-- Mostrar mensaje de error como modal -->
        <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
        <!-- <p id="error-message" class="error-message">{{ errorMessage }}</p> -->
        <button id="register" class="register" @click.prevent="redirectToSignUp">Registrarse</button>
    </div>
  </div>
</template>


<style lang="scss"  >
  $light-color:#312c02;
  $degradado: rgba(33, 36, 36, 0.552);
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

  .page-container {
      height: 85vh;
      box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);

      width: 90vw;
      margin: 0 auto; /* Centrar horizontalmente */
      margin-top: 10rem; /* Centrar verticalmente */
      border-radius: 10px;
      display: flex;
      justify-content: space-between;
      overflow: hidden;
      

      .left-content {
       /* Fondo gris */
       padding: 4rem;
        text-align: center;
        color: #ccc;
        text-shadow: #000000;
        width: 50%;
        background: linear-gradient( $bg, $degradado), url("src/assets/buenosaires.jpg") no-repeat center/cover;
        box-sizing: border-box;
      }
     

    .login-container {
      width: 50%;
      display: flex;
      flex-direction: column;
      align-items: center;
      text-align: center;
      padding-top: 3rem;
      background-color: $azul-claro; 

      h1 {
        margin: 0;
      }

      input {
          width: 80%;
          margin-top: 10rem;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
      }

      .login {
        width: 80%;
        padding: 10px;
        margin-top: 45px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }

      .box-recovery-password{
        position: relative;
        
        .recovery-password{
          font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
          background-color: transparent;
          position: absolute;
          top: 0;
          right: 0; 
        }
      }

      .register {
        width: 40%;
        padding: 10px;
        
        background-color: #77797a;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }

      .left-content-inner {
        margin-right: 40px; /* Agregar margen derecho de 40px entre el título y el texto */
      }

      .tittle {
        margin-top: 20px;
      }

      .text-login p {
        margin-top: 80px;
        text-align: center;
        margin: 10px 0;
        
      }

      .text1{
        font-family: 'Courier New', Courier, monospace;
        font-size: small;
        text-align: right;
      }

      .text2{
        font-family: 'Courier New', Courier, monospace;
        font-size: small;
        text-align: center;
        margin-top: 10px;
      }

      .error-message {
          color: red;
      }

    }

    @media screen and (max-width: 1000px) {
        .page-container {
            width: 70%;
            margin-top: 10rem;
        }
        .login-container {
            width: 100%;
            border-radius: 5px;
        }
        
        .left-content {
            display: none;
        }  
    }

    @media screen and (max-width: 650px) {
        .page-container {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .page-container{
            height: 100%;
            margin-top:10rem;
        }

        .login-container {
           .texto{
                margin-top:5rem ;
            }
            
            
        }
    }
      
  }

</style>

<script>
import LoginService from "@/services/authenticationService/LoginService.js";
import errorModal from "@/components/ErrorModal.vue";
import spinner from "@/components/spinner.vue";

export default {
    data() { 
      return {
        email: "",
        password: "",
        errorMessage: "",
        showErrorMessage: false,
        showSpinner: false, // Initialize as hidden
      };
    },
  methods: {
      login() {
        this.showSpinner = true; // Initialize as hidden
        const { email, password } = this;
        
        // Call the LoginService.login method
        LoginService.login(email, password)
          .then((response) => {
            // Handle the successful login response here
            if (response.status == 200){
              this.showSpinner = false;
              // Extract the JWT token from the response data
              const token = response.data.token;
              // Save the JWT token in the localStorage
              window.sessionStorage.setItem("JWTtoken", token);
              console.log("Login successful:", response.data);

              // You can redirect the user or perform other actions here.
              this.$router.push('/');
            }
          })
          .catch((error) => {
            this.showSpinner = false;
            // Handle login errors here
            if (error.response.status == 401){
              console.log("Login failed:", error.response.status, error);
              this.errorMessage = "Login failed";
              this.showErrorMessage = true;
            } 
            if (error.response.status == 403){
              console.log("User not found sorry:", error.response.status, error);
              this.errorMessage = "User not found sorry";
              this.showErrorMessage = true;
            }
            else {
              // You can redirect the user or perform other actions here.
              console.error("Something happened:", error);
              this.errorMessage = "Something happened";
              this.showErrorMessage = true;
            }
            // Display an error message to the user or take appropriate action.
          });
      },
      redirectToSignUp() {
        // Add navigation logic to your sign-up page here
        console.log("Redirecting to sign-up page");
        this.$router.push('/signup');
      },
      redirectToRecoverPassword(){
        console.log("Redirecting to recoverPassword page");
        this.$router.push('/recoverpassword');
      }
  },
  components: {
    errorModal,
    spinner,
  },
};
</script>