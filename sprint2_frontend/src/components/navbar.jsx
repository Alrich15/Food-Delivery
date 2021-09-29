import React, {Component} from "react";
import {NavLink} from "react-router-dom";

import { FaHome,FaHamburger,FaUserPlus,FaInfoCircle,FaShoppingCart } from "react-icons/fa";
import { BiNotepad,BiLogIn,BiUserPlus,BiLogOut } from "react-icons/bi";
import { MdFeedback } from "react-icons/md";
import { useSelector } from "react-redux";

// import { useSelector } from "react-redux";



// class Nav extends Component{
//     constructor(props){
//         super(props)
//         this.state={};
//     }
const Nav = () => {
  

  const login = useSelector((state) => state.login);
   
    
        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-danger py-0" >
            <div className="container-fluid">
              <NavLink className="navbar-brand" to="/"><FaHamburger size="2em" color="white"/></NavLink>
              <NavLink className="navbar-brand" to="/"><h4 style={{color:"white"}}>Food Delivery</h4></NavLink>
              <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
              </button>
              <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                
                  <li className="nav-item">
                    
                    <NavLink className="nav-link active" aria-current="page" to="/home"><h5>Home</h5></NavLink>
                  </li>
                  
                  <li className="nav-item">
                    
                    <NavLink className="nav-link active" aria-current="page" to="/"><h5>About us</h5></NavLink>
                  </li>
                  
                  <li className="nav-item">
                    <NavLink className="nav-link active" to="/"><h5>Contact us</h5></NavLink>
                  </li>
                  
                 
                </ul>
                
                <ul className="navbar-nav mb-2 mb-lg-0">
                <NavLink className="nav-link active" to="/ordercard"><MdFeedback size="1.8em" color="white" style={{marginRight:"30px"}}/><h5 style={{marginRight:"40px"}}>Order Summary</h5></NavLink>
                {login.loggedIn ?(
                  <NavLink className="nav-link active" to="/logout"><BiLogOut size="1.8em" color="white"/><h5>Logout</h5></NavLink>
                ) :( 
                  <NavLink className="nav-link active" to="/login"><BiLogIn size="1.8em" color="white"/><h5>Login</h5></NavLink>
                )} 
                
                <NavLink className="nav-link active p-2" to="/foodcart"><FaShoppingCart size="1.7em" color="white"/><h5>Cart</h5></NavLink>

                  
                  
                </ul>
              </div>
            </div>
          </nav>
      );
    };

export default Nav;


