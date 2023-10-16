<template>
 

        <div class="container light-style flex-grow-1 container-p-y">
            <div class="card card-large">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-2 pt-0">
                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action active" data-toggle="list"
                                href="#account-general">General</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                                href="#account-change-password">Cambiar Contraseña</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                                href="#account-info">Información Personal</a>
                           
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content">
                            <div class="tab-pane fade active show" id="account-general">
                                <div class="card-body media align-items-center">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar1.png" 
                                        class="d-block ui-w-80">
                                    <div class="media-body ml-3">
                                        <label class="btn btn-outline-primary">
                                            Foto de perfil
                                            <input type="file" class="account-settings-fileinput">
                                        </label> &nbsp;
                                        <button type="button" class="btn btn-default md-btn-flat">Restablecer</button>
                                        <div class="text-light small mt-1">Permitido JPG, GIF or PNG. Tamaño máximo 800K</div>
                                    </div>
                                </div>
                                <hr class="border-light m-0">
                                <div class="card-body">
                                    <div class="form-group ">
                                        <label class="form-label">Usuario</label>
                                        <input type="text" class="form-control " value="nmaxwell">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Nombre Completo</label>
                                        <input type="text" class="form-control" value="Nelle Maxwell">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Correo Electrónico</label>
                                        <input type="text" class="form-control mb-1" value="nmaxwell@mail.com">
                                       <!-- <div class="alert alert-warning mt-3">
                                            Tu correo no ha sido confirmado. Verifica tu bandeja de entrada.<br>
                                            <a href="javascript:void(0)">Reenviar confirmación</a>
                                        </div> --> 
                                    </div>
                                    <div class="form-group">
                                        <div class="switch-button">
                                            <label class="form-label">Suscribirse al módulo de noticias</label>
                                            <!-- Checkbox -->
                                            <input type="checkbox" name="switch-button" id="switch-label" class="switch-button__checkbox">
                                            <!-- Botón -->
                                            <label for="switch-label" class="switch-button__label"></label>
                                        </div>
                                    </div>
                                   

                                
                                </div>
                            </div>
                            <div class="tab-pane fade" id="account-change-password">
                                <div class="card-body ">
                                    <div class="form-group">
                                        <label class="form-label">Contraseña Actual</label>
                                        <input type="password" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Nueva Contraseña</label>
                                        <input type="password" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Confirme Su Contraseña</label>
                                        <input type="password" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="account-info">
                                <div class="card-body pb-2">
                                    
                                    <div class="form-group">
                                        <label class="form-label">Fecha de Nacimiento</label>
                                        <input type="text" class="form-control" value="May 3, 1995">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Lugar de Nacimiento</label>
                                        <input type="text" class="form-control" value="Melbourne, Australia">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">DNI</label>
                                        <input type="text" class="form-control" value="1004759221">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Dirección de Facturación</label>
                                        <input type="text" class="form-control" value="Calle 123 # 45-67, Barrio El Poblado, Medellín, Colombia.">
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Género</label>
                                        <select class="custom-select">
                                            <option selected> </option>
                                            <option>Hombre</option>
                                            <option>Mujer</option>
                                            <option>Prefiero no decirlo</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                      
                        </div>
                    </div>
                    
                </div>
                <div class="text-right mt-3 bt-3">
                    <button type="button" class="btn btn-primary">Guardar Cambios</button>&nbsp;
                    <button type-="button" class="btn btn-default">Cancelar</button>
                </div>
                <div style="margin-bottom: 20px;"></div> 
            </div>
            <footer class="footer">
                    <div class="box-container">
                        <div class="box"  >
                            <h3 href="/" class="logo"><i class="fas fa-paper-plane"></i>AirTravel</h3>
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
            
        </div>
    <!------------------------------------------------FOOTER------------------------------------------->
   
  
    
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
   .container light-style flex-grow-1 container-p-y{
      background: #3B5998;
    }
   @mixin grid($val){
        display:grid;
        grid-template-columns: repeat(auto-fit, minmax($val, 1fr));
        gap:1.5rem;
    }

  /* Estilo para pantallas pequeñas */
    @media (min-width: 500px) {
        .ui-w-80 {
            width: 30% !important; /* Toma el ancho completo en pantallas pequeñas */
        }
        .card {
            margin-right: -5rem; /* Márgenes más amplios en pantallas de laptop */
            width: 100%; 
        }
    }

    @media (min-width: 700px) {
        .ui-w-80 {
            width: 30% !important; /* Toma el ancho completo en pantallas pequeñas */
        }
        .card {
            margin-right: -1rem; /* Márgenes más amplios en pantallas de laptop */
            width: 80%; 
        }
      
  
    }

    /* Estilo para pantallas de laptop (por ejemplo, 15.6 pulgadas) */
    @media (min-width: 992px) {
        .ui-w-80 {
         width: 8rem !important;
        }
        .card {
           
            width: 100%; 
            margin-right: -5rem; 
        }
    }

    @media (min-width: 1024px) {
        .ui-w-80 {
        width: 8rem !important;
        }
        .card {
            width: 100%; /* Márgenes más amplios en pantallas de laptop */
            margin-left: -1rem;
           
        }
    }
    .ui-w-80 {
        width: 8rem !important;
    }
    

    .btn-default {
        border-color: rgba(24, 28, 33, 0.1);
        background: rgba(195, 173, 173, 0);
        color: #222426;
    }

    

    label.btn {
        margin-bottom: 10;
    }

    .btn-outline-primary {
        border-color: #26B4FF;
        background: transparent;
        color: #26B4FF;
    }



    .btn {
        cursor: pointer;
    }

    .text-light {
        color: #babbbc !important;
    }

    .btn-facebook {
        border-color: rgba(0, 0, 0, 0);
        background: #3B5998;
        color: #fff;
    }

    .btn-instagram {
        border-color: rgba(0, 0, 0, 0);
        background: #000;
        color: #fff;
    }

    .card{
        background-clip: padding-box;
        box-shadow: 0 1px 4px rgba(24, 28, 33, 0.012);
        
        background: $gris;//FONDO DE LA CARD
        margin-top: 10rem;
        width:90vw;
        margin-right: -10%; 
    }

    .row-bordered {
        overflow: hidden;
    }

    .account-settings-fileinput {
        position: absolute;
        visibility: hidden;
        width: 1rem;
        height: 1rem;
        opacity: 0;
    }

    .account-settings-links .list-group-item.active {
        font-weight: bold !important;
    }

    html:not(.dark-style) .account-settings-links .list-group-item.active {
        background: transparent !important;
    }

    .account-settings-multiselect~.select2-container {
        width: 100% !important;
    }

    .light-style .account-settings-links .list-group-item {
        padding     : 0.85rem 1.5rem;
        border-color: rgba(24, 28, 33, 0.03) !important;
    }

    .light-style .account-settings-links .list-group-item.active {
        color: #4e5155 !important;
    }

    .material-style .account-settings-links .list-group-item {
        padding     : 0.85rem 1.5rem;
        border-color: rgba(24, 28, 33, 0.03) !important;
    }

    .material-style .account-settings-links .list-group-item.active {
        color: #4e5155 !important;
    }

    .dark-style .account-settings-links .list-group-item {
        padding     : 0.85rem 1.5rem;
        border-color: rgba(255, 255, 255, 0.03) !important;
    }

    .dark-style .account-settings-links .list-group-item.active {
        color: #fff !important;
    }

    .light-style .account-settings-links .list-group-item.active {
        color: #4E5155 !important;
    }

    .light-style .account-settings-links .list-group-item {
        padding     : 0.85rem 1.5rem;
        border-color: rgba(24, 28, 33, 0.03) !important;
    }

 
    /* Aumenta el tamaño de las etiquetas en los formularios */
    .form-label {
        font-size: 1.8rem; /* Ajusta el tamaño según tus preferencias */
    }

    .form-group {
        font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
        input{
         font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
        }
        option{
            font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
        }
    }
    
    .custom-select{
        font-size: 1.5rem; /* Aumenta el tamaño de los campos de entrada según tus preferencias */
    }
    .text-right .btn {
        margin-right: 1rem; /* Ajusta este valor según tus preferencias */
        padding: 0.5rem 2rem; /* Ajusta el relleno según tus preferencias */
    }
   

  //BOTÓN DESLIANTE 
    .switch-button {
        display: inline-block;
       
    }
    .switch-button .switch-button__checkbox {
        display: none;
    }
    .switch-button .switch-button__label {//BOTÓN INACTIVO
        background-color: $azul;//Color de fondo del botón deslizante
        width: 5rem;
        height: 3rem;
        border-radius: 3rem;
        display: inline-block;
        position: relative;
        
        
    }
    .switch-button .switch-button__label:before {
        transition: .2s;
        display: block;
        position: absolute;
        width: 3rem;
        height: 3rem;
        background-color: $blanco;//Color del circulo deslizante
        content: '';
        border-radius: 50%;
        box-shadow: inset 0px 0px 0px 1px $negro;
        
    }
    .switch-button .switch-button__checkbox:checked + .switch-button__label {
        background-color: $verde;//Color de fondo del botón deslizante
    }
    .switch-button .switch-button__checkbox:checked + .switch-button__label:before {
        transform: translateX(2rem);//Movimiento del circulo blanco 
   
    }

    
    .footer{  
        .box-container{
            @include grid(25rem);
            background:$secondary;
            padding: 3rem 2rem;
            margin-top: 10rem;
            width:90vw;
            
            .box{
                padding: 1rem 0;
                background:$secondary;
                .logo{
                    color:$negro;
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

                .compartir{ //Seccion de redes sociales 
                    padding:1rem 0;

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
                            text-decoration-line: none;
                        }

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
    
</style>
