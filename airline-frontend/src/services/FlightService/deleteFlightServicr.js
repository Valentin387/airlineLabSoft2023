import axiosInstance from '../axiosInstance.js';

              
//cancela un vuelo
const deleteFlight = (id) => {
  //const credentials = { id };
  return axiosInstance.delete(`flight/delete/${id}`);
};

export default { deleteFlight };