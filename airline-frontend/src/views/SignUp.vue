<template>
    <div class="registration-container">
      <h1>Crear Cuenta</h1>
      <form id="registration-form">

        <div class="form-group">
            <!-- Nombre Completo -->
            <input type="text" id="full-name" placeholder="Nombre completo" v-model="fullName" required>
    
            <!-- Documento -->
            <input type="text" id="birth-place" placeholder="Lugar de Nacimiento" v-model="birthPlace" required>
            
            <!-- Fecha de Nacimiento -->
            <input type="date" id="birth-date" v-model="birthDate" required>
            
            <!-- Direccion de Facturacion -->
            <input type="text" id="billing-address" placeholder="Dirección de Facturación" v-model="billingAddress" required>
            
            <!-- Documento -->
            <select id="id-document" v-model="idDocument" style="margin-bottom: 10px; padding-bottom: 10px; margin-top: 10px;">
                <option value="DNI">DNI</option>
                <option value="CC">Cedula de ciudadania</option>
                <option value="VISA">VISA</option>
            </select>
        
            <!-- Genero -->
            <select id="gender" v-model="gender" style="margin-bottom: 10px;">
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                <option value="Otro">Otro</option>
            </select>
            
            <!-- Email -->
            <input type="email" id="email" placeholder="Correo Electrónico" v-model="email" required>
        
            <!-- Usuario -->
            <input type="text" id="username" placeholder="Usuario" v-model="username" required>

            <!-- Contraseña -->
            <input type="password" id="password" placeholder="Contraseña" v-model="password" required>
            
            <!-- Foto de Perfil -->
            <input type="file" id="profile-picture" accept="image/*" @change="uploadProfilePicture" required>
        </div>
  
        <button id="create-account" class="create-account" @click="createAccount" type="submit">Crear Cuenta</button>
        </form>
        <p id="text1">---------- o ----------</p>
        <button id="login" class="login" @click="redirectToLogin">Iniciar sesión</button>
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
        display: inline-block;
    
    
    .form-group {
        margin: 10px 0;
        padding: 20px;
    }
    
    label {
        display: block;
        font-weight: bold;
    }
    
    input, select {
        width: 500px;
        margin: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    
    .create-account {
        width: 500px;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .login{
        width: 300px;
        padding: 10px;
        margin-top: 10px;
        background-color: #7c7f83;
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
        margin-top: 20px;
    }

  }
</style>

<script>
  /*import RegistrationService from "@/services/RegistrationService.js";*/

  export default {
    data() {
      return {
        fullName: "",
        birthPlace: "",
        birthDate: "",
        billingAddress: "",
        idDocument: "DNI",
        gender: "Otro",
        email: "",
        username: "",
        password: "",
        profilePicture: null,
        errorMessage: "",
      };
    },
    methods: {
      createAccount() {
        // Recopila todos los datos del formulario y crea un objeto con ellos
        const accountData = {
          fullName: this.fullName,
          birthPlace: this.birthPlace,
          birthDate: this.birthDate,
          billingAddress: this.billingAddress,
          idDocument: this.idDocument,
          gender: this.gender,
          email: this.email,
          username: this.username,
          password: this.password,
        };
        // Llama al servicio de registro para crear la cuenta
        /*RegistrationService.createAccount(accountData)
          .then((response) => {
            if (response.status === 201) {
              console.log("Cuenta creada exitosamente:", response.data);
              this.$router.push('/login');
            }
          })
          .catch((error) => {
            console.error("Error al crear la cuenta:", error);
            this.errorMessage = "Error al crear la cuenta. Por favor, inténtalo de nuevo.";
          });*/
      },
      uploadProfilePicture(event) {
        const file = event.target.files[0];
        this.profilePicture = file;
      },
      redirectToLogin() {
        console.log("Redirigiendo a la página de inicio de sesión");
        this.$router.push('/login');
      },
    },
  };
</script>

