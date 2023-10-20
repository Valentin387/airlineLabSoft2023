<template>
    <section class="EliminarAdmin">
      <button class="card_buttonAdmin" @click="toggleCardContainer">
        Eliminar administrador
      </button>
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
              <button class="buttonAdmin" @click="confirmDelete">
                Continuar
              </button>
            </div>
          </div>
          <p class="close_btnAdmin" @click="toggleCardContainer">
            <i class='bx bx-x'></i>
          </p>
        </div>
      </div>
    </section>
  </template>
  
  <script>
  export default {
    data() {
      return {
        cardContainerAdmin: false,
      };
    },
    methods: {
      toggleCardContainer() {
        this.cardContainerAdmin = !this.cardContainerAdmin;
      },
      cancelDelete() {
        // Aquí puedes implementar la lógica para cancelar la eliminación
        this.toggleCardContainer(); // Oculta la ventana emergente
      },
      confirmDelete() {
        // Aquí puedes implementar la lógica para confirmar la eliminación
        this.toggleCardContainer(); // Oculta la ventana emergente
      },
    },
  };
</script>
  
<style lang="scss">
    @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
   /*  *{
        margin:0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Popins', sans-serif;
    }*/
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
    
    .EliminarAdmin{
        background-color: $blanco;
        height: 100vh;
        display:flex;
        justify-content: center;
        align-items:center;
    }
    .card_buttonAdmin{
        padding:12px 40px;
        border-radius:18px;
        border:none;
        background-color: rgb(18,18,18);
        color: $blanco;
        font-size: 18px;
        cursor: pointer;
    }
   
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

</style>