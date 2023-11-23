<template>
    <body>
        <div class="action">
            <div class="profile"  @click="menuToggle">
                  <a data-aos= "zoom-in-left" data-aos-delay="600"  class="usuario" id="usuario"><i class="material-symbols-outlined">person</i></a>
            </div>
            <div class="menu">
                <h3>Usuario<br><span>Bienvenido</span></h3>
                <ul>
                    <li><a href="#">Perfil</a></li>
                    <li><a href="#">Modulo Financiero</a></li>
                    <li><a href="#">Mis compras</a></li>
                    <li><a href="#">Mis reservas</a></li>
                    <li><a href="#">Noticias</a></li>
                    <!--  <li><a href="#">Foro de preguntas</a></li> -->
                    <li><a href="#">Cerrar Sesión</a></li>  
                </ul>
            </div>
        </div>    
    </body>
</template>
<style lang="scss" scoped>
body{
    background:white;
    top: 20px;
    right:30px;
}
.action .menu{
    position: relative; 
    /* Ajusta la posición para que el menú no afecte la barra de navegación */
    top: auto;
    right: auto;
    /* Modifica otros estilos según sea necesario */
    padding: 10px 20px;
    background: white;
    width: 200px;
    box-sizing: border-box; /* Corrige la propiedad box-sizing */
    border-radius: 15px;
    transition: 0.5s;
    visibility: hidden;
    opacity: 0;
    z-index: 10; /* Asegura que esté por debajo de la barra de navegación */
}

.action .menu h3{
width:100%;
text-align: center;
font-size:18px;
padding:20px 0;
font-weight:500;
font-size: 18px;
color: black;
line-height: 1.2em;
}
.action .menu::before{
    content: "";
    position:absolute ;
    top:-5;
    right:28px;
    width:20px;
    height: 20px;
    background: white;
    transform:rotate(45deg);

}
.action .menu h3 span{
    font-size: 14px;
    color:rgb(179, 130, 67);
    font-weight: 400;
}
.action .menu ul li{
    list-style: none;
    padding:10px 0;
    border-top:1px solid rgba(0,0,0,0.5);
    display:flex;
    align-items:center;
}

.action .menu ul li a {
    display:inline-block;
    text-decoration: none;
    color: aquamarine;
    font-weight:500;
    transition:0.5s;
}
.action .menu ul li a:hover{
    color:rgb(179, 130, 67);
}
.action .menu.active{
    top:80px;
    visibility: visible;
    opacity:1;
}
</style>

<script>
    function menuToggle(){
        const menuToggle=document.querySelector('.menu');
        toggleMenu.classList.toggle('active');
    }
</script>
