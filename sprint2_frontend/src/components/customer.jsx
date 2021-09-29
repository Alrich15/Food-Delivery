import React, { Component } from "react";
import { Link } from "react-router-dom";
//import AddressTable from "./addressTable";
//import AddressService from "../Services/AddressService";
import CustomerService from "../services/CustomerService";
import CustomerTable from "./customerTable";

class Customer extends Component {
    state = {
        customer : [],
        search : "",
    };
    componentDidMount() {
        CustomerService.getAllCustomers().then((res) =>
        this.setState({ customer : res.data })
        );
    }

    handleDelete = (id) => {
        //axios.delete("http://localhost3000/address/id").then();
        CustomerService.deleteCustById(id).then((res) => {
            const customer = this.state.customer.filter((cust) => cust.customerId != id);
            this.setState({ customer });
        });
    };
    
    handleSearch = (event) => {
        //const emps = [...this.state.employees];
        console.log("handleSearch");
        this.setState({ search: event.target.value });
    
        const filteredCust = this.state.customer.filter(
          (cust) =>
          cust.firstName.toLowerCase().startsWith(event.target.value.toLowerCase())
            //emp.firstName.toLowerCase().startsWith(event.target.value.toLowerCase())
          //emp.firstName.toLowerCase().includes(event.target.value.toLowerCase())
        );
        this.setState({ customer: filteredCust });
    };

    render() {
        return(
            <div className="mt-3 w-75 mx-auto">
                <div className="d-flex justify-content-end">
                <div>
                    <form className="mb-2">
                    <input
                        type="search"
                        className="form-control"
                        placeholder="Search by first name"
                        value={this.state.search}
                        onChange={this.handleSearch}
                    />
                    </form>
                </div>
                <div><Link to="/customer/add">
                  <input
                    type="button"
                    className="btn btn-success mb-3 ms-3"
                    value="Add"
                  />
                </Link></div>
                </div>
                <CustomerTable
                customer={this.state.customer}
                handleDelete={this.handleDelete}>
                </CustomerTable>
            </div>

       );
    }
    
}
export default Customer;