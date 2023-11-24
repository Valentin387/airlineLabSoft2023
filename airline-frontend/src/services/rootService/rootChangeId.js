import axiosInstance from '../axiosInstance.js';
              
//cambiar el id de un usuario
const rootChangeID = (email) => {
  const credentials = { email };
  return axiosInstance.post(`root/rootChangeID`, credentials);
};

export default { rootChangeID };