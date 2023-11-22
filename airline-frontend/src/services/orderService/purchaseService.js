import axiosInstance from '../axiosInstance.js';
              
//realiza una compra y transacción de todo el contenido del carrito de compras.
//el orderFlightInfoList es un array de todos los vuelos, y cada vuelo tiene un array de pasajeros,
//cada pasajero tiene un seatID que se asigna arbitrariamente en el front-end, recordando que los asientos
//ya son devueltos al frontend con el servicio de listService.js en shoppingCartServices
const purchase = (
  userID,
  cardID,
  userID,
  totalAmount,
  paymentDetails, 
  orderFlightInfoList
) => {
  const credentials = { 
    userID,
    cardID,
    userID,
    totalAmount,
    paymentDetails, 
    orderFlightInfoList
  };
  return axiosInstance.post(`order/purchase`, credentials);
};

export default { purchase };

/* 

{
    "userID":52,
    "cardID":20,
    "totalAmount":7501.5,
    "paymentDetails":"transferencia llevada a cabo por AirTravel LTDA",
    "orderFlightInfoList":
    [
        //for each flight
        { 
            "flightID":117,
            "passengerList":
            [ //for each passenger in that flight
                {
                    "DNI":"25-9207323",
                    "firstName":"Brayan",
                    "lastName":"Torres",
                    "birthday":"1950-08-20",
                    "gender":"Male",
                    "cellphoneNo":"1283077140",
                    "email":"brayanandrey.torres@utp.edu.co",
                    "contactName":"Fran",
                    "contactNo":"1362469105",
                    "seatID":1015
                },
                {
                    "DNI":"49-3703264",
                    "firstName":"Valentin",
                    "lastName":"Valencia",
                    "birthday":"1983-07-23",
                    "gender":"Male",
                    "cellphoneNo":"9831536698",
                    "email":"valentin.valencia@utp.edu.co",
                    "contactName":"Leonard",
                    "contactNo":"5813895868",
                    "seatID":948
                },
                {
                    "DNI":"03-7631448",
                    "firstName":"Toby",
                    "lastName":"Torres",
                    "birthday":"1978-05-11",
                    "gender":"Male",
                    "cellphoneNo":"2931770815",
                    "email":"brayanandrey.torres@utp.edu.co",
                    "contactName":"Lotti",
                    "contactNo":"1106654139",
                    "seatID":1009
                }

            ]

        }
       
    ]
    
}

*/