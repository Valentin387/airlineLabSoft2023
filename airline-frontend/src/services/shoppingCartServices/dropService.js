import axiosInstance from '../axiosInstance.js';

/* 
            @RequestParam  long userID,
            @RequestParam  long flightID
*/

// elimina un vuelo del carrito de compras
const dropItem = (params) => {
  return axiosInstance.get(`shopping-cart/drop`, { params });

};

export default { dropItem };