import React, { Component } from 'react';
import OrderService from '../services/OrderService';
// import Joi from "joi-browser";

//class component for update operation
class UpdateOrder extends Component{
    state={
        order:{
            orderId: "",
            orderDate:"",
            orderStatus:"",
          
        },
       
    };

    componentDidMount(){
        OrderService.viewOrderById(this.props.match.params.id).then((res) => 
        this.setState({order:res.data}));
    }

    handleChange = (event) => {
        const order = {...this.state.order};
        order[event.target.name] = event.target.value;
        console.log(event.target.name);
        console.log(event.target.value);
        this.setState({order:order});
        
    };

    handleSubmit = (event) => {
        event.preventDefault();
        
        if (this.state.order.orderStatus == "") {
            alert("Order status is invalid");
            return false;
          }
        OrderService.updateOrder(this.state.order).then((res) => {
            this.props.history.push("/orders");
        })
        
    };

    render(){
        return (
            <div className="w-50 mx-auto border border-5 border-danger bg-warning rounded shadow-lg p-3 mt-5">
                {this.state.errMsg && (
                    <div className="alert alert-danger" role="alert">
                        {this.state.errMsg} 
                    </div>
                )}
                <h3>Update Order</h3><hr />
                <form onSubmit={this.handleSubmit}>
                    <div className="mb-3 text-start ">
                        <label htmlFor="orderId">Order Id</label>
                        <input type="text" className="form-control" id="orderId" name="orderId" disabled  value={this.state.order.orderId} onChange={this.handleChange}/>
                        {this.state.errors && (
                            <p className="text-danger font-monospace text-start">
                                {this.state.errors.orderId}
                            </p>
                        )}
                    </div>
                    <div className="input-append date mb-3 text-start " >
                        <label htmlFor="orderId">Order Date</label>
                        <input type="date" name="orderDate" id="orderDate" max="2021-09-03" className="form-control" value={this.state.order.orderDate}  onChange={this.handleChange} />
                        {this.state.errors && (
                            <p className="text-danger font-monospace text-start">
                                {this.state.errors.orderDate}
                            </p>
                        )}
                    </div>
                    <div className="mb-3 text-start ">
                        <label htmlFor="orderStatus">Order Status</label>
                        <input type="text" className="form-control" id="orderStatus" name="orderStatus" value={this.state.order.orderStatus} placeholder="Enter Order Status" onChange={this.handleChange}/>
                        {this.state.errors && (
                            <p className="text-danger font-monospace text-start">
                                {this.state.errors.orderStatus}
                            </p>
                        )}
                    </div>
                    
                    <div className="d-grid">
                        <button type="submit" className="btn btn-primary bg-danger">Submit</button>

                    </div>
                    
                </form>
            </div>

        );
    }

}
export default UpdateOrder;



// import React, { Component } from 'react';
// import OrderService from '../services/OrderService';
// import Joi from "joi-browser";


// class UpdateOrder extends Component{
//     state={
//         order:{
//             orderId: "",
//             orderDate:"",
//             orderStatus:"",
//             // cartId:"",
//             // totalAmount:"",
//         },
//         errors: {},
//         errMsg: "",
//     };

//     schema={
//         orderId: Joi.string().alphanum().min(6).max(6).regex(/^[O,o]{1}[D,d]{1}[0-9]{1,4}$/).required(),
//         orderDate: Joi.date().required(),

//         orderStatus: Joi.string().regex(/[a-zA-Z]$/).required(),
//     };

//     validate = () => {
//         const errors={};
//         const result = Joi.validate(this.state.order, this.schema, {abortEarly:false,});
//         console.log(result);

//         //initialize error object with errors, if validate method returns errors
//         if(result.error !== null){
//             for(let err of result.error.details){
//                 errors[err.path[0]] = err.message;
//             }
//         }

//         return Object.keys(errors).length === 0 ? null:errors;
//     };

//     componentDidMount(){
//         OrderService.viewOrderById(this.props.match.params.id).then((res) => 
//         this.setState({order:res.data}));
//     }

//     handleChange = (event) => {
//         const order = {...this.state.order};
//         order[event.target.name] = event.target.value;
//         console.log(event.target.name);
//         console.log(event.target.value);
//         this.setState({order:order});
        
//     };

//     handleSubmit = (event) => {
//         event.preventDefault();
//         const errors = this.validate();

//         //set state error object with errors or empty object based on errors return by the validate() method
//         this.setState({errors:errors || {}});
//         console.log(errors);

//         if(errors) return;
//         OrderService.updateOrder(this.state.order).then((res) => {
//             this.props.history.push("/orders");
//         })
//         .catch((error)=> this.setState({errMsg: error.response.data.message}));
//     };

//     render(){
//         return (
//             <div className="w-50 mx-auto border border-5 border-info bg-warning rounded shadow-lg p-3 mt-3">
//                 {this.state.errMsg && (
//                     <div className="alert alert-danger" role="alert">
//                         {this.state.errMsg} 
//                     </div>
//                 )}
//                 <h3>Update Order</h3><hr />
//                 <form onSubmit={this.handleSubmit}>
//                     <div className="mb-3 text-start">
//                         <label htmlFor="orderId">Order Id</label>
//                         <input type="text" className="form-control" id="orderId" name="orderId"  value={this.state.order.orderId} onChange={this.handleChange}/>
//                         {this.state.errors && (
//                             <p className="text-danger font-monospace text-start">
//                                 {this.state.errors.orderId}
//                             </p>
//                         )}
//                     </div>
//                     <div className="input-append date mb-3 text-start" >
//                         <label htmlFor="orderId">Order Date</label>
//                         <input type="date" name="orderDate" id="orderDate" max="2021-08-24" className="form-control" value={this.state.order.orderDate}  onChange={this.handleChange} />
//                         {this.state.errors && (
//                             <p className="text-danger font-monospace text-start">
//                                 {this.state.errors.orderDate}
//                             </p>
//                         )}
//                     </div>
//                     <div className="mb-3 text-start">
//                         <label htmlFor="orderStatus">Order Status</label>
//                         <input type="text" className="form-control" id="orderStatus" name="orderStatus" value={this.state.order.orderStatus} placeholder="Enter Order Status" onChange={this.handleChange}/>
//                         {this.state.errors && (
//                             <p className="text-danger font-monospace text-start">
//                                 {this.state.errors.orderStatus}
//                             </p>
//                         )}
//                     </div>
//                     {/* <div className="mb-3 text-start">
//                         <label htmlFor="cartId">cart Id</label>
//                         <input type="text" className="form-control" id="cartId" name="cartId" value={this.state.order.cartId} placeholder="Enter cart Id" onChange={this.handleChange}/>
//                         {this.state.errors && (
//                             <p className="text-danger font-monospace text-start">
//                                 {this.state.errors.cartId}
//                             </p>
//                         )}
//                     </div>
//                     <div className="mb-3 text-start">
//                         <label htmlFor="totalAmount">total Amount</label>
//                         <input type="text" className="form-control" id="totalAmount" name="totalAmount" value={this.state.order.totalAmount} placeholder="Enter total Amount" onChange={this.handleChange}/>
//                         {this.state.errors && (
//                             <p className="text-danger font-monospace text-start">
//                                 {this.state.errors.totalAmount}
//                             </p>
//                         )}
//                     </div> */}
//                     <div className="d-grid">
//                         <button type="submit" className="btn btn-primary">Submit</button>

//                     </div>
                    
//                 </form>
//             </div>

//         );
//     }

// }
// export default UpdateOrder;


