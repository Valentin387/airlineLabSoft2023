import axiosInstance from '../axiosInstance.js';
              
//listar oferta
const getOffers= () => {
  return axiosInstance.get(`offer/list`);
};

export default { getOffers };