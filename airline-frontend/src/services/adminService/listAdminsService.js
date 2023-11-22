import axiosInstance from '../axiosInstance.js';

//axios.defaults.headers.common["Authorization"] = null;
              
//lista los administradores
const listAdmins = () => {
  return axiosInstance.get(`admin/listAdmins`);
};

export default { listAdmins };