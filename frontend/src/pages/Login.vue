<script setup>
import { ref } from 'vue'
import {useAuthStore} from '../stores/auth.js';
import axios from 'axios'
import { useNavigation } from "../useNavigation.js";
const { goToHome, goToLogin, goToOverview, goToProfile, goToAddClub } = useNavigation();

const API_URL = 'https://bookclub-6vy2.onrender.com'

// --- Refs für die Formulare ---
const username = ref('')
const password = ref('')
const email = ref('')
const error = ref(null)

const authStore = useAuthStore();
// --- POST-Anfrage ---
// (wird vom Formular-Submit aufgerufen)
async function login() {
  error.value = null // Fehler zurücksetzen
  try {
    // Das ist dein JSON-Payload
    const memberLogin = {
      username: username.value,
      password: password.value
    }
    
    // Sende POST an /member. Axios schickt das Objekt automatisch als JSON.
    const response = await axios.post(`${API_URL}/auth/login`, memberLogin)
    const token = response.data.token;
    const userId = response.data.userId;
    console.log('Member erfolgreich eingeloggt:', response.data)
    authStore.setCredentials(userId, token);
    // Formular leeren
    username.value = ''
    password.value = ''
    email.value = ''
    
  } catch (e) {
    console.error('Fehler beim Erstellen:', e)
    error.value = e.message
  }
}
</script>
<template>
  <div class="flex bg-gradient-to-br  min-h-screen">
<form @submit.prevent="login" class="m-auto fieldset bg-base-200 border-base-300 rounded-box w-xs border p-4">
  <legend class="fieldset-legend">Login</legend>

  <label class="label">Username</label>
  <input v-model="username" type="username" class="input" placeholder="Username" />

  <label class="label">Password</label>
  <input v-model="password" type="password" class="input" placeholder="Password" />
  <p>Don't have an acoount? <a class="link"><RouterLink to="/register">Register</RouterLink></a></p>
  <button type="submit" class="btn btn-neutral mt-4">Login</button>
</form>
</div>
</template>