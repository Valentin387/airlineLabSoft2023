<template>
    <div class="purchase-container">
      <!-- Left Column - List of flights and seats -->
      <div class="left-column">
        <div v-for="flight in cartItems" :key="flight.flightId" class="flight-section">
          <h3>{{ flight.origin }} to {{ flight.destination }}</h3>
          <ul>
            <li v-for="seat in flight.seats" :key="seat.seatID">
              Seat {{ seat.id }}
              <button @click="openPassengerForm(flight, seat)">Add Passenger</button>
            </li>
          </ul>
        </div>
      </div>
  
      <!-- Right Column - Passenger Form -->
      <div v-if="selectedFlightAndSeat" class="right-column">
        <h2>Passenger Information</h2>
        <form @submit.prevent="submitPassengerForm">
          <!-- Add your form fields for passenger details -->
          <label for="dni">DNI:</label>
          <input v-model="passengerData.dni" type="text" required />
          <label for="firstName">firstName:</label>
          <input v-model="passengerData.firstName" type="text" required />
          <label for="lastName">lastName:</label>
          <input v-model="passengerData.lastName" type="text" required />
          <label for="birthday">birthday:</label>
          <input v-model="passengerData.birthday" type="text" required />
          <label for="gender">gender:</label>
          <input v-model="passengerData.gender" type="text" required />
          <label for="cellphoneNo">cellphoneNo:</label>
          <input v-model="passengerData.cellphoneNo" type="text" required />
          <label for="email">email:</label>
          <input v-model="passengerData.email" type="text" required />
          <label for="contactName">contactName:</label>
          <input v-model="passengerData.contactName" type="text" required />
          <label for="contactNo">contactNo:</label>
          <input v-model="passengerData.contactNo" type="text" required />
          <!-- Add other form fields for passenger details -->
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        selectedFlightAndSeat: null,
        orderObject: {
          userID: 52,
          cardID: 20,
          totalAmount: 7501.5,
          paymentDetails: "transferencia llevada a cabo por AirTravel LTDA",
          orderFlightInfoList: [],
        },
        cartItems: [], // Populate this array from API or elsewhere
        passengerData: {
            dni: "",
            firstName:"",
            lastName:"",
            birthday:"",
            gender:"",
            cellphoneNo:"",
            email:"",
            contactName:"",
            contactNo:"",
            seatID:0
          // Add other fields for passenger details
        },
      };
    },
    created() {
        this.cartItems =  JSON.parse(window.sessionStorage.getItem('cartItems'));
    },
  
    methods: {
      openPassengerForm(flight, seat) {
        this.selectedFlightAndSeat = { flight, seat };
        this.passengerData = {
            dni: "",
            firstName:"",
            lastName:"",
            birthday:"",
            gender:"",
            cellphoneNo:"",
            email:"",
            contactName:"",
            contactNo:"",
          // Reset other fields for passenger details
        };
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
            firstName:"",
            lastName:"",
            birthday:"",
            gender:"",
            cellphoneNo:"",
            email:"",
            contactName:"",
            contactNo:"",
            seatID:0
            // Reset other fields for passenger details
          };
          console.log(this.orderObject);
          console.log(this.cartItems);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .purchase-container {
    display: flex;
    justify-content: space-between;
    padding: 20px;
  }
  
  .left-column {
    flex: 1;
  }
  
  .right-column {
    flex: 1;
    padding-left: 20px;
  }
  
  .flight-section {
    margin-bottom: 20px;
  }
  
  ul {
    list-style: none;
    padding: 0;
  }
  
  button {
    margin-left: 10px;
  }
  </style>
  