import React, { Component } from 'react';
import RestaurantService from '../services/RestaurantService';
import AddressService from '../services/AddressService';
import ItemService from '../services/ItemService';

class UpdateRestaurant extends Component {
    state = {  
        restaurant:{
          
            contactNumber: "",
            managerName: "",
            restaurantId: "",
            restaurantName: ""
          
        }

    }

    componentDidMount() {
        RestaurantService.getRestaurantById(this.props.match.params.id).then((res) =>
          this.setState({ restaurant: res.data })
        );
      }



      handleChange=(event)=>{
        const restaurant={...this.state.restaurant};
        restaurant[event.target.name]=event.target.value;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({restaurant:restaurant});


  }
handleSubmit=(event)=>{
  event.preventDefault();
  RestaurantService.updateRestaurant(this.state.restaurant).then((res)=>{
    this.props.history.push("/restaurants");
    console.log()
  });
}


    render() { 
        return ( 
            <div className="w-50 mx-auto border p-3 mt-3">Update Restaurant 
<form onSubmit={this.handleSubmit}>
  <div className="mb-3 text-start">
    <label for="restaurantId" className="text-start">Restaurant Id</label>
    <input type="text" class="form-control" id="restaurantId" 
    name="restaurantId"
    value={this.state.restaurant.restaurantId} 

    //placeholder="Enter Restaurant Id"
    onChange={this.handleChange}

    />
  </div>
  <div className="mb-3 text-start">
    <label for="managerName" className="form-label">Manager Name</label>
    <input type="text" className="form-control" id="managerName" 
    name="managerName"
    value={this.state.restaurant.managerName}
   // placeholder="Enter Manager name"
    onChange={this.handleChange}
    />
  </div>
  
  <div className="mb-3 text-start">
    <label for="restaurantName" className="form-label">Restaurant Name</label>
    <input type="text" className="form-control" id="restaurantName" 
    name="restaurantName"
    value={this.state.restaurant.restaurantName}
   // placeholder="Enter Manager name"
    onChange={this.handleChange}
    />
  </div>

  <div className="mb-3 text-start">
    <label for="contactNumber" className="form-label">Contact Number</label>
    <input type="text" className="form-control" id="contactNumber"
    name="contactNumber"
    value={this.state.restaurant.contactNumber}
   
    onChange={this.handleChange}

    />
  </div>

  

  

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

            </div>
                
           
         );
    }
}
 
export default UpdateRestaurant;