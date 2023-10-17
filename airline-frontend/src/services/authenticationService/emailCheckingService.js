import axiosInstance from '../axiosInstance.js';

              

const emailChecking = (userEmail) => {
  return axiosInstance.post(`auth/emailChecking/${userEmail}`);
};

export default { emailChecking };