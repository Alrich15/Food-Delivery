import axios from "axios";

const BASE_URL = "http://localhost:8081/foodcart";

class CartService{
    async getCarts(){
        return await axios.get(BASE_URL+"/all");
    }

    async addCart(cart){
        return await axios.post(BASE_URL+"/add",cart);
    }

    async viewCart(cartId){
        return await axios.get(BASE_URL+"/view/"+cartId);
    }

    async updateCart(item,cartId){
        return await axios.put(BASE_URL+"/update/"+cartId)
    }

    async deleteCart(cartId){
        return await axios.delete(BASE_URL+"/delete/"+cartId)
    }


}
export default new CartService();