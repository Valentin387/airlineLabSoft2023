import axiosInstance from '../axiosInstance.js';

const listShoppingCartItems = (params) => {
  return axiosInstance.get(`shopping-cart/list`, { params });

};

export default { listShoppingCartItems };
