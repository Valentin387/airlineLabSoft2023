import axiosInstance from '../axiosInstance.js';
              

const deleteUser = (id) => {
  return axiosInstance.delete(`user/profileDelete/${id}`);
};

export default { deleteUser };