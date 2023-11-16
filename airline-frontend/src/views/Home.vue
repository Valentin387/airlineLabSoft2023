"
<template>
  <!-----------------------------------Imagen de inicio de la pagina --------------------------------->
  <section class="Home" id="home">
    <div class="content">
      <span data-aos="fade-up" datas-aos-delay="150">Descubre</span>
      <h3 data-aos="fade-up" datas-aos-delay="300">Tu próximo destino</h3>
      <p>
        Encuentra las mejores ofertas en tiquetes de avión y comienza tu
        aventura
      </p>
    </div>
  </section>
  <!----------------------------------------Barra de busqueda de vuelos----------------------------- -->
  <section class="book-form" id="book-form">
    <form action="" @submit.prevent="performFlightSearch">
      <div class="inputBox">
        <span>Origen</span
        ><!--Origen del vuelo -->
        <select
          name="origin"
          placeholder="¿Desde dónde vuelas?"
          v-model="searchParams.origin"
         required>
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
        <span>Destino</span
        ><!--Destino del vuelo-->
        <select
          name="destination"
          placeholder="¿A dónde vuelas?"
          v-model="searchParams.destination"
        required>
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
        <input
          type="date"
          name="departureDate"
          v-model="searchParams.flightDate" required
        />
      </div>

      <!--<div class="inputBox"> Fecha de regreso del vuelo 
                    <span>Fecha de regreso</span>
                    <input type="date" name="returnDate" value="">
                </div>-->

      <div class="inputBox" id="numPasajeros">
        <!--Número de pasajeros del vuelo -->
        <span>¿Cuántos?</span>
        <input
          type="number"
          name="numPassengers"
          placeholder="Número de pasajeros"
          v-model="searchParams.numPassengers"
         required/>
      </div>
      <input
        type="submit"
        value="Buscar"
        class="btn_buscar"
      /><!--Botón de busqueda de vuelo -->
    </form>
  </section>
  <!-------------------Imagenes, información  y precio de los destinos del vuelo ---------------------->
  <section class="destination" id="destination">
    <div class="heading">
      <span>Nuestros destinos</span>
      <h1>Escoge el tuyo</h1>
    </div>

    <div class="box-container">
      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/miami.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Miami</h3>
          <p>
            Miami es una ciudad en el sureste de Florida, conocida por su clima
            tropical, playas impresionantes y vida nocturna vibrante. Es un
            destino popular para aquellos que buscan diversión, compras y
            relajación bajo el sol de Florida.
          </p>
          <a href="/Miami" class
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $1.717.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/londres.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Londres</h3>
          <p>
            La capital del Reino Unido, Londres, es una metrópolis diversa que
            combina la historia y la modernidad. Ofrece una amplia gama de
            atracciones, desde el Palacio de Buckingham hasta el Museo Británico
          </p>
          <a href="/Londres"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $1.717.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/newyork.jpg" alt="" />
        </div>
        <div class="content">
          <h3>New York</h3>
          <p>
            La Gran Manzana, Nueva York, es una de las ciudades más emblemáticas
            del mundo. Ofrece rascacielos imponentes, teatros de Broadway y una
            escena artística vibrante.
          </p>
          <a href="/New York"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $1.717.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/madrid.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Madrid</h3>
          <p>
            Madrid, la capital de España, es conocida por su rica cultura, arte
            y vida nocturna. Puedes disfrutar de tapas en los bares locales,
            visitar el Museo del Prado y explorar la arquitectura impresionante.
          </p>
          <a href="/Madrid"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $1.717.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/buenosaires.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Buenos Aires</h3>
          <p>
            La ciudad de Buenos Aires en Argentina es famosa por su pasión por
            el tango, su deliciosa comida y su arquitectura europea. Es una
            ciudad que combina un ambiente elegante con un toque de nostalgia.
          </p>
          <a href="/Buenos Aires"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $1.717.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/bogota.jpeg" alt="" />
        </div>
        <div class="content">
          <h3>Bogotá</h3>
          <p>
            La capital de Colombia, Bogotá, es una ciudad cosmopolita con una
            rica historia y una creciente escena de arte. El Museo del Oro y el
            centro histórico son puntos de referencia importantes.
          </p>
          <a href="/Bogotá"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $417.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/medellin.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Medellín</h3>
          <p>
            Conocida como "La Ciudad de la Eterna Primavera", Medellín es una de
            las ciudades más dinámicas de Colombia. Rodeada por colinas verdes,
            la ciudad disfruta de un clima templado durante todo el año.
            Medellín es famosa por su espíritu innovador.
          </p>
          <a href="/Medellín"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $417.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/pereira.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Pereira</h3>
          <p>
            Pereira es una ciudad colombiana rodeada de paisajes montañosos y
            cafetales. Es un destino ideal para los amantes de la naturaleza y
            el café colombiano.
          </p>
          <a href="/Pereira"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $417.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/cali.jpg" alt="" />
        </div>
        <div class="content">
          <h3>Cali</h3>
          <p>
            Cali es famosa por ser la capital de la salsa en Colombia. La ciudad
            tiene una vibrante escena de baile y música, además de una cultura
            culinaria única
          </p>
          <a href="/Cali"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $417.176 </span>
          </h5>
        </div>
      </div>

      <div class="box" data-aos="fade-up" datas-aos-delay="150">
        <div class="image">
          <img src="../assets/cartagena.jpeg" alt="" />
        </div>
        <div class="content">
          <h3>Cartagena</h3>
          <p>
            Cartagena, en la costa caribeña de Colombia, es conocida por su
            encanto histórico, arquitectura colonial y playas de aguas
            cristalinas. Es un lugar perfecto para sumergirse en la historia y
            la cultura.
          </p>
          <a href="/Cartagena"
            >Ver vuelos
            <i class="material-symbols-outlined">arrow_forward_ios</i></a
          >
          <h5>
            Desde <br />
            <span> $417.176 </span>
          </h5>
        </div>
      </div>
    </div>
  </section>
  <!-------------------------Sección sobre información de la aerolinea y video------------------------------------->
  <section class="about" id="about">
    <div class="video-container" data-aos="fade-right" datas-aos-delay="300">
      <video
        class="video"
        src="../assets/londres.mp4"
        autoplay
        loop
        muted
      ></video>
      <div class="controls">
        <span class="control-btn"></span>
        <span class="control-btn"></span>
        <span class="control-btn"></span>
      </div>
    </div>
    <div class="content" data-aos="fade-left" datas-aos-delay="600">
      <span>¿Por qué escogernos?</span>
      <h3>Haz de cada viaje una aventura inolvidable</h3>
      <p>
        Ofrecemos calidad y tarifas competitivas en tus boletos de avión.
        Nuestro compromiso con tu satisfacción es inquebrantable, y nuestra
        dedicación a hacer que tu viaje sea inolvidable te dejará deseando
        volver a volar con nosotros.
      </p>
    </div>
  </section>
  <error-modal
      :show-error="showNumberError"
      :error-message="numberErrorMessage"
      @close="showNumberError = false"
    />

  <!------------------------------------------------FOOTER------------------------------------------->
  <Footer></Footer>
