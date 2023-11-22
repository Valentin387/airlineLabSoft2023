
<template>
    <div class="page-container">
      <spinner :showSpinner="showSpinner"></spinner>
      <div class="left-content">
        <hr>
          <h1 class="tittle">Crea Nuevas Aventuras</h1>
          <hr>
          <div class="text-login">
                <p>Somos tu pasaporte hacia el mundo de la aviación. Con una amplia gama de destinos, ofertas irresistibles y un servicio excepcional, estamos aquí para hacer realidad tus sueños de viaje.</p>
                <hr><hr> 
                <p class="text1"> ¡Ayuda a tus clientes a escoger un vuelo y comencemos a explorar el mundo juntos!</p>
          </div>
      </div>
      <div class="creacionV-container">
        <!-- Contenido para crear vuelos -->
        <hr>
        <h1>Crear Vuelo</h1>
        <hr><hr>
        <form @submit.prevent="validateAndCreateFlight" id="flight-form">
          <input type="date" id="flightDate" v-model="flightDate" required>
          <select name="origin" v-model="origin" required>
            <option value="" disabled selected>Origen del vuelo</option>
            <option value="Madrid">Madrid</option>
            <option value="Londres">Londres</option>
            <option value="New York">New York</option>
            <option value="Buenos Aires">Buenos Aires</option>
            <option value="Miami">Miami</option>
            <option value="Pereira">Pereira</option>
            <option value="Bogotá">Bogotá</option>
            <option value="Medellín">Medellín</option>
            <option value="Cali">Cali</option>
            <option value="Cartagena">Cartagena</option>
            <!-- ... (otros destinos) ... -->
          </select>
          <select name="destination" v-model="destination" required>
            <option value="" disabled selected>Destino del Vuelo</option>
            <option value="Madrid">Madrid</option>
            <option value="Londres">Londres</option>
            <option value="New York">New York</option>
            <option value="Buenos Aires">Buenos Aires</option>
            <option value="Miami">Miami</option>
            <option value="Pereira">Pereira</option>
            <option value="Bogotá">Bogotá</option>
            <option value="Medellín">Medellín</option>
            <option value="Cali">Cali</option>
            <option value="Cartagena">Cartagena</option>
          </select>
          <div class="duration-input">
                <input type="number" id="flightDuration" placeholder="Duración" v-model="flightDurationValue" :min="flightDurationUnit === 'hours' ? 1 : 15" :max="flightDurationUnit === 'hours' ? 24 : 59" required>
                <!--valor mínimo de 1 hora si la unidad seleccionada es "Horas" y un valor mínimo de 15 minutos si la unidad es "Minutos". El valor máximo es 24 horas si se selecciona "Horas" y 59 minutos si se selecciona "Minutos".-->
                <select v-model="flightDurationUnit">
                <option value="hours">Horas</option>
                <option value="minutes">Minutos</option>
                </select>
          </div>
          <input type="date" id="arrivalDate" v-model="arrivalDate" required>
          <input type="number" id="costByPerson" placeholder="Costo por persona" v-model="costByPerson" required>
          <button id="create-flight" class="login" type="submit">Crear Vuelo</button>
        </form>
        <!-- Mostrar mensaje de error como modal si es necesario -->
        <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
      </div>
    </div>
    <!-- Footer aquí -->
    <Footer></Footer>
  </template>


