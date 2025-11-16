<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useAuthStore } from "../stores/auth";
const authStore = useAuthStore();

const API_URL = 'https://bookclub-6vy2.onrender.com'

console.log(authStore.token)

const members = ref([
  authStore.userId
]);

const config = {
  headers: {
    // Hier wird das Token im 'Bearer'-Schema hinzugefügt
    'Authorization': `Bearer ${authStore.token}`
  }
};

const newClubName = ref('')
const error = ref(null)

async function createClub() {
  error.value = null
  // Fehler zurücksetzen
  try {
    // Das ist dein JSON-Payload
    const clubToCreate = {
      name: newClubName.value,
    }
    
    // Sende POST an /member. Axios schickt das Objekt automatisch als JSON.
   const response = await axios.post(`${API_URL}/club`, clubToCreate,config)
    console.log('Club erfolgreich erstellt:', response.data.id)

    // Formular leeren
    newClubName.value = ''
    
  } catch (e) {
    console.error('Fehler beim Erstellen:', e)
    error.value = e.message
  }
}

</script>

<template>
  <div class="flex bg-gradient-to-br  min-h-screen">
<form @submit.prevent="createClub" class="m-auto fieldset bg-base-200 border-base-300 rounded-box w-xs border p-4">
  <legend class="fieldset-legend">Create Club</legend>

  <label class="label">Club Name</label>
  <input v-model="newClubName" type="text" class="input" placeholder="Clubname" />
  <button type="submit" class="btn btn-neutral mt-4">Create</button>
</form>
</div>
</template>