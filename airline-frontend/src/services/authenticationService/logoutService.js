import axiosInstance from '../axiosInstance.js';

const logout = () => {
  return axiosInstance.post(`auth/logout`);
};

export default { logout };