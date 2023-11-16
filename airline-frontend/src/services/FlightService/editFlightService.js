import axiosInstance from '../axiosInstance.js';
              

const editFlight = (id, image, costByPerson, costByPersonOffer, availableSeats, seats) => {
  const credentials = { id, image, costByPerson, costByPersonOffer, availableSeats, seats };
  return axiosInstance.put(`flight/edit/${id}`, credentials);
};

export default { editFlight };