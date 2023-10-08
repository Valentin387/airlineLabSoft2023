
<template>
    <section class ="home" id="home">
        <div class="content">
            <span>Descubre</span>
            <h3>tu próximo destino</h3>
            <p>Encuentra las mejores ofertas en boletos de avión y comienza tu aventura</p>
            <a href="#book-form" class="btn">Reservar</a>
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
                        <option value="Pereira">Madrid</option>
                        <option value="Bogotá">Londres</option>
                        <option value="Medellín">New York</option>
                        <option value="Cali">Buenos Aires</option>
                        <option value="Cartagena">Miami</option>
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
    <section class="about" id="about">

        <div class="video-container">
          
         
            <video class="video" src="../assets/londres.mp4" autoplay loop muted  ></video>
            <div class="controls">      
                    <span class="control-btn"  data-src = '../assets/newyork.mp4' ></span>
                    <span class="control-btn" data-src ='../assets/miami.mp4'></span>
                    <span class="control-btn"  data-src = '../assets/londres.mp4'></span>
            </div>
             
        </div>
        <div class="content">
            <span>¿Por qué escogernos?</span>
            <h3>Nature's Majesty Awaits You</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.</p>
            <a href="#" class="btn">Read More</a>
        </div>
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
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.</p>
                    <a href="#" >Leer más <i class="material-symbols-outlined">arrow_forward_ios</i></a>
                </div>
            </div>
            <div class="box">
                <div class="image">
                    <img src="../assets/londres2.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Londres</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.</p>
                    <a href="#" >Leer más <i class="material-symbols-outlined">arrow_forward_ios </i></a>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="../assets/newyork1.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>New York </h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.</p>
                    <a href="#" >Leer más <i class="material-symbols-outlined">arrow_forward_ios </i></a>
                </div>
            </div>


            <div class="box">
                <div class="image">
                    <img src="../assets/madrid.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Madrid </h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.</p>
                    <a href="#" >Leer más <i class="material-symbols-outlined">arrow_forward_ios </i></a>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="../assets/buenosaires1.jpg" alt="">
                </div>  
                <div class="content">
                    <h3>Buenos Aires </h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.</p>
                    <a href="#" >Leer más<i class="material-symbols-outlined">arrow_forward_ios </i></a>
                </div>
            </div>
        </div>
    </section>

</template>


<style lang="scss" > 
    $blue: #0d629b; 
	$black: hwb(216 19% 56% / 0.7);
	$white:#b8e4f5;
	$light-color:#312c02;
    $verde:#cffcf1;
    $degradado: rgba(0, 0, 0, 0.5);
	$bg-color:#ffffff;
	$black-bg:rgba(102, 111, 96, 0.7);
	$border:.2rem solid $blue;
    $accent: #00BD8E;


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
        background: $black;
    }

    &::-webkit-scrollbar-thumb{
        background-color: $bg-color;
    }

}



   
	
.home {  //Recuadro con imagen 
    margin: 0 auto;
    margin-top:9rem;
    width: 90vw;
    border-radius: 1rem;
    background: linear-gradient($degradado, $black-bg), url(../assets/home1.jpg) no-repeat ;
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
            -webkit-text-stroke: .1rem $white;
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
            color: $white;
            line-height: 2;

        }

       
    }
}

.book-form{//Barra de busqueda de vuelos 
    width: 80vw;
    margin: 0 auto;
    margin-top: -9rem;
    background: $bg-color;
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
                color: $light-color;
            }

            input, select{ 
                //select--> selectores de Origen de vuelo y destino de vuelo
                //input--> selectores de fecha de salida, fecha de regreso y número de pasajeros
                width: 100%;
                padding: 1.2rem 1.4rem;
                border-radius: 5rem;
                border: $border;
                font-size: 1.6rem ;
                color: $light-color;
                text-transform: none;
                background: none;
                margin-top: 1rem;
                
            }
            
        }

        .btn{
            flex: 1 1 15rem;
            align-content: center;
        }
    }

}

.about{
    display: flex;
    align-items:center;
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
                    background: $blue;

                }


            }
        }
    }

    .content{
        flex: 1 1 42rem;
        margin-bottom: 5rem;

        span{
            color: $bg-color;
            font-size: 2rem;
        }

        h3{
            color: $light-color;
            font-size: 4rem;
            margin-top: .5rem;
        }

        
        p{
            padding: 1rem 0;
            font-size:1.4rem ;
            color: $light-color;
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
        color: $bg-color;
        font-size: 2rem;
    }
    h1{
        font-size: 4rem;
        color:$light-color;
    }
}


.destination .box-container{
    @include grid (27rem);

    .box{
        border-radius: 1rem;
        overflow:hidden;
        background: $bg-color;
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
                color: $blue;

            }
            p{
                padding:1rem 0;
                font-size: 1.4rem;
                color: $light-color;
                line-height: 2rem;
            }

            a{
                font-size:1.7rem;
                color:$accent;
                &:hover{
                    padding-left: 1rem;
                }


                i{
                    padding-right: .5rem ;

                }
            }
        }
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