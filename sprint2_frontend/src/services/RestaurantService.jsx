import axios from "axios";

const BASE_URL = "http://localhost:8081/restaurant";

class RestaurantService {
  async getRestaurants() {
    return await axios.get(BASE_URL + "/all");
  }

  async createRestaurant(restaurant) {
    return await axios.post(BASE_URL +"/add/" , restaurant);
  }

  async getRestaurantById(restaurantId) {
    return await axios.get(BASE_URL + "/" + restaurantId);
  }

  async updateRestaurant(restaurant) {
    return await axios.put(BASE_URL+"/update/", restaurant);
  }

  async deleteRestaurant(restaurantId) {
    return await axios.delete(BASE_URL+"/delete/byId/"+ restaurantId);
    
    //"http://localhost:8081/restaurant/delete/byId/100"
  }
}

export default new RestaurantService();