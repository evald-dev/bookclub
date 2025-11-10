import { useRouter } from 'vue-router'

// 1. Erstelle eine Hauptfunktion, die wir exportieren
export function useNavigation() {
  
  // 2. Hole den Router *innerhalb* der Composable-Funktion
  const router = useRouter()

  // 3. Definiere deine Navigations-Funktionen
  const goToHome = () => {
    // Hier könntest du auch komplexe Logik einbauen
    console.log('Gehe zur Homepage...')
    router.push('/')
  }

  const goToLogin = () => {
    router.push('/login')
  }

 const goToOverview = () => {
    router.push('/overview')
  }

const goToProfile = () => {
    router.push('/profile')
  }

  const goToAddClub = () => {
    router.push('/addclub')
  }

  // 4. Gib die Funktionen zurück, die deine Komponenten brauchen
  return {
    goToHome,
    goToLogin,
    goToOverview,
    goToProfile,
    goToAddClub
  }
}