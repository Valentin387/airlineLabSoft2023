import axiosInstance from '../axiosInstance.js';
              

const getDetailFlight = (id) => {
  return axiosInstance.get(`flight/detail/${id}`);
};

export default { getDetailFlight };