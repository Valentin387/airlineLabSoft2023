import axiosInstance from '../axiosInstance.js';
              

const createFlight = (
                    flightDate,
                    origin,
                    destination,
                    flightDuration,
                    arrivalDate,
                    costByPerson,
                    international
                    ) => {
  const credentials = { 
                    flightDate,
                    origin,
                    destination,
                    flightDuration,
                    arrivalDate,
                    costByPerson,
                    international
                     };
  return axiosInstance.post(`flight/create`, credentials);
};

export default { createFlight };