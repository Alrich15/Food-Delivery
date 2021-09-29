import React, { Component } from "react";
import AddressService from "../services/AddressService";

class UpdateAddress extends Component {
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
  };

  componentDidMount() {
    AddressService.getAddrById(this.props.match.params.id).then((res) =>
      this.setState({ address: res.data })
    );
  }
  handleChange = (event) => {
    const address = { ...this.state.address };
    address[event.target.name] = event.target.value;
    //employee[empId]=1;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ address : address });
  };

  handleSubmit = (event) => {
    // Prevents default behaviour of submit button
    event.preventDefault();
    AddressService.updateAddress(this.state.address).then((res) => {
      this.props.history.push("/address");
    });
  };
  render() {
    return (
      <div className="w-50 mx-auto border p-3 mt-3">
        Update Address
        <form onSubmit={this.handleSubmit}>
          <div className="mb-3 text-start">
            <label for="addrId">Address Id</label>
            <input
              type="text"
              className="form-control"
              id="addrId"
              name="addrId"
              disabled
              value={this.state.address.addressId}
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="buildingName">Building Name</label>
            <input
              type="text"
              className="form-control"
              id="buildingName"
              name="buildingName"
              value={this.state.address.buildingName}
              //placeholder="Enter buildingName"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="streetNo">Street No</label>
            <input
              type="text"
              className="form-control"
              id="streetNo"
              name="streetNo"
              value={this.state.address.streetNo}
              placeholder="Enter streetNo"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="area">Area</label>
            <input
              type="text"
              className="form-control"
              id="area"
              name="area"
              //aria-describedby="emailHelp"
              value={this.state.address.area}
              placeholder="Enter area"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="city">City</label>
            <input
              type="text"
              className="form-control"
              id="city"
              name="city"
              value={this.state.address.city}
              placeholder="Enter city Name"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="state">State</label>
            <input
              type="text"
              className="form-control"
              id="state"
              name="state"
              value={this.state.address.state}
              placeholder="Enter State Name"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="country">Country</label>
            <input
              type="text"
              className="form-control"
              id="country"
              name="country"
              value={this.state.address.country}
              placeholder="Enter country Name"
              onChange={this.handleChange}
            />
          </div>
          <div className="mb-3 text-start">
            <label for="pincode">Pincode</label>
            <input
              type="text"
              className="form-control"
              id="pincode"
              name="pincode"
              value={this.state.address.pincode}
              placeholder="Enter Pincode"
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

export default UpdateAddress;