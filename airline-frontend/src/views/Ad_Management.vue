<template>
  <div class="admin-panel">
    <spinner :showSpinner="showSpinner"></spinner>
    <div class="sidebar">
      <a data-aos="zoom-in-left" data-aos-delay="150" href="#" class="logo">
        <i class="fa-solid fa-paper-plane"></i>AirTravel
      </a>
      <div class="sidebar-item" @click="redirectToPerfil">
        <span class="material-symbols-outlined">person</span>Perfil
      </div>
      <div class="sidebar-item" @click="selectTab('admins', $event)">
        <span class="material-symbols-outlined">lock</span>Gestionar administradores
      </div>
      <div class="logout-container">
        <div class="sidebar-item" @click="logout">
          <span class="material-symbols-outlined">logout</span>Cerrar sesión
        </div>
      </div>
    </div>
    <div class="content">
      <div v-if="selectedTab === 'profile'">
        <h2>Perfil</h2>
      </div>
      <div v-else-if="selectedTab === 'admins'">
        <h2>Administradores</h2>
        <div class="admins-content">
          <ul>
            <li v-for="admin in admins" :key="admin.id">
              <div class="admin-info-box">
                <div class="admin-info">
                  <div class="span-container">
                    <div class="span-Name">
                      <span class="span-firstName" v-if="admin.firstName">{{ admin.firstName }}</span>
                      <span class="span-lastName" v-if="admin.lastName">{{ admin.lastName }}</span>
                    </div>
                    <div class="span-email">
                      <span v-if="admin.email">{{ admin.email }}</span>
                    </div>
                  </div>
                </div>
                <div class="delete-button-container">
                  <i class='bx bx-x'   @click="toggleCardContainer" ></i> 
                </div>
                <div class="card_containerAdmin" :class="{ active: cardContainerAdmin }">
                  <div class="cardAdmin">
                    <img class="card_img" src="../assets/londres.jpg" alt="">
                    <div class="card_contentAdmin">
                      <h1>Eliminar administrador</h1>
                      <p>¿Está seguro de que desea eliminar este administrador?</p>
                      <div class="group_btns">
                        <button class="buttonAdmin" @click="cancelDelete">
                          Cancelar
                        </button>
                        <button class="buttonAdmin" @click="confirmDelete(admin.id)">
                          Continuar
                        </button>
                      </div>
                    </div>
                    <p class="close_btnAdmin" @click="toggleCardContainer">
                      <i class='bx bx-x'></i>
                    </p>
                  </div>
                </div>
              </div>
            </li>
          </ul>
        </div>
        <button @click="showCreateAdminForm" class="create-admin-button" type="button">
          Crear Administrador
        </button>
      </div>
      
      <div v-if="creatingAdmin" class="create-admin-box">
        <h2 class="tittle-ad">Crear Administrador</h2>
        <p class="text-ad">Por favor ingrese correo electronico y nombre del administrador</p>
        <div class="create-admin-form">
          <input class="input-admin" type="text" v-model="newAdminName" placeholder="Nombre">
          <input class = "input-admin" type="email" v-model="newAdminEmail" placeholder="Correo Electrónico">
          <div></div>
          <button @click="confirmAdminCreation" class="button-create-ad">Confirmar Creación</button>
        </div>
      </div>
    </div>
    <error-modal :show-error="showErrorMessage" :error-message="errorMessage" @close="showErrorMessage = false" />
  </div>
</template>



