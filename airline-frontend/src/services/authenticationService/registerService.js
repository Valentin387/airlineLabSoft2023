import axiosInstance from '../axiosInstance.js';


const register = (dni,
                  email,
                  password,
                  firstName,
                  lastName,
                  birthday,
                  birthPlace,
                  billingAddress,
                  gender,
                  username,
                  profileImage,
                  subscribedToFeed) => {
  const credentials = { 
                  dni,
                  email,
                  password,
                  firstName,
                  lastName,
                  birthday,
                  birthPlace,
                  billingAddress,
                  gender,
                  username,
                  profileImage,
                  subscribedToFeed };
  return axiosInstance.post(`auth/register`, credentials);
};

export default { register };