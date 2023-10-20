
import {createRouter,createWebHistory} from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import Ad_Management from '../views/Ad_Management.vue'
import Perfil from '../views/Perfil.vue'
import CrearAdmin from '../views/CrearAdmin.vue'
import CambioIdRoot from '../views/CambioIdRoot.vue'
import EliminarAdmin from '../views/EliminarAdmin.vue'
import RecoverPassword from '../views/RecoverPassword.vue'
import ResetPassword from '../views/ResetPassword.vue'

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
            path: '/EliminarAdmin',
            component:  EliminarAdmin,
            meta: { requiresAuth: true }
        },

        {
            path: '/RecoverPassword',
            component:  RecoverPassword
        },

        {
            path: '/ResetPassword/:email',
            component: ResetPassword
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



router.beforeEach((to, from, next) => {//Antes de cada transición:  hacia donde voy se requiere autenticación 
    if (to.meta.requiresAuth && window.sessionStorage.getItem('JWTtoken')==null) {  
        next({name: 'Login'})
    }else{
        next()
    }
});
export default router