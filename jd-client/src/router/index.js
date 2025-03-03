import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/home/HomeView.vue';
import DetailView from '../views/detail/DetailView.vue';
import SearchView from '../views/search/SearchView.vue';
import LoginView from '../views/login/LoginView.vue';
import NowShopingView from '../views/shoppoing_cart/NowShopingView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },{
    path:'/detail',
    name:'detail',
    component: DetailView
  },{
    path:'/search',
    name:'search',
    component:SearchView
  },{
    path:'/login',
    name:'login',
    component:LoginView
  },{
    path:'/shopping',
    name:'shopping',
    component:NowShopingView
  }
]

const router = createRouter({
  mode:'hash',
  history:createWebHashHistory(),
  routes
})

export default router
