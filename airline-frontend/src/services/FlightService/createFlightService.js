import axiosInstance from '../axiosInstance.js';
              

const createFlight = (
                    flightDate,
                    origin,
                    destination,
                    flightDuration,
                    arrivalDate,
                    costByPerson,
                    ) => {
  const credentials = { 
                    flightDate,
                    origin,
                    destination,
                    flightDuration,
                    arrivalDate,
                    costByPerson,
                     };
  return axiosInstance.post(`flight/create`, credentials);
};

export default { createFlight };