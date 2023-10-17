import axiosInstance from '../axiosInstance.js';

              

const deleteAdmin = (id) => {
  const credentials = { id };
  return axiosInstance.delete(`admin/deleteAdmin`, credentials);
};

export default { deleteAdmin };