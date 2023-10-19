<template>
  <div class="admin-panel">
    <div class="sidebar">
      <a data-aos="zoom-in-left" data-aos-delay="150" href="#" class="logo">
        <i class="fa-solid fa-paper-plane"></i>AirTravel
      </a>
      <div class="sidebar-item" @click="selectTab('profile', $event)">
        <span class="material-symbols-outlined">person</span>Perfil
      </div>
      <div class="sidebar-item" @click="selectTab('admins', $event)">
        <span class="material-symbols-outlined">lock</span>Gestionar administradores
      </div>
      <div class="sidebar-item" @click="logout">
        <span class="material-symbols-outlined">logout</span>Cerrar sesión
      </div>
    </div>
    <div class="content">
      <div v-if="selectedTab === 'profile'">
        <h2>Perfil</h2>
      </div>
      <div v-else-if="selectedTab === 'admins'">
        <h2>Administradores</h2>
        <div class="admins-content">
          <button @click="showCreateAdminForm" class="create-admin-button" type="button">
            Crear Administrador
          </button>
          <ul>
            <li v-for="admin in admins" :key="admin.id">
              {{ admin.name }} - {{ admin.title }} - {{ admin.createdAt }}
              <span @click="deleteAdmin(admin)" class="delete-button">X</span>
            </li>
          </ul>
        </div>
      </div>
      <div v-if="creatingAdmin" class="create-admin-box">
        <h2 class="tittle-ad">Crear Administrador</h2>
        <p class="text-ad">Por favor ingrese correo electronico y nombre del administrador</p>
        <div class="create-admin-form">
          <input type="text" v-model="newAdminName" placeholder="Nombre">
          <input type="email" v-model="newAdminEmail" placeholder="Correo Electrónico">
          <button @click="confirmAdminCreation" class="button-create-ad">Confirmar Creación</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss">
  .admin-panel {
    display: flex;
    margin-top:9rem;
  }

  .sidebar {
    width: 270px;
    background-color: #ccc;
    padding: 20px;

    .sidebar-item {
      cursor: pointer;
      margin-bottom: 10px;
      margin-top: 10px;
      display: flex;
      align-items: center; 
      
      span {
        margin-right: 10px; 
      }
    }
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
</style>

  
<script>
import listAdminsService from "@/services/adminService/listAdminsService.js";

export default {
  data() {
    return {
      selectedTab: 'profile',
      admins: [/* Lista de administradores */],
      creatingAdmin: false,
      newAdminName: '',
      newAdminEmail: '',
    };
  },
  created(){
    listAdminsService.listAdmins()
          .then((response) => {
            // Handle the successful login response here
            if (response.status == 200){
              this.admins = response.data;
              console.log(this.admins);
              //console.log(admins);
              console.log("Add management successful:", response.data);
            }
          })
          .catch((error) => {
            // Handle login errors here
            if (error.response.status == 401){
              console.log("Login failed:", error.response.status, error);
              this.errorMessage = error.response.data.message;
            } 
            if (error.response.status == 403){
              console.log("User not found sorry:", error.response.status, error);
              this.errorMessage = error.response.data.message;
            }
            else {
              // You can redirect the user or perform other actions here.
              console.error("Something happened:", error);
            }
            // Display an error message to the user or take appropriate action.
          });
  },
  methods: {
    selectTab(tab, event) {
      this.selectedTab = tab;
      this.creatingAdmin = false; // Oculta el formulario al cambiar de pestaña
    },

    showCreateAdminForm() {
      this.selectedTab = 'createAdmin'; // Cambiar a una pestaña especial para la creación
      this.creatingAdmin = true;
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
  },
};
</script>
  