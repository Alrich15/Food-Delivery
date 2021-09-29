import React,{ Component } from "react";
import ItemService from "../services/ItemService";

import { Link } from "react-router-dom";

class Items extends Component{
    state = {
        adminItems: [],
};

//View all items
componentDidMount(){
    ItemService.getItems().then((res) =>
        this.setState({ adminItems: res.data })
      );
  }
     
 //delete selected item by id  
  handleDelete= ( id ) =>{
      ItemService.deleteItem(id).then((res) =>{
        const adminItems=this.state.adminItems.filter((itm) => itm.itemId != id);
        this.setState({ adminItems });
      });
};

//search item by name
  handleSearch=(event) =>{
        console.log("Searching..");
        this.setState({search: event.target.value});

        const filteredItems = this.state.adminItems.filter((item) =>
        item.itemName.toLowerCase() .startsWith(event.target.value.toLowerCase())
        );
      
        this.setState({adminItems: filteredItems});
  };

render(){
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
      
         <div >
          <Link to="/item/add">
            <input type="button"
             className="btn btn-outline-danger float-end mb-3 ms-3 " 
            value="Add"
            />
            </Link>
        </div> 
       </div>

          <table className="table table-striped">
        <thead>
            <tr className="table-danger">
            <th scope="col">Image</th>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Item Description</th>
            <th scope="col">Cost (INR) </th>
            <th scope="col">Item Category</th>
            <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
           {this.state.adminItems.map((item)=>(
               <tr>
                   <td><img src={item.image} class="img-thumbnail " height="140" alt={item.image} /></td>
                   <td>{item.itemId}</td>
                   <td>{item.itemName}</td>
                   <td>{item.itemDesc}</td>
                   <td>{item.cost}</td>
                   <td>{item.itemCategory.itemCategoryName}</td>
                   <td>
                   <Link to={`/item/update/${item.itemId}`}>
                     <input type="button" 
                       className="btn btn-outline-primary m-3 "
                        value="Update"
                     />
                     </Link>
                     <input type="button" 
                       className="btn btn-outline-dark m-3"
                        value="Delete"
                        onClick={() => this.handleDelete(item.itemId)}
                
                     />
                   </td>
                   
               </tr>
           ))}
        </tbody>
    </table>
      
    </div> 
  );
}

};

export default Items;