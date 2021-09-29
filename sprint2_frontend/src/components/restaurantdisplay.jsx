import React, { Component } from 'react';
import {
    Grid,
    Paper,
    Box,
    Container,
    Drawer,
    List,
    ListItem,
    ListItemText,
    Link,
    Button,
  } from "@material-ui/core";
  import Card from '@material-ui/core/Card';
  import CardHeader from '@material-ui/core/CardHeader';
  import CardMedia from '@material-ui/core/CardMedia';
  import CardActionArea from "@material-ui/core/CardActionArea";
  import CardContent from '@material-ui/core/CardContent';
  import CardActions from '@material-ui/core/CardActions';
  import Typography from '@material-ui/core/Typography';
import RestaurantService from '../services/RestaurantService';
import RestaurantCategoryService from '../services/RestaurantCategoryService';
import Avatar from '@material-ui/core/Avatar';
import { Redirect, useHistory } from "react-router-dom";


class RestaurantDisplay extends Component {
    constructor(props) {
        super(props);
        this.state = { 
          color: "#D3D3D3",
        Category:this.props.match.params.category,
        restaurant:[],
        description:[
            
            "People who love to eat are always the best people..",
            "To eat is a necessity, but to eat intelligently is an art.",
            "We all eat, an it would be a sad waste of opportunity to eat badly.",
            "If you really want to make a friend, go to someone's house and eat with him...the people who give you their food give you their heart.",
            "A good restaurant is like a vacation; it transports you, and it becomes a lot more than just about the food."
            
        ]
         }
    }
    
    componentDidMount(){
        RestaurantCategoryService.getRestaurantCategoryById(this.state.Category).then((res)=>
        {this.setState({restaurant:res.data.rest})
        })
                
    }
  
    
    handleOnClick = (id, name) =>{
      console.log("selected :",id);
      //return <Redirect to='/foodItem' restId={id} />
      this.props.history.push({
          pathname: '/foodItem',
          state : { restId : id,restName : name,},
      })
    }

    render() { 
        return (
            
            this.state.restaurant.map((
                restaurant,index)=>
                
                <div style={{ background: this.state.color }} id="main">
                <div class="card-deck">
                <div class="row justify-content-center">
                    
                <div class="card" style={{width:"300px" ,margin:"20px"}}>
                {/* <img height="80px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTy8xVQfQSKYNpRBth0guFrwadf364I7w-HZQ&usqp=CAU"   class="card-img-top" alt="..." /> */}

                <div class="card-body">
              
                <Avatar src="/broken-image.jpg" />
                  <h5 class="card-title">{restaurant.restaurantName}</h5>
                  <p class="card-text"><em>{this.state.description[index]}</em></p>
                  <h6 class="card-title">{restaurant.contactNumber}</h6>
                  <a onClick={this.handleOnClick.bind(this, restaurant.restaurantId,restaurant.restaurantName)} class="btn btn-primary" >Menu</a>
                </div>
                  </div>
                  </div>
                  </div>
                  </div>
            )
           
          );
    }
}
export default RestaurantDisplay;