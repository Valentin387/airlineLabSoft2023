
import {createRouter,createWebHistory} from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SingUp from '../views/SignUp.vue'
import Perfil from '../views/Perfil.vue'
import CrearAdmin from '../views/CrearAdmin.vue'
import CambioIdRoot from '../views/CambioIdRoot.vue'
import EliminarAdmin from '../views/EliminarAdmin.vue'
const router = createRouter ({

    history: createWebHistory(),
    routes: [ 
        { path: '/', 
          component: Home 
          
        },
        {
            path: '/Ayuda',
            component: () => import('../views/Ayuda.vue')   
        },
        {
            path: '/Login',
            component: Login
        },
        {
            path: '/SignUp',
            component: SingUp
        },

        {
            path: '/Perfil',
            component: Perfil
        },

        {
            path: '/CrearAdmin',
            component: CrearAdmin
        },

        {
            path: '/CambioIdRoot',
            component: CambioIdRoot
        },

        {
            path: '/EliminarAdmin',
            component:  EliminarAdmin
        }

    ]
    
})

//write the const router
/*

const router = createRouter({
    history: createWebHistory("/"),
    routes
})

*/



router.beforeEach((to,from, next) => {//Antes de cada transición:  hacia donde voy se requiere autenticación 
    if (to.meta.requiresAuth && window.sessionStorage.getItem('JWTtoken')==null) {  
        next({name: 'Login'})
    }else{
        next()
    }
});
export default router