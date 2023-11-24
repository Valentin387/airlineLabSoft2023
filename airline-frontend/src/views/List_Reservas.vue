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
        <!------------------------------------------------FOOTER------------------------------------------->
      <!-- Footer aquí -->
      <Footer></Footer>
</template>
  
<style lang="scss">

$light-color: #312c02;
$degradado: rgba(149, 168, 238, 0.11);
$bg: rgba(6, 31, 14, 0.947);
$azul-claro: #CFE0EB;
$gris: #F7F7F7;
$gris2: #364265;
$verde: #00BD8E;
$azul: #0D629B;
$blue: #54b2f1;
$blanco: #FFFFFF;
$negro: #1A1320;
$accent: #0B97F4;
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

  .cont-reservas{
    padding: 20px;
    border-radius: 5px;
    background-color:$secondary ;
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
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from "@/components/footer.vue";

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
  },
  components: {
        errorModal,
        spinner,
        Footer,
    },
};
</script>
  