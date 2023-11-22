import axiosInstance from '../axiosInstance.js';

/* @RequestParam long userID */

//lista todas las ordenes de un usuario, dado el id del usuario

const listOrders = (params) => {
  return axiosInstance.get(`search/list`, { params });
};

export default { listOrders };