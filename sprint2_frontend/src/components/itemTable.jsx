import React, { Component } from 'react';
import { Link } from "react-router-dom";

class ItemTable extends Component {
   
    render() { 
        return (   <table className="table">
        <thead>
            <tr>
            <th scope="col">Item ID</th>
            <th scope="col">Item Name</th>
            <th scope="col">Item Description</th>
            <th scope="col">qty </th>
            <th scope="col">cost </th>
            <th scope="col">Item Category</th>
            <th scope="col">Actions</th>
            
            </tr>
        </thead>
        <tbody>
           {this.props.adminItems.map((item)=>(
               <tr>
                   <td>{item.itemId}</td>
                   <td>{item.itemName}</td>
                   <td>{item.itemDesc}</td>
                   <td>{item.qty}</td>
                   <td>{item.cost}</td>
                   <td>{item.itemCategory.itemCategoryName}</td>
                   <td>
                     
                     <Link to={`/item/update/${item.itemId}`}>
                     <input type="button" 
                       className="btn btn-primary"
                        value="Update"
                     />
                     </Link>
                     <input type="button" 
                       className="btn btn-secondary ms-3"
                        value="Delete"
                        onClick={() => this.props.handleDelete(item.itemId)}
                
                     />
                   </td>
                   
               </tr>
           ))}
        </tbody>
    </table>
    );
    }
}
 
export default ItemTable;