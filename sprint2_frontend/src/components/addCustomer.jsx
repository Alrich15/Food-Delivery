
import React, { Component } from "react";
import Joi from "joi-browser";
import CustomerService from "../services/CustomerService";
class AddCustomer extends Component {
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
        errors: {},
        errMsg : "",
    };
    
    // schema to validate
    schema = {
        customerId: Joi.string().alphanum().min(6).max(6).required(),
        firstName: Joi.string().alphanum().required(),
        lastName: Joi.string().alphanum().required(),
        age : Joi.number().required(),
        gender: Joi.string().alphanum().required(),
        email: Joi.string()
        .email({ minDomainSegments: 2, tlds: { allow: ["com"] } })
        .required(),
        mobileNumber: Joi.string().min(10).max(10).required(),
        password: Joi.string().min(4).max(15).alphanum().required(),
    };
  
    // form validation method
    validate = () => {
      const errors = {};
      // Validate account details with schema
      const result = Joi.validate(this.state.customer, this.schema, {
        abortEarly: false,
      });
      console.log(result);
  
      // Initialize error object with errors, if validate method returns errors
      if (result.error !== null) {
        for (let err of result.error.details) {
          errors[err.path[0]] = err.message;
        }
      }
  
      // return null if no errors otherwise return errors
      return Object.keys(errors).length === 0 ? null : errors;
    };

    handleChange = (event) => {
        const customer = { ...this.state.customer };
        customer[event.target.name] = event.target.value;
        console.log(event.target.name);
        console.log(event.target.value);
        this.setState({ customer : customer });
    };

    handleSubmit = (event) => {
        event.preventDefault();
        const errors = this.validate(); // null / errors
        // Set state error object with errors or empty object based on
        // errors return by the validate() method
        this.setState({ errors: errors || {} });
        // if errors exists in the form , return to the login page
        console.log(errors);

        if(errors) return;
        CustomerService.addCustomer(this.state.customer)
        .then((res) => {
            this.props.history.push("/customer")
        })
        .catch((error) => this.setState({ errMsg: error.response.data.message }));
    }; 

    render() {
        return(
            <div className="w-50 mx-auto mt-3">
            {this.state.errMsg && (
            <div className="alert alert-danger" role="alert">
                {this.state.errMsg}
            </div>
            )}
            <div
            className="border shadow-lg"
            style={{
                padding: "20px",
            }}
            >
            <h3 className="bg-secondary text-white p-1">Register</h3>
            <form onSubmit={this.handleSubmit}>
                <div className="mb-3 text-start">
                <label for="customerId">Customer Id</label>
                <input
                    type="text"
                    className="form-control"
                    id="customerId"
                    name="customerId"
                    value={this.state.customer.customerId}
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.customerId}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="firstName">First Name</label>
                <input
                    type="text"
                    className="form-control"
                    id="firstName"
                    name="firstName"
                    value={this.state.customer.firstName}
                    placeholder="Enter firstName"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.firstName}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="lastName">last Name</label>
                <input
                    type="text"
                    className="form-control"
                    id="lastName"
                    name="lastName"
                    value={this.state.customer.lastName}
                    placeholder="Enter lastName"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.lastName}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="age">Age</label>
                <input
                    type="number"
                    className="form-control"
                    id="age"
                    name="age"
                    value={this.state.customer.age}
                    placeholder="Enter your age"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.age}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="gender">Gender</label>
                <input
                    type="text"
                    className="form-control"
                    id="gender"
                    name="gender"
                    value={this.state.customer.gender}
                    placeholder="Enter your gender"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.gender}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="email">E-Mail</label>
                <input
                    type="text"
                    className="form-control"
                    id="email"
                    name="email"
                    value={this.state.customer.email}
                    placeholder="Enter your email"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.email}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="mobileNumber">Mobile Number</label>
                <input
                    type="text"
                    className="form-control"
                    id="mobileNumber"
                    name="mobileNumber"
                    value={this.state.customer.mobileNumber}
                    placeholder="Enter your mobile Number"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.mobileNumber}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="password">Password</label>
                <input
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    value={this.state.customer.password}
                    placeholder="Enter your password"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.password}
                    </p>
                )}
                </div>
                <div>
                    < a href="http://localhost:3000/address/add">Can add address here!</a>
                </div>
                <div class="d-grid mt-2">
                <button type="submit" className="btn  btn-secondary">
                    Submit
                </button>
                </div>
            </form>
            </div>
        </div>
        );
    }
}
export default AddCustomer;