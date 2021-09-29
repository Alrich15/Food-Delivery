import React, { Component } from "react";
import { Link } from "react-router-dom";

class AddressTable extends Component {
    render() {
        return( 
            
            <div className = "w-60  mx-auto my-auto mt-3"> 
            
            <table className="table border shadow-lg table-hover table-striped" >
            <thead className="thead-dark">
                <tr>
                <th scope="col">Address Id</th>
                <th scope="col">Area</th>
                <th scope="col">Building Name</th>
                <th scope="col">Street No</th>
                <th scope="col">City</th>
                <th scope="col">State</th>
                <th scope="col">Country</th>
                <th scope="col">Pincode</th>
                <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                {this.props.address.map((addr) =>
                (
                    <tr>
                        <td>{addr.addressId}</td>
                        <td>{addr.area}</td>
                        <td>{addr.buildingName}</td>
                        <td>{addr.streetNo}</td>
                        <td>{addr.city}</td>
                        <td>{addr.state}</td>
                        <td>{addr.country}</td>
                        <td>{addr.pincode}</td>
                        <td>
                            <Link to={`/address/update/${addr.addressId}`}>
                            <input type="button" className="btn btn-primary" value="Update" />
                            </Link>
                            <input type="button" className="btn btn-danger ms-2" value="Delete " 
                            onClick={() => this.props.handleDelete(addr.addressId)}/>
                        </td>
                    </tr>
                ))}
            </tbody>
            </table>
            </div> 
        )
    }
}

export default AddressTable;
