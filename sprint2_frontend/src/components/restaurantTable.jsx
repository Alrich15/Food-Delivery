import React, { Component } from 'react';
import { Link } from "react-router-dom";
class RestaurantTable extends Component {
    state = {  }
    render() { 
        return ( 
            
<table className="table table-bordered">
                   <thead>
                       <tr>
                       <th>Restaurant ID</th>
                       <th>Restaurant Name</th>
                       <th>Manager Name</th>
                       <th>Contact No</th>
                       {/* <th>Address Id</th>
                       <th>Area</th> */}
                       {/* <th>Rest</th> */}
                       <th>Actions</th>
                       
                       </tr>
                   </thead>
                   <tbody>
                      {this.props.restaurants.map((rest)=>(
                          <tr>
                              <td>{rest.restaurantId}</td>
                              <td>{rest.restaurantName}</td>
                              <td>{rest.managerName}</td>
                              <td>{rest.contactNumber}</td>
                              {/* <td>{rest.address.addressId}</td>
                              <td>{rest.address.area}</td>
                               */}
                              <td>
                              <Link to={`/restaurant/update/${rest.restaurantId}`}>
                                <input type="button" 
                                  className="btn btn-primary"
                                   value="Update"
                                />
                                </Link>

                                <input type="button" 
                                  className="btn btn-secondary ms-3"
                                   value="Delete"
                                   onClick={() => this.props.handleDelete(rest.restaurantId)}  
                                    />                            

                              </td>
                              
                          </tr>
                      ))}
                   </tbody>
               </table>

         );
    }
}
 
export default RestaurantTable;