import axiosInstance from '../axiosInstance.js';
              

const purchase = (ID, COD, userID, shoppingCartID, cardID, totalAmount, Date, paymentDetails, orderFlightInfoList) => {
  const credentials = { ID, COD, userID, shoppingCartID, cardID, totalAmount, Date, paymentDetails, orderFlightInfoList };
  return axiosInstance.post(`order/purchase`, credentials);
};

export default { purchase };