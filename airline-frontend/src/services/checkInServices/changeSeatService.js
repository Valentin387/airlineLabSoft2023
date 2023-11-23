import axiosInstance from '../axiosInstance.js';

/*  
            @RequestParam long passengerID,
            @RequestParam long currentSeatID,
            @RequestParam long newSeatID
*/

//cambia el asiento de un pasajero, dado el id del pasajero, el id del asiento actual y el id del nuevo asiento
const changeSeat = (params) => {
  return axiosInstance.put(`check-in/change-seat`, { params });

};

export default { changeSeat };