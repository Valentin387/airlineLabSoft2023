<template>
      <div class="page-container">
        <div class="left-content">
          <h1>Bienvenido a AirTravel</h1>
          <p>Somos tu pasaporte hacia el mundo de la aviación. Con una amplia gama de destinos, ofertas irresistibles y un servicio excepcional, 
            estamos aquí para hacer realidad tus sueños de viaje. 
            Descubre vuelos asequibles, reserva con facilidad y despega hacia tus aventuras. 
            En AirTravel, volamos alto para que tú también lo hagas. 
            ¡Prepara tus maletas y comencemos a explorar el mundo juntos!</p>
        </div>
        <div class="login-container">
            <h1>Iniciar Sesión</h1>
            <form id="login-form">
                <input type="email" id="email" placeholder="Email" v-model="email" required>
                <input type="password" id="password" placeholder="Password" v-model="password" required>
                <p id="text1" class="text1">¿Olvidaste tu contraseña?</p>
                <button id="login" class="login" @click="login" type="submit">Iniciar Sesión</button>
            </form>
            <p id="text2" class="text">o</p>
            <p id="error-message" class="error-message">{{ errorMessage }}</p>
            <button id="register" class="register" @click="redirectToSignUp">Registrarse</button>
        </div>
      </div>
</template>


<style lang="scss"  >
    .page-container {
        display: flex;
        justify-content: flex-end; /* Alinea login-container a la derecha */
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .left-content {
        background-color: #f2f2f2; /* Fondo gris */
        padding: 20px;
        max-width: 50%; /* Ajusta el ancho según tus necesidades */
        text-align: center;
    }


    .login-container {
        text-align: center;
        padding: 20px;
        max-width: 50%;

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
          margin-top: 10px;
          background-color: #007bff;
          color: #fff;
          border: none;
          border-radius: 5px;
          cursor: pointer;
      }

      .register {
          width: 60%;
          padding: 10px;
          margin-top: 10px;
          background-color: #77797a;
          color: #fff;
          border: none;
          border-radius: 5px;
          cursor: pointer;
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

</style>

<script>
import LoginService from "@/services/LoginService.js";

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
          } if (error.response.status == 403){
            console.log("User not found sorry:", error.response.status, error);
            this.errorMessage = error.response.data.message;
          }else {
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
  },
};
</script>