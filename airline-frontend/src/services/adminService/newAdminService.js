import axiosInstance from '../axiosInstance.js';              

const newAdmin = (firstName, email, password) => {
  const credentials = { firstName, email, password };
  return axiosInstance.post(`admin/newAdmin`, credentials);
};

export default { newAdmin };