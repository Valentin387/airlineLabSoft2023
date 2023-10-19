<template>
    <div class="registration-container">
      <h1>Crear Cuenta</h1>
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
            <!--<select id="id-document" v-model="idDocument" style="margin-bottom: 10px; padding-bottom: 10px; margin-top: 10px;">
                <option value="DNI">DNI</option>
                <option value="CC">Cedula de ciudadania</option>
                <option value="VISA">VISA</option>
            </select> -->
            <input type="text" id="DNI" placeholder="Documento" v-model="DNI" required>
        
            <!-- Genero 
            <select id="gender" v-model="gender" style="margin-bottom: 10px; padding-bottom: 10px;">
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                <option value="Otro">Otro</option>
            </select>-->
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
</template>
  
<style lang="scss">
  
    .registration-container {
        margin: 0 auto;
        margin-top:9rem;//AGREGUÉ ESTO PARA QUE QUEDE BAJO LA BARRA HORIZONTAL
        text-align: center;
        max-width: 50%px;
        padding: 20px;
        background-color: #f2f2f2;
        border-radius: 10px;
    }
    
    .form-group {
        margin: 10px 0;
        padding: 20px;
    }
    
    label {
        display: block;
        font-weight: bold;
    }
    
    input, select {
        width: 100%;
        margin-top: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    
    .create-account {
        width: 100%;
        padding: 7px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    
    .login{
        width: 50%;
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
      const { DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender,  username, profileImage, errorMessage } = this;
      // Recopila todos los datos del formulario y crea un objeto con ellos
      /*const accountData = {
        firstName: this.firstName,
        lastName: this.lastName,
        birthPlace: this.birthPlace,
        birthDate: this.birthDate,
        billingAddress: this.billingAddress,
        DNI: this.DNI,
        gender: this.gender,
        email: this.email,
        username: this.username,
        password: this.password,
        profileImage: this.profileImage,
      };*/

      // Llama al servicio de registro para crear la cuenta
      registerService.register(DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender,  username, profileImage)
        .then((response) => {
          // Maneja la respuesta exitosa aquí
          if (response.status === 200) {
            console.log("Cuenta creada exitosamente:", response.data);
            // Redirige al usuario o realiza otras acciones según tus necesidades
            this.$router.push('/login');
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
          // Maneja errores de registro aquí
          /*console.error("Error al crear la cuenta:", error);
          // Muestra un mensaje de error al usuario u toma medidas apropiadas
          this.errorMessage = "Error al crear la cuenta. Por favor, inténtalo de nuevo.";*/
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

