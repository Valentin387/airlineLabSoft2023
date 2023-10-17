import axiosInstance from '../axiosInstance.js';

//axios.defaults.headers.common["Authorization"] = null;
              

const listAdmins = () => {
  return axiosInstance.get(`admin/listAdmins`);
};

export default { listAdmins };