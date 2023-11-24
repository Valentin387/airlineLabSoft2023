<template>
  <div class="flight-detail" v-if="Object.keys(flight).length">
    <div class="flight-info">
      <img class="flight-image" :src="flight.imageSrc">
      <div class="flight-details">
        <div class="flight-info-item">
          <div class="black-info">
            <h2>{{ flight.name }}</h2>
            <p>${{ flight.price }}</p>
          </div>
          <p>Fecha: {{ formatDate(flight.flightDate) }}</p>
          <p>Hora: {{ flight.time }}</p>
          <p>Origen: {{ flight.origin }}</p>
          <p>Destino: {{ flight.destination }}</p>
          <p>Tiempo de vuelo: {{ formatDuration(flight.flightDuration) }}</p>
          <p>Fecha de llegada: {{ formatDate(flight.arrivalDate) }}</p>
          <p>Hora de llegada: {{ flight.arrivalTime }}</p>
          <p>Costo del vuelo por persona: ${{ flight.costByPerson }}</p>
          <div class="seats-input">
            <label for="seats">Asientos:</label>
            <input type="number" id="seats" v-model="selectedSeats" min="1" max="5" @change="updateTotalPrice" />
          </div>
          <div class="class-input">
            <label for="class">Clase:</label>
            <select id="class" v-model="selectedClass">
              <option value="First Class">Primera Clase</option>
              <option value="Economic Class">Clase Económica</option>
            </select>
          </div>
        </div>
        <div class="action-buttons">
          <button class="right-button" @click="addToCart">Añadir al carrito</button>
        </div>
      </div>
    </div>
  </div>
  <div v-else>
    <p class="loading">Cargando detalles del vuelo...</p>
  </div>
</template>


<style lang="scss">

  .flight-detail {
    /*margin: 0 auto;
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente 
    margin-top: 10rem; /* Centrar verticalmente 
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;*/

    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */
    border-radius: 10px;
    display: flex;
    justify-content: space-between;
    overflow: hidden;
  }


  .flight-image {
    max-width: 50%;
    max-height: 300px;
    margin-right: 20px;
  }


  .black-info {
    font-weight: bold;
    font-size: 20px;
  }

  .flight-info-item {
    margin-top: 2px;
    font-size: 13px;
  }

  .flight-seats {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 10px;
    font-size: 13px;

    .seats-input,
    .class-input {
      display: flex;
      align-items: center;

      label {
        margin-right: 5px; /* Ajusta el valor según tus preferencias */
      }
    }
  }

  .action-buttons button {
    display: inline;
    justify-content: center;
    margin-top: 20px;
  }

  .right-button {
    background-color: rgb(233, 230, 230);
    color: rgb(128, 128, 187);
    border: 10px solid rgb(233, 230, 230);
    border-radius: 5px;
  }

  .left-button {
    background-color: #1c88cf;
    color: rgb(233, 233, 233);
    border: 10px solid #1086d4;
    border-radius: 5px;
  }

  .loading {
    text-align: center;
  }

  button {
    margin: 0 10px;
  }

  .flight-info {
    display: flex;
    align-items: center;

    .flight-details {
      flex: 1;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      padding-left: 20px; // Ajusta el espacio entre la imagen y la información
    }

    .seats-input,
    .class-input {
      margin-top: 10px;
    }
  }

  .flight-image {
    max-width: 50%;
    max-height: 300px;
    margin-right: 20px;
  }

  @media screen and (max-width: 1000px) {
    .flight-detail {
      width: 70%;
      margin-top: 10rem;
    }

    .flight-info {
      flex-direction: column;

      .flight-image {
        display: none;
      }
    }
  }

  @media screen and (max-width: 650px) {
    .flight-detail {
      width: 90%;
    }
  }

  @media screen and (max-width: 500px) {
    .flight-detail {
      height: 100%;
      margin-top: 10rem;
    }

    .flight-info {
      .texto {
        margin-top: 5rem;
      }
    }
  }

</style>


<script>
  import addToCartService from '@/services/shoppingCartServices/addToCartService.js';

  export default {
    name: 'DetalleVuelo',
    data() {
      return {
        flight: { imageSrc: "@src/assets/madrid.jpg" },
        selectedSeats: 1,
        selectedClass: 'Primera Clase', // Valor predeterminado
        loading: true,
      };
    },
    methods: {
      addToCart() {
        const token = window.sessionStorage.getItem('JWTtoken');
        const tokenData = JSON.parse(atob(token.split('.')[1]));
        const userID = tokenData.ID;
        const flightID = this.flight.id;
        const seatQuantity = this.selectedSeats;
        const seatClass = this.selectedClass;

        // Llamar al servicio para añadir el vuelo al carrito
        addToCartService.addToCart(userID, flightID, seatQuantity, seatClass)
          .then(response => {
            console.log('Vuelo añadido al carrito exitosamente:', response.data);
          })
          .catch(error => {
            console.error('Error al añadir el vuelo al carrito:', error);
          });
      },
      updateTotalPrice() {
        // Actualiza el precio total multiplicando el costo por persona por la cantidad de asientos seleccionados
        this.flight.price = this.selectedSeats * this.flight.costByPerson;
      },
      formatDate(dateString) {
        //Cambia el formato de la fecha de milisegundos a años, meses y dias
        const options = { year: "numeric", month: "long", day: "numeric" };
        const date = new Date(dateString);
        return date.toLocaleDateString("es-ES", options);
      },
      formatDuration(duration) {
        //formato simplificado de tiempo de duración del vuelo ( reemplaza 00:00:00)
        const parts = duration.split(":").map((part) => parseInt(part, 10));
        const hours = parts[0];
        const minutes = parts[1];

        if (hours > 0) {
          return hours;
        } else {
          return hours * 60 + minutes;
        }
      },
    },
    created() {
    // Recupera los detalles del vuelo almacenados en sessionStorage
    const storedFlightDetails = sessionStorage.getItem("DetalleVuelo");

    if (storedFlightDetails) {
      // Convierte los detalles del vuelo de nuevo a un objeto JavaScript
      this.flight = JSON.parse(storedFlightDetails);
      // Inicializa el precio total con el costo por persona por defecto (por ejemplo, para 1 asiento)
      this.flight.price = this.flight.costByPerson;
      this.loading = false; // Marca como cargado
    }
  },
};
</script>

