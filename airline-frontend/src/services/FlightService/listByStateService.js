import axiosInstance from '../axiosInstance.js';
              
//lista los vuelos según el estado
const getFlightsByState = (state) => {
  return axiosInstance.get(`flight/list/${state}`);
};

export default { getFlightsByState };