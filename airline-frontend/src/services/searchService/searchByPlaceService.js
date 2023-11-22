import axiosInstance from '../axiosInstance.js';
              

const searchByPlace = (place) => {
  return axiosInstance.get(`search/${ place }`);
};

export default { searchByPlace };