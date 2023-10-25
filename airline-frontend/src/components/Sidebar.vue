<template>
  <aside :class="`${is_expanded  && 'is-expanded' }`">
    <div class="logo"> 

        <img src="../assets/logo.svg" alt="vue" />
    </div>

    <div class= "menu-toggle-wrap">
        <button class="menu-toggle" @click="ToggleMenu">
          <span class="material-icons">keyboard_double_arrow_right </span>
        </button>
    </div>

   <h3> Menu</h3> 
   <div class="menu">
      <router-link class="button" to="/">
          <span class="material-icons">home</span>
          <span class="text">Home</span>
      </router-link>

      <router-link class="button" to="/About">
          <span class="material-icons">visibility</span>
          <span class="text">About</span>
      </router-link>
   
      <router-link class="button" to="/team">
          <span class="material-icons">group</span>
          <span class="text">Team</span>
      </router-link>

      <router-link class="button" to="/contact">
          <span class="material-icons">email</span>
          <span class="text">Contact</span>
      </router-link>
    </div>
    <div class="flex"> </div>
    <div class="menu">
      <router-link class="button" to="/settings">
          <span class="material-icons">settings</span>
          <span class="text">Settings</span>
      </router-link>
    </div>

  </aside>
</template>

<script setup>

import {ref} from 'vue'

const is_expanded = ref(localStorage.getItem('is_expanded') === 'true');/**
 * Referencia a una variable reactiva que almacena el valor booleano de si la barra lateral está expandida o no.
 * El valor se inicializa con el valor almacenado en el almacenamiento local del navegador.
 */

const ToggleMenu = () => {
  is_expanded.value = !is_expanded.value;
  localStorage.setItem('is_expanded', is_expanded.value);// Guarda y restaura la última página seleccionada al refrescar la página.

}

</script>
 
<style lang="scss" scoped>
aside {
  position: fixed;
  left: 0;
  top: 0;
  display:flex; 
  flex-direction: column;
  width: calc(2rem + 32px);
  min-height: 100vh;
  overflow: hidden;
  padding: 1rem;
  background-color: var(--dark);
  color: var(--light);
  transition: 0.2s ease-out;

  /**
   * Esta regla CSS establece las propiedades flex-grow, flex-shrink y flex-basis de la clase .flex en 1, 1 y 0 respectivamente.
   * Esto permite que el elemento con la clase .flex crezca y se encoja según sea necesario, manteniendo su tamaño inicial de 0.
   * 
   * La propiedad flex es una abreviatura de las propiedades flex-grow, flex-shrink y flex-basis.
   * El primer número (1) establece el valor de flex-grow, que define la capacidad de un elemento para crecer si hay espacio disponible.
   * El segundo número (1) establece el valor de flex-shrink, que define la capacidad de un elemento para reducir su tamaño si no hay suficiente espacio disponible.
   * El tercer número (0) establece el valor de flex-basis, que define el tamaño inicial de un elemento antes de que se apliquen las propiedades flex-grow y flex-shrink.
   */
  .flex{
    flex: 1 1 0;
  }
  
  .flex{
    flex: 1 1 0;
  }
  .logo {
    margin-bottom: 1rem;

    img{
      width:2rem;
    }
  }
  .menu-toggle-wrap{
    display: flex;
    justify-content: flex-end;
    margin-bottom: 1rem;

    position: relative;
    top: 0;
    transition:0.2s ease-out;

    .menu-toggle{
      transition: 0.2s ease-out;
    }
    
      .material-icons{ /* Cambiar color de iconos */
        font-size: 2rem;
        color: var(--light);
        transition: 0.2s ease-out;
      }
     
       &:hover{   /* Al pasar el cursor sobre el siguiente elemento:  */
        .material-icons{ /* Se pasa el cursos sobre un icono*/
          color: var(--primary);/*El color del icono cambia al color 'primary': <<  */
          transform: translateX(0.5rem);/*El icono se desplaza 0.5rem hacia la derecha  */
        }
       }
  }

  h3, .button .text{/*Vuelve invisible el texto del botón*/
    opacity: 0;
    transition: 0.3s ease-out;
  }

  h3{
    color:var(--grey);
    font-size:0.875rem;
    margin-bottom:0.5rem;
    text-transform:uppercase;

  }


  .menu{     /* Referencia al menú */
    margin: 0 -1rem;
      .button{ /* Referencia a cada botón*/
        display:flex;
        align-items: center;
        text-decoration: none;

        padding: 0.5rem 1rem;
        transition: 0.2s ease-out;

        .material-icons{/*Iconos de opciones de la barra*/
          font-size: 2rem;
          
          color: var(--light);
          transition: 0.2s ease-out;
        }
        .text{
          color: var(--light);
          transition: 0.2s ease-out;
        }

        &:hover, &.router-link-exact-active{ /*Al pasar el cursor sobre cualquier icono del menú cambia de color */
          background-color: var(--dark-alt);
          .material-icons, .text{
            color: var(--primary);
          }
        }
        &.router-link-exact-active{
          border-right: 5px solid var(--primary);
        }
      }

  }
  

  &.is-expanded {
    width: var(--sidebar-width);/*El icono ''<<' se desplaza la siguiente cantidad: 'sidebar-width' */
    .menu-toggle-wrap{
      top:-3rem; /*Al desplazarse sube 3rem*/
      .menu-toggle{
        transform: rotate(-180deg); /*Cambiar la dirección del icono : <<*/
      }
    }

    h3, .button .text{/* Vuelve visible el texto del botón */
      opacity: 1;
    }

    .button{
      .material-icons{
        margin-right: 1rem;
      }

    }
  }


  @media(max-width: 768px){
    position: fixed;
    z-index: 99;
  }
}

</style>