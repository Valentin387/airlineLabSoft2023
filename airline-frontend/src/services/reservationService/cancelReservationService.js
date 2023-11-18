import axiosInstance from '../axiosInstance.js';
              
/* @RequestParam  long reservationID */

const cancelReservation = (params) => {

  return axiosInstance.post(`reservation/cancel`, { params });
};

export default { cancelReservation };