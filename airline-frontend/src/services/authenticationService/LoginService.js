import axiosInstance from '../axiosInstance.js';

//axios.defaults.headers.common["Authorization"] = null;
              
//autenticación
const login = (email, password) => {
  const credentials = { email, password };
  return axiosInstance.post(`auth/authenticate`, credentials);
};

export default { login };