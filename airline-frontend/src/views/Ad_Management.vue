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
                  <span @click="deleteAdmin(admin)" class="delete-button">x</span>
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
          <div>
            <button @click="confirmAdminCreation" class="button-create-ad">Confirmar Creación</button>
          </div>
         
        </div>
      </div>
    </div>
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
  html{
        /* 
        Estilo CSS para la vista Home.vue del proyecto Vue.js. 
        La propiedad font-size establece el tamaño de fuente base en 10px, lo que equivale a 62.5% del tamaño de fuente predeterminado del navegador. 
        La propiedad overflow-x:hidden oculta el desplazamiento horizontal de la página. 
        La propiedad scroll-behavior: smooth agrega un efecto de desplazamiento suave al hacer clic en los enlaces internos de la página. 
        La propiedad scroll-padding-top establece la cantidad de espacio de relleno en la parte superior de la página para compensar la barra de navegación fija. 
        */
        font-size: 62.5%;
        overflow-x:hidden;
        scroll-behavior: smooth;
        scroll-padding-top:9rem;

        /* 
        Estilos para la barra de desplazamiento en la vista Home.vue.
        Se utiliza el selector de pseudo-elemento &:: para aplicar estilos a la barra de desplazamiento.
        */
        &::-webkit-scrollbar{
            width:1rem;
        }

        &::-webkit-scrollbar-track{
            background: $accent;
        }

        &::-webkit-scrollbar-thumb{
            background-color: $azul;
        }

  }
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
    background-color: $azul-claro;
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
  