<style lang="scss">
    $light-color:#312c02;
    $degradado: rgba(149, 168, 238, 0.11);
    $bg:rgba(6, 31, 14, 0.947);
    $azul-claro: #CFE0EB;
    $gris:#F7F7F7;
    $verde: #00BD8E;
    $azul: #0D629B;
    $blanco: #FFFFFF;
    $negro:#1A1320;
    $accent:#0B97F4;
    $secondary:#ceeafd;
  .admin-panel {
    box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
    /*display: flex;
    margin-top: 9rem;*/
    width: 90vw;
    margin: 0 auto; /* Centrar horizontalmente */
    margin-top: 10rem; /* Centrar verticalmente */
    border-radius: 10px;
    display: flex;
    justify-content: space-between;
    overflow: hidden;
  }

  .sidebar {
    width: 270px;
    background-color: $secondary;
    padding: 20px;
    display: flex;
    flex-direction: column;
  }

  .sidebar-items {
    display: flex;
    flex-direction: column;
    margin-bottom: auto; // Empuja los elementos hacia la parte superior
  }

  .sidebar-item {
    cursor: pointer;
    margin-bottom: 10px;
    display: flex;
    align-items: center;

    span {
      margin-right: 10px;
    }
  }

  .logout-container {
    margin-top: auto; // Empuja el elemento hacia la parte inferior
  }

  .content {
    flex: 1;
    padding: 20px;
    display: flex;
    flex-direction: column;
  }

  .admins-content {
    display: flex;
    flex-direction: column;
    justify-content: flex-end; // Alinea los elementos al final (derecha)
  }

  .create-admin-button {
    width: 180px;
    padding: 5px;
    background-color: #5981b4;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .create-admin-box{
    text-align: center;

    .tittle-ad{
      font-weight: bold;
    }
    .text-ad{
      margin-top: 30px;
    }

    .button-create-ad{
      width: 250px;
      padding: 5px;
      margin-top: 30px;
      border-radius: 5px;
      background-color: #5981b4;
      color: #fff;
      border: none;
      cursor: pointer;
    }
  }

  .admin-info-box {
    background-color: #f5f5f5;
    border: 1px solid #ddd;
    padding: 10px;
    margin-bottom: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .span-firstName{
    margin-right: 5px;
  }

  .admin-info {
    flex: 1;
  }

  .delete-button-container {
    flex: 0;
    margin-left: 10px;
    cursor: pointer;
    color: red;
  }

  .create-admin-form{
    
        
      .input-admin {
          width: 60%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;

    }  

  }
  ///ELIMINAR ADMIN 
  .card_containerAdmin{
      visibility: hidden;
      opacity: 0;
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgb(0,0,0,0.2);
      display: flex;
      justify-content: center;
      align-items: center;
      overflow: hidden;
    }

    .card_containerAdmin.active{
        visibility: visible;
        opacity: 1;
    }

    .cardAdmin{
        
        width: 360px;
        background-color: $blanco;
        padding: 40px 25px;
        border-radius:8px;
        text-align: center;
        position:relative;
    }

    .card_img{
        width: 100px;
        margin-bottom: 10px;
    }

    .card_contentAdmin h1{
        font-size: 28px;
        margin-bottom: 10px;
    }
    .card_contentAdmin p{
        font-size: 14px;
        margin-bottom: 20px;
    }
    .group_btns{
       margin-bottom: 10px;
    }
    .buttonAdmin{
        width: 90px;
        height: 35px;
        border:$azul .2rem solid; 
        border-radius:5rem;
        cursor: pointer;
        margin-top:1rem;
        background-color: $blanco;
        font-size: 12px;
    }
    .buttonAdmin:nth-child(1){
        background-color: $azul;
        color: $blanco;
        margin-right: 10px;
    }

    .close_btnAdmin{
        position: absolute;
        top:5%;
        right: 5%;
        font-size: 30px;
        cursor: pointer;
    }

    .bx .bx-x{
      cursor: pointer;
      background-color:$accent;

    }

  @media screen and (max-width: 1000px) {
        .admin-panel {
            width: 70%;
            margin-top: 10rem;
        }
        .content {
            width: 100%;
            border-radius: 5px;
        }
    }

    @media screen and (max-width: 650px) {
        .admin-panel {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .admin-panel {
            height: 100%;
            margin-top:10rem;
        }

        .content {
           .texto{
                margin-top:5rem ;
            }  
        }
    }
</style>

  
<script>
import listAdminsService from "@/services/adminService/listAdminsService.js";
import logoutService from "@/services/authenticationService/logoutService.js";
import deleteAdminService from "@/services/adminService/deleteAdminService.js";
import errorModal from "@/components/ErrorModal.vue";
import spinner from "@/components/spinner.vue";

export default {
  data() {
    return {
      selectedTab: 'admins',
      admins: [/* Lista de administradores */],
      creatingAdmin: false,
      newAdminName: '',
      newAdminEmail: '',
      cardContainerAdmin: false,
      errorMessage: "",
      showErrorMessage: false,
      showSpinner: false, // Initialize as hidden
    };
  },
  created(){
    this.showSpinner = true;
    this.loadAdmins();
    listAdminsService.listAdmins()
          .then((response) => {
            this.showSpinner = false;
            // Handle the successful login response here
            if (response.status == 200){
              this.admins = response.data;
              console.log(this.admins);
              //console.log(admins);
              console.log("Add management successful:", response.data);
            }
          })
          .catch((error) => {
            this.showSpinner = false;
            // Handle login errors here
            if (error.response.status == 401){
              console.log("authorized personnel only:", error.response.status, error);
              this.errorMessage = error.response.data.message || "authorized personnel only";
              this.showErrorMessage = true;
            } 
            if (error.response.status == 403){
              console.log("User not found sorry:", error.response.status, error);
              this.errorMessage = error.response.data.message || "User not found";
              this.showErrorMessage = true;
            }
            else {
              // You can redirect the user or perform other actions here.
              console.error("Something happened:", error);
              this.errorMessage = error.response.data.message || "Something happened";
              this.showErrorMessage = true;
            }
            // Display an error message to the user or take appropriate action.
          });
  },
  methods: {
    redirectToPerfil(){
      this.$router.push('/Perfil');
    },

    selectTab(tab, event) {
      this.selectedTab = tab;
      this.creatingAdmin = false; // Oculta el formulario al cambiar de pestaña
    },

    showCreateAdminForm() {
      this.selectedTab = 'createAdmin'; // Cambiar a una pestaña especial para la creación
      this.creatingAdmin = true;

      //por ahora, para la entrega el sprint 1. solo haré un redirect
      this.$router.push('/CrearAdmin');
    },

    confirmAdminCreation() {
      // Agregar lógica para crear un nuevo administrador aquí.
      // Restablecer los valores y volver a la pestaña "Admins".
      this.newAdminName = '';
      this.newAdminEmail = '';
      this.creatingAdmin = false;
      this.selectedTab = 'admins';
  
    },
    
    // Otros métodos como logout, deleteAdmin, etc.
    toggleCardContainer() {
      this.cardContainerAdmin = !this.cardContainerAdmin;
    },
    cancelDelete() {
      // Aquí puedes implementar la lógica para cancelar la eliminación
      this.toggleCardContainer(); // Oculta la ventana emergente
    },
   
    //INTENTO
    loadAdmins() {
      listAdminsService.listAdmins()
        .then((response) => {
          if (response.status === 200) {
            this.admins = response.data;
            console.log(this.admins);
          }
        })
        .catch((error) => {
          console.error("Something happened:", error);
          this.errorMessage = error.response.data.message || "Something happened";
          this.showErrorMessage = true;
        });
    },
   
      confirmDelete(adminId) {
        deleteAdminService.deleteAdmin(adminId)
          .then((response) => {
            if (response.status === 200) {
              console.log("Administrador eliminado:", adminId);
              this.loadAdmins(); // Vuelve a cargar la lista de administradores
              this.toggleCardContainer(); // Oculta la ventana emergente
            }
          })
          .catch((error) => {
            console.error("Error al eliminar al administrador:", error);
            this.errorMessage = error.response.data.message || "Error al eliminar al administrador";
            this.showErrorMessage = true;
          });
      },
  

      logout(){
            logoutService.logout().then((response) => {
          // Maneja la respuesta exitosa aquí
          if (response.status === 200) {
            console.log("logout exitoso", response.data);
            // Redirige al usuario o realiza otras acciones según tus necesidades
          }
        })
        .catch((error) => {
            console.error("Something happened:", error);
            this.errorMessage = error.response.data.message || "Something happened";
            this.showErrorMessage = true;
          }
        );
        // Remove the JWT token from the localStorage
        window.sessionStorage.removeItem("JWTtoken");
        this.$router.push("/Login");
    },
  },
  components: {
        errorModal,
        spinner,
  },
    // Otros métodos como logout, deleteAdmin, etc.
}
</script>

