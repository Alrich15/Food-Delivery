import React, {Component} from "react" ;
import {Link} from "react-router-dom";
import { MdDelete } from "react-icons/md";

class OrderTable extends Component{
    render(){
        return(
            <table className="table  table-warning table-striped mt-3">
            <thead className="table-dark"> 
                <tr>
                    <th><h4>Order Id</h4></th>
                    <th><h4>Order Date</h4></th>
                    <th><h4>Order Status</h4></th>
                    {/* <th><h4>Food Cart Id</h4></th> */}
                    {/* <th><h4>Total Bill Amount</h4></th> */}
                    <th><h4>Actions</h4></th>
                    {/* <th><h3>Actions</h3></th>
                    <th><h3>Actions</h3></th>
                    <th><h3>Actions</h3></th>
                    <th><h3>Actions</h3></th> */}
                </tr>
            </thead>
            <tbody>
                {this.props.orders.map((od)=> (
                    <tr>

                        <td>{od.orderId}</td>
                        <td>{od.orderDate}</td>
                        <td>{od.orderStatus}</td>
                        {/* <td>{od.cart.cartId}</td> */}
                        {/* <td>{od.cart.totalAmount}</td> */}
                        <td>
                            <Link to={`/orderdetails/${od.orderId}`}>
                                <input type="button" className="btn btn-primary" value="Update" />

                            </Link>
                            
                            <input type="button" className="btn btn-danger ms-3" value="Delete" onClick={()=>this.props.handleDelete(od.orderId)}/>
                            <Link>
                                <MdDelete size="2em" color="red" onClick={()=>this.props.handleDelete(od.orderId)} />
                            </Link>
                            
                        </td>
                    </tr>
                ) )}
            </tbody>
        </table>

        );
    }
}
export default OrderTable;
