import React, { Component } from 'react';
import ItemCategoryService from '../services/ItemCategoryService';
import Joi  from 'joi-browser';

class UpdateItemCategory extends Component {
    state = { 
        itemCategory : {
            itemCategoryId : "",
            itemCategoryName : "",
        },
        errors: {},
        errorMsg: "",
    }

    componentDidMount(){
        ItemCategoryService.getItemCategoryById(this.props.match.params.id).then(
            res => {
               this.setState({itemCategory : res.data});
            }
        )
    }

    // schema to validate
    schema = {
        itemCategoryId: Joi.string().min(6).max(6).alphanum().required(),
        itemCategoryName : Joi.string().min(3).max(50).alphanum().required(),
    };

    // form validation method
    validate = () => {
        const errors = {};
        // Validate account details with schema
        const result = Joi.validate(this.state.itemCategory, this.schema, {
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

    handleChange = (event) =>{
        const itemCategory = {...this.state.itemCategory};
        itemCategory[event.target.name] = event.target.value;
        this.setState({itemCategory : itemCategory});
    }

    handleSubmit = (event) =>{
        event.preventDefault();
        
        // Prevents default behaviour of submit button
        event.preventDefault();

        const errors = this.validate(); // null / errors
        // Set state error object with errors or empty object based on
        // errors return by the validate() method
        this.setState({ errors: errors || {} });
        // if errors exists in the form , return to the login page
        console.log(errors);

        if (errors) return;

        ItemCategoryService.updateItemCategory(this.state.itemCategory).then( 
            res => {
               this.props.history.push("/itemCategory");
               
            }
        ).catch((error) => {
            const err = error.response.data.message;
            if(err.length > 0){
                this.setState({errorMsg : "Item Category Name already exists"});
            }
        } );

    }


    render() { 
        return ( 

            <div className="w-50 mx-auto border p-3 mt-3">
                Update Item Category
                {this.state.errorMsg && (
                <div className="alert alert-danger" role="alert">
                    {this.state.errorMsg}
                </div>
                )}
                
                <form onSubmit={this.handleSubmit}>
                    <div className="mb-3 text-start">
                        <label htmlFor="itemCategoryId">Category Id</label>
                        <input
                        type="text"
                        className="form-control"
                        id="itemCategoryId"
                        name="itemCategoryId"
                        placeholder="Enter item category Id"
                        onChange={this.handleChange}
                        value={this.state.itemCategory.itemCategoryId}
                        disabled
                        />
                    </div>
                    <div className="mb-3 text-start">
                        <label htmlFor="itemCategoryName">Category Name</label>
                        <input
                        type="text"
                        className="form-control"
                        id="itemCategoryName"
                        name="itemCategoryName"
                        placeholder="Enter item category Name"
                        onChange={this.handleChange}
                        value={this.state.itemCategory.itemCategoryName} 
                        />
                        {this.state.errors && (
                        <p className="text-danger font-monospace text-start">
                            {this.state.errors.itemCategoryName}
                        </p>
                        )}
                    </div>

                    <button type="submit" className="btn  btn-primary">
                        Submit
                    </button>

                </form>

            </div>

         );
    }
}
 
export default UpdateItemCategory;