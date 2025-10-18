import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'localhost:8080',
  headers: {
    'Content-Type': 'application/json',
  },
  timeout: 10000
});

// Interceptor für Auth-Token
apiClient.interceptors.request.use(config => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default apiClient;

// Verwendung in Komponenten
import apiClient from '@/api/axios';

apiClient.get('/books').then(response => {
  console.log(response.data);
});