import axiosInstance from '../axiosInstance.js';
              

const parametrizedSearch = (params) => {
  return axiosInstance.get(`parametrized-search`, { params });
};

export default { parametrizedSearch };