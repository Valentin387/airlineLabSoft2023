import axiosInstance from '../axiosInstance.js';
              
/*           
@RequestParam long flightID,
@RequestParam long userID 
 */

//cancela una reserva
const cancelReservation = (params) => {

  return axiosInstance.post(`reservation/cancel`, { params });
};

export default { cancelReservation };