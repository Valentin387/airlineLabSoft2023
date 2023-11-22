import axiosInstance from '../axiosInstance.js';
              
//reemplazar el saldo de una tarjeta
const editBalance = (cardId, balance) => {
  const credentials = { cardId, balance };
  return axiosInstance.put(`financial-module/edit-balance/${cardId}`, credentials);
};

export default { editBalance };