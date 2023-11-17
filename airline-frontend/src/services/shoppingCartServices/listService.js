import axiosInstance from '../axiosInstance.js';

/* @RequestParam  long userID */

const listShoppingCartItems = (params) => {
  return axiosInstance.get(`shopping-cart/list`, { params });

};

export default { listShoppingCartItems };
