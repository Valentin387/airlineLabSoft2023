import axiosInstance from '../axiosInstance.js';
              
//lista los vuelos con estado ON_TIME
const getActiveFlights = () => {
  return axiosInstance.get(`flight/list/active`);
};

export default { getActiveFlights };