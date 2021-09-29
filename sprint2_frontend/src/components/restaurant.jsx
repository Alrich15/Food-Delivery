import React, { Component } from 'react';
import RestaurantService from '../services/RestaurantService';
import RestaurantTable from './restaurantTable';
import axios from 'axios';
import {Link} from "react-router-dom"


class Restaurant extends Component {
    state = { 
     

        restaurants:[],
        restCategory:[]
     };

     componentDidMount(){
        RestaurantService.getRestaurants().then((res) =>{this.setState({restaurants:res.data});
        // (this.state.restaurants.forEach(element=> {
        //     (element.restCat.forEach(el =>
        //         console.log(el.restaurantCategoryName)
        //         ))
        // }))
        
       // this.setState({restCategory:restaurants.data})
       
    }

       
        );
        console.log(this.state.restCategory)
        this.state.restaurants.forEach(element => {
           
            this.State({restCategory:element.restCat})
            
            console.log(this.state.restCategory)
        })
       
     }

      handleDelete =(id) =>{
        RestaurantService.deleteRestaurant(id).then((res) =>{
            const restaurants=this.state.restaurants.filter((rest)=> rest.restaurantId!= id);
            this.setState({restaurants});
           

        });

     };


     handleAdd=()=>{
         this.props.history.push({pathname:'/restaurant/add'});
     }

     
  handleSearch=(event) =>{
    console.log("Searching..");
    this.setState({search: event.target.value});

    const filteredItems = this.state.restaurants.filter((res) =>
    res.restaurantName.toLowerCase() .startsWith(event.target.value.toLowerCase())
    );
    this.setState({restaurants: filteredItems});
  };



    render() { 
        return ( 

            
           <div className="mt-3 w-75 mx-auto">
                <div className="d-flex justify-content-end">
        <div>
          <form>
            <input type="search"
            className="form-control"
            placeholder="Search items"
            value={this.state.search}
            onChange={this.handleSearch}
          />
          </form>
        </div>
      </div>


               <div >
               {/* <Link to="/restuarant/add"> */}
                   <input type="button"
                    className="btn btn-info float-end mb-3" 
                   value="Add"
                   onClick={this.handleAdd}
                   
                   />
                   {/* </Link> */}
               </div>
               <RestaurantTable 
                restaurants={this.state.restaurants} 
                handleDelete={this.handleDelete}
                />

           </div> 
         );
    }
}
 
export default Restaurant;