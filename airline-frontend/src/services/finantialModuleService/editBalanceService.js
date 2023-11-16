import axiosInstance from '../axiosInstance.js';
              

const editBalance = (cardId, balance) => {
  const credentials = { cardId, balance };
  return axiosInstance.put(`financial-module/edit-balance/${cardId}`, credentials);
};

export default { editBalance };