
<template>
    <section class ="home" id="home">
        <div class="content">
            <span>Descubre</span>
            <h3>tu próximo destino</h3>
            <p>Encuentra las mejores ofertas en tiquetes de avión y comienza tu aventura</p>
        </div>
    </section>
    <section class="book-form" id="book-form">
        <form action="">
              
                <div class="inputBox">
                    <span>Origen</span>
                    <select name="origen" placeholder = "¿Desde dónde vuelas?" value="">
                        <option value="Pereira">Pereira</option>
                        <option value="Bogotá">Bogotá</option>
                        <option value="Medellín">Medellín</option>
                        <option value="Cali">Cali</option>
                        <option value="Cartagena">Cartagena</option>
                    </select>
                </div>
              
                <div class="inputBox">
                    <span>Destino</span>
                    <select name="destino" placeholder = "¿A dónde vuelas?" value="">
                        <option value="Madrid">Madrid</option>
                        <option value="Londres">Londres</option>
                        <option value="NewYork">New York</option>
                        <option value="BuenosAires">Buenos Aires</option>
                        <option value="Miami">Miami</option>
                    </select>
                 
                </div>
                <div class="inputBox">
                    <span>Fecha de salida</span>
                    <input type="date" value="">
                    
                </div>
            
                <div class="inputBox">
                    <span>Fecha de regreso</span>
                    <input type="date" value="">
                </div>
            
                <div class="inputBox" id="numPasajeros">
                    <span>¿Cuántos?</span>
                    <input type="number" placeholder="Número de pasajeros" value="">
                </div>
                <input type="submit" value="Buscar" class="btn">
        </form>
    </section>
   
    <section class="destination" id="destination">
        <div class="heading">
            <span>Nuestros destinos</span>
            <h1>Escoge el tuyo</h1>
        </div>
        <div class="box-container">
            <div class="box">
                <div class="image">
                    <img src="../assets/miami.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Miami </h3>
                    <p>Miami es una ciudad en el sureste de Florida, conocida por su clima tropical, playas impresionantes y vida nocturna vibrante. Es un destino popular para aquellos que buscan diversión, compras y relajación bajo el sol de Florida.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/londres2.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Londres</h3>
                    <p>a capital del Reino Unido, Londres, es una metrópolis diversa que combina la historia y la modernidad. Ofrece una amplia gama de atracciones, desde el Palacio de Buckingham hasta el Museo Británico</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="../assets/newyork1.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>New York </h3>
                    <p>La Gran Manzana, Nueva York, es una de las ciudades más emblemáticas del mundo. Ofrece rascacielos imponentes, teatros de Broadway y una escena artística vibrante.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>


            <div class="box">
                <div class="image">
                    <img src="../assets/madrid.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Madrid </h3>
                    <p>Madrid, la capital de España, es conocida por su rica cultura, arte y vida nocturna. Puedes disfrutar de tapas en los bares locales, visitar el Museo del Prado y explorar la arquitectura impresionante.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="../assets/buenosaires1.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Buenos Aires </h3>
                    <p> La ciudad de Buenos Aires en Argentina es famosa por su pasión por el tango, su deliciosa comida y su arquitectura europea. Es una ciudad que combina un ambiente elegante con un toque de nostalgia.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/bogota.jpeg" alt="">
                </div>  
                <div class="content">
                    <h3>Bogotá </h3>
                    <p>La capital de Colombia, Bogotá, es una ciudad cosmopolita con una rica historia y una creciente escena de arte. El Museo del Oro y el centro histórico son puntos de referencia importantes.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/medellin.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Medellín</h3>
                    <p>Conocida como "La Ciudad de la Eterna Primavera", Medellín es una de las ciudades más dinámicas de Colombia. Rodeada por colinas verdes, la ciudad disfruta de un clima templado durante todo el año. Medellín es famosa por su espíritu innovador.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/pereira.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Pereira</h3>
                    <p>Pereira es una ciudad colombiana rodeada de paisajes montañosos y cafetales. Es un destino ideal para los amantes de la naturaleza y el café colombiano.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/cali.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Cali</h3>
                    <p>Cali es famosa por ser la capital de la salsa en Colombia. La ciudad tiene una vibrante escena de baile y música, además de una cultura culinaria única</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/cartagena.jpeg" alt="">
                </div>  
                <div class="content">
                    <h3>Cartagena</h3>
                    <p>Cartagena, en la costa caribeña de Colombia, es conocida por su encanto histórico, arquitectura colonial y playas de aguas cristalinas. Es un lugar perfecto para sumergirse en la historia y la cultura.</p>
                    <a href="#" >Ver vuelos <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
        </div>
    </section>
   
    <section class="about" id="about">

        <div class="video-container">
          
         
            <video class="video" src="../assets/londres.mp4" autoplay loop muted  ></video>
            <div class="controls">      
                    <span class="control-btn"   ></span>
                    <span class="control-btn" ></span>
                    <span class="control-btn"  ></span>
            </div>
             
        </div>
        <div class="content">
            <span>¿Por qué escogernos?</span>
            <h3>Haz de cada viaje una aventura inolvidable</h3>
            <p>Ofrecemos calidad y tarifas competitivas en tus boletos de avión. Nuestro compromiso con tu satisfacción es inquebrantable, y nuestra dedicación a hacer que tu viaje sea inolvidable te dejará deseando volver a volar con nosotros.</p>
        </div>
    </section>
    <section class="footer">
        <div class="box-container">
            <div class="box ">
                <a href="#" class="logo"><i class="fas fa-paper-plane"></i>AirTravel</a>
                <p> Elige más que un tiquete; elige una experiencia de viaje excepcional con nosotros.</p>
                <div class="compartir">
                    <a href="#" class="fab fa-facebook-f"></a>
                    <a href="#" class="fab fa-twitter"></a>
                    <a href="#" class="fab fa-instagram"></a>
                    <a href="#" class="fab fa-github"></a>
                </div>
            </div>

            <div class="box">
                <h3>Links</h3>
                <a href="#home" class="links"><i class="material-symbols-outlined">chevron_right</i>Inicio</a>
                    <a href="#check-in" class="links"><i class="material-symbols-outlined">chevron_right</i>Confirmar Check-in</a>
                    <a href="#Ayuda" class="links"><i class="material-symbols-outlined">chevron_right</i>Ayuda</a>
                    <a href="#contact" class="links"><i class="material-symbols-outlined">chevron_right</i> contactanos</a>

            </div>
            <div class="box">
                <h3> Información de contacto </h3>
                <p><i class="material-symbols-outlined">map</i>Pereira, Colombia</p>
                <p><i class="material-symbols-outlined">call</i>+57 123-456-7890</p>
                <p><i class="material-symbols-outlined">mail</i>airtravellabsoft@gmail.com</p>
            </div>
            <div class="box">
                <h3>Boletín informativo</h3>
                <p>Suscribete para conocer las ultimas actualizaciones</p>
                <form action = "">
                    <input type="email" placeholder="Ingrese su correo" class="email" id="">
                    <input type="submit" value="Suscribirse" class="btn">
                </form>
            </div>
        </div>
    </section>
    <div class="credit">Creado por : <span> Valentín Valencia - Felipe Galindo - Evelyn Tabares - Brayan Torres</span> | all rights reserved</div>
   
