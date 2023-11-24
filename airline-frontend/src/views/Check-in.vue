<template>
  <div class = "checkin-container">
    <spinner :showSpinner="showSpinner"></spinner>
    <div class="checkin-info-container">
        <h1 class="title">CheckIn</h1>
        <hr>
        <p class="texto">Por favor ingrese su código de reserva y DNI del pasajero</p>

        <label class="text-orderCOD" for="orderCOD">OrderCOD</label>
        <input v-model="orderCOD" class = "input-orderCOD" type="text" id="orderCOD">

        <label class="text-passengerDNI" for="passengerDNI">DNI del pasajero</label>
        <input v-model="passengerDNI" class ="input-passengerDNI" type="text" id="passengerDNI">
        <!-- Botón de búsqueda -->
        <button class = "search-button" @click="consult">Buscar</button>
    </div>
    <div class="info-container">
        <h1 class="title-info">Detalle pasajero</h1>
        <!-- <div class="back-response" v-if="backendResponse">
            <p>{{ backendResponse }}</p>
        </div> -->
        <div v-if="backendResponse && backendResponse.length > 0">
            <table class="passenger-details">
                <thead>
                    <tr>
                        <th>Origen</th>
                        <th>Destino</th>
                        <th>Fecha de vuelo</th>
                        <th>Asiento</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="passenger in backendResponse" :key="passenger.passengerId">
                        <td>{{ passenger.origin }}</td>
                        <td>{{ passenger.destination }}</td>
                        <td>{{ new Date(passenger.flightDate).toLocaleDateString() }}</td>
                        <td>{{ passenger.seatLetter }}{{ passenger.seatNumber }}</td>
                        <td>
                            <!-- Agrega el botón de check-in -->
                            <button @click="performCheckIn(passenger.seatId)" >Check-In</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-else>
            <p class="back-response" v-if="!backendResponse">Realice una búsqueda para ver los detalles del pasajero.</p>
            <p class="back-response" v-else>Error al obtener los datos.</p>
        </div>
    </div>
    <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
    <success-modal :show-note="showSuccessMessage" :success-message="successMessage" @close="showSuccessMessage = false" />
  </div>
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

    .checkin-container {
        height: 85vh;
        box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
      // background-image: linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%);
    }

    .passenger-details {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    .passenger-details th,
    .passenger-details td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
        color: $negro;
    }

    .passenger-details th {
        background-color: #f2f2f2;
    }

    .checkin-container {
        
        width: 90vw;
        margin: 0 auto; /* Centrar horizontalmente */
        margin-top: 10rem; /* Centrar verticalmente */
        border-radius: 10px;
        display: flex;
        justify-content: space-between;
        overflow: hidden;
    }

    .text-passengerDNI {
        font-size: 1.5rem;
        font-weight: 400;
        color: $azul;
        margin-top: 2rem;
    }

    .text-orderCOD {
        font-size: 1.5rem;
        font-weight: 400;
        color: $azul;
        margin-top: 2rem;
    }

    .checkin-info-container {
        width: 50%;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
        padding-top: 3rem;
        background-color: $secondary;
    }

    .info-container {
        width: 50%;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
        padding-top: 3rem;
        background-color: $gris;
        padding: 5rem;
    }

    .title {
        text-transform: capitalize;
        font-size: 2.25rem;
        font-weight: 600;
        letter-spacing: 1px;
        color: $azul;
        
    }

    .title-info {
        text-transform: capitalize;
        font-size: 2.25rem;
        font-weight: 600;
        letter-spacing: 1px;
        color: $negro;
        text-shadow: 2px 2px 2px rgba(31, 29, 29, 0.456);
        
    }

    .texto {
        font-size: 1.5rem;
        font-weight: 400;
        color: $negro;
        margin-top: 2rem;
    }

    .back-response {
        font-size: 1.5rem;
        font-weight: 400;
        color: $negro;
        margin-top: 2rem;
    }

    .checkin-info-container > p {
        font-size: 1rem;
        margin-top: 1rem;
    }

    .info-container > p {
        font-size: 1rem;
        margin-top: 1rem;
    }


    .input-orderCOD {
          width: 50%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;

    }

    .input-passengerDNI {
          width: 50%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;

    }

  

    .input-passengerDNI:hover {
        border: 1px solid $negro;
    }

    .input-orderCOD:hover {
        border: 1px solid $azul;
    }

    .search-button {
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

    /* .inputs-container p {
        margin: 0;
        .span {
            color: $accent;
            font-weight: 600;
            cursor: pointer;
         }
    } */

    

    @media screen and (max-width: 1000px) {
        .checkin-container {
            width: 70%;
            margin-top: 10rem;
        }
        .checkin-info-container {
            width: 100%;
            border-radius: 5px;
        }
        .info-container {
            width: 100%;
            border-radius: 5px;
        }
 
    }

    @media screen and (max-width: 650px) {
        .checkin-container {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .checkin-container {
            height: 100%;
            margin-top:10rem;
        }
        .checkin-info-container  {
           .texto{
                margin-top:5rem ;
            } 
        }
        .info-container  {
           .texto{
                margin-top:5rem ;
            } 
        }

    }

</style>

<script>
import consultService from "@/services/checkInServices/ConsultService.js";
import confirmService from "@/services/checkInServices/confirmService.js";
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import successModal from "@/components/successModal.vue";
import Footer from '@/components/footer.vue';

export default {
    data() {
    return {
      orderCOD: "",
      passengerDNI: "",
      errorMessage: "",
      showErrorMessage: false,
      showSpinner: false, // Initialize as hidden
      successMessage: "",
      showSuccessMessage: false,
      backendResponse: null,
    };
  },
  methods: {
    performCheckIn(seatId) {
        console.log(`Realizando check-in para el pasajero con ID: ${seatId}`);
        confirmService.confirm({"seatID":seatId})
        .then((response) => {
                    this.showSpinner = true;
                // Handle the successful response here
                    if (response.status === 200) {
                        this.successMessage =  "Check-in exitoso, email enviado";
                        this.showSuccessMessage = true;
                        this.showSpinner = false;
                    }
                })
                .catch((error) => {
                    this.showSpinner = false;
                // Handle login errors here
                    if (error.response.status == 401){
                        console.log("Error en obtener los datos:", error.response.status, error);
                        this.errorMessage = error.response.data.message || "Error en obtener los datos";
                        this.showErrorMessage = true;

                    } 
                    if (error.response.status == 403){
                        console.log("Error en obtener los datos:", error.response.status, error);
                        this.errorMessage = error.response.data.message || "Error en obtener los datos";
                        this.showErrorMessage = true;

                    }
                    else {
                        // You can redirect the user or perform other actions here.
                        console.error("Error en obtener los datos:", error);
                        this.errorMessage = error.response.data.message || "Error en obtener los datos";
                        this.showErrorMessage = true;
                    }
                    // Display an error message to the user or take appropriate action.
                });
    },
    consult() {
            this.showSpinner = true;
            consultService.consult({"orderCOD":this.orderCOD , "passengerDNI":this.passengerDNI}).then((response) => {
                    this.showSpinner = false;
                // Handle the successful response here
                    if (response.status == 200) {
                        console.log("Se obtuvieron los datos de forma correcta:", response.data);
                        this.backendResponse = response.data;
                        console.log('backendResponse:', this.backendResponse);
                    }
                })
                .catch((error) => {
                    this.showSpinner = false;
                // Handle login errors here
                   
                    if (error.response.status == 403){
                        console.log("Error en obtener los datos:", error.response.status, error);
                        this.errorMessage = error.response.data.message || "Error en obtener los datos";
                        this.showErrorMessage = true;
                        this.backendResponse = null;

                    }
                    else {
                        // You can redirect the user or perform other actions here.
                        console.error("Error en obtener los datos:", error);
                        this.errorMessage = error.response.data.message || "Error en obtener los datos";
                        this.showErrorMessage = true;
                        this.backendResponse = null;
                        console.log('backendResponse:', this.backendResponse);
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
