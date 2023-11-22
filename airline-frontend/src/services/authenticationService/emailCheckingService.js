import axiosInstance from '../axiosInstance.js';

              
//para recuperar contraseña
const emailChecking = (userEmail) => {
  return axiosInstance.post(`auth/emailChecking/${userEmail}`);
};

export default { emailChecking };