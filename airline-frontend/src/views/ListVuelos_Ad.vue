<template>
  <div class="list_container">
    <div class="buttons-container">
      <div class="left-buttons">
        <button @click="showFlights('activos')" :class="{ activeButton: filter === 'activos' }">Activos</button>
        <button @click="showFlights('realizados')" :class="{ activeButton: filter === 'realizados' }">Realizados</button>
        <button @click="showFlights('cancelados')" :class="{ activeButton: filter === 'cancelados' }">Cancelados</button>
      </div>
      <div class="right-button">
        <button @click="createFlight">Crear Vuelo</button>
      </div>
    </div>
    <div class="flight-list">
      <div class="tittle-container">
        <table>
          <thead>
            <tr>
              <th class="left-align">Vuelo</th>
              <th class="left-align">Fecha de Creación</th>
            </tr>
          </thead>
          <tbody>
            <tr v-if="filteredFlights.length === 0">
              <td class="warning" colspan="3">No se encontraron vuelos</td>
            </tr>
            <tr v-for="flight in filteredFlights" :key="flight.id" class="flight-item">
              <td class="flight">{{ flight.name }}</td>
              <td>{{ flight.creationDate }}</td>
              <td>
                <button class="button-delete" @click="removeFlight(flight.id)">x</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<style lang="scss">
  .list_container {
    margin: 0 auto;
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */
  }

  .buttons-container {
    display: flex;
    justify-content: space-between;
  }

  .left-buttons {
    display: flex;
    gap: 10px; /* Espacio entre los tres primeros botones */
  }

  .right-button {
    text-align: right;
  }

  .tittle-container {
    border: 1px solid #ccc;
    background-color: #e9e4e4;
    border-radius: 5px;
    max-height: 300px; 
    overflow-y: auto;
    margin-top: 20px;

  }

  table {
    width: 100%;
    border-collapse: collapse;
  }

  th, td {
    padding: 8px;
    text-align: center; 
  }

  .flight{
    text-align: left;
  }

  .warning{
    font-size: 20px;
  }

  .button-delete {
    background-color: rgb(163, 160, 160);
    color: white;
    border-radius: 5px;
    cursor: pointer;
  }

  .button-delete:hover {
    background-color: rgb(117, 117, 214); /* Cambia el color de fondo al pasar el mouse sobre el botón "Eliminar" */
  }

  .flight-item {
    border: 1px solid #b6b5b5; /* Agrega un borde de color gris oscuro a cada vuelo */
  }
  
  .left-buttons button {
    background-color: rgb(233, 230, 230);
    color: rgb(128, 128, 187);
    border: 10px solid rgb(233, 230, 230);
    border-radius: 5px;
  }

  .activeButton {
    background-color: rgb(117, 117, 214);
    color: white;
    border: 10px solid rgb(117, 117, 214);
    border-radius: 5px;
  }

  .right-button button {
    background-color: rgb(0, 0, 0);
    color: rgb(255, 255, 255);
    border: 3px solid rgb(0, 0, 0);
    border-radius: 5px;
    width: 120px;
  }
</style>

<script>
  export default {
    data() {
      return {
        flights: [], // Aquí almacenamos los vuelos obtenidos del backend
        filter: 'activos', // Filtro inicial
      };
    },
    created() {
      },
    computed: {
      filteredFlights() {
        // Filtrar los vuelos según el filtro seleccionado
        return this.flights.filter(flight => flight.status === this.filter);
      },
    },
    methods: {
      showFlights(filter) {
        this.filter = filter;
      },
      createFlight() {
        // Lógica para crear un nuevo vuelo
      },
      removeFlight(id) {
        // Eliminar el vuelo con el ID correspondiente
        this.flights = this.flights.filter(flight => flight.id !== id);
      },
    },
  };
</script>
