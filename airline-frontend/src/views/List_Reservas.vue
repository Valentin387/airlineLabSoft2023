<template>
  <div class="cont-reservas">
    <h1>Lista de reservas</h1>
    <div class="reservas-container">
      <!-- Mostrar el esqueleto de la reserva incluso si no hay datos -->
      <div v-if="reservas.length === 0">
        <div v-for="index in 5" :key="index" class="reserva">
          <div class="info">
            <p><strong>Origen/Destino:</strong> Cargando...</p>
            <p><strong>Fecha de despegue:</strong> Cargando...</p>
            <p><strong>Clase:</strong> Cargando...</p>
            <p><strong>Cantidad de tiquetes:</strong> Cargando...</p>
            <p><strong>Precio total:</strong> Cargando...</p>
          </div>
          <div class="acciones">
            <button class="delete-reserv" :disabled="true">Cancelar reserva</button>
            <button class="move-reserv" :disabled="true">Mover al carrito</button>
          </div>
        </div>
      </div>
      <!-- Mostrar las reservas reales cuando están disponibles -->
      <div v-else>
        <div v-for="reserva in reservas" :key="reserva.id" class="reserva">
          <div class="info">
            <p><strong>Origen/Destino:</strong> {{ reserva.origenDestino }}</p>
            <p><strong>Fecha de despegue:</strong> {{ reserva.fechaDespegue }}</p>
            <p><strong>Clase:</strong> {{ reserva.clase }}</p>
            <p><strong>Cantidad de tiquetes:</strong> {{ reserva.cantidadTiquetes }}</p>
            <p><strong>Precio total:</strong> ${{ reserva.precioTotal }}</p>
          </div>
          <div class="acciones">
            <button class="delete-reserv" @click="cancelarReserva(reserva.id)">Cancelar reserva</button>
            <button class="move-reserv" @click="moverAlCarrito(reserva.id)">Mover al carrito</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

  
<style lang="scss">

  .cont-reservas{
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */
  }

  .reservas-container {
    background-color: #f0f0f0;
    padding: 20px;
    border-radius: 5px;
    margin-top: 20px;
  }
  
  .reserva {
    display: flex;
    justify-content: space-between;
    border: 1px solid #ccc;
    padding: 10px;
    margin-bottom: 10px;
  }
  
  .info {
    flex: 1;
  }
  
  .acciones {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    }

    .delete-reserv {
    background-color: #b8b8b8;
    color: white;
    border: none;
    padding: 5px 10px;
    border-radius: 5px;
    cursor: pointer;
    }

    .move-reserv {
    background-color: #007BFF;
    color: white;
    border: none;
    padding: 5px 10px;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 20px;
    }

    button:hover {
    background-color: #0056b3;
    }
</style>

<script>
  import listReservationService from '@/services/reservationService/listReservationService.js';
  import cancelReservationService from '@/services/reservationService/cancelReservationService.js';
  import moveToCartService from '@/services/reservationService/moveToCartService.js';

  export default {
    data() {
      return {
        reservas: []
      };
    },
    methods: {
      cargarReservas() {
        const userID = obtenerIdUsuario(); 
        listReservationService.getReservations(userID)
          .then(response => {
            this.reservas = response.data;
          })
          .catch(error => {
            console.error('Error al obtener las reservas:', error);
          });
      },
      cancelarReserva(reservaId) {
        // Llama al servicio para cancelar la reserva
        cancelReservationService.cancelReservation({ reservationID: reservaId })
          .then(response => {
            // Actualiza la lista de reservas después de la cancelación
            this.cargarReservas();
            console.log('Reserva cancelada exitosamente:', response.data);
          })
          .catch(error => {
            console.error('Error al cancelar la reserva:', error);
          });
      },
      moverAlCarrito(reservaId) {
        // Llama al servicio para mover la reserva al carrito
        moveToCartService.moveToCart({ reservationID: reservaId, userID: obtenerIdUsuario() })
          .then(response => {
            // Actualiza la lista de reservas después de moverla al carrito
            this.cargarReservas();
            console.log('Reserva movida al carrito exitosamente:', response.data);
          })
          .catch(error => {
            console.error('Error al mover la reserva al carrito:', error);
          });
      }
    },
    created() {
      this.cargarReservas();
    }
  };
</script>
  