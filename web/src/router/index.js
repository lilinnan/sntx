import Vue from 'vue'
import VueRouter from 'vue-router'
import Search from "../views/Search";
import About from "../views/About";
import Update from "../views/Update";

Vue.use(VueRouter)

const routes = [
    {
        path: '',
        redirect: 'mainland'
    },
    {
        path: '/mainland',
        name: 'mainland',
        component: Search
    }, {
        path: '/taiwan',
        name: 'taiwan',
        component: Search
    }, {
        path: '/japan',
        name: 'japan',
        component: Search
    },
    {
        path: '/about',
        name: 'about',
        component: About
    },
    {
        path: '/update',
        name: 'update',
        component: Update
    }
]

const router = new VueRouter({
    routes
})

export default router
