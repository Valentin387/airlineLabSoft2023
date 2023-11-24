import axiosInstance from '../axiosInstance.js';
              
//retorna el detalle de un vuelo
const getDetailFlight = (id) => {
  return axiosInstance.get(`flight/detail/${id}`);
};

export default { getDetailFlight };