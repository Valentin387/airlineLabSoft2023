import axiosInstance from './axiosInstance.js';

              

const updatePassword = (email, password) => {
  const credentials = { email, password };
  return axiosInstance.post(`auth/updatePassword`, credentials);
};

export default { updatePassword };