import axiosInstance from '../axiosInstance.js';


const register = (DNI,
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
  const credentials = { DNI,
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