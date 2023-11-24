<template>
    <div class="pagina">
        <!-- ... Tu formulario de búsqueda ... -->
        <section class="book-form" id="book-form">
            <form action="" @submit.prevent="performOfferSearch">
                <div class="inputBox">
                    <span>Origen</span><!--Origen del vuelo -->
                    <select name="origin" placeholder="¿Desde dónde vuelas?" v-model="searchParams.origin">
                        <option value="" disabled selected>¿Desde dónde vuela?</option>
                        <option value=""></option>
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
                    <select name="destination" placeholder="¿A dónde vuelas?" v-model="searchParams.destination">
                        <option value="" disabled selected>¿A dónde vuela?</option>
                        <option value=""></option>
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
                    <span>Fecha de Vencimiento</span>
                    <input type="date" name="departureDate" v-model="searchParams.validDateRange" />
                </div>

                <input type="submit" value="Buscar" class="btn_buscar" /><!--Botón de busqueda de vuelo -->
                <form action="/CrearOfertasAdmin" method="get">
                    <button type="submit" class="btn_buscar">Crear Oferta</button>
                </form>

            </form>
        </section> <!--Finaliza aquí la barra de búsqueda -->

        <div class="contenedores">
            <div v-if="filteredOffers && filteredOffers.length > 0">
                <div v-for="(offer, index) in filteredOffers" :key="index" class="flight-container">
                    <div class="flight-info">
                        <div class="flight-details">
                            <div class="time-location">
                                <!-- Muestra la descripción del vuelo -->
                                <p><strong>Descripción:</strong> {{ offer.description }}</p>
                                <!-- Muestra el rango de fechas válidas -->
                                <p><strong>Fecha de Vencimiento:</strong> {{ formatDate(offer.validDateRange) }}</p>
                            </div>
                            <!-- Resto del contenido -->
                            <!-- ... -->

                            <!-- Muestra el origen y destino del vuelo -->
                            <p class="flight-location">{{ offer.origin }} - {{ offer.destination }}</p>
                        </div>
                        <div class="flight-price">
                            <!-- Muestra el descuento y el precio -->
                            <p class="price"><strong>Descuento:</strong> <strong style="color: rgb(14, 14, 15);">{{
                                offer.discount }}%</strong></p>
                            <!-- Botón "Ver Oferta" -->
                            <button @click="cancelPromotion(offer)">Cancelar promoción</button>
                        </div>
                    </div>
                </div>
            </div>
            <p v-else>No se encontraron ofertas con los criterios seleccionados.</p>
        </div>
        <!-- ... Tu pie de página u otros componentes ... -->
   
        <Footer />

    </div>
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
    background: $secondary;
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
                color: $negro;
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
                    font-size: 1.7rem;
                    /* Espaciado entre elementos */
                }

                .time-location p {
                    margin: 0;
                    /* Elimina el margen inferior de los párrafos */

                }

                .flight-time {
                    margin-right: 1rem;
                    font-weight: bolder;
                    color: $azul;
                }

                .flight-location {
                    display: flex;
                    font-size: 1.8rem;
                    color: $negro;
                    font-weight: bolder;

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
        margin-top: 1rem;
        /* Agrega un margen entre la información del vuelo y el precio */
    }

    .flight-details {
        margin-bottom: 1rem;
        /* Agrega espacio entre la información del vuelo y el botón */
    }

    @media screen and (min-width: 720px) {
        flex-direction: row;
        /* Vuelve a la disposición en fila en pantallas más grandes */

        .flight-price {
            order: initial;
            /* Restaura el orden original en pantallas más grandes */
            margin-top: 0;
            /* Elimina el margen en pantallas más grandes */
        }

        .flight-details {
            margin-bottom: 0;
            /* Elimina el espacio entre la información del vuelo y el botón */
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
import flightService from "@/services/offerService/listOfferService.js";
import deleteService from "@/services/offerService/deleteOfferService.js";
import Footer from "@/components/footer.vue";
import errorModal from "@/components/ErrorModal.vue";

export default {
    components: {
        Footer,
        errorModal,
    },
    data() {
        return {
            offers: [], // Almacena todas las ofertas obtenidas inicialmente
            filteredOffers: [], // Ofertas filtradas según los parámetros de búsqueda
            searchParams: {
                origin: '',
                destination: '',
                validDateRange: '',
            },
            showConfirmationModal: false,
            confirmationMessage: '¿Estás seguro de cancelar la promoción?',
            offerToDelete: null
        };
    },
    mounted() {
        this.fetchOffers();

    },
    methods: {
        formatDate(dateString) {//Cambia el formato de la fecha de milisegundos a años, meses y dias 
            const options = { year: 'numeric', month: 'long', day: 'numeric' };
            const date = new Date(dateString);
            return date.toLocaleDateString('es-ES', options);
        },
        fetchOffers() {
            // Llama al servicio para obtener todas las ofertas

            flightService.getOffers()
                .then(response => {
                    if (response.status === 200) {
                        this.offers = response.data;
                        this.filteredOffers = this.offers;

                    }
                })
                .catch(error => {
                    console.error("Error al obtener ofertas:", error);
                });

        },
        performOfferSearch() {
            console.log('SearchParams:', this.searchParams);
            console.log('All Offers:', this.offers);


            // Filtra las ofertas de acuerdo a los parámetros de búsqueda ingresados
            this.filteredOffers = this.offers.filter(offer => {
                // Verifica si se ha proporcionado al menos un criterio de búsqueda
                const offerDate = new Date(offer.validDateRange);
                const year = offerDate.getFullYear();
                const month = (offerDate.getMonth() + 1).toString().padStart(2, '0'); // Agrega 1 al mes porque en JavaScript los meses van de 0 a 11
                const day = offerDate.getDate().toString().padStart(2, '0');

                const formattedDate = `${year}-${month}-${day}`;

                const hasOrigin = this.searchParams.origin !== '';
                const hasDestination = this.searchParams.destination !== '';
                const hasvalidDateRange = formattedDate !== '';
                // Realiza la búsqueda en función de los criterios proporcionados

                if (!hasOrigin && !hasDestination && !hasvalidDateRange) {
                    this.filteredOffers = this.offers;
                    return true;
                }
                if (hasOrigin && hasDestination && hasvalidDateRange) {//ORIGEN DESTINO Y FECHA
                    return (
                        offer.origin === this.searchParams.origin &&
                        offer.destination === this.searchParams.destination &&
                        formattedDate === this.searchParams.validDateRange
                    );
                }
                else if (hasOrigin) {//ORIGEN
                    return offer.origin === this.searchParams.origin;
                }
                else if (hasDestination) {//DESTINO
                    return offer.destination === this.searchParams.destination;
                }
                else if (hasDestination && hasvalidDateRange) {//DESTINO Y FECHA
                    return offer.destination === this.searchParams.destination &&
                        formattedDate === this.searchParams.validDateRange
                }
                else if (hasOrigin && hasvalidDateRange) {///ORIGEN FECHA
                    return offer.origin === this.searchParams.origin &&
                        formattedDate === this.searchParams.validDateRange
                }
                else if (hasvalidDateRange) {//FEcHA 
                    return formattedDate === this.searchParams.validDateRange;
                }
                else if (hasOrigin && hasDestination) {//ORIGEN DESTINO
                    return offer.origin === this.searchParams.origin &&
                        offer.destination === this.searchParams.destination
                }
                return true;


            });
        },
        cancelPromotion(offer) {
            deleteService.deleteOffer(offer.id) // Utiliza el servicio para eliminar la oferta
                .then(response => {
                    if (response.status === 200) {
                        // Elimina la oferta de la lista local después de borrarla en el servidor
                        const index = this.offers.findIndex(o => o.id === offer.id);
                        if (index !== -1) {
                            this.offers.splice(index, 1);
                            this.performOfferSearch(); // Actualiza la lista de ofertas filtradas si es necesario
                        }
                    }
                })
                .catch(error => {
                    console.error("Error al eliminar la oferta:", error);
                });
        },
        // Otros métodos necesarios
        // ... offer.validDateRange === this.searchParams.validDateRange
    },
};
</script>
