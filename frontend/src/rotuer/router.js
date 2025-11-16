import { createMemoryHistory, createRouter } from 'vue-router'

import Home from '../pages/Home.vue'
import Login from '../pages/Login.vue'
import Register from '../pages/Register.vue'
import Overview from '../pages/Overview.vue'
import Profile from '../pages/Profile.vue'
import AddClub from '../pages/AddClub.vue'
import Settings from '../pages/Settings.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/login', component: Login},
  { path: '/register', component: Register },
  { path: '/overview', component: Overview },
   { path: '/profile', component: Profile },
   { path: '/addclub', component: AddClub },
   { path: '/settings', component: Settings }
]

const router = createRouter({
  history: createMemoryHistory(import.meta.env.BASE_URL),
  routes,
})

router.afterEach(async (to, from, failure) => {
  if (!failure) setTimeout(() => window.HSStaticMethods.autoInit(), 100);
});

function goToLogin() {
  // Ersetze '/' durch den Pfad zu deiner Homepage, 
  // z.B. '/home' oder was auch immer in deinem router/index.js steht
  router.push('/login') 
}

export default router