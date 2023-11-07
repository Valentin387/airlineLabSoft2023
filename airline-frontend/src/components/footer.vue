<template>
<footer class="footer">
        <div class="box-container">
            <div class="box"  >
                <h3 href="/" class="logo"><i class="fas fa-paper-plane"></i>AirTravel</h3>
                <p> Elige más que un tiquete; elige una experiencia de viaje excepcional con nosotros.</p>
               
            </div>

            <div class="box">
                <h3>Links</h3>
                <a href="/" class="links"><i class="material-symbols-outlined">chevron_right</i>Inicio</a>
                <a href="/Check-In" class="links"><i class="material-symbols-outlined">chevron_right</i>Confirmar Check-in</a>
                <a href="/Ayuda" class="links"><i class="material-symbols-outlined">chevron_right</i>Ayuda</a>
                    <a href="/Contactanos" class="links"><i class="material-symbols-outlined">chevron_right</i> contáctanos</a>

            </div>
            <div class="box">
                <h3> Información de contacto </h3>
                <p><i class="material-symbols-outlined">map</i>Pereira, Colombia</p>
                <p><i class="material-symbols-outlined">call</i>+57 123-456-7890</p>
                <p><i class="material-symbols-outlined">mail</i>airtravellabsoft@gmail.com</p>
            </div>
            <div class="box">
                <h3>Boletín informativo</h3>
                <p>Suscríbete para conocer las últimas actualizaciones</p>
                <form action = "">
                    <input type="email" placeholder="Ingrese su correo" class="email" id="">
                    <input type="submit" value="Suscribirse" class="btn">
                </form>
            </div>
        </div>
    </footer>
    <!-----------------------------------------------Creditos de la pagina------------------------------------------>
    <div class="credit">Creado por : <span> Valentín Valencia - Felipe Galindo - Evelyn Tabares - Brayan Torres</span> | All rights reserved</div>
   
</template>
  
<script>
  export default {
    name: 'Footer',
  };
</script>
  

<style lang="scss" > 
 
  @import url("https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;1,300&family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,600;1,200&display=swap");
  *{
      font-family: 'Poppins', sans-serif;
      margin: 0; padding: 0;
      box-sizing: border-box;
      outline: none; border:none;
      text-decoration: none; 
      transition:all .2s;
  }
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

      
  @mixin grid($val){
      display:grid;
      grid-template-columns: repeat(auto-fit, minmax($val, 1fr));
      gap:1.5rem;
  }


  .footer{  
      .box-container{
          @include grid(25rem);
          background:$secondary;
          padding: 3rem 2rem;
          
          .box{
              padding: 1rem 0;
              background:$secondary;
             
              .logo{
                i{//Figura de avión 
                    padding-right: 1rem;
                    color:$blanco;
                    text-shadow: -1px 3px 3px rgba(1, 0.4, 0.3, 0.6);
                }
                  color:$negro;//Letra de la palabra AirTravel
              }
              .btn{ //------Botón de buscar vuelo
                    margin-top:1rem;
                    display:inline-block;
                    padding: 1rem 3rem; 
                    font-size: 1.7rem;
                    color: $blanco;
                    border:$azul .2rem solid; 
                    border-radius:5rem;
                    cursor: pointer;
                    background: $azul;

                    &:hover{
                        background: $accent;
                        color: $blanco;
                        text-decoration-line: none;
                        
                    }
                }
              h3{
                  font-size: 2.2rem;
                  color:$azul;
                  font-weight: bolder;
                  padding:1rem 0;
                  text-transform: capitalize;

              }

              p{
                  font-size: 1.4rem;
                  color:$negro;
                  padding:1rem 0;
                  line-height: 2;
                  i{//Iconos de informacion de contacto
                      padding-right:.5rem ;
                      color:$accent;
                  }

                  
              }

              .links{ //Links rapidos a secciones de la pagina
                  font-size: 1.4rem;
                  color: $negro;
                  padding: 1rem 0 ;
                  display: block;
                  text-transform: capitalize;
                  font-weight: bolder;

                  &:hover{
                      background-color: transparent;
                      color:$verde;
                      text-decoration: none;
                      i{
                      padding-right: 2rem;
                      }
                  }

                  i{
                      padding-right:.5rem ;
                      color:$accent;
                  }
              }
              form .email{
                  width: 100%;
                  border-radius: 5rem;
                  border:$accent solid .1rem;
                  background: none;
                  font-size:1.5rem;
                  text-transform: none;
                  color:$negro;
                  margin-top: 1rem;
                  padding: 1.4rem 1.4rem;


              }
          }

      }
  }

  .credit{//Autores de la pagina
      background: $secondary;
      text-align: center;
      font-size: 2rem;
      padding: 2rem 1rem;
      color: $verde;
      font-weight: bolder;
      margin-top: 5rem;

      span{ 
          color: $negro;
      }
  }

</style>