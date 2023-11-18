import axiosInstance from '../axiosInstance.js';
              

const listCards = (id) => {
  return axiosInstance.post(`financial-module/list/${id}`);
};

export default { listCards };