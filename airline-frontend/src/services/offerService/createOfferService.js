import axiosInstance from '../axiosInstance.js';
              
//crear oferta
const createOffer = (
                    origin,
                    destination,
                    discount,
                    validDateRange,
                    description
                    ) => {
  const credentials = { 
                    origin,
                    destination,
                    discount,
                    validDateRange,
                    description
                     };
  return axiosInstance.post(`offer/create`, credentials);
};

export default { createOffer };