import axiosInstance from '../axiosInstance.js';

/* @RequestParam  long userID,
@RequestParam  long scsID  // this is the item's ID in the shopping cart. ShopingCartSeats - >scs
*/

const dropItem = (params) => {
  return axiosInstance.get(`shopping-cart/drop`, { params });

};

export default { dropItem };