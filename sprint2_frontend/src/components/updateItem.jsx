import React, { Component } from "react";
import ItemService from "../services/ItemService";
import ItemCategoryService from "../services/ItemCategoryService";
import { Link } from 'react-router-dom';
class UpdateItem extends Component {
    
    state = { 
        item:{
            cost: 0,
            itemDesc: "",
            image: "",
            itemCategory:{
            itemCategoryName:"",
            },
            itemId: "",
            itemName: "",
            qty: 0,
          },

          itemCateg: [],
     }; 
     

     componentDidMount(){
         ItemService.getItemById(this.props.match.params.id)
         .then((res) => this.setState({item: res.data }));

         ItemCategoryService.getItemCategories().then((res) =>
          this.setState({ itemCateg: res.data }));
     };

     handleChange = (event) => {
         const item = { ...this.state.item};
         item[event.target.name] = event.target.value;
         console.log(event.target.name);
         console.log(event.target.value);
         this.setState({item : item });
     };

     handleSubmit = (event) => {
         event.preventDefault();

         const item={
          itemId: this.state.item.itemId,
          itemName: this.state.item.itemName, 
          itemDesc: this.state.item.itemDesc,
          image: this.state.item.image,
          qty: 1,
         cost: this.state.item.cost,
         
        }

        {console.log(this.state.item)}
  {console.log(item)}
         ItemService.updateItem(item).then((res) =>{
             this.props.history.push("/items");
         });
     };

    
    render() { 
        return ( <div className="w-50 mx-auto border p-3 m-3">
        Update Item 
        <form onSubmit={ this.handleSubmit}>
        <img src={this.state.item.image} class="img-thumbnail" alt={this.state.item.itemName}  style={{ height: "100px", width: "auto" }} />
          
          <div className="mb-3 text-start">
            <label for="itemId">Item Id</label>
            <input
            type="text" 
            className="form-control"
            id="itemId"
            name="itemId"
            disabled
            value={this.state.item.itemId}
            onChange={this.handleChange}
            />
          </div>

          <div className="mb-3 text-start">
            <label for="itemName">Item Name</label>
            <input
            type="text" 
            className="form-control"
            id="itemName"
            name="itemName"
            value={this.state.item.itemName}
            onChange={this.handleChange}
            />
          </div>

          <div className="mb-3 text-start">
            <label for="image">Image URL</label>
            <input
            type="text" 
            className="form-control"
            id="image"
            name="image"
            value={this.state.item.image}
            onChange={this.handleChange}
            />
          </div>

          <div className="mb-3 text-start">
            <label for="itemDesc">Item Description</label>
            <textarea 
            className="form-control"
            id="itemDesc"
            name="itemDesc"
            rows="4"
            value={this.state.item.itemDesc}
            onChange={this.handleChange}
            />
          </div>

          <div className="mb-3 text-start">
            <label for="cost">Cost</label>
            <input
            type="text" 
            className="form-control"
            id="cost"
            name="cost"
            value={this.state.item.cost}
            onChange={this.handleChange}
            />
          </div>

          <div className="mb-3 text-start">
          <label for="itemCategory">Item Category: {this.state.item.itemCategory.itemCategoryName}</label>
          <Link to={`/itemCategory/update/${this.state.item.itemCategory.itemCategoryId}`}>
          <button type="button" class="btn btn-light">Update Category?</button>
          </Link>
 </div>
 <div className="d-grid btn-primary">
 <input type="submit" className="btn btn-danger" value="Submit" />
           </div>
        </form>
      </div>
       );
    }
}
 
export default UpdateItem;