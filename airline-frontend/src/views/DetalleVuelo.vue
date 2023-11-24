<template>
  <div class="flight-detail" v-if="Object.keys(flight).length">
    <div class="flight-info">
      <img v-if="flight.destination === 'Miami'" src="../assets/miami.jpg" alt="Miami Image" class="flight-image" />
      <img v-else-if="flight.destination === 'Londres'" src="../assets/londres.jpg" alt="Londres Image"
        class="flight-image" />
      <img v-else-if="flight.destination === 'Madrid'" src="../assets/madrid.jpg" alt="Madrid Image"
        class="flight-image" />
      <img v-else-if="flight.destination === 'Buenos Aires'" src="../assets/buenosaires.jpg" alt="Buenos AiresImage"
        class="flight-image" />
      <img v-else-if="flight.destination === 'Bogotá'" src="../assets/bogota.jpeg" alt="Bogotá Image"
        class="flight-image" />
      <img v-else-if="flight.destination === 'Cali'" src="../assets/cali.jpg" alt="Cali Image" class="flight-image" />
      <img v-else-if="flight.destination === 'Cartagena'" src="../assets/cartagena.jpeg" alt="Cartagena Image"
        class="flight-image" />
      <img v-else-if="flight.destination === 'Medellín'" src="../assets/medellin.jpg" alt="Medellin Image"
        class="flight-image" />
      <img v-else-if="flight.destination === 'New York'" src="../assets/newyork.jpg" alt="New York Image"
        class="flight-image" />
      <img v-else-if="flight.destination === 'Pereira'" src="../assets/pereira.jpg" alt="Pereira Image"
        class="flight-image" />
      <img v-else src="../assets/crearAdmin.svg" alt="Default Image" class="flight-image" />
      <div class="flight-details">
        <div class="black-info">
          <h2>{{ flight.name }}</h2>
          <p> <strong>{{ flight.origin }} - {{ flight.destination }} </strong></p>
          <p><strong>$ </strong>{{ flight.price }}</p>
        </div>
        <p> <strong>Fecha: </strong> {{ formatDate(flight.flightDate) }}</p>
        <p><strong> Tiempo de vuelo: </strong>  {{ formatDuration(flight.flightDuration) }}
        <span class="letrahoras" v-if="isDurationHours(flight.flightDuration)">
          horas
        </span>
        <span v-else>minutos</span></p> 
       
       
        <p> <strong> Fecha de llegada: </strong> {{ formatDate(flight.arrivalDate) }}</p>
        <p><strong> Costo del vuelo por persona: </strong> ${{ flight.costByPerson }}</p>
        <div class="seats-input">
          <label for="seats"> <strong> Asientos: </strong></label>
          <input type="number" id="seats" v-model="selectedSeats" min="1" max="5" @change="updateTotalPrice" />
        </div>
        <div class="class-input">
          <label for="class"><strong> Clase:</strong></label>
          <select class="classe" v-model="selectedClass">
            <option value="First Class">Primera Clase</option>
            <option value="Economic Class">Clase Económica</option>
          </select>
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
  <Footer></Footer>
</template>


<style lang="scss" scoped>
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
  justify-content: center;
  background-color: $secondary;
  width: 90vw;
  margin: 0 auto;
  /* Centrar horizontalmente */
  margin-top: 10rem;
  /* Centrar verticalmente */
  border-radius: 10px;
  display: flex;
  justify-content: space-between;
  overflow: hidden;
}

.classe select {
  width: 80%;
  margin-top: 10rem;
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.flight-image {
  max-width: 50%;
  max-height: 300px;
  width: 100%;
  border-radius: 15px;
  /* Ajusta el valor según tus preferencias */
  margin-right: 20px;
  box-shadow: 6px 6px 1px rgba(5, 1, 5, 0.2);
}


.black-info {
  font-weight: bold;
  font-size: 3rem;
}

.flight-info-item {
  margin-top: 2px;
  font-size: 15px;
}

.flight-seats {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 10px;
  font-size: 15px;


}

.action-buttons button {
  display: inline;
  justify-content: center;
  margin-top: 20px;
}

.right-button {
  width: 30%;
  padding: 9px;
  background-color: #364265;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 2rem;

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
  margin: 0 auto;
  margin-top: 2rem;
  margin-bottom: 2rem;

  .flight-details {
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding-left: 20px; // Ajusta el espacio entre la imagen y la información

    .seats-input,
    .class-input {
      display: flex;
      align-items: center;

      label {
        margin-right: 5px;
        /* Ajusta el valor según tus preferencias */
      }

      select,
      input {
        width: 40%;
        margin-top: 10rem;
        margin: 1px 0;
        padding: 1rem;
        margin-left: 1rem;
        border: 1px solid #ccc;
        border-radius: 5px;
        /* Ajusta el valor según tus preferencias */
      }
    }

  }

  .seats-input,
  .class-input {
    margin-top: 10px;

  }
}

.flight-image {
  max-width: 50%;
  max-height: 100%;
  margin-right: 20px;
  margin-left: 4rem;
}

.flight-image-container {
  max-width: 50%;
  max-height: 50%;
  margin-left: 2rem;
  overflow: hidden;
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
import Footer from "@/components/footer.vue";

export default {
  name: 'DetalleVuelo',
  data() {
    return {
      flight: {

      },
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
    isDurationHours(duration) {
     //Permite saber si la duración del vuelo será en horas o minutos.( reemplaza 00:00:00)
     const parts = duration.split(":").map((part) => parseInt(part, 10));
     const hours = parts[0];
     return hours > 0;
   },



  },
  components: {
    Footer,
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

