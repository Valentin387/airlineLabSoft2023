<template>
    <body>
        <div class="login-container">
            <h1>Login</h1>
            <form id="login-form">
            
                <input type="email"  id="email" placeholder="Email" v-model="email" required>
                <input type="password"  id="password" placeholder="Password" v-model="password" required>
                <button @click="login" type="submit">Log In</button>
       
            </form>
            <p id="error-message" class="error-message"></p>
        </div>
    </body>

</template>

<script>
import LoginService from "@/services/LoginService.js";

export default {
  data() { 
    return {
      email: "",
      password: "",
      errorMessage: "",
    };
  },
  methods: {
    login() {
      const { email, password } = this;
      
      // Call the LoginService.login method
      LoginService.login(email, password)
        .then((response) => {
          // Handle the successful login response here
          if (response.status == 200){
            // Extract the JWT token from the response data
            const token = response.data.token;
            // Save the JWT token in the localStorage
            window.sessionStorage.setItem("JWTtoken", token);
            console.log("Login successful:", response.data);

            // You can redirect the user or perform other actions here.
            this.$router.push('/Home');
          }
        })
        .catch((error) => {
          // Handle login errors here
          if (error.response.status == 401){
            console.log("Login failed:", error.response.status, error);
            this.errorMessage = error.response.data.message;
          } if (error.response.status == 403){
            console.log("User not found sorry:", error.response.status, error);
            this.errorMessage = error.response.data.message;
          }else {
            // You can redirect the user or perform other actions here.
            console.error("Something happened:", error);
          }
          // Display an error message to the user or take appropriate action.
        });
    }
    /*redirectToSignUp() {
      // Add navigation logic to your sign-up page here
      console.log("Redirecting to sign-up page");
      this.$router.push('/signup');
    },*/
  },
};
</script>

<style lang="scss"  >

    .login-container {
        text-align: center;
        border: 1px solid #ccc;
        padding: 20px;
        max-width: 300px;
        background-color: #f9f9f9;
        font-family: 'Open Sans', sans-serif;

        
        input {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-family: 'Open Sans', sans-serif;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-family: 'Open Sans', sans-serif;
        }

        .error-message {
            color: red;
            
        }
    }




</style>

