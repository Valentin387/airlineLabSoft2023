<template>
    <div class="centro-de-ayuda">
      <h1>Acerca de la aplicación</h1>
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
</template>
  
<style lang="scss">
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
    background-color: #bbbbbb;
    color: white;
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
  }
  
  .flecha-abajo::before {
    content: "▼";
  }
  
  .flecha-arriba::before {
    content: "▲";
  }
  
  .pestana .contenido {
    background-color: #f0f0f0;
    padding: 10px;
    border-radius: 5px;
  }
</style>
   
<script>
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
              "Contenido: Conocer, actualizar, rectificar y/o eliminar sus datos personales, siempre que no medie un deber legal o contractual que lo impida. El canal oficial para ejercer estos derechos es el correo: habeasdata@avianca.com. Para saber más detalles del procedimiento, ver la sección 4.1 de la Política de Privacidad.",
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
    }
  };
</script>