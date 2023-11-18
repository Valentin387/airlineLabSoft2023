import axiosInstance from '../axiosInstance.js';

              

const deleteFlight = (id) => {
  //const credentials = { id };
  return axiosInstance.delete(`flight/delete/${id}`);
};

export default { deleteFlight };