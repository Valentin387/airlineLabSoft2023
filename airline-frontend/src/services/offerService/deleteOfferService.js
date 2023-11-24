import axiosInstance from '../axiosInstance.js';
              
//borrar oferta
const deleteOffer = (id) => {
  return axiosInstance.delete(`offer/delete/${id}`);
};

export default { deleteOffer };