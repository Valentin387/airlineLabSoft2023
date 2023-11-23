
import {createRouter,createWebHistory} from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import Ad_Management from '../views/Ad_Management.vue'
import Perfil from '../views/Perfil.vue'
import CrearAdmin from '../views/CrearAdmin.vue'
import CambioIdRoot from '../views/CambioIdRoot.vue'
import EditarPerfil from '../views/EditarPerfil.vue'
import RecoverPassword from '../views/RecoverPassword.vue'
import ResetPassword from '../views/ResetPassword.vue'
import SearchResults from '../views/SearchResults.vue'; // Ajusta la ruta según sea necesario
import M_Financiero from '../views/M_Financiero.vue'
import ListVuelos_Ad from '../views/ListVuelos_Ad.vue'
import DetalleVuelo from '../views/DetalleVuelo.vue'
import Carrito from '../views/Carrito.vue'
import List_Reservas from '../views/List_Reservas.vue'
import CentroAyuda from '../views/CentroAyuda.vue'
import ListVuelosClient from '../views/ListVuelos_Client.vue'
import CrearVuelo from '../views/CrearVuelo.vue'
import DatosPasajeros from '../views/DatosPasajeros.vue'
const router = createRouter ({

    history: createWebHistory(),
    routes: [ 
        { path: '/', 
          component: Home 
          
        },
   
        {
            path: '/Login',
            component: Login
        },
        {
            path: '/SignUp',
            component: SignUp
        },
        {
            path: '/Ad_Management',
            component: Ad_Management,
            meta: { requiresAuth: true }
        },
        {
            path: '/Perfil',
            component: Perfil,
            meta: { requiresAuth: true }
        },

        {
            path: '/CrearAdmin',
            component: CrearAdmin,
            meta: { requiresAuth: true }
        },

        {
            path: '/CambioIdRoot',
            component: CambioIdRoot,
            meta: { requiresAuth: true }
        },

        {
            path: '/RecoverPassword',
            component:  RecoverPassword
        },

        {
            path: '/ResetPassword/:email',
            component: ResetPassword
        },

        {
            path: '/ResetPassword',
            component: ResetPassword
        },

        {
            path: '/EditarPerfil',
            component:  EditarPerfil,
            meta: { requiresAuth: true }
           
        },
        {
            path: '/search-results',
            name: 'SearchResults',
            component: SearchResults,
        },

        {
            path: '/M_Financiero',
            component: M_Financiero,
            meta: { requiresAuth: true }
        },

        {
            path: '/ListVuelos_Ad',
            component: ListVuelos_Ad,
            meta: { requiresAuth: true }
        },

        {
            path: '/DetalleVuelo',
            component: DetalleVuelo,
            meta: { requiresAuth: true }
        },

        {
            path: '/Carrito',
            component: Carrito,
            meta: { requiresAuth: true }
        },
        {
            path: '/List_Reservas',
            component: List_Reservas,
            meta: { requiresAuth: true }
        },
        {
            path: '/CentroAyuda',
            component: CentroAyuda
        },
        {
            path: '/ListVuelos_Client',
            name: 'ListVuelosClient',
            component: ListVuelosClient
       },
       {
            path: '/CrearVuelo',
            name: 'CrearVuelo',
            component: CrearVuelo
        },
        {
            path: '/DatosPasajeros',
            name: 'DatosPasajeros',
            component: DatosPasajeros
        },
    ]
    
})

//write the const router
/*

const router = createRouter({
    history: createWebHistory("/"),
    routes
})

*/



router.beforeEach((to, from, next) => {//Antes de cada transición:  hacia donde voy se requiere autenticación 
    if (to.meta.requiresAuth && window.sessionStorage.getItem('JWTtoken')==null) {  
        next({name: 'Login'})
    }else{
        next()
    }
});
export default router