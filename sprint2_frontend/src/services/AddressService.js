import axios from "axios";

const BASE_URL = "http://localhost:8080/address";

class AddressService {
    async getAllAddress() {
      return await axios.get(BASE_URL + "/all");
    }
  
    async addAddress(address) {
      return await axios.post(BASE_URL, address);
    }
  
    async getAddrById(addressId) {
      return await axios.get(BASE_URL + "/" + addressId);
    }

    async getAddrByArea(area) {
        return await axios.get(BASE_URL + "/byArea/" + area);
      }
  
    async updateAddress(address) {
      return await axios.patch(BASE_URL, address);
    }
  
    async deleteAddrById(addressId) {
      return await axios.delete(BASE_URL + "/delete/Id/" + addressId);
    }
  }
  
  export default new AddressService();