import React, { Component } from 'react';
import RestaurantService from '../services/RestaurantService';
import ItemService from '../services/ItemService';
import AddressService from '../services/AddressService';
import RestaurantCategoryService from '../services/RestaurantCategoryService';
//import 'react-multi-checkbox-select/lib/multi-checkbox-select.css';

import Joi from "joi-browser";



class AddRestaurant extends Component {
    state = {  
        restaurant:{
          
            
    managerName: "",
    restaurantId: "",
    restaurantName: "",
    contactNumber:""
},
        
      
        errors: {},
        errMsg: "",
        
    };
    // schema to validate
  schema = {
    restaurantId: Joi.number().min(1000).required(),
    restaurantName: Joi.string().min(3).max(30).alphanum().required(),
    managerName: Joi.string().min(1).alphanum().required(),
    contactNumber: Joi.number().min(9000000000).max(9999999999).required(),
  };
  
   // form validation method
   validate = () => {
    const errors = {};
    // Validate account details with schema
    const result = Joi.validate(this.state.restaurant, this.schema, {
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
  
    componentDidMount(){
    
    ItemService.getItem().then((item)=>{this.setState({item:item.data})
    });
    RestaurantCategoryService.getRestaurantCategory().then((rest)=>{this.setState({restCat:rest.data})});
    AddressService.getAddress().then((add)=>{this.setState({address1:add.data})
     
    });

  

  }

    handleChange=(event)=>{
        const restaurant={...this.state.restaurant};
        restaurant[event.target.name]=event.target.value;
   
    this.setState({restaurant:restaurant});
    
   


  }

   handleCheckbox(index,item) {
 
    
    var itemList=[...this.state.selectedItem]
    var ischecked=document.getElementById(index).checked
    


    if(ischecked==true){
      itemList[index]=item
    }
    else{
     
    itemList.forEach(element => {
     
      if(element.itemId==item.itemId){
     
      

      itemList=itemList.filter(s=>s.itemId!=element.itemId)
      }
      });
    
     
    }
    this.setState({selectedItem:itemList})
    
      
}

handleSubmit=(event)=>{
  event.preventDefault();

const errors = this.validate(); // null / errors
// Set state error object with errors or empty object based on
    // errors return by the validate() method
    this.setState({ errors: errors || {} });
    // if errors exists in the form , return to the login page
    console.log(errors);

    if (errors) return;
RestaurantService.createRestaurant(this.state.restaurant).then((res)=>{

  this.props.history.push("/restaurants")
}).catch((error) => this.setState({ errMsg: error.response.data.message }));
}





  

    render() { 
        return ( 

            <div className="w-50 mx-auto border p-3 mt-3">
              {this.state.errMsg && (
          <div className="alert alert-danger" role="alert">
            {this.state.errMsg}
          </div>
        )}
        <div className="border shadow-lg p-3">
          <h3 className="bg-secondary text-white p-1">Add Restaurant </h3>   
<form onSubmit={(e)=>this.handleSubmit(e)}>
  <div className="mb-3 text-start">
    <label for="restaurantId" className="text-start">Restaurant Id</label>
    <input type="text" class="form-control" id="restaurantId" 
    name="restaurantId"
    value={this.state.restaurant.restaurantId} 

    //placeholder="Enter Restaurant Id"
    onChange={this.handleChange}

    />
     {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.restaurantId}
                </p>
              )}
  </div>
  <div className="mb-3 text-start">
    <label for="managerName" className="form-label">Manager Name</label>
    <input type="text" className="form-control" id="managerName" 
    name="managerName"
    value={this.state.restaurant.managerName}
   // placeholder="Enter Manager name"
    onChange={this.handleChange}
    />
     {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.managerName}
                </p>
              )}
  </div>
  
  <div className="mb-3 text-start">
    <label for="restaurantName" className="form-label">Restaurant Name</label>
    <input type="text" className="form-control" id="restaurantName" 
    name="restaurantName"
    value={this.state.restaurant.restaurantName}
   // placeholder="Enter Manager name"
    onChange={this.handleChange}
    />
     {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.restaurantName}
                </p>
              )}
  </div>

  <div className="mb-3 text-start">
    <label for="contactNumber" className="form-label">Contact Number</label>
    <input type="text" className="form-control" id="contactNumber"
    name="contactNumber"
    value={this.state.restaurant.contactNumber}
   
    onChange={this.handleChange}

    />
     {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.contactNumber}
                </p>
              )}
  </div>

  {/* <div class="mb-3 text-start">
    <label for="address" className="form-label">Address</label>
   
      <select class="form-select" id="addressId" name="address" 

    onChange={()=>{
      
        if (document.getElementById("addressId")!=null){
          this.setState({
            addressId:document.getElementById("addressId").value
          })
         

        }
      }}
      
      >
         <option disabled="true" selected="true">Address Id  List</option>
                                {
                                    this.state.address1.map(
                                        address=>
                                            <option value={address.addressId}>{address.city}</option>
                                    )
                                }         
   
</select>
  </div> */}
{/* 
  <div className="mb-3 text-start">
  <label for="item" className="form-label">ItemList</label>

<div class="list-group">

      {
        this.state.item.map((item,
          index)=>

          <label >< input name={item.itemName} type="checkbox" onClick={()=>this.handleCheckbox(index,item)} id={index} value={item.itemName}/>{item.itemName}</label>

            
        )
        

       
      }
 
 
</div> */}
{/* 
<div class="mb-3 text-start">
    <label for="restaurantCategory" className="form-label">Restaurant Category</label>
   
      <select class="form-select" id="restaurantCategoryId" onChange={()=>{
      
        if (document.getElementById("restaurantCategoryId")!=null){
          this.setState({
            restaurantCategoryId:document.getElementById("restaurantCategoryId").value
          })

        }
      }}>

         <option disabled="true" selected="true">Restaurant Id  List</option>
                                {
                                    this.state.restCat.map(
                                        restCat=>
                                            <option  value={restCat.restaurantCategoryId}>{restCat.restaurantCategoryName}</option>
                                    )
                                }
   
</select>
  </div> */}
{/* 
  </div> */}

  <div class="d-grid">
  <input type = "submit" value = "Submit" />
            </div>
</form>
</div>
            </div>
         );
    }
}
 
export default AddRestaurant;