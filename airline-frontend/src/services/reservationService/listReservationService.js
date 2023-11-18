import axiosInstance from '../axiosInstance.js';
              

const getReservations = (userID) => {
  const credentials = { userID };
  return axiosInstance.get(`reservation/list/${userID}`, credentials);
};

export default { getReservations };