</template>
 

<style lang="scss" > 
   

	$light-color:#312c02;
 
    $degradado: rgba(224, 209, 209, 0.11);
	$black-bg:rgba(102, 111, 96, 0.7);

    
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



   
	
.home {  //Recuadro con imagen 
    margin: 0 auto;
    margin-top:9rem;
    width: 90vw;
    border-radius: 1rem;
    background: linear-gradient($degradado, $light-color), url(../assets/home1.jpg) no-repeat ;
    background-size: cover;
    background-position:center;
    display:flex;
    /**
     * Establece la altura mínima de la vista Home en un 80% de la altura de la ventana gráfica (vh-> view height).
     * La altura de la ventana gráfica (vh) es una unidad de medida que representa la altura de la ventana del navegador.
     */
    min-height: 80vh;
    display:flex;
    align-items: center;
    justify-content: center;
    padding-bottom: 5rem;
   

    .content{
        text-align: center;
        span{
            
            font-weight: bolder;
            color: transparent;
            -webkit-text-stroke: .1rem $blanco;
            // Esta línea establece el tamaño de fuente de un elemento al 4% del ancho de la ventana gráfica en el archivo Home.vue
            font-size: 4vw;
            display: block;
        }
        
        h3{
            font-size:6vw;
            color: white;
        }

        p{
            max-width:60rem;
            margin: 1rem auto;
            font-size:1.4rem ;
            color: $blanco;
            line-height: 2;

        }

       
    }
}

