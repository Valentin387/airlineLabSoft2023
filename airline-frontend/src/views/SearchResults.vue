<template>
  <div class="pagina">
    <!----------------------------------------Barra de busqueda de vuelos----------------------------- -->
    <section class="book-form" id="book-form">
      <form action="" @submit.prevent="performFlightSearch">
        <div class="inputBox">
          <span>Origen</span><!--Origen del vuelo -->
          <select name="origin" placeholder="¿Desde dónde vuelas?" v-model="searchParams.origin" required>
            <option value="" disabled selected>¿Desde dónde vuelas?</option>
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
        </div>

        <div class="inputBox">
          <span>Destino</span><!--Destino del vuelo-->
          <select name="destination" placeholder="¿A dónde vuelas?" v-model="searchParams.destination" required>
            <option value="" disabled selected>¿A dónde vuelas?</option>
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
        </div>
        <div class="inputBox">
          <!--Fecha de salida del vuelo -->
          <span>Fecha de salida</span>
          <input type="date" name="departureDate" v-model="searchParams.flightDate" required />
        </div>

        <!-- <div class="inputBox"> Fecha de regreso del vuelo 
                    <span>Fecha de regreso</span>
                    <input type="date" name="returnDate" v-model="searchParams.arrivalDate" required>
                </div> -->

        <div class="inputBox" id="numPasajeros">
          <!--Número de pasajeros del vuelo -->
          <span>¿Cuántos?</span>
          <input type="number" name="numPassengers" placeholder="Número de pasajeros" v-model="searchParams.numPassengers"
            required />
        </div>
        <input type="submit" value="Buscar" class="btn_buscar" /><!--Botón de busqueda de vuelo -->
      </form>
    </section> <!--Finaliza aquí la barra de búsqueda -->

    <div class="contenedores ">        
      <!-- Verifica si hay vuelos para mostrar -->
      <div v-if="flights && flights.length > 0">
        <!-- Renderizar vuelos aquí -->
        <div v-for="(flight, index) in flights" :key="index" class="flight-container">
          <!-- Muestra la información del vuelo con el nuevo formato -->
          <div class="flight-info">
            <div class="flight-details">
              <div class="time-location">
                <p class="flight-time">
                  {{ formatDate(flight.flightDate) }} - {{ formatDate(flight.arrivalDate) }}
                </p>
              </div>
              <p class="flight-duration">
                <span class="icon-flight">
                  <span class="material-icons-outlined">flight_takeoff</span>
                  {{ formatDuration(flight.flightDuration) }}
                  <span class="letrahoras" v-if="isDurationHours(flight.flightDuration)"> horas</span>
                  <span v-else>minutos</span>
                  <span class="material-icons-outlined">flight_land</span>

                  <span class="directo">Directo</span>
                </span>
              </p>
              <p class="flight-location">{{ flight.origin }} - {{ flight.destination }}</p>
            </div>
            <div class="flight-price">
              <p class="price">${{ flight.costByPerson }}</p>
              <!-- Botón "Ver Oferta" -->
              <button @click="verOferta(flight)">Ver Oferta</button>
            </div>
          </div>
        </div>
      </div>

      <!-- Mensaje si no hay vuelos encontrados -->
      <p v-else-if="flights && flights.length === 0">No se encontraron vuelos con los criterios seleccionados.</p>
      <p v-else>No se encontraron vuelos con los criterios seleccionados.</p>
    </div>
  </div>
  <Footer />
</template>

<style lang="scss" scoped>
$light-color: #312c02;
$degradado: rgba(149, 168, 238, 0.11);
$bg: rgba(6, 31, 14, 0.947);
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


