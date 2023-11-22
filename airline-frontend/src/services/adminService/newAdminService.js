import axiosInstance from '../axiosInstance.js';              

//crea un nuevo administrador
const newAdmin = (firstName, email, password) => {
  const credentials = { firstName, email, password };
  return axiosInstance.post(`admin/newAdmin`, credentials);
};

export default { newAdmin };