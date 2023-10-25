<template>
  <div class="registration-box">
    <div class="registration-container">
        <h1 class ="title">Crear Cuenta</h1>
      <form id="registration-form" @submit.prevent="createAccount">
        <div class="form-group">
            <!-- Nombre Completo -->
            <input type="text" id="firstName" placeholder="Nombre" v-model="firstName" required>

            <!-- Nombre Completo -->
            <input type="text" id="lastName" placeholder="Apellido" v-model="lastName" required>
            
            <!-- Documento -->
            <input type="text" id="birth-place" placeholder="Lugar de Nacimiento" v-model="birthPlace" required>
            
            <!-- Fecha de Nacimiento -->
            <input type="date" id="birth-date" v-model="birthDate" required>
            
            <!-- Direccion de Facturacion -->
            <input type="text" id="billing-address" placeholder="Dirección de Facturación" v-model="billingAddress" required>
            
            <!-- Documento -->
            <input type="text" id="DNI" placeholder="Documento" v-model="DNI" required>
        
            <!-- Genero -->
            <input type="text" id="gender" placeholder="Genero" v-model="gender" required>
            
            <!-- Email -->
            <input type="email" id="email" placeholder="Correo Electrónico" v-model="email" required>
        
            <!-- Usuario -->
            <input type="text" id="username" placeholder="Usuario" v-model="username" required>

            <!-- Contraseña -->
            <input type="password" id="password" placeholder="Contraseña" v-model="password" required>
            
            <!-- Foto de Perfil -->
            <!-- <input type="file" id="profile-picture" accept="image/*" @change="uploadProfilePicture" required> -->
        </div>
  
        <button id="create-account" class="create-account" @submit.prevent="createAccount" type="submit">Crear Cuenta</button>
        </form>
        <p id="text1">o</p>
        <p>¿Ya tienes una cuenta?</p>
        <button id="login" class="login" @click.prevent="redirectToLogin">Iniciar sesión</button>
    </div>
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

export default {
  data() {
    return {
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
      profileImage: "Soy una imagen",
      errorMessage: ""
    };
  },
  methods: {
    createAccount() {
      // Recopila todos los datos del formulario y crea un objeto con ellos
      const { DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender,  username, profileImage, errorMessage } = this;
      // Llama al servicio de registro para crear la cuenta
      registerService.register(DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender,  username, profileImage)
        .then((response) => {
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
        });
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