//-------------------Barra de busqueda de vuelos -------------------------
.book-form {
  position: relative; //La barra de navegación se fija en la parte superior de la página
  width: 80%;
  margin: -1rem auto;
  display: fixed;
  margin-top: 5%;
  margin-bottom: 3%;
  background: $azul;
  border-radius: 3rem;
  padding: 3rem 2rem;
  box-shadow: 0 5px 8px rgba(1, 0, 1, 0.7);
  overflow: hidden;

  form {
    display: flex;
    align-items: flex-end;
    flex-wrap: wrap;
    gap: 1.5rem;

    .inputBox {
      flex: 1 1 20rem;

      span {
        font-size: 1.4rem;
        padding: 2rem;
        color: $blanco;
        text-transform: capitalize;
      }

      input,
      select {
        //select--> selectores de Origen de vuelo y destino de vuelo
        //input--> selectores de fecha de salida, fecha de regreso y número de pasajeros
        width: 100%;
        padding: 1.2rem 1.4rem;
        border-radius: 5rem;
        border: $accent 0.3rem solid;
        font-size: 1.6rem;
        color: $light-color;
        text-transform: none;
        background: $blanco;
        margin-top: 1rem;
      }
    }

    .btn_buscar {
      flex: 1 1 15rem;
      align-content: center;
      border: $accent 0.3rem solid;
    }
  }
}

.btn_buscar {
  //------Botón de buscar vuelo
  margin-top: 1rem;
  display: inline-block;
  padding: 1rem 3rem;
  font-size: 1.7rem;
  color: $accent;
  border: $azul 0.2rem solid;
  border-radius: 5rem;
  cursor: pointer;
  background: $blanco;

  &:hover {
    background: $accent;
    color: $blanco;
    text-decoration-line: none;
  }
}

//-------------------------

.contenedores {
  //position: relative;
  //display: fixed;
  flex-wrap: wrap;
  width: 100%;
  margin: 0 auto;
  overflow: hidden;


  .flight-container {
    //position: sticky;
    //display: fixed;
    margin: 0 auto;
    //flex-wrap: wrap;
    width: 100%;
    // max-width: 45vw;
    /* Define un ancho máximo para mantenerlo legible */
    align-items: center;

    display: center;
    background: #0d629b17;
    border-radius: 3rem;
    flex-direction: column;
    /* Cambia la disposición a columnas en pantallas pequeñas */
    padding: 3rem 2rem;
    padding: 2rem;
    /* Ajusta el relleno general para pantallas pequeñas */

    backdrop-filter: blur(20px);
    box-shadow: 6px 6px 6px rgba(5, 0, 0, 0.2);
    overflow: visible;
    margin-top: 5rem;


    .flight-info {
      display: flex;

      justify-content: space-between;

      .flight-details {
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: center;
        /* Centra verticalmente el contenido */
        // padding-left: 2%;


        .time-location {
          display: flex;
          flex-direction: column;

          margin-bottom: 1rem;
          /* Espaciado entre elementos */
        }

        .flight-time {
          margin-right: 1rem;
          font-weight: bolder;
          color: $azul;
        }

        .flight-location {
          display: flex;
          font-size: 1.6rem;
          color: $negro;

        }

        .flight-duration {

          font-size: 1.6rem;
          color: $negro;

          .icon-flight {
            display: flex;
            align-items: center;
            justify-content: space-between;
            font-size: 1.6rem;

            .directo {
              font-weight: bolder;
               
            }

          }

          .material-icons-outlined {
            font-family: 'Material Icons';
            font-size: 2.5rem;
            line-height: 1;
            margin: 0rem;
            // margin-left: 15%;
            display: inside;
            color: $blue;

            .letrahoras {
              color: $negro;
              margin-left: 4%;
            }

          }


        }
      }

      .flight-price {
        flex: 1;
        display: flex;
        flex-direction: column; // Alineados como columnas
        align-items: flex-end;
        // padding-right: 2%;

        .price {
          font-size: 2.5rem;
          font-weight: bold;
          color: $verde;

        }

        button {
          position: sticky;

          padding: 1rem 2rem;
          background-color: $blue;
          color: $blanco;
          border: none;
          border-radius: 5rem;
          cursor: pointer;
          margin-top: 1rem;


          &:hover {
            background-color: $accent;
          }
        }
      }
    }
  }
}

.flight-info {
  display: flex;
  flex-direction: column;

  .flight-details,
  .flight-price {
    width: 100%;
  }

  .flight-price {
    /* Cambia el orden, lo pone antes en pantallas pequeñas */
    margin-top: 1rem; /* Agrega un margen entre la información del vuelo y el precio */
  }

  .flight-details {
    margin-bottom: 1rem; /* Agrega espacio entre la información del vuelo y el botón */
  }

  @media screen and (min-width: 720px) {
    flex-direction: row; /* Vuelve a la disposición en fila en pantallas más grandes */

    .flight-price {
      order: initial; /* Restaura el orden original en pantallas más grandes */
      margin-top: 0; /* Elimina el margen en pantallas más grandes */
    }

    .flight-details {
      margin-bottom: 0; /* Elimina el espacio entre la información del vuelo y el botón */
    }
  }
}


