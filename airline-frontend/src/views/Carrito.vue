<template>
    <div class="cart-container">
      <div class="cart-header">
        <h2>Carrito de Compra</h2>
      </div>
      <div class="cart-items">
        <table>
          <thead>
            <tr>
              <th class="left-align">Vuelo</th>
              <th class="left-align">Origen</th>
              <th class="left-align">Destino</th>
              <th class="left-align">Fecha de despegue</th>
              <th class="left-align">Estado</th>
              <th class="left-align">Cantidad de asientos</th>
              <th class="left-align">Costo por pasajero</th>
              <th class="left-align"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in cartItems" :key="index">
              <td class="flight">{{ item.flightId }}</td>
              <td class="left-align">{{ item.origin }}</td>
              <td class="left-align">{{ item.destination }}</td>
              <td class="left-align">{{ formatDate(item.flightDate) }}</td>
              <td class="left-align">{{ item.state }}</td>
              <td class="left-align">{{ item.seats.length }}</td>
              <td class="left-align">${{ item.costByPerson }}</td>
              <td>
                <button class="button-delete" @click="removeItem(index)">X</button>
              </td>
            </tr>
        </tbody>
        </table>
      </div>
      <div class="cart-total">
        <p>Total: ${{ total }}</p>
        <button class="button-buy" @click="purchase">Comprar Ahora</button>
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
    .cart-container {
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */
    background-color: $secondary;
    }

    .cart-header {
    text-align: left;
    padding: 10px;
    }

    .cart-items {
    background-color: #f2f2f283;
    padding: 10px;
    }
    .left-align {
      font-weight: bolder;
    }

    table {
    width: 100%;
    border-collapse: collapse;
    }

    th, td {
    padding: 8px;
    text-align: center; 
    }

    .flight{
        text-align: left;
    }

    .left-align {
    text-align: center; 
    }

    .button-delete {
    background-color: rgb(163, 160, 160);
    color: white;
    border-radius: 10px;
    width: 20px;
    text-align: center;
    cursor: pointer;
    }

    .cart-total {
    display: inline;
    text-align: right;
    padding: 10px;
    }

    .button-buy {
    background-color: #1c88cf;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    }
</style>

<script>
import errorModal from "@/components/errorModal.vue";

import spinner from "@/components/spinner.vue";
import Footer from "@/components/footer.vue";
import successModal from "@/components/successModal.vue";
import listService from "@/services/shoppingCartServices/listService.js";
import checkoutService from "@/services/shoppingCartServices/checkoutService.js";
import dropService from "@/services/shoppingCartServices/dropService.js";
import modifyService from "@/services/shoppingCartServices/modifyItemService.js";

export default {
  data() {
    return {
      /*
      cartItems: {
        flightId: "",
        origin: "",
        destination: "",
        flightDate: "",
        state: "",
        seats: [],
        costByPerson: "",
        costByPersonOffer: "",
      }, */
      cartItems: [],
      total: 0, // You may need to initialize this based on your requirements
    };
  },
  components: {
    errorModal,
    spinner,
    Footer,
    successModal,
  },
  
  mounted() {
    // Call the listShoppingCartItems function when the component is created
    this.listItems();
    this.getTotal();

    // You can also call other functions or perform additional logic here
  },
  methods: {
    
    async getTotal(){
      const token = window.sessionStorage.getItem('JWTtoken');
      const tokenData = JSON.parse(atob(token.split('.')[1]));
      const userID = tokenData.ID;

      // Llamar al servicio para obtener los items
      checkoutService.checkoutShoppingCart({"userID" : userID})
          .then(response => {
            if (response.status == 200){
              this.total = response.data.totalAmount;
              console.log(response);
            }
          })
          .catch(error => {
            console.error(error);
          });
    },


    async listItems() {
      const token = window.sessionStorage.getItem('JWTtoken');
      const tokenData = JSON.parse(atob(token.split('.')[1]));
      const userID = tokenData.ID;

      // Llamar al servicio para obtener los items
      listService.listShoppingCartItems({"userID" : userID})
          .then(response => {
            if (response.status == 200){
              this.cartItems = response.data;
              console.log(response);
            }

          })
          .catch(error => {
            console.error(error);
          });
    },
    

    async purchase(){

    },

    removeItem(index) {
      //use the service
      const token = window.sessionStorage.getItem('JWTtoken');
      const tokenData = JSON.parse(atob(token.split('.')[1]));
      const userID = tokenData.ID;

      dropService.dropItem(userID, this.cartItems[index].flightId)
          .then(response => {
            if (response.status == 200){
              console.log(response.data);
            }
          })
          .catch(error => {
            console.error(error);
          });
    },
    updateSeatQuantity(item) {
      // use the service
      const token = window.sessionStorage.getItem('JWTtoken');
      const tokenData = JSON.parse(atob(token.split('.')[1]));
      const userID = tokenData.ID;
      
      modifyService.modifyItemInCart(userID, flightID, seatQuantity, seatClass)
          .then(response => {
            if (response.status == 200){
              console.log(response.data);
            }
          })
          .catch(error => {
            console.error(error);
          });
    },

    formatDate(dateString) {
     //Cambia el formato de la fecha de milisegundos a años, meses y dias
     const options = { year: "numeric", month: "long", day: "numeric" };
     const date = new Date(dateString);
     return date.toLocaleDateString("es-ES", options);
   },

  },
};

</script>

  