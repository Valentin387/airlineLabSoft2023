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
    export default {
    data() {
        return {
        cartItems: [
        ],
        total: 0, // Inicializa la suma total en 0
        };
    },
    methods: {
        updateTotalPrice(item) {
        item.totalPrice = item.price * item.quantity;
        this.calculateTotal();
        },
        removeItem(index) {
        this.cartItems.splice(index, 1);
        this.calculateTotal();
        },
        calculateTotal() {
        this.total = this.cartItems.reduce((total, item) => total + item.totalPrice, 0);
        },
        checkout() {
        // Implementa la lógica para el proceso de compra
        },
    },
    mounted() {
        // Calcula la suma total al inicio después de que los datos estén disponibles
        this.calculateTotal();
    },
    };
</script>

  