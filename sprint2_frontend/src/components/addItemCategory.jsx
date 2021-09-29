import React, { useEffect, useState } from 'react';
import ItemCategoryService from '../services/ItemCategoryService';
import Joi from "joi-browser";

const AddItemCategory = (props) => {

    const[itemCategory, setItemCategory] = useState({});
    const[errorMsg, setErrorMsg] = useState("");
    const[errors, setErrors] = useState({});

    // schema to validate
    const schema = {
        itemCategoryId: Joi.string().min(6).max(6).alphanum().required(),
        itemCategoryName : Joi.string().min(3).max(50).alphanum().required(),
    };

    const handleChange = (event) =>{
        itemCategory[event.target.name] = event.target.value;
        console.log("itemCategory ", itemCategory);
    }

    const handleSubmit = (event) =>{
        event.preventDefault();

        const errors = validate(); // null / errors
        // Set state error object with errors or empty object based on
        // errors return by the validate() method
        setErrors({ errors: errors});
        // if errors exists in the form , return to the login page
        console.log(errors);
        if (errors) return;

        ItemCategoryService.addItemCategory(itemCategory).then( 
            res => {
               props.history.push("/itemCategory");
               
            }
        ).catch((error) => {
            const err = error.response.data.message;
            if(err.length > 50){
                setErrorMsg("Item Category Name already exists");
            }else{
                setErrorMsg(err);
            }
        } );

    }

    // form validation method
    const validate = () => {
        const errors = {};
        // Validate account details with schema
        const result = Joi.validate(itemCategory, schema, {
        abortEarly: false,
        });

        // Initialize error object with errors, if validate method returns errors
        if (result.error !== null) {
        for (let err of result.error.details) {
            errors[err.path[0]] = err.message;
        }
        }

        // return null if no errors otherwise return errors
        return Object.keys(errors).length === 0 ? null : errors;
    };



    return ( 
        
        <div className="w-50 mx-auto border p-3 mt-3">
            Add Item Category
            {errorMsg && (
            <div className="alert alert-danger" role="alert">
                {errorMsg}
            </div>
            )}
            
            <form onSubmit={handleSubmit}>
                <div className="mb-3 text-start">
                    <label htmlFor="itemCategoryId">Category Id</label>
                    <input
                    type="text"
                    className="form-control"
                    id="itemCategoryId"
                    name="itemCategoryId"
                    placeholder="Enter item category Id"
                    onChange={handleChange}
                    />
                    {errors.errors && (
                    <p className="text-danger font-monospace text-start">
                        {errors.errors.itemCategoryId}
                    </p>
                    )}
                </div>
                <div className="mb-3 text-start">
                    <label htmlFor="itemCategoryName">Category Name</label>
                    <input
                    type="text"
                    className="form-control"
                    id="itemCategoryName"
                    name="itemCategoryName"
                    placeholder="Enter item category Name"
                    onChange={handleChange} 
                    />
                    {errors.errors && (
                    <p className="text-danger font-monospace text-start">
                        {errors.errors.itemCategoryName}
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
 
export default AddItemCategory;