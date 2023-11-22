import axiosInstance from '../axiosInstance.js';
              
//buscar por lugar
const searchByPlace = (place) => {
  return axiosInstance.get(`search/${ place }`);
};

export default { searchByPlace };