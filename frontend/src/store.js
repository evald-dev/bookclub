import { ref } from 'vue'

// 1. Erstelle dein 'ref' hier, genau wie in einer Komponente
export const globalAppName = ref('Knigoeb')

// Du kannst auch globale Funktionen exportieren
export function setGlobalText(neuerText) {
  globalerText.value = neuerText
}