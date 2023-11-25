<template>
  <div class="ResetPassword-container">
    <spinner :showSpinner="showSpinner"></spinner>
    <img class="imageReset-container" alt="" />
    <div class="ResetPassword">
      <hr />
      <!-- <h1 class="title">
                <i class="material-icons larger-icon">account_circle</i> 
            </h1> -->
      <h1 class="title">Restablece la contraseña</h1>
      <form class="inputs-container" @submit.prevent="UpdateP">
        <hr />
        <hr />
        <hr />
        <hr />
        <hr />
        <p class="texto">
          ¡Gracias! por favor ingrese su nueva contraseña, y despues confirmela
        </p>
        <input
          type="password"
          id="password"
          placeholder="Nueva contraseña"
          v-model="temporal"
          required
        />
        <p v-if="password.length < 8 || password.length > 80">
          La contraseña debe tener entre 8 y 30 caracteres
        </p>
        <input
          type="password"
          id="password2"
          placeholder="Confirme su contraseña"
          v-model="password"
          required
        />
        <p v-if="temporal != password">Los campos no coinciden</p>
        <button class="btn-password" type="submit">Guardar cambios</button>
      </form>
    </div>

    <error-modal
      :show-error="showErrorMessage"
      :error-message="errorMessage"
      @close="showErrorMessage = false"
    />
    <success-modal
      :show-note="showSuccessMessage"
      :success-message="successMessage"
      @close="showSuccessMessage = false"
    />
  </div>
  <!------------------------------------------------FOOTER------------------------------------------->
  <Footer></Footer>
</template>

<style lang="scss">
$light-color: #312c02;
$degradado: rgba(149, 168, 238, 0.11);
$bg: rgba(6, 31, 14, 0.947);
$azul-claro: #cfe0eb;
$gris: #f7f7f7;
$gris2: #364265;
$verde: #00bd8e;
$azul: #0d629b;
$blanco: #ffffff;
$negro: #1a1320;
$accent: #0b97f4;
$secondary: #ceeafd;
$blue: #54b2f1;

/* Estilos para aumentar el tamaño del icono */
.larger-icon {
  font-size: 48px;
  /* Tamaño del icono, ajusta según tus preferencias */
}

.ResetPassword-container {
  height: 85vh;
  box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
  // background-image: linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%);
}

.ResetPassword-container {
  width: 90vw;
  margin: 0 auto;
  /* Centrar horizontalmente */
  margin-top: 10rem;
  /* Centrar verticalmente */
  border-radius: 10px;
  display: flex;
  justify-content: space-between;
  overflow: hidden;
}

.ResetPassword {
  width: 50%;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  padding-top: 3rem;
  background-color: $secondary;

  .inputs-container {
    height: 55%;
    width: 60%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
  }
}

.imageReset-container {
  width: 50%;
  background: linear-gradient($degradado, $bg),
    url("src/assets/buenosaires.jpg") no-repeat center/cover;
  box-sizing: border-box;
  position: relative;
}

.title {
  color: $azul;
  font-weight: bold;
  font-size: 3rem; /* Aumenta el tamaño de la fuente */
  letter-spacing: 1px; /* Aumenta el espaciado entre las letras */
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.456); /* Añade una sombra al texto */
  font-family: "Arial", sans-serif; /* Cambia la fuente (opcional) */
}

.social-login-element {
  width: 12.5rem;
  height: 3.75rem;
  font-size: 1.2rem;
  font-weight: 700;
  letter-spacing: 0.5px;
  border-radius: 5px;
  border: 1px solid $azul;
  display: flex;
  justify-content: center;
  align-items: center;
}

.social-login-element img {
  width: 1.875rem;
  height: 1.875rem;
  position: relative;
  top: 0;
  left: -0.625rem;
}

.ResetPassword > p {
  font-size: 1rem;
  margin-top: 1rem;
}

.input-password:hover {
  border: 2px solid $azul;
}

.btn-password {
  margin-top: 1rem;
  display: inline-block;
  padding: 1rem 3rem;
  font-size: 1.7rem;
  color: $blanco;
  border: $azul 0.2rem solid;
  border-radius: 5rem;
  cursor: pointer;
  background-color: $blue;
  box-shadow: 1px 5px 5px rgba(0.5, 0.1, 0.1, 0.1);

  &:hover {
    background: $accent;
    color: $blanco;
    text-decoration-line: none;
  }
}