.book-form{//Barra de busqueda de vuelos 
    width: 80vw;
    margin: 0 auto;
    margin-top: -9rem;
    background: $azul;
    border-radius: 3rem;
    box-shadow:7 .7rem 1rem rgba(17,17,17,.3);
    padding: 3rem 2rem;

    form{
        display: flex;
        align-items: flex-end;
        flex-wrap: wrap;
        gap:1.5rem; 

        .inputBox{
            flex:1 1 20rem;

            span{
                font-size: 1.4rem;
                padding: 2rem;
                color: $blanco;
            }

            input, select{ 
                //select--> selectores de Origen de vuelo y destino de vuelo
                //input--> selectores de fecha de salida, fecha de regreso y número de pasajeros
                width: 100%;
                padding: 1.2rem 1.4rem;
                border-radius: 5rem;
                border: $accent .3rem solid;
                font-size: 1.6rem ;
                color: $light-color;
                text-transform: none;
                background: $blanco;
                margin-top: 1rem;
                
            }
            
        }

        .btn{
            flex: 1 1 15rem;
            align-content: center;
            border: $accent .3rem solid;
            
        }
    }

}
.btn{ //Botón de buscar vuelo
    margin-top:1rem;
    display:inline-block;
    padding: 1rem 3rem; 
    font-size: 1.7rem;
    color: $accent;
    border:$azul .2rem solid; 
    border-radius:5rem;
    cursor: pointer;
    background: $blanco;

    &:hover{
        background: $accent;
        color: $blanco;
        
    }
}



.destination .box-container{ //DESTINOS DE VUELO
    @include grid (27rem);

    .box{
        border-radius: 1rem;
        overflow:hidden;
        background: $secondary;
        &:hover img{
            transform:scale(1.1);  
        }
        .image{
            height: 20rem;
            overflow: hidden;
            width:100%;

            img{
                height: 100%;
                width: 100%;
                object-fit: cover;

            }

        }

        .content{
            padding:2rem;
            text-align: center;

            h3{
                font-size:2.3rem;
                color: $accent;
            }
            p{
                padding:1rem 0;
                font-size: 1.4rem;
                color: $negro;
                line-height: 2rem;

            }

            a{
                font-size:1.7rem;
                color:$verde;
               
                &:hover{
                    padding-left: 1rem;
                    background-color: transparent;
                    color:$accent;
     
                }


                i{
                    padding-right: .5rem ;

                }
            }
        }
    }
}
.about{
    display: flex;
    align-items: right;
    flex-wrap:wrap;
    gap: 2rem;
    margin-top: 5rem;

    .video-container{
        flex: 1 1 42rem;

        video{
            border-radius: 1rem;
            width:100%;
        }

        .controls{
            text-align: center;
            padding: 2rem 0;

            span{
                display: inline-block;
                height: 2rem;
                width: 2rem;
                border-radius: 50%;
                background: $accent;
                cursor: pointer;
                margin: .7rem;

                &:hover{
                    background: $azul;

                }


            }
        }
    }

    .content{
        flex: 1 1 42rem;
        margin-bottom: 5rem;

        span{
            color: $verde;
            font-size: 2rem;
        }

        h3{
            color: $azul;
            font-size: 4rem;
            margin-top: .5rem;
        }

        
        p{
            padding: 1rem 0;
            font-size:1.4rem ;
            color: $negro;
            line-height: 2;

        }

    }
}

section{
    padding: 3rem 9vh;
    
}

.heading{
    text-align: center;
    margin-bottom: 2rem;

    span{
        color: $verde;
        font-size: 2rem;
    }
    h1{
        font-size: 4rem;
        color:$azul;
    }
}


.footer{
    .box-container{
        @include grid(25rem);

        .box{
            padding: 1rem 0;

            h3{
                font-size: 2.2rem;
                color:$azul;
                padding:1rem 0;

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

            .compartir{
                padding-top:1rem;

                a{
                    height: 4.5rem;
                    width: 4.5rem;
                    line-height:4rem;
                    font-size:2rem;
                    border-radius:50%;
                    font-size:1.7rem;
                    border: $accent .2rem solid;
                    color:$negro;
                    margin-right:1rem;
                    text-align:center ;

                    &:hover{
                        background:$azul;
                        color:$blanco;
                        border: $azul .2rem solid;
                    }

                }
            }
            .links{
                font-size: 1.4rem;
                color: $negro;
                padding: 1rem 0 ;
                display: block;

                &:hover{
                    background-color: transparent;
                    color:$verde;
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
                padding: 1.2rem 1.4rem;


            }
        }

    }
}

.credit{//Creditos 
    background: $secondary;
    text-align: center;
    font-size: 2rem;
    padding: 2rem 1rem;
    color: $azul;
    font-weight: bolder;
    margin-top: 5rem;

    span{ 
        color: $negro;
    }
}




@media (max-width: 768px){//Pagina en tamaño de tablet
  .home{ 
    margin-top: 10rem;

    .content{
        span{
            font-size: 8vw;
        }
        h3{
            font-size:9vw;
        }
    }
  }
}
  

@media (max-width: 991px) {//pagina en tamaño de computador 
    section{
     padding: 3rem 2rem;
    }
}

@media(max-width:450px){
    html{
        font-size: 50%;
    }

    .about .content h3{
        font-size: 3.5rem;
    }
}


</style>