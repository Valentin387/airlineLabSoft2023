<template>
  <div>
    <h2>Resultados de la búsqueda</h2>
    <!-- Verifica si hay vuelos para mostrar -->
    <ul v-if="flights && flights.length > 0">
    <!-- Renderizar vuelos aquí -->
      <li v-for="(flight, index) in flights" :key="index">
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
export default {
  data() {
    return {
      flights: [],
    };
  },
  mounted() {
    // Carga los vuelos almacenados en el almacenamiento de la sesión
    const storedResults = sessionStorage.getItem('searchResults');
    console.log("Stored Results:", storedResults);

    if (storedResults) {
      this.flights = JSON.parse(storedResults);
      console.log("Flights:", this.flights);
    }
  }

};
</script>
