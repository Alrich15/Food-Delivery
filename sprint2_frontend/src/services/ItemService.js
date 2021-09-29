import axios from "axios";

const BASE_URL = "http://localhost:8081/item";
const CART_URL = "http://localhost:8081/foodcart";

class ItemService {
  async getItems() {
    return await axios.get(BASE_URL + "/all");
  }

  async getItemById(itemId){
    return await axios.get(BASE_URL + "/byId/" + itemId);
  }


  async createItem(item) {
    return await axios.post(BASE_URL +"/add", item);
  }

  async getItem(itemName) {
    return await axios.get(BASE_URL + "/byName/" + itemName);
  }

  async updateItem(item) {
    return await axios.put(BASE_URL + "/update", item);
  }

  async updateQty(qty,itemId){
    return await axios.patch(BASE_URL + "/updateqty/" + itemId + "/" + qty);
  }

  async deleteItem(itemId) {   
    return await axios.delete(BASE_URL + "/remove/byId/" + itemId);
  
  }
  async restItemsByItemCateg(restId, catId){
    return await axios.get(BASE_URL + "/categoryIdAndRestaurantId/" + restId +"/" + catId);
  }

  async deleteItemByName(itemName) {
    return await axios.delete(BASE_URL + "/remove/" + itemName);
  
  }

  async viewCartItemsByCostAsc(cartId){
    return await axios.get(CART_URL + "/" + cartId + "/Asc");
  }

  async searchCartItem(cartId,itemName){
      return await axios.get(CART_URL + "/search/" + itemName);
  }
  async searchcartItemByCateg(cartId,itemCategory){
      return await axios.get(CART_URL + "/search/byCategory/" + itemCategory);
  }

  async addItemToCart(cartId,item){
    return await axios.post(BASE_URL+"/cart/"+cartId,item);
}


}

export default new ItemService();
