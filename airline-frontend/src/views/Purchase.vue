<template>
  <div class="purchase-container">
    <spinner :showSpinner="showSpinner"></spinner>
    <!-- Left Column - List of flights and seats -->
    <div class="left-column">
      <div v-for="flight in cartItems" :key="flight.flightId" class="flight-section">
        <h3><strong>Origen:</strong> {{ flight.origin }} - <strong>Destino:  </strong> {{ flight.destination }}</h3>
        <ul>
          <li v-for="seat in flight.seats" :key="seat.seatID">
            <strong>Silla: </strong>  {{ seat.id }}
            <button @click="openPassengerForm(flight, seat)" class="register">Agregar Pasajero</button>
          </li>
          <form @submit.prevent="purchase">
            <br>
           <button type="submit" class="login">Comprar Ahora</button>
          </form>
        </ul>
      </div>
    </div>

    <!-- Right Column - Passenger Form -->
    <div v-if="selectedFlightAndSeat" class="right-column">
      <h2><strong> Información del Pasajero</strong></h2>
      <br>
      <form @submit.prevent="submitPassengerForm" class="login-form">
        <!-- Add your form fields for passenger details -->
        <label for="dni">DNI:</label>
        <input v-model="passengerData.dni" type="text" required />
        <br>
        <label for="firstName">Nombre:</label>
        <input v-model="passengerData.firstName" type="text" required />
        <br>
        <label for="lastName">Apellido:</label>
        <input v-model="passengerData.lastName" type="text" required />
        <br>
        <label for="birthday">Fecha de Nacimiento:</label>
        <input v-model="passengerData.birthday" type="date" required />
        <br>
        <label for="gender">Genero:</label>
        <input v-model="passengerData.gender" type="text" required />
        <br>
        <label for="cellphoneNo">Número de teléfono:</label>
        <input v-model="passengerData.cellphoneNo" type="text" required />
        <br>
        <label for="email">Correo:</label>
        <input v-model="passengerData.email" type="text" required />
        <br>
        <label for="contactName">Nombre de Contacto:</label>
        <input v-model="passengerData.contactName" type="text" required />
        <br>
        <label for="contactNo">Número del contacto:</label>
        <input v-model="passengerData.contactNo" type="text" required />
        <!-- Add other form fields for passenger details -->
        <button type="submit" class ="login">Guardar</button>
      </form>
    </div>
  
     
  
  </div>
  <Footer></Footer>
</template>
  
  
<style lang="scss" scoped >


$light-color: #2e2b18;
$degradado: rgba(34, 33, 39, 0.552);
$bg: rgba(25, 32, 57, 0.947);
$azul-claro: #cfe0eb;
$gris: #f7f7f7;
$verde: #00bd8e;
$azul: #0d629b;
$blanco: #ffffff;
$negro: #1a1320;
$blue: #54b2f1;
$accent: #0b97f4;
$accent2: #007bff;
$gris2: #364265;
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
.purchase-container {
  height: 100vh;
  box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
  margin:0 auto;
  width: 90vw;
  margin: 0 auto; /* Centrar horizontalmente */
  margin-top: 15rem; /* Centrar verticalmente */
  border-radius: 10px;
  display: flex;
  justify-content: center;
  overflow: hidden;
  align-items: center;
    text-align: center;
    padding-top: 3rem;
    background-color: $secondary;
}

.register {
  width: 100%;
  padding: 10px;

  background-color: #364265;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 2rem;
}
.login {
      width: 80%;
      padding: 10px;
      margin-top: 45px;
      background-color: $blue;
      color: #fff;
      border: none;
      border-radius: 5px;
     
      cursor: pointer;
    }
.left-column {
  max-width: 50%;
  /* Ajusta el ancho máximo de la columna izquierda */
}
.left-column h3{
  font-size: 2rem;
  /* Ajusta el ancho máximo de la columna izquierda */
}


.right-column {
  max-width: 50%;
  /* Ajusta el ancho máximo de la columna derecha */
  padding-left: 20px;
}


.flight-section {
  margin-bottom: 20px;
}

.button-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.login-form{
  align-items: left;
  justify-content: left;
  display: left;
  font-size: 2rem;
  input{
    margin-bottom: 2rem;
  }
  label{
    margin-right: 2rem;
  }


}

ul {
  list-style: none;
  padding: 0;
}

button {
  margin-left: 10px;
}
</style>
  


  
<script>

import purchaseService from "@/services/orderService/purchaseService.js";
import errorModal from "@/components/errorModal.vue";
import spinner from "@/components/spinner.vue";
import Footer from "@/components/footer.vue";
export default {
  components: {
    errorModal,
    spinner,
    Footer,
  },
  data() {
    return {
      showSpinner: false, // Initialize as hidden
      selectedFlightAndSeat: null,
      orderObject: {
        userID: 0,
        cardID: 20,
        totalAmount: 7501.5,
        paymentDetails: "transferencia llevada a cabo por AirTravel LTDA",
        orderFlightInfoList: [],
      },
      cartItems: [], // Populate this array from API or elsewhere
      passengerData: {
        dni: "",
        firstName: "",
        lastName: "",
        birthday: "",
        gender: "",
        cellphoneNo: "",
        email: "",
        contactName: "",
        contactNo: "",
        seatID: 0
        // Add other fields for passenger details
      },
    };
  },
  created() {
    this.cartItems = JSON.parse(window.sessionStorage.getItem('cartItems'));

    const token = window.sessionStorage.getItem('JWTtoken');
    const tokenData = JSON.parse(atob(token.split('.')[1]));
    this.orderObject.userID = tokenData.ID;
  },

  methods: {
    openPassengerForm(flight, seat) {
      this.selectedFlightAndSeat = { flight, seat };
      this.passengerData = {
        dni: "",
        firstName: "",
        lastName: "",
        birthday: "",
        gender: "",
        cellphoneNo: "",
        email: "",
        contactName: "",
        contactNo: "",
        // Reset other fields for passenger details
      };
    },

    purchase() {
      this.showSpinner = true;
      purchaseService.purchase(
        this.orderObject.userID,
        this.orderObject.cardID,
        this.orderObject.totalAmount,
        this.orderObject.paymentDetails,
        this.orderObject.orderFlightInfoList
      )
        .then(response => {
          if (response.status == 200) {
            this.showSpinner = false;
            console.log(response.data);
            window.sessionStorage.removeItem('cartItems');
            this.$router.push("/");
          }
        })
        .catch(error => {
          this.showSpinner = false;
          console.log(error);
        });
    },

    submitPassengerForm() {
      if (this.selectedFlightAndSeat) {
        const { flight, seat } = this.selectedFlightAndSeat;
        const newPassenger = { ...this.passengerData, seatID: seat.id };

        const existingFlight = this.orderObject.orderFlightInfoList.find(
          (info) => info.flightID === flight.flightId
        );

        if (existingFlight) {
          existingFlight.passengerList.push(newPassenger);
        } else {
          this.orderObject.orderFlightInfoList.push({
            flightID: flight.flightId,
            passengerList: [newPassenger],
          });
        }

        this.passengerData = {
          dni: "",
          firstName: "",
          lastName: "",
          birthday: "",
          gender: "",
          cellphoneNo: "",
          email: "",
          contactName: "",
          contactNo: "",
          seatID: 0
          // Reset other fields for passenger details
        };
        console.log(this.orderObject);
        console.log(this.cartItems);
      }
    },
  },
};
</script>