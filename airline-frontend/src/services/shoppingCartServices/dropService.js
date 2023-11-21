import axiosInstance from '../axiosInstance.js';

/* 
            @RequestParam  long userID,
            @RequestParam  long flightID
*/

const dropItem = (params) => {
  return axiosInstance.get(`shopping-cart/drop`, { params });

};

export default { dropItem };