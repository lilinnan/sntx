import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';

import Axios from "axios";

Vue.config.productionTip = false
Vue.prototype.$http = Axios
Axios.defaults.baseURL = './'

new Vue({
    router,
    vuetify,
    render: h => h(App)
}).$mount('#app')
