import axiosInstance from '../axiosInstance.js';

const dropItem = (params) => {
  return axiosInstance.get(`shopping-cart/drop`, { params });

};

export default { dropItem };