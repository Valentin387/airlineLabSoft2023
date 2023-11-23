import axiosInstance from '../axiosInstance.js';

/*           
    @RequestParam String orderCOD,
    @RequestParam String passengerDNI 
            
*/

//lista todos los asientos comprados para un pasajero, es decir, todas 
//los check-in pendientes que tiene el pasajero a hacer

const consult = (params) => {
  return axiosInstance.get(`check-in/consult`, { params });

};

export default { consult };