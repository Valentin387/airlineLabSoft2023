import axiosInstance from './axiosInstance.js';

//axios.defaults.headers.common["Authorization"] = null;
              

const login = (email, password) => {
  const credentials = { email, password };
  return axiosInstance.post(`auth/emailChecking/{userEmail}`, credentials);
};

export default { login };