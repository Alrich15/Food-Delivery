import React, { Component } from "react";
import { Link } from "react-router-dom";

class CustomerTable extends Component {
    render() {
        return( 
            
            <div className = "w-80  mx-auto my-auto mt-3"> 
            <table className="table border shadow-lg table-hover table-striped" >
            <thead className="thead-dark">
                <tr>
                <th scope="col">Customer Id</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Age</th>
                <th scope="col">Gender</th>
                <th scope="col">Email</th>
                <th scope="col">Mobile No</th>
                <th scope="col">Password</th>
                <th scope="col">Role</th>
                <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                {this.props.customer.map((cust) =>
                (
                    <tr>
                        <td>{cust.customerId}</td>
                        <td>{cust.firstName}</td>
                        <td>{cust.lastName}</td>
                        <td>{cust.age}</td>
                        <td>{cust.gender}</td>
                        <td>{cust.email}</td>
                        <td>{cust.mobileNumber}</td>
                        <td>{cust.password}</td>
                        <td>customer</td>
                        <td>
                            <Link to={`/customer/update/${cust.customerId}`}>
                            <input type="button" className="btn btn-primary" value="Update" />
                            </Link>
                            <input type="button" className="btn btn-danger ms-2" value="Delete " 
                            onClick={() => this.props.handleDelete(cust.customerId)}/>
                        </td>
                    </tr>
                ))}
            </tbody>
            </table>
            </div> 
        )
    }
}

export default CustomerTable;