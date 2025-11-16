<script setup>
import { ref } from 'vue'
// Importiere axios
import axios from 'axios'

// Die Basis-URL deines Spring Boot-Backends
const API_URL = 'https://bookclub-448521902618.europe-west1.run.app'

// --- Refs für die Formulare ---
const newUsername = ref('')
const newPassword = ref('')
const newEmail = ref('')
const memberIdToFind = ref('')

// --- Refs für die Ergebnisse ---
const foundMember = ref(null)
const error = ref(null)


// --- POST-Anfrage ---
// (wird vom Formular-Submit aufgerufen)
async function createMember() {
  error.value = null // Fehler zurücksetzen
  try {
    // Das ist dein JSON-Payload
    const memberToCreate = {
      username: newUsername.value,
      password: newPassword.value,
      email: newEmail.value
    }
    
    // Sende POST an /member. Axios schickt das Objekt automatisch als JSON.
    const response = await axios.post(`${API_URL}/auth/register`, memberToCreate)
    
    console.log('Member erfolgreich erstellt:', response.data)
    // Formular leeren
    newUsername.value = ''
    newPassword.value = ''
    newEmail.value = ''
    
  } catch (e) {
    console.error('Fehler beim Erstellen:', e)
    error.value = e.message
  }
}


// --- GET-Anfrage ---
// (wird vom "Suchen"-Button aufgerufen)

</script>

<template>
  <div class="flex bg-gradient-to-br  min-h-screen">
<form @submit.prevent="createMember" class="m-auto fieldset bg-base-200 border-base-300 rounded-box w-xs border p-4">
  <legend class="fieldset-legend">Register</legend>

  <label class="label">Username</label>
  <input v-model="newUsername" type="username" class="input" placeholder="Username" />
   <label class="label">E-mail</label>
  <input v-model="newEmail" type="email" class="input" placeholder="E-mail" />

  <label class="label">Password</label>
  <input v-model="newPassword"  type="password" class="input" placeholder="Password" />
  <button type="submit" class="btn btn-neutral mt-4">Login</button>
</form>
</div>
</template>