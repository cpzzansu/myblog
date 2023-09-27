import {createApp} from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

import 'bootstrap/dist/css/bootstrap.min.css';

const rootElement = document.querySelector('#app');
if (rootElement) {
  rootElement.classList.add('container');
}

const app = createApp(App);
app.use(router);
app.use(store);
app.mount('#app');