</template>
 

<style lang="scss" >

@import url("https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;1,300&family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,600;1,200&display=swap");

* {
  font-family: "Poppins", sans-serif;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  outline: none;
  border: none;
  text-decoration: none;
  transition: all 0.2s;
}

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

@mixin grid($val) {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax($val, 1fr));
  gap: 1.5rem;
}

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

body {
  //FONDO DE LA PAGINA
  background: #f3f5fd;
  //background-image: linear-gradient(to top, #fcfeff 0%, #fbfeff 100%);

  overflow-x: hidden;
}

.Home {
  //Recuadro con imagen
  margin: 0 auto;
  margin-top: 9rem;
  width: 90vw;
  border-radius: 2rem;
  background: linear-gradient($degradado, $bg),
    url(../assets/homelondres.jpg) no-repeat; //Degradado sobre la imagen
  background-size: cover;
  background-position: center;
  display: flex;
  /*** Establece la altura mínima de la vista Home en un 80% de la altura de la ventana gráfica (vh-> view height).
        * La altura de la ventana gráfica (vh) es una unidad de medida que representa la altura de la ventana del navegador.*/
  min-height: 80vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding-bottom: 5rem;

  .content {
    text-align: center;

    span {
      //Texto 1 posicionado sobre la imagen de fondo
      font-weight: bolder;
      color: transparent;
      -webkit-text-stroke: 0.1rem $blanco;
      // Esta línea establece el tamaño de fuente de un elemento al 4% del ancho de la ventana gráfica en el archivo Home.vue
      font-size: 4vw;
      display: block;
    }

    h3 {
      //texto 2
      font-size: 6vw;
      color: white;
    }

    p {
      //Texto 3
      max-width: 60rem;
      margin: 1rem auto;
      font-size: 1.4rem;
      color: $blanco;
      line-height: 2;
    }
  }
}

