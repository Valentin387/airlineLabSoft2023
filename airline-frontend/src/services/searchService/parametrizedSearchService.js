import axiosInstance from '../axiosInstance.js';

/* @RequestParam  String origin,
@RequestParam  String destination,
@RequestParam  Date flightDate,
@RequestParam  int numPassengers */

//retorna todos los vuelos que cumplan con los parámetros de búsqueda
const parametrizedSearch = (params) => {
  return axiosInstance.get(`search/parametrized-search`, { params });
};

export default { parametrizedSearch };
