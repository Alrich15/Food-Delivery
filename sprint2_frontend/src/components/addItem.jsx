import React, { Component } from "react";
import ItemService from "../services/ItemService";
import ItemCategoryService from "../services/ItemCategoryService";
import Joi from "joi-browser";
import { Link } from "react-router-dom";
class AddItem extends Component{
  state = { 
   item:{
            cost: 0,
            itemCategoryId: "",
            itemDesc: "",
            itemId: "",
            itemName: "",
            image: "",
        },
  itemCateg:[],
 
   errors: {},
   errMsg: "",
  };
  
  schema={
    itemId: Joi.string().length(6).alphanum().required(),
    itemName: Joi.string().min(3).required(),
    itemDesc: Joi.string().min(10).required(),
    cost: Joi.number().min(30).required(), 
    image: Joi.string().required(),
    itemCategoryId: Joi.required(),
  
  };

  //form Validaiton Method
  validate = () =>{
    const errors = {};
    //Validate details with schema
    const result = Joi.validate(this.state.item, this.schema, {
      abortEarly: false,
    });
    console.log(result);

     // Initialize error object with errors, if validate method returns errors
     if (result.error !== null) {
      for (let err of result.error.details) {
        errors[err.path[0]] = err.message;
      }
    }

    //return null if no errors otherwise return errors
    return Object.keys(errors).length === 0 ? null : errors;
  };

    componentDidMount(){
      ItemCategoryService.getItemCategories().then((res) =>
          this.setState({ itemCateg: res.data })
        );
      }
handleChange=(event) =>{
    const item={...this.state.item};
    item[event.target.name] = event.target.value;
    console.log(event.target.name);
    console.log(event.target.value);
    this.setState({ item: item});
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
   itemCategory: {
    itemCategoryId: this.state.item.itemCategoryId,
   },
  }
  {console.log(this.state.item)}
  {console.log(item.image)}

  const errors= this.validate(); // (null || Errors)
  // Set state error object with errors or empty object based on
    // errors return by the validate() method
    this.setState({errors: errors || {} });

    // if errors exists in the form , return to the login page
    console.log(errors);

    if (errors) return;

    ItemService.createItem(item).then((res)  =>{
        this.props.history.push("/items");
    }).catch((error) => this.setState({ errMsg: error.response.data.message }));
  };
  
render( ){
    return(
      <div className="w-60 mx-auto mt-3">
      {this.state.errMsg && (
        <div className="alert alert-danger" role="alert">
          {this.state.errMsg}
        </div>
      )}
        <div className="w-50 mx-auto border p-3 mt-3">
        Add Item
        <form onSubmit={ (e) => this.handleSubmit(e)} >
        <img src={this.state.item.image} class="img-thumbnail" alt={this.state.item.itemName}  style={{ height: "100px", width: "auto" }} />
         

          <div className="mb-3 text-start">
            <label for="itemId">Item Id</label>
            <input
              type="text"
              className="form-control"
              id="itemId"
              name="itemId"
              value={this.state.item.itemId}
              placeholder="Enter Item Id"
              onChange={this.handleChange}
            />
            {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.itemId}
                </p>
              )}
            </div>
           

            <div className="mb-3 text-start">
                <label for="image">Image URL</label>
                <input
                type="text"
                className="form-control"
                id="image"
                name="image"
                value={this.state.item.image}
             //   onInput={this.onChange}
              placeholder="Enter Image URL"
              onChange={this.handleChange}
              />

            {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.image}
                </p>
              )}
            </div>

            <div className="mb-3 text-start">
                <label for="itemName">Item Name</label>
                <input
                type="text"
                className="form-control"
                id="itemName"
                name="itemName"
                value={this.state.item.itemName}
                
              placeholder="Enter Item Name"
              onChange={this.handleChange}
              />

            {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.itemName}
                </p>
              )}
            </div>

            <div className="mb-3 text-start">
                <label for="itemDesc">Item Description</label>
                <textarea
                className="form-control"
                id="itemDesc"
                name="itemDesc"
                rows="4"
                value={this.state.item.itemDesc}
                placeholder="Enter Item Description"
                 onChange={this.handleChange}
              />

            {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.itemDesc}
                </p>
              )}
            </div>
           
            <div className="mb-3 text-start">
            <label for="cost">Cost</label>
            <input
              type="text"
              className="form-control"
              id="cost"
              name="cost"
              value={this.state.item.cost}
              placeholder="Enter cost"
              onChange={this.handleChange}
            />

            {this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.cost}
                </p>
              )}
          </div>

          <div className="mb-3 text-start">
          <label for="itemCategory">Item Category</label>
<select className="form-select"  value={this.state.item.itemCategoryId}  id="itemCategoryId"
              name="itemCategoryId"onChange={this.handleChange}>
 {this.state.itemCateg.map((itemCat)=>(
 <option value={itemCat.itemCategoryId}>{itemCat.itemCategoryName}</option>
 
 ))}
 
</select>
{this.state.errors && (
                <p className="text-danger font-monospace text-start">
                  {this.state.errors.itemCategoryId}
                </p>
              )}
 <Link to="/itemCategory/add">
<button type="button" class="btn btn-link">add new Category?</button>
</Link>
  </div>


         

       <div className="d-grid btn-primary">
          <input type="submit" className="btn btn-danger"  value="Submit" />
                    </div>
        </form>
      </div>
</div>
         );
    }
}
 

export default AddItem;