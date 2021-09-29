import axios from "axios";

const BASE_URL = "http://localhost:8081/restCategory";

class RestaurantCategoryService {
  async getRestaurantCategory() {
    return await axios.get(BASE_URL + "/all");
  }

  async createRestaurantCategory(restaurantCategory) {
    return await axios.post(BASE_URL, restaurantCategory);
  }

  async getRestaurantCategoryById(restaurantCategoryId) {
    return await axios.get(BASE_URL + "/byId/" + restaurantCategoryId);
  }

  async updateRestaurantCategory(restaurantCategory) {
    return await axios.put(BASE_URL, restaurantCategory);
  }

  async deleteRestaurantCategory(restaurantCategoryId) {
    return await axios.delete(BASE_URL+"/"+ restaurantCategoryId);
    
    //"http://localhost:8081/restaurant/delete/byId/100"
  }
}

export default new RestaurantCategoryService();