import axiosInstance from '../axiosInstance.js';

//cerrar sesión
const logout = () => {
  return axiosInstance.post(`auth/logout`);
};

export default { logout };