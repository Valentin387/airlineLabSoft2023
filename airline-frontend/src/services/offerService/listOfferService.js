import axiosInstance from '../axiosInstance.js';
              

const getOffers= () => {
  return axiosInstance.get(`offer/list`);
};

export default { getOffers };