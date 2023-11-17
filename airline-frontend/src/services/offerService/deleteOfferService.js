import axiosInstance from '../axiosInstance.js';
              

const deleteOffer = (id) => {
  return axiosInstance.delete(`offer/delete/${id}`);
};

export default { deleteOffer };