.flight-container {
  margin: 5% auto;
  width: 90%;
  max-width: 45rem;
  /* Por ejemplo, puedes cambiar este valor según tus necesidades */
  /* Otros estilos aquí */
}

.book-form {
  width: 90%;
  margin: 5% auto;
  /* Otros estilos aquí */
}


/* Media query para pantallas más grandes */
@media screen and (min-width: 1024px) {
  .flight-container {
    max-width: 80rem;
    
  }
}
</style>
<script>
import flightService from "@/services/searchService/parametrizedSearchService.js";
import Footer from "@/components/footer.vue";
import errorModal from "@/components/ErrorModal.vue";
export default {
  components: {
    Footer,
    errorModal,
  },
  data() {
    return {
      flights: [],
      searchParams: {
        origin: "",
        destination: "",
        flightDate: "",
        //arrivalDate: "",
        numPassengers: 1,
      },
      showNumberError: false,
      numberErrorMessage: "",
    };
  },
  methods: {
    verOferta(flight) {//Botón de ber oferta del vuelo
      // Lógica para ver la oferta del vuelo
      console.log('Ver oferta para el vuelo:', flight);
      // Puedes redirigir a una página de detalles de la oferta, por ejemplo.
    },
    formatDate(dateString) {//Cambia el formato de la fecha de milisegundos a años, meses y dias 
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      const date = new Date(dateString);
      return date.toLocaleDateString('es-ES', options);
    },
    formatDuration(duration) {//formato simplificado de tiempo de duración del vuelo ( reemplaza 00:00:00)
      const parts = duration.split(':').map(part => parseInt(part, 10));
      const hours = parts[0];
      const minutes = parts[1];

      if (hours > 0) {
        return hours;
      } else {
        return hours * 60 + minutes;
      }
    },


    isDurationHours(duration) {
      const parts = duration.split(':').map(part => parseInt(part, 10));
      const hours = parts[0];
      return hours > 0;
    },
    performFlightSearch() { //Busqueda de vuelos
      if (this.searchParams.numPassengers <= 0 || isNaN(this.searchParams.numPassengers)) {
        // Mostrar un mensaje de error o tomar la acción correspondiente
        this.showNumberError = true;
        this.numberErrorMessage = "Por favor, ingrese un número válido de pasajeros.";
        return;
      }
      if (this.searchParams.numPassengers > 16) {
        this.showNumberError = true;
        this.numberErrorMessage = "Las búsquedas tienen un máximo de 16 pasajeros.";
        return;
      }

      flightService
        .parametrizedSearch(this.searchParams)
        .then((response) => {
          console.log(response.status);
          if (response.status === 200) {
            console.log("Vuelos encontrados:", response.data);
            this.flights = response.data;
            // Cuando el usuario realiza una búsqueda, almacenar los parámetros en sessionStorage
            sessionStorage.setItem('searchResults', JSON.stringify(response.data));

          }
        })
        .catch((error) => {
          console.error("Error en la búsqueda de vuelos:", error);
        });
    },
  },
  mounted() {
    const storedOrigin = sessionStorage.getItem('searchOrigin');
    const storedDestination = sessionStorage.getItem('searchDestination');
    const storedFlightDate = sessionStorage.getItem('searchFlightDate');
    const storedNumPassengers = sessionStorage.getItem('searchNumPassengers');

    if (storedOrigin && storedDestination && storedFlightDate && storedNumPassengers) {
      this.searchParams.origin = storedOrigin;
      this.searchParams.destination = storedDestination;
      this.searchParams.flightDate = storedFlightDate;
      this.searchParams.numPassengers = storedNumPassengers;
    }
    // Carga los vuelos almacenados en el almacenamiento de la sesión
    const storedResults = sessionStorage.getItem('searchResults');
    console.log("Stored Results:", storedResults);

    if (storedResults) {
      this.flights = JSON.parse(storedResults);
      console.log("Flights:", this.flights);


    }
  },
};
</script>