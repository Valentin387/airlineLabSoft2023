import axiosInstance from '../axiosInstance.js';
              

const searchByPlace = () => {
  return axiosInstance.get(`search/${place}`);
};

export default { searchByPlace };