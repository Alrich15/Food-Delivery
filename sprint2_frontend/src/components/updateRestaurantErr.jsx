import React, { useState, useEffect } from "react";
import RestaurantService from '../services/RestaurantService';


const UpdateRestaurant=(props)=>{

const[restaurant,setRestaurant]=useState({
  contactNumber: "",
  managerName: "",
  restaurantId: "",
  restaurantName: ""

});

useEffect(()=>{
  RestaurantService.getRestaurantById(props.match.params.id).then((res)=>{
  setRestaurant(res.data);
});
});


const handleChange=(event)=>{
  const rest={...restaurant};
  console.log(rest);
  rest[event.target.name]=event.target.value;
  console.log(event.target.name);
  console.log(event.target.value);
  setRestaurant({ ...restaurant,[event.target.name]:event.target.value});
};

const handleSubmit=(event)=>{
  event.preventDefault();
  RestaurantService.updateRestaurant(restaurant).then((res)=>{
    props.history.push("/restaurants");
    console.log("hi")
  });
};

return ( 
    <div className="w-50 mx-auto border p-3 mt-3">Update Restaurant 
<form onClick={handleSubmit}>
<div className="mb-3 text-start">
<label for="restaurantId" className="text-start">Restaurant Id</label>
<input type="text" class="form-control" id="restaurantId" 
name="restaurantId"
value={restaurant.restaurantId} 

//placeholder="Enter Restaurant Id"
onChange={handleChange}

/>
</div>
<div className="mb-3 text-start">
<label for="managerName" className="form-label">Manager Name</label>
<input type="text" className="form-control" id="managerName" 
name="managerName"
value={restaurant.managerName}
// placeholder="Enter Manager name"
onChange={handleChange}
/>
</div>

<div className="mb-3 text-start">
<label for="restaurantName" className="form-label">Restaurant Name</label>
<input type="text" className="form-control" id="restaurantName" 
name="restaurantName"
value={restaurant.restaurantName}
// placeholder="Enter Manager name"
onChange={handleChange}
/>
</div>

<div className="mb-3 text-start">
<label for="contactNumber" className="form-label">Contact Number</label>
<input type="text" className="form-control" id="contactNumber"
name="contactNumber"
value={restaurant.contactNumber}

onChange={handleChange}

/>
</div>



<button type="submit" class="btn btn-primary">Submit</button>
</form>

    </div>
        
   
 );

                    }
export default UpdateRestaurant;