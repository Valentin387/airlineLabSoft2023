<template>
    <div class="registration-box">
      <spinner :showSpinner="showSpinner"></spinner>
      <div class="registration-container">
        <div class="title">Datos de Pasajeros</div>
        <form id="registration-form" @submit.prevent="createAccount">
          <hr class="border-light m-0" />
          <div class="card-body">
            <div class="form-group">
              <!-- Nombre Completo -->
              <input type="text" id="firstName" placeholder="Nombre" v-model="firstName" required />
              <p v-if="!isValidFirstName">El nombre no es válido</p>
  
              <!-- Apellido -->
              <input type="text" id="lastName" placeholder="Apellido" v-model="lastName" required />
              <p v-if="lastName.length > 25">
                El apellido no puede tener más de 25 caracteres
              </p>
  
              <!-- Lugar de Nacimiento -->
              <!-- Fecha de Nacimiento -->
            <!-- Fecha de Nacimiento -->
            <label for="birthDate">Fecha de Nacimiento</label>
            <input type="date" id="birthDate" class="birth-place" v-model="birthDate" @input="validateBirthdate" required />
            <p v-if="!isValidBirthday">{{ birthdateError }}</p>
  
              <!-- Direccion de Facturacion -->
              <input type="text" id="telefono" placeholder="Nombre" v-model="cellphoneNo" required />
    
              <!-- DNI -->
              <input type="text" id="DNI" placeholder="Documento" v-model="DNI" required />
              <p v-if="DNI.length > 10">
                El DNI no puede tener más de 10 caracteres
              </p>
  
              <!-- Género -->
              <select id="gender" placeholder="Género" v-model="gender">
                <option value="" disabled selected>Seleccione el género</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                <option value="Otro">Otro</option>
              </select>
  
              <!-- Email -->
              <input type="email" id="email" placeholder="Correo Electrónico" v-model="email" required />
              <p v-if="email.length > 80">
                El correo electrónico no puede tener más de 30 caracteres
              </p>
              <input type="text" id="contactName" placeholder="Nombre de un contacto" v-model="contactName" required />
              <p v-if="!isValidcontactName">El nombre no es válido</p>
              <input type="text" id="contactNo" placeholder="Teléfono del contacto" v-model="contactNo" required />

            </div>
          </div>
  
          <button id="create-account" class="create-account" @submit.prevent="createAccount" type="submit">
            Crear Cuenta
          </button>
        </form>
        <p id="text1">o</p>
        <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
        <p>¿Ya tienes una cuenta?</p>
        <button id="login" class="login" @click.prevent="redirectToLogin">
          Iniciar sesión
        </button>
      </div>
    </div>
    <!------------------------------------------------FOOTER------------------------------------------->
    <Footer></Footer>
  </template>
    
  <style lang="scss" scoped >
  $light-color: #312c02;
  $degradado: rgba(149, 168, 238, 0.11);
  $bg: rgba(6, 31, 14, 0.947);
  $azul-claro: #cfe0eb;
  $gris: #f7f7f7;
  $verde: #00bd8e;
  $azul: #0d629b;
  $blanco: #ffffff;
  $negro: #1a1320;
  $accent: #0b97f4;
  $accent3: #f7f7f7;
  $blue: #54b2f1;
  $secondary: #ceeafd;
  
  html {
    /* 
          Estilo CSS para la vista Home.vue del proyecto Vue.js. 
          La propiedad font-size establece el tamaño de fuente base en 10px, lo que equivale a 62.5% del tamaño de fuente predeterminado del navegador. 
          La propiedad overflow-x:hidden oculta el desplazamiento horizontal de la página. 
          La propiedad scroll-behavior: smooth agrega un efecto de desplazamiento suave al hacer clic en los enlaces internos de la página. 
          La propiedad scroll-padding-top establece la cantidad de espacio de relleno en la parte superior de la página para compensar la barra de navegación fija. 
          */
    font-size: 62.5%;
    overflow-x: hidden;
    scroll-behavior: smooth;
    scroll-padding-top: 9rem;
  
    /* 
          Estilos para la barra de desplazamiento en la vista Home.vue.
          Se utiliza el selector de pseudo-elemento &:: para aplicar estilos a la barra de desplazamiento.
          */
    &::-webkit-scrollbar {
      width: 1rem;
    }
  
    &::-webkit-scrollbar-track {
      background: $accent;
    }
  
    &::-webkit-scrollbar-thumb {
      background-color: $azul;
    }
  }
  
  .registration-box {
    box-shadow: 0 6px 6px rgba(6, 6, 6, 0.1);
    background: $secondary; //FONDO DE LA CARD
    width: 90vw;
    margin: 2vw auto;
    /* Centrar horizontalmente */
    margin-top: 10rem;
    margin-bottom: 10rem;
    /* Centrar verticalmente */
    border-radius: 10px;
    display: flex;
    justify-content: space-between;
    overflow: hidden;
    text-align: center;
  
    .form-group {
      margin: 10px 0;
      padding: 20px;
    }
  .registration-container {
    .title {
    
      margin: 0;
      color: $azul;
      font-weight: bold;
      font-size: 3rem; /* Aumenta el tamaño de la fuente */
     
      letter-spacing: 1px; /* Aumenta el espaciado entre las letras */
      text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.456); /* Añade una sombra al texto */
      font-family: 'Arial', sans-serif; /* Cambia la fuente (opcional) */
      text-align: center;
      margin-top:3rem;
    }
  }
   
  
    label {
      display: block;
      font-weight: bold;
      align-items: center !important;
    }
  
    input,
    select {
      width: 70%;
      margin: 10px 0;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
  
    .create-account {
      width: 40%;
      padding: 7px;
      background-color: $blue;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-align: center;
    }
  
    .login {
      width: 30%;
      padding: 7px;
      background-color: #364265;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-align: center;
      margin-bottom: 5rem;
    }
  
    .login-link:hover {
      text-decoration: underline;
    }
  
    .image-section {
      //text-align: center; // Alinea la imagen al centro horizontalmente
      margin-top: 1rem; // Ajusta el espaciado superior según tus necesidades
      align-items: center !important;
      display: flex !important;
      justify-content: center !important;
    }
  
    .image-section img {
      display: block !important; // Asegura que la imagen esté centrada en su contenedor
      //margin: 0 auto; // Alinea la imagen al centro horizontalmente dentro de su contenedor
      border-radius: 50%;
      /* Aplicamos un borde circular */
      overflow: hidden;
      /* Aseguramos que la imagen esté dentro del círculo */
      // text-align: center;
    }
  
    .profile-picture {
      width: 30px;
      border-radius: 50%;
      /* Aplicamos un borde circular */
      overflow: hidden;
      /* Aseguramos que la imagen esté dentro del círculo */
      align-items: center !important;
      display: flex !important;
      justify-content: center !important;
    }
  
    .text1 {
      font-family: "Courier New", Courier, monospace;
      font-size: small;
      text-align: center;
      margin-top: 30px;
    }
  
    .avatar-gallery {
      display: flex;
      flex-wrap: wrap;
      align-items: center !important;
      display: flex !important;
      justify-content: center !important;
    }
  
    .avatar-gallery img {
      width: 100px;
      height: 100px;
      margin: 5px;
      border: 1px solid #1b1818;
      cursor: pointer;
      border-radius: 50%;
      /* Aplicamos un borde circular */
      overflow: hidden;
      /* Aseguramos que la imagen esté dentro del círculo */
    }
  
    .btn-outline-primary {
      border-color: $accent;
      background: transparent;
      color: $accent;
      margin-top: 1rem;
      margin-bottom: 2rem;
      display: inline-block;
      padding: 1rem 1rem;
      align-items: center !important;
      font-size: 1.7rem;
      font-weight: bolder;
      border: $azul 0.2rem solid;
      border-radius: 5rem;
      margin-left: 0rem;
      box-shadow: inset 0px 0px 0px 1px $accent;
    }
  
    .btn-primary {
      background-color: $accent;
      color: $blanco;
      margin-top: 1rem;
      display: inline-block;
      padding: 1rem 3rem;
      font-size: 1.7rem;
      // font-weight: bold;
      margin-left: 5rem;
      border: $azul-claro 0.2rem solid;
      border-radius: 5rem;
      box-shadow: inset 0px 0px 0px 1px $negro;
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
    .registration-box {
      height: 100%;
      margin-top: 10rem;
    }
  
    .registration-container {
      .texto {
        margin-top: 5rem;
      }
    }
  }
  </style>
  
<script>
import registerService from "@/services/authenticationService/registerService.js";
import emailService from "@/services/authenticationService/emailCheckingService";
import errorModal from "@/components/errorModal.vue";
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
      profileImage: 'src/assets/user.png',
      errorMessage: "",
      showErrorMessage: false,
      isValidFirstName: true,
      showSpinner: false,
     
      showGallery: false,
      selectedAvatar: null,
      avatarOptions: [
        "https://bootdey.com/img/Content/avatar/avatar1.png",//Opciones de imagen de usuario
        "https://bootdey.com/img/Content/avatar/avatar2.png",
        "https://bootdey.com/img/Content/avatar/avatar3.png",
        "https://bootdey.com/img/Content/avatar/avatar8.png",
        'src/assets/user.png'//Imagen por defecto de usuario
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
      eighteenYearsAgo.setFullYear(currentDate.getFullYear() - 18);
      const eighteenYearsAgoString = eighteenYearsAgo.toISOString().split('T')[0];

      // Verifica si el usuario tiene más de 18 años
      if (userBirthdate > eighteenYearsAgoString) {
        this.birthdateError = "¡Ten cuidado McFly!, debes ser mayor de edad para registrarte";
        this.isValidBirthday = false;
      } else {
        // Verifica si el usuario tiene menos de 90 años
        const ninetyYearsAgo = new Date();
        ninetyYearsAgo.setFullYear(currentDate.getFullYear() - 90);
        const ninetyYearsAgoString = ninetyYearsAgo.toISOString().split('T')[0];

        if (userBirthdate < ninetyYearsAgoString) {
          this.birthdateError = "¡Eres demasiado mayor para registrarte!";
          this.isValidBirthday = false;
        } else {
          this.birthdateError = '';
          this.isValidBirthday = true;
        }
      }

      // Mostrar una ventana emergente en caso de error
      if (!this.isValidBirthday) {
        this.errorMessage = this.birthdateError;
        this.showErrorMessage = true;
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

    async createAccount() {
      this.showSpinner = true;

      // Validación de complejidad de contraseña (ejemplo: al menos una mayúscula, una minúscula y un número)
      if (!/(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,30}/.test(this.password)) {
        this.handleValidationError("La contraseña no cumple con los criterios de complejidad");
        return;
      }

      // Validación de nombre y fecha de nacimiento
      if (!this.isValidFirstName || !this.isValidBirthday) {
        this.handleValidationError("Datos no válidos, revisa que hayas llenado correctamente todos los campos");
        return;
      }

      // Validación de DNI (ejemplo: debe ser numérico)
      if (isNaN(this.DNI)) {
        this.handleValidationError("El DNI debe ser numérico");
        return;
      }

      // Validar que el nombre de usuario no consista solo en espacios, solo en caracteres especiales o solo en números
      if (/^\s*[a-zA-Z]+[a-zA-Z0-9]*[!@#$%^&*(),.?":{}|<>_-]*[a-zA-Z0-9]+\s*$/.test(this.username)) {
        // El nombre de usuario cumple con los criterios
      } else {
        this.handleValidationError("El nombre de usuario no puede consistir solo en espacios, solo en caracteres especiales o solo en números");
        return;
      }

      // Validar que el nombre no consista solo en espacios, números o caracteres especiales
      if (!/^[a-zA-Z]+$/.test(this.firstName)) {
        this.handleValidationError("El nombre no puede contener números, espacios o caracteres especiales");
        return;
      }

      // Validar que el apellido no consista solo en espacios, números o caracteres especiales
      if (!/^[a-zA-Z]+$/.test(this.lastName)) {
        this.handleValidationError("El apellido no puede contener números, espacios o caracteres especiales");
        return;
      }

      // Validar que la contraseña no consista solo en espacios en blanco
      if (this.password.trim().length === 0) {
        this.handleValidationError("La contraseña no puede consistir solo en espacios en blanco");
        return;
      }

      // Validar el formato del correo electrónico
      if (!/\S+@\S+\.\S+/.test(this.email)) {
        this.handleValidationError("El formato del correo electrónico no es válido");
        return;
      }

      // Verificación de disponibilidad de correo electrónico
      try {
        const response = await emailService.emailChecking(this.email);

        if (response.status === 200) {
          // El correo electrónico está disponible, continúa con el registro
          // ... (resto de tu lógica de registro)
        } else {
          // El correo electrónico ya está en uso
          this.handleValidationError("El correo electrónico ya está en uso");
        }
      } catch (error) {
        // Maneja cualquier error de la solicitud
        console.error("Error al verificar el correo electrónico:", error);
        this.handleValidationError("Error al verificar el correo electrónico");
      } finally {
        this.showSpinner = false;
      }


      if (isNaN(this.firstName) && this.firstName.length <= 25) {
        this.isValidFirstName = true;

        // Recopila todos los datos del formulario y crea un objeto con ellos
        const { DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender, username, profileImage, errorMessage } = this;
        // Llama al servicio de registro para crear la cuenta
        registerService.register(DNI, email, password, firstName, lastName, birthDate, birthPlace, billingAddress, gender, username, profileImage)
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
            if (error.response.status == 401) {
              console.log("Login failed:", error.response.status, error);
              this.errorMessage = "Signup failed.Error 401";
              this.showErrorMessage = true;
            }
            if (error.response.status == 403) {
              console.log("User not found sorry:", error.response.status, error);
              this.errorMessage = "Signup failed.Error 403";
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
        this.errorMessage = "El nombre no puede ser un numero o no esta dentro del limite";
        this.showErrorMessage = true;
      }
    },

    // Función para manejar errores de validación
    handleValidationError(errorMessage) {
      this.showSpinner = false;
      this.errorMessage = errorMessage;
      this.showErrorMessage = true;
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

