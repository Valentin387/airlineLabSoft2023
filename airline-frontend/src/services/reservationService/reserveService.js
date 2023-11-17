import axiosInstance from '../axiosInstance.js';
              

const reserve = (userID, flightID, seatQuantity, seatClass) => {
  const credentials = { userID, flightID, seatQuantity, seatClass };
  return axiosInstance.post(`reservation/reserve`, credentials);
};

export default { reserve };