//-------------------Barra de busqueda de vuelos -------------------------
.book-form {
  width: 80vw;
  margin: 0 auto;
  margin-top: -9rem;
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

//--------------------Imagenes, información  y precio de los destinos del vuelo------------------
.heading {
  //DESTINOS DE VUELO: titulo y subtitulo
  text-align: center;
  margin-bottom: 2rem;

  span {
    //titulo
    color: $verde;
    font-size: 2rem;
    text-transform: capitalize;
  }

  h1 {
    //subtitulo
    font-size: 4rem;
    color: $azul;
    text-transform: capitalize;
  }
}

.destination .box-container {
  //Destino de vuelo en contenedores e imagen
  @include grid(27rem);

  .box {
    border-radius: 1rem;
    // border: solid 1px rgba(255, 255, 255, 0.5);
    overflow: hidden;
    //background: rgba(255, 255, 255, 0.3);
    //background: #aae1fe91;
    background: #0d629b17;
    backdrop-filter: blur(20px);
    box-shadow: 6px 6px 6px rgba(5, 0, 0, 0.2);
    transition: transform 0.3s ease;

    &:hover img {
      transform: scale(1.1);
      text-decoration-line: none;
    }

    .image {
      height: 20rem;
      overflow: hidden;
      width: 100%;

      img {
        height: 100%;
        width: 100%;
        object-fit: cover;
      }
    }

    .content {
      //Información de los destinos de vuelo

      padding: 2rem;
      margin-bottom: 5rem;
      text-align: center;

      h3 {
        //Titulo de la información del destino de vuelo
        font-size: 2.8rem;
        color: $negro;
        //verde
        //-webkit-text-stroke: 0.5px #25a84a;
        text-shadow: 0.5px 2.5px 0.5px rgba(255, 248, 248, 0.734);
        // font-family: 'Nunito', sans-serif;
      }

      p {
        //información del vuelo
        padding: 1rem 0;
        font-size: 1.4rem;
        color: $negro;
        line-height: 2rem;
      }

      h5 {
        //Precio del vuelo
        text-align: right;
        font-size: 1.7rem;
        font-weight: 600;
        margin-top: 1rem;
        position: absolute;
        bottom: 1rem;
        /* Ajusta esta cantidad según tus necesidades para posicionar el precio */
        right: 2rem;

        span {
          color: $verde;
          font-size: 2rem;
          font-weight: bolder;
        }
      }

      a {
        //Botón de "ver vuelo"
        font-size: 1.7rem;
        color: $accent;
        text-shadow: 1px 1px 1px rgba(16, 15, 15, 0.492);
        text-transform: capitalize;

        &:hover {
          //Al pasar el mouse por encima del botón
          padding-left: 1rem;
          background-color: transparent;
          color: $verde;
          text-decoration-line: none;
        }

        i {
          //Logo de flecha para ver vuelo
          padding-right: 0.5rem;
          cursor: pointer;
        }
      }
    }
  }
}

.about {
  display: flex;
  align-items: right;
  flex-wrap: wrap;
  gap: 2rem;
  margin-top: 5rem;

  .video-container {
    flex: 1 1 42rem;

    video {
      border-radius: 1rem;
      width: 100%;
    }

    .controls {
      text-align: center;
      padding: 2rem 0;

      span {
        display: inline-block;
        height: 2rem;
        width: 2rem;
        border-radius: 50%;
        background: $accent;
        cursor: pointer;
        margin: 0.7rem;

        &:hover {
          background: $azul;
          text-decoration-line: none;
        }
      }
    }
  }

  .content {
    flex: 1 1 42rem;
    margin-bottom: 5rem;

    span {
      color: $verde;
      font-size: 2rem;
      text-transform: capitalize;
    }

    h3 {
      color: $azul;
      font-size: 4rem;
      margin-top: 0.5rem;
      text-transform: capitalize;
    }

    p {
      padding: 1rem 0;
      font-size: 1.4rem;
      color: $negro;
      line-height: 2;
    }
  }
}

section {
  padding: 3rem 9vh;
}

@media (max-width: 991px) {
  //pagina en tamaño de computador
  section {
    padding: 3rem 2rem;
  }

  html {
    font-size: 55%;
  }

  .header {
    padding: 1.5rem 2rem; // Establece el padding de la barra de navegación en 1.5rem en la parte superior e inferior y 2rem en la izquierda y derecha
  }
}

@media (max-width: 768px) {
  //Pagina en tamaño de tablet
  .home {
    margin-top: 10rem;

    .content {
      span {
        font-size: 8%;
      }

      h3 {
        font-size: 9%;
      }
    }
  }
}

@media (max-width: 450px) {
  //Tamaño de celular
  html {
    font-size: 43%;
  }

  .about .content h3 {
    font-size: 3.5rem;
  }
}

@media (max-width: 1280px) {
  /* Estilos para pantallas con un ancho máximo de 1280px */
  .Home {
    margin-top: 10rem;
    width: 90vw;
    align-items: center;
    margin-left: auto;
    /* Márgenes automáticos a la izquierda */
    margin-right: auto;
    /* Márgenes automáticos a la derecha */
  }

  .book-form {
    width: 80vw;
  }

  .destination .box-container {
    @include grid(35rem);
  }

  .about {
    flex-direction: column;
    align-items: center;

    .video-container {
      flex: 1 1 100%;
      margin-bottom: 2rem;
    }

    .content {
      flex: 1 1 100%;
    }
  }
}
</style><script>
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
      searchParams: {
        origin: "",
        destination: "",
        flightDate: "",
        numPassengers: 1,
      },
      showNumberError: false,
      numberErrorMessage: "",
    };
  },
  methods: {
    performFlightSearch() {
      if (this.searchParams.numPassengers <= 0 || isNaN(this.searchParams.numPassengers  )) {
        // Mostrar un mensaje de error o tomar la acción correspondiente
        this.showNumberError= true;
        this.numberErrorMessage = "Por favor, ingrese un número válido de pasajeros.";
        return;
      }
      if(this.searchParams.numPassengers > 16){
        this.showNumberError= true;
        this.numberErrorMessage = "Las búsquedas tienen un máximo de 16 pasajeros.";
        return;
      }
      
      flightService
        .parametrizedSearch(this.searchParams)
        .then((response) => {
          console.log(response.status);
          if (response.status === 200) {
            console.log("Vuelos encontrados:", response.data);

            // Almacena los vuelos en el almacenamiento de la sesión
            sessionStorage.setItem(
              "searchResults",
              JSON.stringify(response.data)
            );

            // Redirige a la nueva vista
            this.$router.push({ name: "SearchResults" });
          }
        })
        .catch((error) => {
          console.error("Error en la búsqueda de vuelos:", error);
        });
    },
  },
};
</script>
