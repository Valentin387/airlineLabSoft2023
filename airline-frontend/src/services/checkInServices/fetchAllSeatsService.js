import axiosInstance from '../axiosInstance.js';

/*  
@RequestParam long flightID
*/

//retorna todos los asientos de un vuelo, dado el id del vuelo
const fetchAllSeats = (params) => {
  return axiosInstance.get(`check-in/fetch-seats`, { params });

};

export default { fetchAllSeats };