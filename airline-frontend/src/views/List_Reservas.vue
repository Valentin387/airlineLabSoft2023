<template>
    <div class="cont-reservas">
      <h1>Lista de reservas</h1>
      <div class="reservas-container">
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
export default {
  data() {
    return {
      reservas: [] 
    };
  },
  methods: {
    cargarDatosSimulados() {
    },
    cancelarReserva(reservaId) {
      // Implementa la lógica para cancelar la reserva aquí
      // Puedes eliminar la reserva del arreglo
      this.reservas = this.reservas.filter(reserva => reserva.id !== reservaId);
    },
    moverAlCarrito(reservaId) {
      // Implementa la lógica para mover la reserva al carrito aquí
    }
  },
  created() {
    this.cargarDatosSimulados(); // Llama al método de carga de datos simulados al iniciar el componente
  }
};
</script>
  