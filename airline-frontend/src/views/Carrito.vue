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
              <th class="left-align">Precio</th>
              <th class="left-align">Cantidad</th>
              <th class="left-align">Precio Total</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in cartItems" :key="index">
              <td class="flight">{{ item.name }}</td>
              <td class="left-align">${{ item.price }}</td>
              <td class="left-align">
                <input type="number" v-model="item.quantity" min="1" max="5" @input="updateTotalPrice(item)" />
              </td>
              <td class="left-align">${{ item.totalPrice }}</td>
              <td>
                <button class="button-delete" @click="removeItem(index)">X</button>
              </td>
            </tr>
        </tbody>
        </table>
      </div>
      <div class="cart-total">
      <p>Total: ${{ total }}</p>
      <button class="button-buy" @click="checkout">Comprar Ahora</button>
    </div>
  </div>
</template>
  
<style lang="scss">

    .cart-container {
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */
    }

    .cart-header {
    text-align: left;
    padding: 10px;
    }

    .cart-items {
    background-color: #f2f2f2;
    padding: 10px;
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
  import dropService from '@/services/shoppingCartServices/dropService.js';
  import listService from '@/services/shoppingCartServices/listService.js';
  import checkoutService from '@/services/shoppingCartServices/checkoutService.js';

  export default {
    data() {
      return {
        cartItems: [],
        total: 0,
      };
    },
    methods: {
      updateTotalPrice(item) {
        item.totalPrice = item.price * item.quantity;
        this.calculateTotal();
      },
      removeItem(index) {
        const flightIDToRemove = this.cartItems[index].flightId;

        // Utiliza el servicio para eliminar el vuelo del carrito
        dropService.dropItem({ userID: tuUserID, flightID: flightIDToRemove })
          .then(response => {
            console.log('Vuelo eliminado del carrito exitosamente:', response.data);
            // Elimina el vuelo localmente en el cliente después de confirmar que se ha eliminado en el servidor
            this.cartItems.splice(index, 1);
            this.calculateTotal();
          })
          .catch(error => {
            console.error('Error al eliminar el vuelo del carrito:', error);
          });
      },
      calculateTotal() {
        this.total = this.cartItems.reduce((total, item) => total + item.totalPrice, 0);
      },
      checkout() {
        const token = window.sessionStorage.getItem('JWTtoken');
        const tokenData = JSON.parse(atob(token.split('.')[1]));
        const userID = tokenData.ID;

        // Llama al servicio de checkout
        checkoutService.checkoutShoppingCart({ userID: userID })
          .then(response => {
            console.log('Checkout del carrito exitoso:', response.data);

            // Después de completar el checkout, puedes limpiar el carrito localmente.
            this.cartItems = [];
            this.total = 0;
          })
          .catch(error => {
            console.error('Error en el checkout del carrito:', error);
          });
      },
    },
    mounted() {
      
      // Saca el user ID
      const token = window.sessionStorage.getItem('JWTtoken');
      const tokenData = JSON.parse(atob(token.split('.')[1]));
      const userID = tokenData.ID;
      
      // Utiliza el servicio para obtener la lista de items del carrito
      listService.listShoppingCartItems({ userID: userID })
        .then(response => {
          console.log('Items del carrito obtenidos exitosamente:', response.data);
          this.cartItems = response.data; // Asigna la lista de items del carrito al array local
          this.calculateTotal();
        })
        .catch(error => {
          console.error('Error al obtener los items del carrito:', error);
        });
    },
  };
</script>

  