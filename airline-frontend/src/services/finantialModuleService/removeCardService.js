import axiosInstance from '../axiosInstance.js';

              

const removeCard = (cardId) => {
  //const credentials = { cardId };
  return axiosInstance.delete(`financial-module/remove/${cardId}`);
};

export default { removeCard };