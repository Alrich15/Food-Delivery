import React from 'react';
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import ItemCategoryService from '../services/ItemCategoryService';
import Button from '@material-ui/core/Button';


const ItemCategory = () => {

    const[itemCategory, setItemCategory] = useState([]);
    const[searchedItemCategory, setSearchedItemCategory] = useState([]);
    const[search, setSearch] = useState("");

    useEffect( () =>{
        ItemCategoryService.getItemCategories().then( (res) =>{
            setItemCategory(res.data);
            setSearchedItemCategory(res.data);
        })
    },[]);

    const handleSearch = (event) =>{
        setSearch(event.target.value);
        const searchRes = searchedItemCategory.filter(
            item => item.itemCategoryName.toLowerCase().startsWith(event.target.value.toLowerCase())
        );
        setItemCategory(searchRes);

    };


    return ( 

        <div className="container mt-3 w-75 mx-auto">

                <form class="d-flex justify-content-end">
                    <input class="form-control me-2 w-25" type="search" placeholder="Search" aria-label="Search"
                    onChange={handleSearch}
                    />
                    <Link to='/itemCategory/add' style={{textDecoration: 'none'}}>
                       {/* <button type="button flexbox" class="btn btn-success">Add</button> */}
                       <Button variant="outlined" color="primary" className="mx-1"> Add </Button> 
                    </Link>
                </form>

                <table className="table table-bordered border-dark table-striped mt-2">
                    <thead>
                        <tr>
                            <th>Category Id</th>
                            <th>Category Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody> 
                        
                        { itemCategory.map( itemCat => 
                            <tr>
                                <td>{itemCat.itemCategoryId}</td>
                                <td>{itemCat.itemCategoryName}</td>
                            
                                <td>
                                <Link to={`/itemCategory/update/${itemCat.itemCategoryId}`} style={{textDecoration: 'none'}}>
                                    <Button size="small" variant="outlined" color="primary" className="mx-1">Update</Button>
                                </Link>
                                
                                </td>
                            </tr>
                        )}
                    </tbody>

                </table>

        </div>

     );
}
 
export default ItemCategory;