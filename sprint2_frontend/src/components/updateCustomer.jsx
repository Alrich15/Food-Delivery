import React, { Component } from "react";
//import AddressService from "../Services/AddressService";
import CustomerService from "../services/CustomerService";

class UpdateCustomer extends Component {
  state = {
    customer: {
        customerId : "",
        firstName : "",
        lastName : "",
        age : 0,
        gender : "",
        email : "",
        mobileNumber : "",
        password : "",
    },
  };

  componentDidMount() {
    CustomerService.viewCustomerById(this.props.match.params.id).then((res) =>
      this.setState({ customer: res.data })
    );
  }
  handleChange = (event) => {
    const customer = { ...this.state.customer };
    customer[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ customer : customer });
  };

  handleSubmit = (event) => {
    // Prevents default behaviour of submit button
    event.preventDefault();
   CustomerService.updateCustomer(this.state.customer).then((res) => {
      this.props.history.push("/customer");
    });
  };
  render() {
    return (
      <div className="w-50 mx-auto border p-3 mt-3">
        Update Address
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3 text-start">
            <label for="customerId">Customer Id</label>
            <input
              type="text"
              className="form-control"
              id="customerId"
              name="customerId"
              disabled
              value={this.state.customer.customerId}
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="firstName">First Name</label>
            <input
              type="text"
              className="form-control"
              id="firstName"
              name="firstName"
              value={this.state.customer.firstName}
              placeholder="Enter first name"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="lastName">Last Name</label>
            <input
              type="text"
              className="form-control"
              id="lastName"
              name="lastName"
              value={this.state.customer.lastName}
              placeholder="Enter last Name"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="age">Age</label>
            <input
              type="number"
              className="form-control"
              id="age"
              name="age"
              //aria-describedby="emailHelp"
              value={this.state.customer.age}
              placeholder="Enter age"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="gender">Gender</label>
            <input
              type="text"
              className="form-control"
              id="gender"
              name="gender"
              value={this.state.customer.gender}
              placeholder="Enter gender"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="email">Email</label>
            <input
              type="email"
              className="form-control"
              id="email"
              name="email"
              value={this.state.customer.email}
              placeholder="Enter email"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="mobileNumber">Mobile Number</label>
            <input
              type="text"
              className="form-control"
              id="mobileNumber"
              name="mobileNumber"
              value={this.state.customer.mobileNumber}
              placeholder="Enter mobileNumber"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="password">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              name="password"
              value={this.state.customer.password}
              placeholder="Enter password"
              onChange={this.handleChange}
            />
          </div>
          <button type="submit" class="btn  btn-primary">
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default UpdateCustomer;