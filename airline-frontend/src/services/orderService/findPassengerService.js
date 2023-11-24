import axiosInstance from '../axiosInstance.js';
//SABER SI UN PASAJERO YA EXISTE, DEVUELVE LOS DATOS DEL PASAJERO
/*@RequestParam String DNI*/

//buscar si un pasajero ya existe como usuario registrado, regresa los datos del pasajero
const findPassenger = (params) => {
  return axiosInstance.get(`order/findPassenger`,{ params });
};

export default { findPassenger };

