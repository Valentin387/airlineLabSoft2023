import axiosInstance from '../axiosInstance.js';
            
/* @RequestParam  long reservationID,
@RequestParam  long userID */

const moveToCart = (params) => {
  return axiosInstance.post(`reservation/move-to-cart`,  { params });
};

export default { moveToCart };