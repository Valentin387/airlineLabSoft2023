import axiosInstance from '../axiosInstance.js';

/*  @RequestParam long userID */

//lista todos los items del carrito de compras de un usuario, dado el id del usuario
const listShoppingCartItems = (params) => {
  return axiosInstance.get(`shopping-cart/list`, { params });

};

export default { listShoppingCartItems };

/*
Retorna el formato:

Un array de objetos tipo:

    private Long flightId;
    private String origin;
    private String destination;
    private Date flightDate;
    private String state;
    private Double costByPerson;
    private Double costByPersonOffer;
    private List<Seat> seats;

    
*/
