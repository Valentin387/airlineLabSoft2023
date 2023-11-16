import axiosInstance from '../axiosInstance.js';
              

const addCard = (id, balance, type, number, name, expirationDate, cvc) => {
  const credentials = { id, balance, type, number, name, expirationDate, cvc };
  return axiosInstance.post(`financial-module/add/${id}`, credentials);
};

export default { addCard };