import React, { Component} from "react" ;
import OrderService from "../services/OrderService";
import OrderTable from "./ordertable";
import { connect } from "react-redux";
import {NavLink} from "react-router-dom";
import {Link} from "react-router-dom";
import { BsFillPlusCircleFill } from "react-icons/bs";
import {FaSearch,FaCartPlus } from "react-icons/fa";




class OrderDetails extends Component{
    state={
        orders: [],
        search:"",
    };

    componentDidMount(){
        OrderService.viewOrder().then((res)=> this.setState({orders: res.data})
        );

    }

    handleDelete = (id) => {
        OrderService.removeOrderById(id).then((res) => {
            const orders=this.state.orders.filter((od)=>od.orderId!=id);
            this.setState({orders});
        });
    };

    handleSearch = (event) => {
        console.log("handleSearch");
        this.setState({search: event.target.value});
        const filteredOrders=this.state.orders.filter(
          (od)=>od.orderStatus.toLowerCase().startsWith(event.target.value.toLowerCase())
        //   (od)=>od.orderStatus.toLowerCase().startsWith(event.target.value.toLowerCase())
        );
        this.setState({orders:filteredOrders});
      };
    render(){
        return(
            <div className="mt-3 w-75 mx-auto">
                <div className="d-flex justify-content-end m-2">
                <FaSearch size="30px" color="dark" className="mt-1 p-1"/>
                    <div>
                   
                        <form>
                      
                            <input className="form-control" type="search" placeholder="Search by Order Status "  value={this.state.search}  onChange={this.handleSearch}/>
                            {/* <button className="btn btn-outline-success" type="submit">Search</button> */}
                        </form>

                    </div>

                    <div className="ms-2">
                        {/* {this.props.login.loggedIn &&  */}
                            {/* // (this.props.login.role == "admin" ? ( */}
                            <Link to="orderdetails/add">
                        
                            <input className="btn btn-success float-end mb-3" type="button" value="Add Order" />
    
                            </Link>
                     

                        {/* // ) : null)} */}
                        
                  
                    
                    
                   
                </div>
                </div>
                
               
                <OrderTable orders={this.state.orders} handleDelete={this.handleDelete} />
                
               
            </div>
            
        );
    }
}

// const mapStateToProps = (state) => {
//     return{
//         login: state.login,
//     };
// };
// export default connect(mapStateToProps) (OrderDetails);
export default OrderDetails;