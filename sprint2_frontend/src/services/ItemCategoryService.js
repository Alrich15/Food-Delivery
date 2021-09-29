import axios from "axios";

const BASE_URL = "http://localhost:8081/itemCategory/";

class ItemCategoryService{
    async getItemCategories(){
        return await axios.get(BASE_URL + "all");
    }

    async addItemCategory(itemCategory){
        return await axios.post(BASE_URL + "add", itemCategory);
    }

    async getItemCategoryById(itemCatId){
        return await axios.get(BASE_URL + "byId/"+itemCatId);
    }

    async updateItemCategory(itemCategory){
        return await axios.put(BASE_URL + "update/",itemCategory);
    }

    async removeItemCategory(itemCatId){
        return await axios.delete(BASE_URL+ "remove/byId/"+itemCatId);
    }

    async getItemCategoryById(itemCategoryId){
        return await axios.get(BASE_URL + "/byId/" + itemCategoryId);
    }

    async getItemCategories(){
        return await axios.get(BASE_URL + "/all/");
    }
}

export default new ItemCategoryService();