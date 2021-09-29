import axios from "axios";
const BASE_URL = "http://localhost:8081/orderdetails";

class OrderService{
    async viewOrder(){
        return await axios.get(BASE_URL + "/all");

    }
    async addOrder(order){
        return await axios.post(BASE_URL + "/add",order)

    }
    async viewOrderById(orderId){
        return await axios.get(BASE_URL + "/byId/" + orderId);

    }
    async updateOrder( order){
        return await axios.put(BASE_URL,order);

    }
    async removeOrderById(orderId){
        return await axios.delete(BASE_URL + "/delete/byId/" + orderId);

    }

}
export default new OrderService();
