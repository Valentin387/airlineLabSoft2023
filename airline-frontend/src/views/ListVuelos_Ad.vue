<template>
  <div class="list_container">
    <div class="buttons-container">
      <div class="left-buttons">
        <button class = "activos" @click="showFlights('activos')" :class="{ activeButton: filter === 'activos' }">Activos</button>
        <button class= "realizados" @click="showFlights('realizados')" :class="{ activeButton: filter === 'realizados' }">Realizados</button>
        <button class = "cancelados" @click="showFlights('cancelados')" :class="{ activeButton: filter === 'cancelados' }">Cancelados</button>
      </div>
      <div class="right-button">
        <button  href= "/CrearVuelo" @click="createFlight">Crear Vuelo</button>
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
$light-color: #312c02;
$degradado: rgba(39, 64, 153, 0.479);
$bg: rgba(6, 31, 14, 0.873);
$azul-claro: #cfe0eb;
$gris: #f7f7f7;
$gris2: #364265;
$verde: #00bd8e;
$azul: #0d629b;
$blanco: #ffffff;
$negro: #1a1320;
$accent: #0b97f4;
$accent3: #77797a;
$blue: #54b2f1;
$secondary: #ceeafd;
$card: #0d629b17;

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
    padding: 1rem 2rem;
    font-size: 1.7rem;
  
  }
  .activos:hover {
    background-color: #54b2f1; /* Cambia el color de fondo al pasar el mouse sobre los botones "Activos", "Realizados" y "Cancelados" */
    border: 0.5rem solid #0f293a17;
    color: white;
    margin: 1rem auto; //Centrado 
    display: inline-block;
  }
  .cancelados:hover {
    background-color: #54b2f1; /* Cambia el color de fondo al pasar el mouse sobre los botones "Activos", "Realizados" y "Cancelados" */
    border: 0.5rem solid #0f293a17;
    color: white;
    margin: 1rem auto; //Centrado 
    display: inline-block;
   
  }
  .realizados:hover {
    background-color: #54b2f1; /* Cambia el color de fondo al pasar el mouse sobre los botones "Activos", "Realizados" y "Cancelados" */
    border: 0.5rem solid #0f293a17;
    color: white;
    margin: 1rem auto; //Centrado 
    display: inline-block;
  }
  .right-button {
    text-align: right;
  }

  .tittle-container {
    border: 1px solid #0d629b17;
    background: #0d629b17;
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
    background: #0d629b17;
    color: white;
    border-radius: 5px;
    cursor: pointer;
    
  }

  .button-delete:hover {
    background-color: #54b2f1; /* Cambia el color de fondo al pasar el mouse sobre el botón "Eliminar" */
  }

  .flight-item {
    border: 1px solid #0d629b17;; /* Agrega un borde de color gris oscuro a cada vuelo */
  }
  
  .left-buttons button {
    background: #0d629b17;
    color: $azul;
    border: 3px solid #0d629b17;
    border-radius: 5px;
  }

  .activeButton {
    background-color: #54b2f1;
    color: white;
    border: 10px solid #54b2f1;
    border-radius: 5px;
  }

  .right-button button {
    background-color: $gris2;
    color: $blanco;
    margin: 1rem auto; //Centrado 
    display: inline-block;
    padding: 1rem 2rem;
    font-size: 1.7rem;
    border: $azul-claro .2rem solid;
    border-radius: 5rem;
    box-shadow: inset 0px 0px 0px 1px $negro;
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
        this.$router.push("/CrearVuelo");
      },
      removeFlight(id) {
        // Eliminar el vuelo con el ID correspondiente
        this.flights = this.flights.filter(flight => flight.id !== id);
      },
    },
  };
</script>
