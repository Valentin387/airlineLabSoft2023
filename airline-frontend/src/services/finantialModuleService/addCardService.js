import axiosInstance from '../axiosInstance.js';
              

const addCard = (userID, balance, type, number, name, expirationDate, cvc) => {
  const credentials = { userID, balance, type, number, name, expirationDate, cvc };
  return axiosInstance.post(`financial-module/add/${id}`, credentials);
};

export default { addCard };