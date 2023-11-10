import axiosInstance from '../axiosInstance.js';

const parametrizedSearch = (params) => {
  return axiosInstance.get(`parametrized-search`, { params })
    .then(response => response.data)
    .catch(error => {
      // Maneja el error de la API
      console.error('Error en la búsqueda:', error);
      throw new Error('No se pudieron cargar los vuelos. Por favor, inténtalo de nuevo más tarde.');
    });
};

export default { parametrizedSearch };
