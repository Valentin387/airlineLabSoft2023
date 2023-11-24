import axiosInstance from '../axiosInstance.js';
              
//borrar un usuario
const deleteUser = (id) => {
  return axiosInstance.delete(`user/profileDelete/${id}`);
};

export default { deleteUser };