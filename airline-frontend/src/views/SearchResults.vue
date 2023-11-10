<template>
  <div>
    <h2>Resultados de la búsqueda</h2>
    <!-- Verifica si hay vuelos para mostrar -->
    <ul v-if="flights.length > 0">
      <li v-for="flight in flights" :key="flight.ID">
        <!-- Muestra la información del vuelo -->
        <p>ID: {{ flight.ID }}</p>
        <p>Origen: {{ flight.origin }}</p>
        <p>Destino: {{ flight.destination }}</p>
        <!-- Agrega más campos según sea necesario -->
      </li>
    </ul>
    <!-- Mensaje si no hay vuelos encontrados -->
    <p v-else>No se encontraron vuelos con los criterios seleccionados.</p>
  </div>
</template>

<script>
import flightService from '@/services/searchService/parametrizedSearchService.js';

export default {
  data() {
    return {
      flights: [],
    };
  },
  mounted() {
    // Cuando el componente se monta, carga los vuelos con los parámetros de la URL
    this.loadFlights();
  },

  methods: {
    loadFlights() {
      // Obtiene los parámetros de la URL
      const queryParams = new URLSearchParams(this.$route.params);

      const searchParams = {
        origin: queryParams.get('origin') || '',
        destination: queryParams.get('destination') || '',
        departureDate: queryParams.get('departureDate') || '',
      };

      // Llama al servicio para obtener los vuelos
      flightService.parametrizedSearch(searchParams)
        .then(response => {
          // Maneja la respuesta de la API aquí
          console.log(response.data);
          this.flights = response.data; // Asigna la lista de vuelos a la propiedad data
        })
        .catch(error => {
          // Maneja el error de la API
          console.error(error);
        });
    },
  },
};
</script>
