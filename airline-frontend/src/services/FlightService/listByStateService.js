import axiosInstance from '../axiosInstance.js';
              

const getFlightsByState = (state) => {
  return axiosInstance.get(`flight/list/${state}`);
};

export default { getFlightsByState };