import axiosInstance from '../axiosInstance.js';

/*           
    @RequestParam String orderCOD,
    @RequestParam String passengerDNI 
            
*/

//lista todos los asientos comprados para un pasajero, es decir, todas 
//los check-in pendientes que tiene el pasajero a hacer

const consult = (params) => {
  return axiosInstance.get(`check-in/consult`, { params });

};

export default { consult };

//returns an array of objects with the following structure:
/*
   private long flightId;
    private long passengerId;
    private String email;
    private String firstName;
    private String lastName;
    private String DNI;
    private boolean didCheckIn;
    private String origin;
    private String destination;
    private Date flightDate;
    private String state;
    private long SeatId;
    private int SeatNumber;
    private char SeatLetter;


*/