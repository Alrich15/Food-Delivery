import axios from "axios";

const BASE_URL = "http://localhost:8081/item";

class FoodItemService{

    async getItemsByRestId(restId){
        return await axios.get(BASE_URL + "/restId/"+restId);
    }

    async getItemsByRestIdAndSortedByPriceAscending(restId){
        return await axios.get(BASE_URL+"/restId/"+restId+"/sortByPriceAscending");
    }

    async getItemsByRestIdAndSortedByPriceDescending(restId){
        return await axios.get(BASE_URL+"/restId/"+restId+"/sortByPriceDescending");
    }

}

export default new FoodItemService();