.inputs-container {
  margin: 0;

  .span {
    color: $accent;
    font-weight: 600;
    cursor: pointer;
  }

  input {
    width: 80%;
    margin-top: 10rem;
    margin: 10px 0;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
}

@media screen and (max-width: 1000px) {
  .ResetPassword-container {
    width: 70%;
    margin-top: 10rem;
  }

  .ResetPassword {
    width: 100%;
    border-radius: 5px;
  }

  .imageReset-container {
    display: none;
  }
}

@media screen and (max-width: 650px) {
  .ResetPassword-container {
    width: 90%;
  }
}

@media screen and (max-width: 500px) {
  .ResetPassword-container {
    height: 100%;
    margin-top: 10rem;
  }

  .ResetPassword {
    .texto {
      margin-top: 5rem;
    }
  }
}
</style>

<script>
import updatePasswordService from "@/services/authenticationService/updatePasswordService.js";
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import successModal from "@/components/successModal.vue";
import Footer from "@/components/footer.vue";

export default {
  data() {
    return {
      email: "",
      password: "",
      temporal: "",
      errorMessage: "",
      showErrorMessage: false,
      showSpinner: false, // Initialize as hidden
      successMessage: "",
      showSuccessMessage: false,
    };
  },
  methods: {

     // Función para manejar errores de validación
     handleValidationError(errorMessage) {
      this.showSpinner = false;
      this.errorMessage = errorMessage;
      this.showErrorMessage = true;
    },
    
    UpdateP() {
      this.showSpinner = true;

      if (this.password.length < 8 || this.password.length > 80) {
        console.log("La contraseña no esta dentro del limite");
        this.errorMessage =
          "La contraseña debe ser menor a 30 y mayor a 8 carácteres";
        this.showErrorMessage = true;
        this.showSpinner = false;
        return;
      }
      // Validación de complejidad de contraseña (puedes personalizar la expresión regular según tus criterios)
      if (this.password && !/(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,30}/.test(this.password)) {
                this.handleValidationError("La contraseña no cumple con los criterios de complejidad");
                return;
        }

      let { email, password, temporal } = this;

      const token = window.sessionStorage.getItem("JWTtoken");
      if (!token || token == null) {
        const encodedEmail = this.$route.params.email;
        const emailWithHyphens = decodeURIComponent(encodedEmail);
        console.log("Decoded email:", emailWithHyphens);
        email = emailWithHyphens.replaceAll("-", ".");
        console.log("final email:", email);
      } else {
        const tokenData = JSON.parse(atob(token.split(".")[1]));
        email = tokenData.sub;
      }

      if (password == temporal) {
        // Call the LoginService.login method
        updatePasswordService
          .updatePassword(email, password)
          .then((response) => {
            this.showSpinner = true;
            // Handle the successful login response here
            if (response.status == 200) {
              //confirm("Contraseña actualizada correctamente");
              this.successMessage = "Contraseña actualizada correctamente";
              this.showSuccessMessage = true;
              this.showSpinner = false;

              console.log("New Password updated:", response.data);
            }
          })
          .catch((error) => {
            this.showSpinner = false;
            // Handle login errors here
            if (error.response.status == 401) {
              console.log("New Password failed:", error.response.status, error);
              this.errorMessage = "New Password failed";
              this.showErrorMessage = true;
            }
            if (error.response.status == 403) {
              console.log(
                "User not found sorry:",
                error.response.status,
                error
              );
              this.errorMessage = "User not found sorry";
              this.showErrorMessage = true;
            } else {
              // You can redirect the user or perform other actions here.
              this.errorMessage =
                "Something happened, try to logout and login again.";
              this.showErrorMessage = true;
              //   console.error("Something happened:", error);
            }
            // Display an error message to the user or take appropriate action.
          });
      } else {
        // console.error("Contraseñas no coinciden");
        this.errorMessage = "Contraseñas no coinciden";
        this.showErrorMessage = true;
        this.showSpinner = false;
      }
    },
  },
  components: {
    errorModal,
    spinner,
    successModal,
    Footer,
  },
};
</script>