import axiosInstance from '../axiosInstance.js';
              

const rootChangeID = (email) => {
  const credentials = { email };
  return axiosInstance.post(`root/rootChangeID`, credentials);
};

export default { rootChangeID };