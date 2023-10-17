<template>
    <body>
        <div class="admin-container">
            <div class="admin-info-container">
                <hr>
                <h1 class="title">Crear administrador</h1>
                <form class="inputs-container">
                    <hr>
                    <p class="texto">Por favor ingrese Correo Electrónico y nombre del administrador</p>
                    <input class="input-admin" type="text" placeholder="Correo Electrónico">
                    <input class="input-admin" type="text" placeholder="Usuario">
                    <button class="btn-admin">Confirmar Creación</button>
                </form>
            </div>
                <img class="image-container" src="src/assets/CrearAdmin.svg" alt="">
        </div>

    </body>
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
  

    .admin-container {
        height: 85vh;
        box-shadow: 3px 3px 6px rgba(1, 0.2, 1, 0.2);
      // background-image: linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%);
    }

    .admin-container {
        
        width: 90vw;
        margin: 0 auto; /* Centrar horizontalmente */
        margin-top: 10rem; /* Centrar verticalmente */
        border-radius: 10px;
        display: flex;
        justify-content: space-between;
        overflow: hidden;
    }


    .admin-info-container {
        width: 50%;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
        padding-top: 3rem;
        background-color: $secondary;
        .inputs-container {
            height: 55%;
            width: 60%;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
        }
    }

    .image-container {
        padding: 2rem;
        width: 50%;
        background-color: $azul;
        box-sizing: border-box;
    }

    .title {
        text-transform: capitalize;
        font-size: 2.25rem;
        font-weight: 600;
        letter-spacing: 1px;
        color: $azul;
        
    }

 

    .social-login-element {
        width: 12.5rem;
        height: 3.75rem;
        font-size: 1.2rem;
        font-weight: 700;
        letter-spacing: 0.5px;
        border-radius: 5px;
        border: 1px solid $azul;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .social-login-element img {
        width: 1.875rem;
        height: 1.875rem;
        position: relative;
        top: 0;
        left: -0.625rem;
    }

   

    .admin-info-container > p {
        font-size: 1rem;
        margin-top: 1rem;
    }

    

    .input-admin {
          width: 100%;
          margin: 10px 0;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;

    }

  

    .input-admin:hover {
        border: 2px solid $azul;
    }

    .btn-admin {
        
        margin-top:1rem;
        display:inline-block;
        padding: 1rem 3rem; 
        font-size: 1.7rem;
        color: $accent;
        border:$azul .2rem solid; 
        border-radius:5rem;
        cursor: pointer;
        background: $blanco;
        box-shadow: 1px 5px 5px rgba(0.5, 0.1, 0.1, 0.1);

        &:hover{
            background: $accent;
            color: $blanco;
            text-decoration-line: none;
            
        }
    
    }

    .inputs-container p {
        margin: 0;
        .span {
            color: $accent;
            font-weight: 600;
            cursor: pointer;
         }
    }

    

    @media screen and (max-width: 1000px) {
        .admin-container {
            width: 70%;
            margin-top: 10rem;
        }
        .admin-info-container {
            width: 100%;
            border-radius: 5px;
        }
        
        .image-container {
            display: none;
        }  
    }

    @media screen and (max-width: 650px) {
        .admin-container {
            width: 90%;
        }
    }

    @media screen and (max-width: 500px) {
        .admin-container {
            height: 100%;
            margin-top:10rem;
        }

        .admin-info-container  {
           .texto{
                margin-top:5rem ;
            }
            
            
        }
    }

</style>