import axiosInstance from './axiosInstance.js';

              

const recoverPassword = (email, password) => {
  const credentials = { email, password };
  return axiosInstance.post(`auth/recoverPassword`, credentials);
};

export default { recoverPassword };