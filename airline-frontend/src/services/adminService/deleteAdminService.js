import axiosInstance from '../axiosInstance.js';

//borra un administrador           

const deleteAdmin = (id) => {
  //const credentials = { id };
  return axiosInstance.delete(`admin/deleteAdmin?id=${id}`);
};

export default { deleteAdmin };