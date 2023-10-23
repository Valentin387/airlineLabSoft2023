import axiosInstance from '../axiosInstance.js';
              

const updateProfile = (id, email, firstName, lastName, birthday, birthPlace, billingAddress, gender, role, username, profileImage, active,DNI, subscribedToFeed) => {
  const credentials = { id, email, firstName, lastName, birthday, birthPlace, billingAddress, gender, role, username, profileImage, active,DNI, subscribedToFeed };
  return axiosInstance.put(`user/profileUpdate/${id}`, credentials);
};

export default { updateProfile };