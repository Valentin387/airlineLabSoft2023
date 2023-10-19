<template>
  <div class="page-container">
    <div class="left-content">
      <div class="left-content-inner">
        <h1 class="tittle">Bienvenido a AirTravel</h1>
        <div class="text-login">
          <p>Somos tu pasaporte hacia el mundo de la aviación. Con una amplia gama de destinos, ofertas irresistibles y un servicio excepcional, estamos aquí para hacer realidad tus sueños de viaje. Descubre vuelos asequibles, reserva con facilidad y despega hacia tus aventuras. En AirTravel, volamos alto para que tú también lo hagas. ¡Prepara tus maletas y comencemos a explorar el mundo juntos!</p>
        </div>
      </div>
    </div>
    <div class="login-container">
        <h1>Iniciar Sesión</h1>
        <form @submit.prevent="login" id="login-form">
            <input type="email" id="email" placeholder="Email" v-model="email" required>
            <input type="password" id="password" placeholder="Password" v-model="password" required>
            <div class="box-recovery-password">
            <button id="recovery-password" class="recovery-password" @click.prevent="redirectToRecoverPassword">¿Olvidaste tu contraseña?</button>
            </div>
            <button id="login" class="login" @click.prevent="login" type="submit">Iniciar Sesión</button>
        </form>
        <p id="text2" class="text">o</p>
        <p id="error-message" class="error-message">{{ errorMessage }}</p>
        <button id="register" class="register" @click.prevent="redirectToSignUp">Registrarse</button>
    </div>
  </div>
</template>


<style lang="scss"  >
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
        background-color: #f2f2f2; /* Fondo gris */
        text-align: center;
        width: 50%;
        box-sizing: border-box;
     }


    .login-container {
      width: 50%;
      display: flex;
      flex-direction: column;
      align-items: center;
      text-align: center;
      padding-top: 3rem;
        

      h1 {
        margin: 0;
      }

      input {
          width: 100%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
      }

      .login {
        width: 100%;
        padding: 10px;
        margin-top: 40px;
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
          background-color: #fff;
          position: absolute;
          top: 0;
          right: 0; 
        }
      }

      .register {
        width: 300px;
        padding: 10px;
        margin-top: 10px;
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

      .text-login {
        margin-top: 80px;
        text-align: center;
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

export default {
    data() { 
      return {
        email: "",
        password: "",
        errorMessage: "",
      };
    },
  methods: {
      login() {
        const { email, password } = this;
        
        // Call the LoginService.login method
        LoginService.login(email, password)
          .then((response) => {
            // Handle the successful login response here
            if (response.status == 200){
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
            // Handle login errors here
            if (error.response.status == 401){
              console.log("Login failed:", error.response.status, error);
              this.errorMessage = error.response.data.message;
            } 
            if (error.response.status == 403){
              console.log("User not found sorry:", error.response.status, error);
              this.errorMessage = error.response.data.message;
            }
            else {
              // You can redirect the user or perform other actions here.
              console.error("Something happened:", error);
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
};
</script>