import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
import "flyonui/flyonui";
import router from "./rotuer/router.js";
import { createPinia } from "pinia";
import { useAuthStore } from "./stores/auth";

const app = createApp(App).use(router);
const pinia = createPinia();
app.use(pinia);

// ==== ZUSTAND WIEDERHERSTELLEN ====
// Dies passiert, BEVOR die App gemountet wird.
const authStore = useAuthStore(); // Hol dir die Store-Instanz
const storedUser = localStorage.getItem("user");
const storedToken = localStorage.getItem("token");

if (storedUser && storedToken) {
  // Wichtig: JSON.parse() nicht vergessen!
  authStore.setCredentials(JSON.parse(storedUser), storedToken);
}

app.mount("#app");
