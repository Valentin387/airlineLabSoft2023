import axiosInstance from '../axiosInstance.js';
              
//ver perfil de un usuario
const viewProfile = (id) => {
  const credentials = { id };
  return axiosInstance.get(`user/profile/${id}`, credentials);
};

export default { viewProfile };