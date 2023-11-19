import axiosInstance from '../axiosInstance.js';
              
/*           
@RequestParam long flightID,
@RequestParam long userID 
 */

const cancelReservation = (params) => {

  return axiosInstance.post(`reservation/cancel`, { params });
};

export default { cancelReservation };