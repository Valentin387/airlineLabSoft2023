<template>
    <body>
        <div class="recoverPassword-container">
            <spinner :showSpinner="showSpinner"></spinner>
            <img class="imageRecover-container" alt="">
            <div class="recoverPassword">
                <hr>
                <!-- <h1 class="title">
                    <i class="material-icons larger-icon">account_circle</i> 
                </h1> -->
                <h1 class="title">Recupera tu contraseña</h1>
                <form class="inputs-container" @submit.prevent="RecoverP">
                    <p class="texto">Introduce tu correo electrónico y te enviaremos un enlace para que
                        vuelvas a entrar en tu cuenta</p>
                    <input class="input-password" type="email" placeholder="Correo Electrónico" v-model="email">
                    <p v-if="email.length > 80">El correo electrónico no puede tener más de 30 caracteres</p>
                    <button class="btn-password" type="submit">Enviar enlace de acceso</button>
                </form>
            </div>
            <success-modal :show-note="showSuccessMessage" :success-message="successMessage" @close="showSuccessMessage = false" />
            <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
        </div>
    </body>
    <!------------------------------------------------FOOTER------------------------------------------->
    <Footer></Footer>
</template>

<style lang="scss" scoped>
   
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
  
        /* Estilos para aumentar el tamaño del icono */
    .larger-icon {
        font-size: 48px; /* Tamaño del icono, ajusta según tus preferencias */
    }
    .recoverPassword-container {
        height: 85vh;
        box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
      // background-image: linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%);
    }

    .recoverPassword-container {
        
        width: 90vw;
        margin: 0 auto; /* Centrar horizontalmente */
        margin-top: 10rem; /* Centrar verticalmente */
        border-radius: 10px;
        display: flex;
        justify-content: space-between;
        overflow: hidden;
    }


    .recoverPassword {
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

    .imageRecover-container {
        width: 50%;
        background: linear-gradient($degradado, $bg), url("src/assets/madrid.jpg") no-repeat center/cover;
        box-sizing: border-box;
        position: relative;

    }

    .title {
        text-transform: capitalize;
        font-size: 2.25rem;
        font-weight: 600;
        letter-spacing: 1px;
        color: $azul;
        
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

   

    .recoverPassword > p {
        font-size: 1rem;
        margin-top: 1rem;
    }

    
    
    .input-password {
          width: 100%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;

    }

  

    .input-password:hover {
        border: 2px solid $azul;
    }

    .btn-password {
        
        margin-top:1rem;
        display:inline-block;
        padding: 1rem 3rem; 
        font-size: 1.7rem;
        color: $accent;
        border:$azul .2rem solid; 
        border-radius:5rem;
        cursor: pointer;
        background: $blanco;
        box-shadow: 1px 5px 5px rgba(0.5, 0.1, 0.1, 0.1);

        &:hover{
            background: $accent;
            color: $blanco;
            text-decoration-line: none;
            
        }
    
    }

    .inputs-container p {
        margin: 0;
        .span {
            color: $accent;
            font-weight: 600;
            cursor: pointer;
         }
    }

    

    @media screen and (max-width: 1000px) {
        .recoverPassword-container {
            width: 70%;
            margin-top: 10rem;
        }
        .recoverPassword {
            width: 100%;
            border-radius: 5px;
        }
        
        .imageRecover-container {
            display: none;
        }  
    }

    @media screen and (max-width: 650px) {
        .recoverPassword-container {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .recoverPassword-container {
            height: 100%;
            margin-top:10rem;
        }

        .recoverPassword  {
           .texto{
                margin-top:5rem ;
            }
            
            
        }
    }

</style>

<script>
import emailCheckingService from "@/services/authenticationService/emailCheckingService.js";
import errorModal from "@/components/ErrorModal.vue";
import spinner from "@/components/spinner.vue";
import successModal from "@/components/successModal.vue";
import Footer from '@/components/footer.vue';

export default {
    data() { 
      return {
        email: "",
        errorMessage: "",
        showErrorMessage: false,
        showSpinner: false, // Initialize as hidden
        successMessage: "",
        showSuccessMessage: false,
      };
    },
    methods: {
      RecoverP() {
        this.showSpinner = true;
        if (this.email.length > 80) {
            console.log("El email debe tener entre 8 y 80 carácteres");
            this.showSpinner = false;
            return;
        }

        let { email} = this;

        // Call the LoginService.login method
        emailCheckingService.emailChecking(email)
          .then((response) => {
            this.showSpinner = false;
            // Handle the successful login response here
            if (response.status == 200){
                //confirm(response.data);
                this.successMessage =  response.data;
                this.showSuccessMessage = true;
                this.showSpinner = false;
            }
          })
          .catch((error) => {
            this.showSpinner = false;
            // Handle login errors here
            if (error.response.status == 401){
              console.log("New Password failed:", error.response.status, error);
              this.errorMessage = error.response.data.message || "New Password failed";
              this.showErrorMessage = true;
            } 
            if (error.response.status == 403){
              console.log("User not found sorry:", error.response.status, error);
              this.errorMessage = error.response.data.message || "User not found";
              this.showErrorMessage = true;
            }
            else {
              // You can redirect the user or perform other actions here.
              console.error("Something happened:", error);
              this.errorMessage = error.response.data.message || "Something happened, logout and login again";
              this.showErrorMessage = true;
            }
            // Display an error message to the user or take appropriate action.
          });
       }
      },
      components: {
        errorModal,
        spinner,
        successModal,
        Footer,
    },
}

</script>