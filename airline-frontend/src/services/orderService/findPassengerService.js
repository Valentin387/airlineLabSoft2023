import axiosInstance from '../axiosInstance.js';
              

const findPassenger = (DNI) => {
  const credentials = { DNI };
  return axiosInstance.get(`order/findPassenger/${DNI}`, credentials);
};

export default { findPassenger };