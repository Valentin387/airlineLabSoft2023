import axiosInstance from '../axiosInstance.js';
              

const modifyItemInCart = (userID, flightID, seatQuantity, seatClass) => {
  const credentials = { userID, flightID, seatQuantity, seatClass };
  return axiosInstance.post(`shopping-cart/modify-cart-item`, credentials);
};

export default { modifyItemInCart };