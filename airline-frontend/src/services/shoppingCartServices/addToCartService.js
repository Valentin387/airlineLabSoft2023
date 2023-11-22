import axiosInstance from '../axiosInstance.js';
              

//agregar al carrito
const addToCart = (userID, flightID, seatQuantity, seatClass) => {
  const credentials = { userID, flightID, seatQuantity, seatClass };
  return axiosInstance.post(`shopping-cart/add-to-cart`, credentials);
};

export default { addToCart };