import axiosInstance from '../axiosInstance.js';
              
//actualizar perfil
const updateProfile = (id, email, dni, firstName, lastName, birthday, birthPlace, billingAddress, gender, role, username, profileImage, active, subscribedToFeed) => {
  const credentials = { id, email, dni, firstName, lastName, birthday, birthPlace, billingAddress, gender, role, username, profileImage, active, subscribedToFeed };
  return axiosInstance.put(`user/profileUpdate/${id}`, credentials);
};

export default { updateProfile };