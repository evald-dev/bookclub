import axios from 'axios';

// 1. Lies die API-Basis-URL aus der .env-Datei.
//    Stelle sicher, dass sie VITE_API_BASE_URL heißt!
const API_URL = "http://localhost:8080";

// Falls die URL fehlt, gibt es eine klare Fehlermeldung in der Konsole
if (!API_URL) {
  console.error("Fehler: VITE_API_BASE_URL ist nicht in der .env-Datei gesetzt.");
  console.error("Stelle sicher, dass die Datei .env heißt und VITE_API_BASE_URL=... enthält.");
  console.error("Du musst den Vue-Server (npm run dev) neu starten, nachdem du die .env-Datei geändert hast.");
}

// 2. Erstelle die zentrale Axios-Instanz
const apiClient = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    'Content-Type': 'application/json'
  }
});

// 3. Der "Magie-Teil": Der Request-Interceptor
//    Diese Funktion wird VOR JEDER Anfrage ausgeführt, die 'apiClient' nutzt.
apiClient.interceptors.request.use(
  (config) => {
    // 4. Hole den Token aus dem localStorage
    const token = localStorage.getItem('token');
    
    // 5. Wenn der Token da ist, füge ihn zum 'Authorization'-Header hinzu
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    
    // 6. Gib die (ggf. modifizierte) Konfiguration an Axios zurück
    return config;
  },
  (error) => {
    // Falls ein Fehler beim Erstellen der Anfrage passiert
    return Promise.reject(error);
  }
);

// 7. Exportiere die fertige Instanz, damit deine Komponenten sie nutzen können
export default apiClient;