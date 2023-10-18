<template>
  <div class="admin-panel">
    <div class="sidebar">
      <a data-aos= "zoom-in-left" data-aos-delay="150" href="#" class="logo"> <i class= "fa-solid fa-paper-plane"></i>AirTravel</a>
      <div class="sidebar-item" @click="showProfile"><span class="material-symbols-outlined">person</span>Perfil</div>
      <div class="sidebar-item" @click="showAdmins"><span class="material-symbols-outlined">lock</span>Gestionar administradores</div>
      <div class="sidebar-item" @click="logout"><span class="material-symbols-outlined">logout</span>Cerrar sesión</div>
    </div>
    <div class="content">
      <div v-if="selectedTab === 'profile'">
        <h2>Perfil</h2>
      </div>
      <div v-else-if="selectedTab = 'admins'">
        <h2>Administradores</h2>
        <div class="admins-content">
          <button @click="showCreateAdminForm" class="create-admin-button" type="button">Crear Administrador</button>
          <ul>
            <li v-for="admin in admins" :key="admin.id">
              {{ admin.name }} - {{ admin.title }} - {{ admin.createdAt }}
              <span @click="deleteAdmin(admin)" class="delete-button">X</span>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>


<style lang="scss">
  .admin-panel {
    display: flex;
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
    align-items: flex-start;
  }

  .create-admin-button {
    width: 150px;
    padding: 10px;
    background-color: #5981b4;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    align-self: flex-end; 
  }
</style>

  
<script>
  export default {
    data() {
      return {
        selectedTab: 'profile',
        admins: [/* Lista de administradores */],
      };
    },
    methods: {
      showProfile() {
        this.selectedTab = 'profile';
      },
      showAdmins() {
        this.selectedTab = 'admins';
      },
      logout() {
        // Agregar la lógica para cerrar sesión
      },
      deleteAdmin(admin) {
        // Agregar la lógica para eliminar un administrador
      },
      showCreateAdminForm() {
        // Agregar la lógica para mostrar el formulario de creación de administradores
      },
    },
  };
</script>
  