import axiosInstance from '../axiosInstance.js';

/*
@RequestParam String orderCOD
*/

//retorna la información sobre la orden

const getOrderPassengersDetail = (params) => {
  return axiosInstance.get(`order/detail`, { params });
};

export default { getOrderPassengersDetail };

/*

    private long ID;

    @Column(length = 100)
    private String COD;

    private long userID;
    private long shoppingCartID;
    private long cardID;
    private double totalAmount;
    private Date date;

    @Column(length = 100)
    private String paymentDetails;

*/