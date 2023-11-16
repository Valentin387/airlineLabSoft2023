import axiosInstance from '../axiosInstance.js';
              

const moveToCart = (reservationID, userID) => {
  //const credentials = { reservationID, userID };
  return axiosInstance.post(`reservation/move-to-cart?reservationID=${reservationID}&userID=${userID}`);
};

export default { moveToCart };