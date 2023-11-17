<template>
    <div class="payment-module">
      <h1 class="tittle">Confirmar y Pagar</h1>
      <div class="payment-options">
        <p class="payment-label">Pagar con: </p>
        <label @click="selectOption('credit-card')" :class="{ selected: selectedOption === 'credit-card' }">Tarjeta de crédito</label>
        <label @click="selectOption('debit-card')" :class="{ selected: selectedOption === 'debit-card' }">Tarjeta de débito</label>
      </div>
      <div v-if="selectedOption === 'credit-card'">
        <h2>Tarjeta de crédito</h2>
        <div class="paypal-details">
          <input type="text" placeholder="Nombre de titular" v-model="cardholderName" @input="restrictToLetters">
          <input type="text" placeholder="Número de tarjeta" v-model="creditCardNumber" @input="restrictToNumbers">
          <div class="expiration-cvc">
            <input type="text" placeholder="MM" v-model="expirationMonth" @input="restrictMonth">
            <input type="text" placeholder="YY" v-model="expirationYear" @input="restrictYear">
            <input type="text" placeholder="CVC" v-model="cvc" @input="restrictCVC">
          </div>
          <label class="checkbox-label">
            <input type="checkbox" v-model="saveCardCheckbox"> Guardar tarjeta
          </label>
        </div>
      </div>
      <div v-if="selectedOption === 'debit-card'">
        <h2>Tarjeta de débito</h2>
        <div class="paypal-details">
          <input type="text" placeholder="Nombre de titular" v-model="cardholderName" @input="restrictToLetters">
          <input type="text" placeholder="Número de tarjeta" v-model="creditCardNumber" @input="restrictToNumbers">
          <div class="expiration-cvc">
            <input type="text" placeholder="MM" v-model="expirationMonth" @input="restrictMonth">
            <input type="text" placeholder="YY" v-model="expirationYear" @input="restrictYear">
            <input type="text" placeholder="CVC" v-model="cvc" @input="restrictCVC">
          </div>
          <label class="checkbox-label">
            <input type="checkbox" v-model="saveCardCheckbox"> Guardar tarjeta
          </label>
        </div>
      </div>
      <button class="button-confi" @click="confirmPayment">Confirmar y pagar</button>
    </div>
    <div>
      <input v-model="titularName" @input="validateTitularName" />
    </div>
</template>
  
<style lang="scss">
    .payment-module {
    margin: 0 auto;
    padding: 20px;
    border-radius: 5px;
    height: 85vh;
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */

    .payment-options {
        display: flex;
        justify-content: space-between;
        align-items: center; /* Alinear verticalmente los elementos al centro */
        margin-top: 10px;

        .payment-label {
        text-align: center; /* Alinear el texto al centro horizontalmente */
        }

        label {
        cursor: pointer;
        padding: 10px;
        margin: 10px 70px 30px 70px;
        text-align: center; /* Alinear texto al centro */
        &.selected {
            color: #4b7ce7; /* Cambiar el color de texto cuando está seleccionado */
        }
        }
    }

    .tittle{
        text-align: center;
        font-size: 30px;
    }
  
    .paypal-details {
      margin-top: 20px;
  
      input[type="text"] {
        /*border: 1px solid #0070ba; 
        padding: 10px;
        margin-top: 5px;
        width: 100%;*/
        width: 100%;
        margin-top: 10rem;
        margin: 10px 0;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }
  
      .expiration-cvc {
        display: flex;
        justify-content: space-between;
        input[type="text"] {
          /*border: 1px solid #0070ba;
          padding: 10px;*/
          margin-top: 10rem;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
          width: calc(50% - 1px); /* Dividir en dos columnas con espacio entre ellos */
          & + input[type="text"] {
            margin-left: 10px;
          }
        }
      }

      .checkbox-label {
        display: flex;
        align-items: center;

            input[type="checkbox"] {
                
                width: 20px;
                height: 20px;
                border: 1px solid #0070ba; /* Estilo del cuadro de selección */
                border-radius: 3px;
                margin-right: 10px; /* Espacio entre el cuadro de selección y el texto */
                cursor: pointer;
            }

            input[type="checkbox"]:checked {
                background-color: #0070ba; /* Cambiar el fondo cuando está seleccionado */
                border: 1px solid #0070ba; /* Cambiar el borde cuando está seleccionado */
            }
        }
    }

    .button-confi {
        margin-top: 40px; /* Margen superior de 40px */
        border-radius: 5px; /* Borde redondeado */
        background-color: #0070ba; /* Color de fondo azul */
        color: #fff; /* Color del texto blanco */
        padding: 10px 20px;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s; /* Efecto de transición al cambiar el color de fondo */
    }

    .button-confi:hover {
        background-color: #00558a; /* Cambiar el color de fondo al pasar el mouse */
    }
  }
</style>
  
<script>
  export default {
    data() {
      return {
        selectedOption: 'credit-card',
        saveCardCheckbox: false, // Variable para controlar si se debe guardar la tarjeta
        expirationMonth: '',
        expirationYear: '',
        creditCardNumber: '',
        cardholderName: '',
        cvc: '',
        titularName: '',
      };
    },
    methods: {
      // Método para restringir la longitud del mes a 2 dígitos
      restrictMonth() {
        if (this.expirationMonth.length > 2) {
          this.expirationMonth = this.expirationMonth.slice(0, 2);
        }
      },
      // Método para restringir el año a 2 dígitos
      restrictYear() {
          if (this.expirationYear.length > 2) {
            this.expirationYear = this.expirationYear.slice(0, 2);
        }
      },
      restrictToNumbers() {
        this.creditCardNumber = this.creditCardNumber.replace(/\D/g, '');
      },
      restrictToLetters() {
        this.cardholderName = this.cardholderName.replace(/[^A-Za-z\s]/g, '');
      },
      restrictCVC() {
        this.cvc = this.cvc.replace(/\D/g, '');
        if (this.cvc.length > 3) {
          this.cvc = this.cvc.slice(0, 3);
        }
      },
      validateTitularName() {
        // Verificar si el nombre del titular solo contiene espacios en blanco
        if (/^\s+$/.test(this.titularName)) {
          // Si solo contiene espacios, borra el contenido del campo
          this.titularName = '';
        }
      },
      selectOption(option) {
        this.selectedOption = option;
      },
      saveCard() {
        if (this.saveCardCheckbox) {
          // Lógica para guardar la tarjeta de Paypal
          alert('Tarjeta guardada');
        }
      },
      confirmPayment() {
        // Lógica para confirmar el pago
        alert('Pago confirmado');
      },
    },
  };
</script>
  