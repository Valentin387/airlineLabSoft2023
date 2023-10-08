<template>
    <div>
        <main class="barraHorizontal"> 
    
            <header class="header">
                <div id="menu-btn" class="material-symbols-outlined" @click="toggle">menu</div>
                <a href="#" class="logo"> <i class="fas fa-paper-plane"></i>AirTravel</a>      
                <nav class="navbar"> 
                    <a href="#home">home</a>
                    <a href="#about">about</a>
                    <a href="#destination">destination</a>
                    <a href="#services">services</a>
                    <a href="#gallery">gallery</a>
                    <a href="#blogs">blogs</a>
                </nav>
                <a href="#book-form" class ="btn">Reservar</a>
            </header>
        </main>
    </div>
    
</template>

<script>

export default {
  methods: {
    toggle() {
      let navbar = document.querySelector(".navbar");
      navbar.classList.toggle("active");
    },
  },
};

</script>



<style lang="scss"  > 
@import url('https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;1,300&family=Poppins:wght@100;300;400;500;600&display=swap');


* {//La regla * selecciona todos los elementos de la página y les aplica los estilos CSS
    border: 1px solid black;
    font-family: 'Poppins', sans-serif;
    margin:0; padding:0;
    box-sizing: border-box;
    outline:none; 
    border:none;
    text-decoration: none;
    text-transform: capitalize;
    transition: all .2s linear; 
}
    $blue: #54b2f1; 
	$black: #0d629b;
	$white:#fff;
    $verde:#cffcf1;
	$light-color:#312c02;
	$bg-color:#ffffff;
	$black-bg:rgba(17, 17, 17, .7);
	$border:.2rem solid $blue;
	
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
        background: $white;
    }

    &::-webkit-scrollbar-thumb{
        background-color: $verde;
    }

}



body{  //FONDO DE LA PAGINA
    background: $blue;
    overflow-x:hidden;
}
//BOTÓN DE "RESERVAR AHORA"
/**
 * Estilos para el botón en la vista Home.
 * 
 * Propiedades:
 * - margin-top: margen superior de 1rem.
 * - display: en línea.
 * - padding: 1rem de padding vertical y 3rem de padding horizontal.
 * - font-size: tamaño de fuente de 1.7rem.
 * - color: color de texto $blue.
 * - border: borde con valor $border.
 * - border-radius: radio de borde de 5rem.
 * - cursor: cursor de tipo pointer.
 * - background: sin fondo.
 * 
 * Pseudo-clase:
 * - &:hover: cuando el cursor está sobre el botón, el fondo cambia a $blue y el texto a $black.
 */

.btn{
    margin-top:1rem;
    display:inline-block;
    padding: 1rem 3rem; 
    font-size: 1.7rem;
    color: $blue;
    border:$border; 
    border-radius:5rem;
    cursor: pointer;
    background: none;

    &:hover{
        background: $blue;
        color:$light-color;
    }
}
//BARRA DE NAVEGACIÓN----------------------------------------------------------------
.header{
    position:fixed;//La barra de navegación se fija en la parte superior de la página
    top:0; right: 0;left: 0;
    z-index: 1000;
    background:$bg-color ;//Color de fondo de la barra de navegación
    display:flex;
    align-items: center;
    justify-content: space-between;
    padding: 1.5rem 9%;

    .navbar a{//Estilos para los enlaces de la barra de navegación
        font-size:1.7rem;
        color:$light-color; //Color de letra de los enlaces
        display: inline-block;//Los enlaces se muestran en una sola línea
        margin: 0 1rem;//Establece el margen del elemento en 0 en la parte superior e inferior, y 1rem en la izquierda y derecha.
        transition: 0.2s ease-out;
        &:hover, &.router-link-exact-active{
            color:$blue ;//Al pasar el cursor sobre la letra del enlace, el color cambia a azul
        }
        &:link{
            text-decoration: none;
        }
        &.router-link-exact-active{
          border-right: 5px solid $blue;
        }
    }

    .btn {
        margin-top: 0;
        
    }

}
//LOGO----------------------------------------------------------------
.logo{//Estilos para el logo de la barra de navegación
    font-size: 2.5rem;
    color:$light-color;
    font-weight: bolder;
    text-decoration: none;

    i{
        color:$blue;
        padding-right:.5rem;
         text-decoration: none;
    }

}

//BARRA RESPONSIVE ----------------------------------------------------------------
#menu-btn {//BOTÓN DE TRES LINEAS PARA RESPONSIVE
    font-size: 2.5rem; // Tamaño de fuente de 2.5rem
    color:$black; // Color de texto blanco
    cursor: pointer; // Cambia el cursor a un puntero al pasar sobre el botón
    display:none; // El botón se muestra en la página
    text-decoration: none;
}

//media queries
@media (max-width: 991px) {//pagina en tamaño de computador 
    html{
        font-size: 55%;
    }
    .header{
        padding: 1.5rem 2rem; // Establece el padding de la barra de navegación en 1.5rem en la parte superior e inferior y 2rem en la izquierda y derecha
    }
}

@media (max-width: 768px){//Pagina en tamaño de tablet

    #menu-btn{  
       display: inline-block; //El menú se muestra desplegado de forma horizontal 
    }
    .header{
        .navbar{
            position:absolute;
            top:99%; left: 0; right:0; 
            background: $bg-color;
            /*
             * El siguiente código establece un clip-path para un elemento con forma de polígono.
             * Inicialmente, el clip-path se establece en un rectángulo sin altura, lo que resulta en un elemento no visible.
             * Cuando se agrega la clase 'active' al elemento, el clip-path se cambia a un rectángulo con una altura del 100%,
             * lo que resulta en que el elemento se vuelva visible.
             */
            clip-path: polygon(0 0, 100% 0, 100% 0, 0 0);
            &.active{
                clip-path: polygon(0 0, 100% 0, 100% 100%, 0 100%);
            }

            a{
                margin:2rem;
                font-size:2rem;
                display:block;
            }
        }
    }
}

@media (max-width: 450px) {//pagina de tamaño de celular
    //Se muestra botón de tres lineas con menú
    html{
        font-size: 50%;
    }
}

</style>
