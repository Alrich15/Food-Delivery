
import React, { Component } from "react";
import Joi from "joi-browser";
import AddressService from "../services/AddressService";
class AddAddress extends Component {
    state = {
        address: {
            addressId : "",
            buildingName : "",
            streetNo : "",
            area : "",
            city : "",
            state : "",
            country : "",
            pincode : "",
        },
        errors: {},
        errMsg : "",
    };
    
    // schema to validate
    schema = {
        addressId: Joi.string().alphanum().min(6).max(6).required(),
        buildingName: Joi.string().alphanum(),
        streetNo: Joi.string().alphanum(),
        area : Joi.string().alphanum().required(),
        city: Joi.string().alphanum().required(),
        state: Joi.string().alphanum().required(),
        country: Joi.string().alphanum().required(),
        pincode: Joi.string().min(6).max(6).alphanum().required(),
    };
  
    // form validation method
    validate = () => {
      const errors = {};
      // Validate account details with schema
      const result = Joi.validate(this.state.address, this.schema, {
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
        const address = { ...this.state.address };
        address[event.target.name] = event.target.value;
        console.log(event.target.name);
        console.log(event.target.value);
        this.setState({address: address});
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
        AddressService.addAddress(this.state.address)
        .then((res) => {
            this.props.history.push("/address")
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
            <h3 className="bg-secondary text-white p-1">Add Address</h3>
            <form onSubmit={this.handleSubmit}>
                <div className="mb-3 text-start">
                <label for="addressId">Address Id</label>
                <input
                    type="text"
                    className="form-control"
                    id="addressId"
                    name="addressId"
                    value={this.state.address.addressId}
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.addressId}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="buildingName">Building Name</label>
                <input
                    type="text"
                    className="form-control"
                    id="buildingName"
                    name="buildingName"
                    value={this.state.address.buildingName}
                    placeholder="Enter Building Name"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.buildingName}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="streetNo">Street No</label>
                <input
                    type="text"
                    className="form-control"
                    id="streetNo"
                    name="streetNo"
                    value={this.state.address.streetNo}
                    placeholder="Enter Street No"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.streetNo}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="area">Area</label>
                <input
                    type="text"
                    className="form-control"
                    id="area"
                    name="area"
                    value={this.state.address.area}
                    placeholder="Enter your area"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.area}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="city">City</label>
                <input
                    type="text"
                    className="form-control"
                    id="city"
                    name="city"
                    value={this.state.address.city}
                    placeholder="Enter your city name"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.city}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="state">State</label>
                <input
                    type="text"
                    className="form-control"
                    id="state"
                    name="state"
                    value={this.state.address.state}
                    placeholder="Enter your State"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.state}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="country">Country</label>
                <input
                    type="text"
                    className="form-control"
                    id="country"
                    name="country"
                    value={this.state.address.country}
                    placeholder="Enter your country"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.country}
                    </p>
                )}
                </div>
                <div className="mb-3 text-start">
                <label for="pincode">Pincode</label>
                <input
                    type="text"
                    className="form-control"
                    id="pincode"
                    name="pincode"
                    value={this.state.address.pincode}
                    placeholder="Enter your pincode"
                    onChange={this.handleChange}
                />
                {this.state.errors && (
                    <p className="text-danger font-monospace text-start">
                    {this.state.errors.pincode}
                    </p>
                )}
                </div>
                <div class="d-grid">
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
export default AddAddress;