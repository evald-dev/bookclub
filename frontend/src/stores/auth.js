import { defineStore } from 'pinia';
import { ref, computed } from 'vue';

export const useAuthStore = defineStore('auth', () => {
  // Der "State" (unverändert)
  const user = ref(null); // Hält das User-Objekt { id: 123, username: '...", ... }
  const token = ref(null); // Hält das JWT

  // "Actions" (unverändert)
  function setCredentials(userData, jwtToken) {
    user.value = userData;
    token.value = jwtToken;

    // !! WICHTIG: Im localStorage speichern !!
    localStorage.setItem('user', JSON.stringify(userData));
    localStorage.setItem('token', jwtToken);
  }

  function logout() {
    user.value = null;
    token.value = null;
    
    // !! WICHTIG: Aus dem localStorage entfernen !!
    localStorage.removeItem('user');
    localStorage.removeItem('token');
  }
  
  // "Getters" (Berechnete Werte) - HIER SIND DIE ÄNDERUNGEN
  
  /**
   * (1) KORRIGIERT:
   * Dein alter 'userId'-Getter, jetzt korrekt benannt.
   * Gibt das GANZE User-Objekt zurück (oder null).
   */
  const currentUser = computed(() => user.value);

  /**
   * (2) NEU: Getter für die User-ID (deine "Objet id")
   * Das `?.` (Optional Chaining) verhindert Fehler, falls 'user.value' null ist.
   */
  const userId = computed(() => user.value?.id || null);
  
  // WICHTIG: Falls deine ID von MongoDB kommt und `_id` heißt:
  // const userId = computed(() => user.value?._id || null);

/**
   * (3) NEU: Getter für den Username
   */
  const username = computed(() => user.value?.username || null);


  const isLoggedIn = computed(() => !!user.value && !!token.value);

  return { 
    // State
    user, 
    token, 
    
    // Actions
    setCredentials, 
    logout, 
    
    // Getters
    isLoggedIn,
    currentUser, // Das ganze Objekt: { id: "...", username: "..." }
    userId,      // Nur die ID: "..."
    username     // Nur der Username: "..."
  };
});