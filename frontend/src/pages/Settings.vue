<script setup>
import { ref, watchEffect } from "vue";

// --- Deine Logik bleibt exakt gleich ---
const currentTheme = ref("retro");

function setTheme(themeName) {
  currentTheme.value = themeName;
}

watchEffect(() => {
  // document.documentElement ist das <html>-Tag
  document.documentElement.setAttribute("data-theme", currentTheme.value);
});
// --- Ende deiner Logik ---


// Hilfs-Array, um die Themes im Template per v-for darzustellen
// (Ich habe deine Liste genommen und Duplikate entfernt)
const themes = [
  'light', 'dark', 'cupcake', 'emerald', 'corporate', 
  'synthwave', 'retro', 'cyberpunk', 'valentine', 'halloween', 'garden', 
  'forest', 'aqua', 'lofi', 'pastel', 'fantasy', 'wireframe', 'black', 
  'luxury', 'dracula', 'cmyk', 'autumn', 'business', 'acid', 'lemonade', 
  'night', 'coffee', 'winter', 'dim', 'nord', 'sunset'
];
</script>

<template>
  <div class="grid grid-cols-2 md:grid-cols-4 lg:grid-cols-6 gap-4 p-4">

    <div
      v-for="theme in themes"
      :key="theme"
      :data-theme="theme"
      @click="setTheme(theme)"
      class="card w-full bg-base-100 shadow-lg cursor-pointer transition-all duration-300 hover:scale-105 border-2"
      :class="currentTheme === theme ? 'border-primary' : 'border-base-300'"
    >
      <div class="card-body p-4">
        
        <h2 class="card-title capitalize text-base-content text-sm font-semibold">
          {{ theme }}
        </h2>
        
        <div class="flex gap-1 mt-2">
          <div class="flex-grow h-5 rounded bg-primary"></div>
          <div class="flex-grow h-5 rounded bg-secondary"></div>
          <div class="flex-grow h-5 rounded bg-accent"></div>
          <div class="flex-grow h-5 rounded bg-neutral"></div>
        </div>
      </div>
    </div>

  </div>
</template>

<style scoped>
/* Kleine Anpassung, damit der Text auf sehr dunklen/hellen Themes lesbar bleibt */
.card-title {
  color: hsl(var(--bc) / 0.8);
}
</style>