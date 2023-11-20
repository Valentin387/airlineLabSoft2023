import axiosInstance from '../axiosInstance.js';

/*  @RequestParam long userID */

const checkoutShoppingCart = (params) => {
  return axiosInstance.get(`shopping-cart/checkout`, { params });

};

export default { checkoutShoppingCart };
