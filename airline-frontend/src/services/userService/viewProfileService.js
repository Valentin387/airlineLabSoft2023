import axiosInstance from '../axiosInstance.js';
              

const viewProfile = (id) => {
  const credentials = { id };
  return axiosInstance.get(`user/profile/${id}`, credentials);
};

export default { viewProfile };