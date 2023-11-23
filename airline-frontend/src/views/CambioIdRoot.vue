<template>
    <body>
        <div class="admin-container">
            <spinner :showSpinner="showSpinner"></spinner>
            <img class="image-container" alt="">
            <div class="admin-info-container">
                <hr>
                <h1 class="title">
                    <i class="material-icons larger-icon">account_circle</i> 
                </h1>
                <h1 class="title">Cambiar Id Root</h1>
                <br>
                <form   @submit.prevent="rootChangeID" class="inputs-container">
                    <p class="texto">Introduce tu nuevo Correo Electrónico</p>
                    <br>
                    <input class="input-admin" type="email" placeholder="Correo Electrónico" v-model="email" required>
                    <br>
                    <button class="btn-admin"  type="submit" >Guardar Cambios</button>
                </form>
                <!-- <p id="error-message" class="error-message">{{ errorMessage }}</p> -->
            </div>
            <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
            <success-modal :show-note="showSuccessMessage" :success-message="successMessage" @close="showSuccessMessage = false" />
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
    .admin-container {
        height: 85vh;
        box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
      // background-image: linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%);
    }

    .admin-container {
        
        width: 90vw;
        margin: 0 auto; /* Centrar horizontalmente */
        margin-top: 10rem; /* Centrar verticalmente */
        border-radius: 10px;
        display: flex;
        justify-content: space-between;
        overflow: hidden;
    }


    .admin-info-container {
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
          
            align-items: center;
        }
    }

    .image-container {
        width: 50%;
        background: linear-gradient($degradado, $bg), url("src/assets/homelondres.jpg") no-repeat center/cover;
        box-sizing: border-box;
        position: relative;

    }

    .title {
        margin: 0;
      color: $azul;
      font-weight: bold;
      font-size: 3rem; /* Aumenta el tamaño de la fuente */
      letter-spacing: 1px; /* Aumenta el espaciado entre las letras */
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.456); /* Añade una sombra al texto */
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

   

    .admin-info-container > p {
        font-size: 1rem;
        margin-top: 1rem;
    }

    

    .input-admin {
          width: 100%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;

    }

  

    .input-admin:hover {
        border: 2px solid $azul;
    }

    .btn-admin {
        
        margin-top:1rem;
        display:inline-block;
        padding: 1rem 3rem; 
        font-size: 1.7rem;
        border:$azul .2rem solid; 
        border-radius:5rem;
        cursor: pointer;
        background-color: #364265;
        color: #fff;
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
        .admin-container {
            width: 70%;
            margin-top: 10rem;
        }
        .admin-info-container {
            width: 100%;
            border-radius: 5px;
        }
        
        .image-container {
            display: none;
        }  
    }

    @media screen and (max-width: 650px) {
        .admin-container {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .admin-container {
            height: 100%;
            margin-top:10rem;
        }

        .admin-info-container  {
           .texto{
                margin-top:5rem ;
            }
            
            
        }
    }

</style>

<script>
import rootChangeId from "@/services/rootService/rootChangeId.js";
import errorModal from "@/components/errorModal.vue";
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
        rootChangeID() {
            this.showSpinner = true;
            const {email} = this;
            // Call the LoginService.login method
            rootChangeId.rootChangeID( email)
                .then((response) => {
                    this.showSpinner = false;
                // Handle the successful login response here
                    if (response.status === 200) {
                        console.log("Creation successful:", response.data);
                        this.successMessage =  "Se ha actualizado el email, por cuestiones de seguridad, cierra sesión y vuelve a iniciarla con el nuevo email";
                        this.showSuccessMessage = true;
                        this.showSpinner = false;
                        this.$router.push('/');
                    }
                })
                .catch((error) => {
                    this.showSpinner = false;
                // Handle login errors here
                    if (error.response.status == 401){
                        console.log("authorized personnel only:", error.response.status, error);
                        this.errorMessage = error.response.data.message || "authorized personnel only";
                        this.showErrorMessage = true;
                    } 
                    if (error.response.status == 403){
                        console.log("email already exists:", error.response.status, error);
                        this.errorMessage = error.response.data.message || "Email already exists";
                        this.showErrorMessage = true;
                    }
                    else {
                        // You can redirect the user or perform other actions here.
                        console.error("Email already exists:", error);
                        this.errorMessage = error.response.data.message || "Email already exists";
                        this.showErrorMessage = true;
                    }
                    // Display an error message to the user or take appropriate action.
                });
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
