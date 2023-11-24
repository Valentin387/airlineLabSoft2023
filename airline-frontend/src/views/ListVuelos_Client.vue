<template>
  
    <div class="imagen">
        <div v-if="flights && flights.length > 0">
            <div v-for="(flight, index) in flights" :key="index">
                <div v-if="index == 1">
                    <div class="content">
                        <span> Destino a {{ flight.destination }} </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="contenedores">
        <div v-if="flights && flights.length > 0">
            <div
            v-for="(flight, index) in flights"
            :key="index"
            class="flight-container"
            >
            <div class="flight-info">
                <div class="flight-details">
                <div class="time-location">
                    <p class="flight-time">
                    {{ formatDate(flight.flightDate) }} -
                    {{ formatDate(flight.arrivalDate) }}
                    </p>
                </div>
                <p class="flight-duration">
                    <span class="icon-flight">
                    <span class="material-icons-outlined">flight_takeoff</span>
                    {{ formatDuration(flight.flightDuration) }}
                    <span
                        class="letrahoras"
                        v-if="isDurationHours(flight.flightDuration)"
                    >
                        horas
                    </span>
                    <span v-else>minutos</span>
                    <span class="material-icons-outlined">flight_land</span>
                    <span class="directo">Directo</span>
                    </span>
                </p>
                <p class="flight-location">
                    {{ flight.origin }} - {{ flight.destination }}
                </p>
                </div>
                <div class="flight-price">
                  <p class="price">${{ flight.costByPerson }}</p>
                  <button @click="verOferta(flight)">Ver Oferta</button>
                </div>
            </div>
            </div>
        </div>
        <p v-else>No se encontraron vuelos con los criterios seleccionados.</p>
    </div>

</template>
  

<style lang="scss" scoped>
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


.imagen {
 
  margin: 0 auto;
  margin-top: 9rem;
  width: 100%;
  border-radius: 2rem;
  background: linear-gradient($degradado, $bg),
    url(../assets/homelondres.jpg) no-repeat; //Degradado sobre la imagen
  background-size: cover;
  background-position: center;
  display: flex;
  /*** Establece la altura mínima de la vista Home en un 80% de la altura de la ventana gráfica (vh-> view height).
        * La altura de la ventana gráfica (vh) es una unidad de medida que representa la altura de la ventana del navegador.*/
  min-height: 30vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding-bottom: 5rem;
  span {
    //Texto 1 posicionado sobre la imagen de fondo
    font-weight: bolder;
    color: transparent;
    -webkit-text-stroke: 0.1rem $blanco;
    // Esta línea establece el tamaño de fuente de un elemento al 4% del ancho de la ventana gráfica en el archivo Home.vue
    display: block;
    font-size: 7.5vw;
    color: $blanco;
    text-align: center;
    text-decoration-line: underline;
  }
}
.contenedores {
  flex-wrap: wrap;
  width: 85vw;
  margin: 0 auto;
  overflow: hidden;
  margin-top: 1vh;

  .flight-container {
    max-width: 80rem;
    margin: 0 auto;
    width: 90%;
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
              margin-left: 2%;
            }
          }

          .material-icons-outlined {
            font-family: "Material Icons";
            font-size: 2.5rem;
            line-height: 1;
            margin: 0rem;
            // margin-left: 15%;
            display: inside;
            color: $blue;

            .letrahoras {
              color: $negro;
              //margin-left: 4%;
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

/* Media query para pantallas más grandes */
@media screen and (min-width: 1024px) {
  .flight-container {
    max-width: 80rem;
  }
}

@media (max-width: 450px) {
  //Tamaño de celular
  html {
    font-size: 40%;
  }
  .imagen {
    span {
      //font-size: 40%;
      -webkit-text-stroke: 0.1rem $blanco !important;
    }
  }
}


@media (max-width: 1280px) {
  /* Estilos para pantallas con un ancho máximo de 1280px */
  .imagen {
    margin-top: 10rem;
    width: 90vw;
    align-items: center;
    margin-left: auto;
    /* Márgenes automáticos a la izquierda */
    margin-right: auto;
    /* Márgenes automáticos a la derecha */
  }
}
</style>
  
<script>
import router from '@/router';

export default {
  name: "ListVuelosClient",

  data() {
    return {
      flights: [],
      searchParams: {
        origin: "",
        destination: "",
        flightDate: "",
        arrivalDate: "",
        numPassengers: 1,
      },
      showNumberError: false,
      numberErrorMessage: "",
    };
  },
  mounted() {
    console.log("Hello");
    // Carga los vuelos almacenados en el almacenamiento de la sesión
    const storedResults = sessionStorage.getItem("ListVuelosClient");
    console.log("Stored Results:", storedResults);

    if (storedResults) {
      this.flights = JSON.parse(storedResults);
      console.log("Flights:", this.flights);
    }
  },

  methods: {
    verOferta(flight) {
      console.log("Ver oferta para el vuelo:", flight);

      sessionStorage.setItem("DetalleVuelo", JSON.stringify(flight));
      // Realiza la redirección a la página de detalle de vuelo
      router.push({ name: 'DetalleVuelo'});
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

};
</script>
  