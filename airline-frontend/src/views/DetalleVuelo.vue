<template>
    <div class="flight-detail" v-if="Object.keys(flight).length">
      <div class="flight-info">
        <img :src="flight.image" class="flight-image" />
        <div class="flight-details">
          <div class="flight-info-item">
            <div class="black-info">
              <h2>{{ flight.name }}</h2>
              <p>${{ flight.price }}</p>
            </div>
            <p>Fecha: {{ flight.date }}</p>
            <p>Hora: {{ flight.time }}</p>
            <p>Origen: {{ flight.origin }}</p>
            <p>Destino: {{ flight.destination }}</p>
            <p>Tiempo de vuelo: {{ flight.flightTime }}</p>
            <p>Fecha de llegada: {{ flight.arrivalDate }}</p>
            <p>Hora de llegada: {{ flight.arrivalTime }}</p>
            <p>Costo del vuelo por persona: ${{ flight.costPerPerson }}</p>
          </div>
          <div class="flight-seats">
            <label for="seats">Asientos: </label>
            <div class="seats-input">
              <input type="number" id="seats" v-model="selectedSeats" min="1" max="5" />
            </div>
          </div>
        </div>
      </div>
      <div class="action-buttons">
        <button class="left-button" @click="orderNow">Ordenar ahora</button>
        <button class="right-button" @click="addToCart">Añadir al carrito</button>
      </div>
    </div>
    <div v-else>
      <p class="loading">Cargando detalles del vuelo...</p>
    </div>
  </template>
  
  
<style lang="scss">
  .flight-detail {
    margin: 0 auto;
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
  
  .flight-info {
    display: flex;
    align-items: center;
  }
  
  .flight-image {
    max-width: 50%;
    max-height: 300px;
    margin-right: 20px;
  }
  
  .flight-details {
    flex: 1;
  }
  
  .black-info{
    font-weight: bold;
    font-size: 20px;
  }

  .flight-info-item {
    margin-top: 2px;
    font-size: 13px;
  }
  

  .flight-seats {
    margin-top: 10px;
    font-size: 13px;

    .seats-input {
        margin-top: 5px; /* Ajusta el valor según tus preferencias */
    }
  }
  
  .action-buttons button{
    display: inline;
    justify-content: center;
    margin-top: 20px;
  }

  .right-button{
    background-color: rgb(233, 230, 230);
    color: rgb(128, 128, 187);
    border: 10px solid rgb(233, 230, 230);
    border-radius: 5px;
  }

  .left-button{
    background-color: #1c88cf;
    color: rgb(233, 233, 233);
    border: 10px solid #1086d4;
    border-radius: 5px;
  }
  
  .loading{
    text-align: center;
  }

  button {
    margin: 0 10px;
  }
</style>

<script>
  import flightService from '@/services/FlightService/detailFlightService.js';
  import addToCartService from '@/services/shoppingCartServices/addToCartService.js';

  export default {
    data() {
      return {
        flight: {}, // Aquí almacenaremos la información del vuelo
        selectedSeats: 1,
        loading: true,
      };
    },
    methods: {
      addToCart() {
        const userID = obtenerIdUsuario(); 
        const flightID = this.flight.id; 
        const seatQuantity = this.selectedSeats;
        const seatClass = obtenerClaseAsiento(); 

        // Llamar al servicio para añadir el vuelo al carrito
        addToCartService.addToCart(userID, flightID, seatQuantity, seatClass)
          .then(response => {
            console.log('Vuelo añadido al carrito exitosamente:', response.data);
          })
          .catch(error => {
            console.error('Error al añadir el vuelo al carrito:', error);
          });
      },
      orderNow() {
        // Lógica para procesar el pedido
      },
      async fetchFlightDetails() {
        try {
          const flightId = obtenerIdDelVuelo(); 
          // Llamar al servicio para obtener los detalles del vuelo
          const response = await flightService.getDetailFlight(flightId);
          // Asignar los datos del vuelo a la propiedad flight
          this.flight = response.data;
        } catch (error) {
          console.error('Error al obtener los detalles del vuelo:', error);
        } finally {
          this.loading = false;
        }
      },
    },
    created() {
      this.fetchFlightDetails();
    },
  };
</script>

