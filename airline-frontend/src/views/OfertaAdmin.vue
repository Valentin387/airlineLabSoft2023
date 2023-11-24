<template>
    <div class="registration-box">
        <spinner :showSpinner="showSpinner"></spinner>
        <div class="registration-container">
            <div class="title">Crear Oferta de Vuelo</div>
            <form id="registration-form" @submit.prevent="submitOffer">
                <hr class="border-light m-0" />
                <div class="card-body">
                    <div class="form-group">

                        <select id="origin" placeholder="Origen" v-model="origin" required>
                            <option value="" disabled selected>Origen del Vuelo</option>
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
                        <select id="destination" placeholder="Destino" v-model="destination" required>
                            <option value="" disabled selected>Destino del Vuelo</option>
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

                        <input type="number" id="discount" placeholder="Descuento (%)" v-model="discount" required />

                        <input type="date" id="validDateRange" placeholder="Fecha de Vencimiento de Promociòn"
                            v-model="validDateRange" required />
                        <p class="expiration-date">Fecha de vencimiento de la promoción</p>

                        <textarea type="text" id="description" placeholder="Descripción de la Oferta" v-model="description"
                            required></textarea>
                    </div>
                </div>

                <button class="create-account" type="submit">Crear Oferta</button>
            </form>
            <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />

        </div>
    </div>
    <!-- FOOTER -->
    <Footer></Footer>
</template>
  


<style lang="scss" scoped >
$light-color: #312c02;
$degradado: rgba(149, 168, 238, 0.11);
$bg: rgba(6, 31, 14, 0.947);
$azul-claro: #cfe0eb;
$gris: #f7f7f7;
$verde: #00bd8e;
$azul: #0d629b;
$blanco: #ffffff;
$negro: #1a1320;
$accent: #0b97f4;
$accent3: #f7f7f7;
$blue: #54b2f1;
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

.registration-box {
    /* ... otros estilos ... */
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.form-group {
    /* ... otros estilos ... */
    text-align: center;
}

.registration-box {
    box-shadow: 0 6px 6px rgba(6, 6, 6, 0.1);
    background: $secondary; //FONDO DE LA CARD
    width: 90vw;
    margin: 0 auto;
    /* Centrar horizontalmente */
    margin-top: 10rem;
    margin-bottom: 10rem;
    /* Centrar verticalmente */
    border-radius: 10px;
    display: flex;
    justify-content: space-between;
    overflow: hidden;
    text-align: center;

    .form-group {
        margin: 10px 0;

        padding: 20px;
        align-content: center;

        input,
        select,
        textarea {
            width: 70%;
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

    }

    .registration-container {
        .title {

            margin: 0;
            color: $azul;
            font-weight: bold;
            font-size: 3rem;
            /* Aumenta el tamaño de la fuente */

            letter-spacing: 1px;
            /* Aumenta el espaciado entre las letras */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.456);
            /* Añade una sombra al texto */
            font-family: 'Arial', sans-serif;
            /* Cambia la fuente (opcional) */
            text-align: center;
            margin-top: 3rem;
        }
    }


    label {
        display: block;
        font-weight: bold;
        align-items: center !important;
    }

    .create-account {
        width: 30%;
        padding: 7px;
        background-color: #364265;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-align: center;
        margin-bottom: 5rem;
    }


}

@media screen and (max-width: 1000px) {
    .registration-box {
        width: 70%;
        margin-top: 10rem;
    }

    .registration-container {
        width: 100%;
        border-radius: 5px;
    }
}

@media screen and (max-width: 650px) {
    .registration-box {
        width: 90%;
    }
}

@media screen and (max-width: 500px) {
    .registration-box {
        height: 100%;
        margin-top: 10rem;
    }

    .registration-container {
        .texto {
            margin-top: 5rem;
        }
    }
}
</style>
<script>
// Importa la función createOffer

import offerService from "@/services/offerService/createOfferService.js"; // Asegúrate de colocar la ruta correcta
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from '@/components/footer.vue';

export default {
  components: {
    errorModal,
    spinner,
    Footer,
  },
  data() {
    return {
      origin: '',
      destination: '',
      discount: 0,
      validDateRange: '',
      description: '',
      errorMessage: "",
      showErrorMessage: false,
      showSpinner: false,
    };
  },
  methods: {
    async submitOffer() {
      try {
        // Llama a la función createOffer del servicio con los datos del formulario
        await offerService.createOffer(
          this.origin,
          this.destination,
          this.discount,
          this.validDateRange,
          this.description
        );

        // Aquí podrías agregar lógica adicional, como mostrar un mensaje de éxito
        console.log('Oferta creada exitosamente!');
      } catch (error) {
        // Manejo de errores, podrías mostrar un modal o mensaje de error
        console.error('Error al crear la oferta:', error.message);
      }
    }
  }
};
</script>