<style lang="scss" scoped >
  $light-color:#2e2b18;
  $degradado: rgba(34, 33, 39, 0.552);
  $bg:rgba(25, 32, 57, 0.947);
  $azul-claro: #CFE0EB;
  $gris:#F7F7F7;
  $verde: #00BD8E;
  $azul: #0D629B;
  $blanco: #FFFFFF;
  $negro:#1A1320;
  $blue: #54b2f1; 
  $accent:#0B97F4;
  $accent2:#007bff;
  $gris2:  #364265;
  $accent3: rgba(149, 168, 238, 0.11);
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
       /* Fondo gris */
       padding: 4rem;
        text-align: center;
        color: $blanco;
        text-shadow: #000000;
        width: 50%;
        background: linear-gradient( $bg, $degradado), url("src/assets/buenosaires.jpg") no-repeat center/cover;
        box-sizing: border-box;
        .left-content-inner {
           margin-right: 40px; /* Agregar margen derecho de 40px entre el título y el texto */
           .text-login  {
            margin-top: 15rem;
            text-align: center;
            margin: 6rem 0;
            font-size: 2rem;
          }
          .tittle{
            font-size: 4rem;
            font-weight: bolder;
            color: transparent;
            -webkit-text-stroke: 0.2rem $blanco;
          }

          .text1{
            font-size: 2.5rem;
            margin-top: 25%;
            text-align: center;
            font-weight: bolder;
          }
        }

      }
     

    .creacionV-container {
      width: 50%;
      display: flex;
      flex-direction: column;
      align-items: center;
      text-align: center;
      padding-top: 3rem;
      background-color: $secondary; 

      h1 {
        margin: 0;
        color: $negro;
        
      }

      input, select{
          width: 80%;
          margin-top: 10rem;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
      }

      .login {
        width: 80%;
        padding: 10px;
        margin-top: 45px;
        background-color: $blue;
        color: #fff;
        border: none;
        border-radius: 5px;
        margin-bottom: 2rem;
        cursor: pointer;
      }

      .box-recovery-password{
        position: relative;
        
        .recovery-password{
          font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
          background-color: transparent;
          position: absolute;
          top: 0;
          right: 0; 
        }
      }

      .register {
        width: 40%;
        padding: 10px;
        
        background-color: #364265;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-bottom: 2rem;
      }

      .tittle {
        margin-top: 20px;
        font-size: 5rem;
      }

      .text2{
        font-family: 'Courier New', Courier, monospace;
        //font-size: small;
        text-align: center;
        margin-top: 10px;
        font-weight: bolder;
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
        .creacionV-container {
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

        .creacionV-container {
           .texto{
                margin-top:5rem ;
            }
            
            
        }
    }
      
  }

</style>



<script>
import flightService from "@/services/flightService/createFlightService.js";
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from '@/components/footer.vue';

export default {
  data() {
    return {
      flightDate: "",
      origin: "",
      destination: "",
      flightDuration: "",
      arrivalDate: "",
      costByPerson: "",
      errorMessage: "",
      showErrorMessage: false,
      showSpinner: false,
      flightDurationValue: "", // Nuevo campo para el valor numérico de la duración
      flightDurationUnit: "hours", // Nuevo campo para la unidad de la duración (por defecto: horas)
    };
  },
  methods: {

    validateAndCreateFlight() {
      // Validar que el origen y destino no sean el mismo lugar
      if (this.origin === this.destination) {
        this.errorMessage = "El origen y el destino no pueden ser iguales.";
        this.showErrorMessage = true;
        return;
      }

      // Validar que la fecha de vuelo no sea en el pasado
      const currentDate = new Date().toISOString().split("T")[0];
      if (this.flightDate < currentDate) {
        this.errorMessage = "La fecha del vuelo no puede ser en el pasado.";
        this.showErrorMessage = true;
        return;
      }
  


      // Validar otras restricciones (duración del vuelo, etc.)

      // Llamar al método createFlight si todas las validaciones pasan
      this.createFlight();
    },
    createFlight() {
      this.showSpinner = true;
      const {
        flightDate,
        origin,
        destination,
        flightDuration,
        arrivalDate,
        costByPerson
      } = this;
      let totalDuration = this.flightDurationValue;
      if (this.flightDurationUnit === "hours") {
        totalDuration *= 60; // Convertir horas a minutos
      }
      const flightData = {
        flightDate: this.flightDate,
        origin: this.origin,
        destination: this.destination,
        flightDuration: flightDuration, // Usa la variable local o this.flightDuration según corresponda
        arrivalDate: this.arrivalDate,
        costByPerson: this.costByPerson,
      };
      flightService.saveFlight(flightData)
        .then((response) => {
          console.log("Vuelo creado:", response.data);
          this.showSpinner = false;
          // Puedes redirigir al usuario o mostrar un mensaje de éxito aquí
        })
        .catch((error) => {
          this.showSpinner = false;
          console.error("Error al crear el vuelo:", error);
          this.errorMessage = "Error al crear el vuelo";
          this.showErrorMessage = true;
        });
       // Convertir 'totalDuration' a formato HH:MM:SS
      const hours = Math.floor(totalDuration / 60);
      const minutes = totalDuration % 60;
      const seconds = 0; // Puedes dejar los segundos en 0 o agregar lógica para ellos si es necesario

      // Formatear los valores para asegurar que tengan dos dígitos
      const formattedHours = String(hours).padStart(2, "0");
      const formattedMinutes = String(minutes).padStart(2, "0");
      const formattedSeconds = String(seconds).padStart(2, "0");

      const formattedDuration = `${formattedHours}:${formattedMinutes}:${formattedSeconds}`;
      flightDuration = formattedDuration;
      flightService.createFlight(flightDate, origin, destination, flightDuration, arrivalDate,costByPerson).then((response) => {
          console.log("Vuelo creado:", response.data);
          this.showSpinner = false;
          // Puedes redirigir al usuario o mostrar un mensaje de éxito aquí
        })
        .catch((error) => {
          this.showSpinner = false;
          console.error("Error al crear el vuelo:", error);
          this.errorMessage = "Error al crear el vuelo";
          this.showErrorMessage = true;
        });
    },

    // Otros métodos según sea necesario
  },
  components: {
    errorModal,
    spinner,
    Footer,
  },
};
</script>