import axiosInstance from '../axiosInstance.js';

/*  @RequestParam long userID */

//checkout del carrito de compras, da un review del estado del carrito 
/*
    private long ID;
    private int quantity;
    private double totalAmount;

*/
const checkoutShoppingCart = (params) => {
  return axiosInstance.get(`shopping-cart/checkout`, { params });

};

export default { checkoutShoppingCart };
