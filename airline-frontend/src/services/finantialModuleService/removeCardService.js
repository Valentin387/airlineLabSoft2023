import axiosInstance from '../axiosInstance.js';

              
//borra una tarjeta
const removeCard = (cardId) => {
  //const credentials = { cardId };
  return axiosInstance.delete(`financial-module/remove/${cardId}`);
};

export default { removeCard };