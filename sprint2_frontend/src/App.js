import { Route } from 'react-router-dom';
import './App.css';
import FoodItem from './components/foodItem';
import Login from './components/login';
import Nav from './components/navbar';
import {Switch, Redirect} from 'react-router-dom';
import ItemCategory from './components/itemCategory';
import AddItemCategory from './components/addItemCategory';
import UpdateItemCategory from './components/updateItemCategory';
import Logout from './components/logout';

import Item from './components/items';
import ItemDetails from './components/itemDetails';
import Items from './components/item';
import AddItem from './components/addItem';
import UpdateItem from './components/updateItem';

import AddRestaurant from './components/addRestaurant';
import UpdateRestaurant from './components/updateRestaurantErr';
import RestCategory from './components/restcategory';
import RestaurantDisplay from './components/restaurantdisplay';

import Home from './components/home';
import OrderDetails from './components/orderdetails';
//import Login from './Components/login';

//import PageNotFound from './Components/pageNotFound';
import AddOrder from './components/addOrderDetails';
import UpdateOrder from './components/updateOrderDetails';

//import Logout from './Components/logout';
import OrderSummary from './components/ordersummary';

import OrderCard from './components/ordercards';

//import ItemDetails from './Components/itemDetails';

import Cart from './components/cart';


import Address from './components/address';
import AddAddress from './components/addAddress';
import UpdateAddress from './components/updateAddress';
import Customer from './components/customer';
import AddCustomer from './components/addCustomer';
import UpdateCustomer from './components/updateCustomer';
import PaymentPage from './components/paymentPage';
import AdminPage from './components/adminpage';


function App() {
  return (
    <div className="App">
      <Nav />
      <Switch>
        <Route exact path="/foodItem" component={FoodItem} />
        <Route path="/login" component={Login} />
        <Route exact path="/itemCategory" component={ItemCategory} />
        <Route path="/itemCategory/add" component={AddItemCategory} />
        <Route path="/itemCategory/update/:id" component={UpdateItemCategory} />
        <Route path="/logout" component={Logout} />

        <Route path="/items" component={Items} />
        <Route path="/item/add" component={AddItem} />
        <Route path="/item/update/:id" component={UpdateItem} />
        <Route path="/item" component={Item} />
        <Route path="/byId/:id" component={ItemDetails} />

        <Route path="/restCategory/display" component={RestCategory}/>
        <Route path="/restaurant/display/:category"  component={RestaurantDisplay}/>

        <Route path="/ordercard" component={OrderCard}/>
        <Route exact path="/" component={Home}/>
        <Route path="/orders" component={OrderDetails}/>
        <Route  path="/orderdetails/byId/:id" component={OrderSummary}/>
        <Route path="/orderdetails/add" component={AddOrder}/>
        <Route  path="/orderdetails/:id" component={UpdateOrder}/>

        <Route path='/foodcart' component={Cart} />

        <Route path="/address/all" component={Address} />
        <Route path="/address/add" component={AddAddress} />
        <Route path="/address/update/:id" component={UpdateAddress} />
        <Route path="/customer/all" component={Customer} />
        <Route path="/customer/add" component={AddCustomer} />
        <Route path="/customer/update/:id" component={UpdateCustomer} />

        <Route path="/bill/payment" component={PaymentPage} />
        <Route path="/adminpage" component={AdminPage} />

        <Redirect from="/home" to="/" />
        
        
      </Switch>
    </div>
  );
}

export default App;
