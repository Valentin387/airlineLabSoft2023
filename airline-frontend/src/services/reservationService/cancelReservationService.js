import axiosInstance from '../axiosInstance.js';
              

const cancelReservation = (reservationID) => {
  //const credentials = { reservationID };
  return axiosInstance.post(`reservation/cancel?reservationID=${reservationID}`);
};

export default { cancelReservation };