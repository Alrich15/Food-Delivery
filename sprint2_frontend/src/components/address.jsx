import React, { Component } from "react";
import { Link } from "react-router-dom";
import AddressTable from "./addressTable";
import AddressService from "../services/AddressService";

class Address extends Component {
    state = {
        address : [],
        search : "",
    };
    componentDidMount() {
        AddressService.getAllAddress().then((res) =>
        this.setState({ address : res.data })
        );
    }

    handleDelete = (id) => {
        //axios.delete("http://localhost3000/address/id").then();
        AddressService.deleteAddrById(id).then((res) => {
            const address = this.state.address.filter((addr) => addr.addressId != id);
            this.setState({ address });
        });
    };
    
    handleSearch = (event) => {
        //const emps = [...this.state.employees];
        console.log("handleSearch");
        this.setState({ search: event.target.value });
    
        const filteredAddr = this.state.address.filter(
          (addr) =>
          addr.area.toLowerCase().startsWith(event.target.value.toLowerCase())
            //emp.firstName.toLowerCase().startsWith(event.target.value.toLowerCase())
          //emp.firstName.toLowerCase().includes(event.target.value.toLowerCase())
        );
        this.setState({ address: filteredAddr });
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
                        placeholder="Search by area"
                        value={this.state.search}
                        onChange={this.handleSearch}
                    />
                    </form>
                </div>
                <div><Link to="/address/add">
                  <input
                    type="button"
                    className="btn btn-success mb-3 ms-3"
                    value="Add"
                  />
                </Link></div>
                </div>
                <AddressTable
                address={this.state.address}
                handleDelete={this.handleDelete}>
                </AddressTable>
            </div>

       );
    }
    
}
export default Address;