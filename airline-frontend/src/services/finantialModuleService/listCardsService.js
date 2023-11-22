import axiosInstance from '../axiosInstance.js';
              
//lista todas las tarjetas de un usuario, dado el id del usuario
const listCards = (id) => {
  return axiosInstance.post(`financial-module/list/${id}`);
};

export default { listCards };