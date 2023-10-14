import axiosInstance from '../axiosInstance.js';

//axios.defaults.headers.common["Authorization"] = null;
              

const register = (firstName, lastName, email, password) => {
  const credentials = { firstName, lastName, email, password };
  return axiosInstance.post(`auth/register`, credentials);
};

export default { register };