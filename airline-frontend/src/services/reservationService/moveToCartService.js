import axiosInstance from '../axiosInstance.js';
            
/* 
            @RequestParam  long flightID,
            @RequestParam  long userID
*/
//mover una reserva al carrito de compras
const moveToCart = (params) => {
  return axiosInstance.post(`reservation/move-to-cart`,  { params });
};

export default { moveToCart };