import axiosInstance from '../axiosInstance.js';
              

const getActiveFlights = () => {
  return axiosInstance.get(`flight/list/active`);
};

export default { getActiveFlights };