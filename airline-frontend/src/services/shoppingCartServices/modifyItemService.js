import axiosInstance from '../axiosInstance.js';
              

//modificar un item del carrito, este sirve para agregar o quitar asientos de un vuelo
//lo que pasa por debajo es magia, no preguntes, sólo gozalo
const modifyItemInCart = (userID, flightID, seatQuantity, seatClass) => {
  const credentials = { userID, flightID, seatQuantity, seatClass };
  return axiosInstance.post(`shopping-cart/modify-cart-item`, credentials);
};

export default { modifyItemInCart };