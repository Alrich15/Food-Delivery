import React, { Component } from 'react';
import { Link } from 'react-router-dom'

class AdminPage extends Component {
    state = {  }
    render() { 
        return ( 
            <div className="page-header mt-3">
                <div>
                    <div className="col-md-6 col-md-offset-3 body-main"
                        style={{
                            marginTop: "20px",
                            marginBottom: "30px",
                            marginRight: "auto",
                            marginLeft: "auto",
                            padding: "40px 30px !important",
                            boxShadow: "0 1px 21px #808080"
                    }}>
                        <table class="table table-success table-striped">
                            <thead>
                                <tr>
                                    <td><strong>Component</strong></td>
                                    <td><strong>Action</strong></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Customer</td>
                                    <td>
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Address</td>
                                    <td>
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Restaurant</td>
                                    <td>
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>Item</td>
                                    <td>
                                    <Link to="/items">
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                   </Link>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Item Category</td>
                                    <td>
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Food Cart</td>
                                    <td>
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Order Details</td>
                                    <td>
                                        <input type="button" className="btn btn-primary" value="Let's go" /> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Bill</td>
                                    <td>
                                        <Link to="/bills">
                                            <input type="button" className="btn btn-primary" value="Let's go" /> 
                                        </Link>    
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }
}
 
export default AdminPage;