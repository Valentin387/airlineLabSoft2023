
<template>
  <div class="page-container">
    <spinner :showSpinner="showSpinner"></spinner>
    <div class="left-content">
      <hr />
      <h1 class="tittle">Crea Nuevas Aventuras</h1>
      <hr />
      <div class="text-login">
        <p class="text1">
          ¡Ayuda a tus clientes a escoger un vuelo y comencemos a explorar el
          mundo juntos!
        </p>
      </div>
    </div>
    <div class="creacionV-container">
      <!-- Contenido para crear vuelos -->
      <hr />
      <h1>Crear Vuelo</h1>
      <hr />
      <hr />
      <form @submit.prevent="validateAndCreateFlight" id="flight-form">
        <label for="flightDate">Fecha de Salida</label>
        <input type="date" id="flightDate" v-model="flightDate" required />
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
          <input
            type="text"
            id="flightDuration"
            placeholder="Duración del Vuelo en HH:MM:SS"
            v-model="flightDuration"
            pattern="([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]"
            required
          />
        </div>
        <label for="arrivalDate">Fecha de Llegada</label>
        <input type="date" id="arrivalDate" v-model="arrivalDate" required />
        <input
          type="number"
          id="costByPerson"
          placeholder="Costo por persona"
          v-model="costByPerson"
          required
        />
        <button id="create-flight" class="login" type="submit">
          Crear Vuelo
        </button>
      </form>
      <!-- Mostrar mensaje de error como modal si es necesario -->
      <error-modal
        :show-error="showErrorMessage"
        :error-message="errorMessage"
        @close="showErrorMessage = false"
      />
    </div>
  </div>
  <!-- Footer aquí -->
  <Footer></Footer>
</template>


<style lang="scss" scoped >
$light-color: #2e2b18;
$degradado: rgba(34, 33, 39, 0.552);
$bg: rgba(25, 32, 57, 0.947);
$azul-claro: #cfe0eb;
$gris: #f7f7f7;
$verde: #00bd8e;
$azul: #0d629b;
$blanco: #ffffff;
$negro: #1a1320;
$blue: #54b2f1;
$accent: #0b97f4;
$accent2: #007bff;
$gris2: #364265;
$accent3: rgba(149, 168, 238, 0.11);
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

.page-container {
  height: 50%;
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
    background: linear-gradient($bg, $degradado),
      url("src/assets/madrid.jpg") no-repeat center/cover;
    box-sizing: border-box;

    .text-login {
      margin-top: 15rem;
      text-align: center;
      margin: 6rem 0;
      font-size: 2rem;
    }
    .tittle {
      font-size: 3rem;
      font-weight: bolder;
      color: transparent;
      -webkit-text-stroke: 0.2rem $blanco;
    }

    .text1 {
      font-size: 2rem;
      margin-top: 25%;
      text-align: center;
      font-weight: bolder;
      margin: 8rem 0;
    }
  }

  .creacionV-container {
    width: 50%;
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    padding-top: 2rem;
    padding-bottom: 9rem;
    background-color: $secondary;

    h1 {
      color: $azul;
      font-weight: bold;
      font-size: 3rem; /* Aumenta el tamaño de la fuente */
      letter-spacing: 1px; /* Aumenta el espaciado entre las letras */
      text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.456); /* Añade una sombra al texto */
      font-family: "Arial", sans-serif; /* Cambia la fuente (opcional) */
    }

    input,
    select {
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
      margin-top: 3rem;
      background-color: $blue;
      margin-bottom: 1rem;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
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

    .text2 {
      font-family: "Courier New", Courier, monospace;
      //font-size: small;
      text-align: center;
      margin-top: 10px;
      font-weight: bolder;
    }

    .error-message {
      color: red;
    }
  }
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bolder;
    font-size: 1.6rem;
    color: $negro;
    margin-top: 1rem;
    margin-right: 50%;
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
    .page-container {
      height: 100%;
      margin-top: 10rem;
    }

    .creacionV-container {
      .texto {
        margin-top: 5rem;
      }
    }
  }
}
</style>



<script>
import flightService from "@/services/flightService/createFlightService.js";
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from "@/components/footer.vue";

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
        costByPerson,
      } = this;

      const flightData = {
        flightDate: this.flightDate,
        origin: this.origin,
        destination: this.destination,
        flightDuration: this.flightDuration, // Usa la variable local o this.flightDuration según corresponda
        arrivalDate: this.arrivalDate,
        costByPerson: this.costByPerson,
      };

        // Comprueba si costByPerson comienza con 0
      if (String(this.costByPerson).startsWith('0')) {
          this.showSpinner = false;
          this.errorMessage = "El costo por persona no puede comenzar con 0";
          this.showErrorMessage = true;
          return;
      }
     
  

      // Convertir el costo a un número
      const cost = Number(this.costByPerson);
      this.showErrorMessage = true;
      // Verificar si el costo es un número válido y mayor que 0
      if (isNaN(cost) || cost <= 0) {
        this.errorMessage = "Por favor, ingresa un costo válido mayor que 0.";
        this.showErrorMessage = true;
        return;
      }

      flightService
        .createFlight(
          flightDate,
          origin,
          destination,
          flightDuration,
          arrivalDate,
          costByPerson
        )
        .then((response) => {
          if (response.status === 200) {
            console.log("Vuelo creado:", response.data);
            this.showSpinner = false;
            // Puedes redirigir al usuario o mostrar un mensaje de éxito aquí
          }
          return response; // Asegúrate de devolver una respuesta
        })
        .catch((error) => {
          this.showSpinner = false;
          console.error("Error al crear el vuelo:", error);
          this.errorMessage = "Error al crear el vuelo";
          this.showErrorMessage = true;
          return { error: "An error occurred." }; // Asegúrate de devolver una respuesta
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