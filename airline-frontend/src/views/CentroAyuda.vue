<template>
    <div class="centro-de-ayuda">
      <h1>Acerca De La Aplicación</h1>
      <br>
      <div class="pestanas">
        <div v-for="(pestaña, index) in pestanas" :key="index" class="pestana">
          <button @click="togglePestana(index)">
            {{ pestaña.titulo }}
            <span class="flecha" :class="{'flecha-abajo': pestaña.abierto, 'flecha-arriba': !pestaña.abierto}"></span>
          </button>
          <div v-if="pestaña.abierto" class="contenido">
            <p>{{ pestaña.contenido }}</p>
          </div>
        </div>
      </div>
    </div>
        <!------------------------------------------------FOOTER------------------------------------------->
        <Footer></Footer>

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

  /* Estilos CSS aquí */
  .centro-de-ayuda {
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto;
    margin-top: 10rem;
    text-align: center;
  
  }
  
  .pestanas {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  
  .pestana button {
    background-color: $secondary;
    color: $negro;
    border: none;
    padding: 10px;
    border-radius: 5px;
    width: 700px;
    cursor: pointer;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0 auto; /* Centrar horizontalmente */
  }
  
  .flecha {
    font-size: 20px;
    transition: transform 0.3s;
    color:$azul;
  }
  
  .flecha-abajo::before {
    content: "▼";
  }
  
  .flecha-arriba::before {
    content: "▲";
  }
  
  .pestana .contenido {
    background-color: $card;
    padding: 10px;
    border-radius: 5px;
  }
</style>
   
<script>
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from "@/components/footer.vue";
  export default {
    data() {
      return {
        pestanas: [
          {
            titulo: "Responsable del tratamiento de datos personales",
            contenido:
              "AirTravel con NIT 822.222.577-2 Pereira, Colombia) y Teléfono: 222222 y demás empresas del Grupo.",
            abierto: false
          },
          {
            titulo: "¿Qué datos personales recolectamos?",
            contenido:
              "Datos de identificación, de contacto y pago;\n" +
              "Otros datos indispensables para dar inicio a la vinculación contractual, entre los que se pueden encontrar datos sensibles;\n" +
              "La información adicional que suministre el Titular en desarrollo de la relación contractual y;\n" +
              "Cookies. Para más detalle, ver la sección 3.5 de la Política de Privacidad.",
            abierto: false
          },
          {
            titulo: "Finalidades principales del tratamiento de datos personales",
            contenido:
              "Proveer los servicios de transporte aéreo bajo la ejecución del contrato de transporte, así como los servicios complementarios.\n" +
              "Gestionar e informar todos los aspectos relacionados con el servicio de transporte, incluyendo la interacción con agencias de viajes, plataformas y pasarelas de pago.\n" +
              "Validar la identificación del titular, prevenir el fraude y la corrupción (SIPLAFT). Para más detalle, ver la sección 3.4 de la Política de Privacidad.",
            abierto: false
          },
          {
            titulo: "Datos personales sensibles o de menores de edad",
            contenido:
              "Información sensible o de menores de edad: Las Compañías requieren la mínima información indispensable para hacer posible la prestación del servicio de transporte.",
            abierto: false
          },
          {
            titulo: "Derechos del titular y cómo ejercerlos",
            contenido:
              "Contenido: Conocer, actualizar, rectificar y/o eliminar sus datos personales, siempre que no medie un deber legal o contractual que lo impida. Para saber más detalles del procedimiento, ver la sección 4.1 de la Política de Privacidad.",
            abierto: false
          },
          {
            titulo: "Política de privacidad para clientes, viajeros y usuarios completa",
            contenido:
              "Contenido: Puede consultar nuestra Política de Tratamiento de Datos personales.",
            abierto: false
          }
        ]
      };
    },
    methods: {
      togglePestana(index) {
        this.pestanas[index].abierto = !this.pestanas[index].abierto;
      }
    },
    components: {
        errorModal,
        spinner,
        Footer,
  },
  };
</script>