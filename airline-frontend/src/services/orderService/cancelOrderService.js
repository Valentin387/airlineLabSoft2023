import axiosInstance from '../axiosInstance.js';

/*
@RequestParam String orderCOD
*/

//cancela una orden y devuelve el dinero al usuario al usuario, resetea todos los asientos asociados a la orden

const cancelOrder = (params) => {
  return axiosInstance.delete(`order/cancel`, { params });
};

export default { cancelOrder };
