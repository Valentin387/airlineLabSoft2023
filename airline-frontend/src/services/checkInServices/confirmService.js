import axiosInstance from '../axiosInstance.js';

/*  
            @RequestParam long seatID
*/

//confirma el check-in de un asiento, dado el id del asiento
const confirm = (params) => {
  return axiosInstance.get(`check-in/confirm-check-in`, { params });

};

export default { confirm };