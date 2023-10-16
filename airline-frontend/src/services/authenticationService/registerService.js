import axiosInstance from '../axiosInstance.js';


const register = (firstName, lastName, email, password) => {
  const credentials = { firstName, lastName, email, password };
  return axiosInstance.post(`auth/register`, credentials);
};

export default { register };