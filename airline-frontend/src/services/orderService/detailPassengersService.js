import axiosInstance from '../axiosInstance.js';

/*
@RequestParam String orderCOD
*/

//retorna todos los vuelos asociados a esa orden, con sus respectivos pasajeros y asientos

const getOrderPassengersDetail = (params) => {
  return axiosInstance.get(`order/detail-passengers`, { params });
};

export default { getOrderPassengersDetail };

/*
Un array de objetos de la siguiente forma:
    private Long flightId;
    private String origin;
    private String destination;
    private Date flightDate;
    private String state;
    private Double costByPerson;
    private Double costByPersonOffer;
    private List<Passenger> passengers;

*/