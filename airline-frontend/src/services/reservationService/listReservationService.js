import axiosInstance from '../axiosInstance.js';
              
//lista todas las reservas de un usuario, dado el id del usuario
const getReservations = (userID) => {
  const credentials = { userID };
  return axiosInstance.get(`reservation/list/${userID}`, credentials);
};

export default { getReservations };