import React, { useEffect, useState } from "react";
import {Button} from "@material-ui/core";
import ItemService from "../services/ItemService";
import { increment, decrement } from "../actions/quantityAction";
import { useSelector, useDispatch } from "react-redux";



const ItemDetails = (props) => {
        const[item,setItem] = useState({});
        useEffect(() => {
          //get item by its id
            ItemService.getItemById(`${props.match.params.id}`)
          .then((res) => {
                setItem(res.data);
            }, []);
    }, []);

    
    const login = useSelector((state) => state.login);
   
    //redux to update item quantity
    const dispatch = useDispatch();
    const quantity = useSelector((state) => state.quantity);

    
    const handleQty= (id, qty) =>{
      ItemService.updateQty(qty,id).catch((error) => console.log(error));
    
    };  
    const totalAmount = 0; 
    
    return(

    <div className='container-fluid'>
    <div className="card mx-auto col-md-3 col-10 mt-5">
       <img className='mx-auto img-thumbnail' src={item.image} width="auto" height="auto" />
        <div className="card-body text-center mx-auto">
            <div className='cvp'>
                <h5 className="card-title font-weight-bold">{item.itemName}</h5>
                <p className="card-text"><b> <s>₹ {item.cost}</s> 20% off!!<br/> ₹  {item.cost - ((item.cost*20)/100)}</b></p> 
                <p className="card-text">{item.itemDesc}</p>  
                {/* <a href="#" className="btn details px-auto">view details</a> */}
                <br />
                <div className='cvp'>
                <p className="card-text">
                {quantity >1 ?(
         <Button
        variant="text"
        size="small"
        color="secondary"
        onClick={() => dispatch(decrement())}
      >
        -
      </Button>):(
       <Button
       variant="text"
       size="small"
       color="secondary"
       disabled="true"
     >
       -
     </Button>)}
      Qty: {quantity} <Button
        variant="text"
        size="small"
        color="secondary"
        onClick={() => dispatch(increment())}
      >
        +
      </Button>
     
    <br />
    
      Total Cost: ₹ {totalAmount + (item.cost - ((item.cost*20)/100)) * quantity}   <br /><br />
      </p>
      <p className="card-text">
      {login.loggedIn ?(
                <button type="button" className="btn btn-danger" onClick={() =>handleQty(item.itemId,quantity)}>ADD TO CART</button>
      ):( <label><b>Please login to order </b></label>)}
     </p>
            </div>
            </div>
        </div>
    </div>
</div>
      );
  };
  
  export default ItemDetails;
  