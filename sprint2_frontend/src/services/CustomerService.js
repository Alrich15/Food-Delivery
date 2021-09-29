import axios from "axios";

const BASE_URL = "http://localhost:8081/customer";

class CustomerService {
    async getAllCustomers() {
        return await axios.get(BASE_URL + "/all");
      }
    
      async addCustomer(customer) {
        return await axios.post(BASE_URL, customer);
      }
    
      async viewCustomerById(customerId) {
        return await axios.get(BASE_URL + "/" + customerId);
      }
  
      async viewCustomerByFirstName(firstname) {
          return await axios.get(BASE_URL + "/byName/" + firstname);
        }
    
      async updateCustomer(customer) {
        return await axios.put(BASE_URL + "/update" , customer);
      }
    
      async deleteCustById(customerId) {
        return await axios.delete(BASE_URL + "/delete/" + customerId);
      }
}
export default new CustomerService();