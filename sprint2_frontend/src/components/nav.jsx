import React from "react";
import {NavLink } from "react-router-dom";
import { makeStyles } from "@material-ui/core/styles";
import ShoppingCartTwoToneIcon from "@material-ui/icons/ShoppingCartTwoTone";
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  IconButton,
} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    menuButton: {
      marginRight: theme.spacing(2),
    },
    title: {
      flexGrow: 1,
    },
  })); 

  const Nav = () => {
      const classes = useStyles();
      return(
        <div className={classes.title}>
        <AppBar position="static">
          <Toolbar>
            <Typography
              variant="h6"
              style={{
                border: "3px solid red",
                padding: "5px",
              }}
            >
              fooddelivery
            </Typography>
            <Button 
            color="inherit"
            component={NavLink}
            to="/"
            >
              Home
              </Button>
            <Button 
            color="inherit" 
            style={{ marginRight: "auto" }}
            component={NavLink}
            to="/item"
            >
              Items
            </Button>
            <Button color="inherit" style={{ marginRight: "auto" }}
            component={NavLink}
            to="/items">
              Item Table
            </Button>
  

            <Button color="inherit">Login</Button>
            <Button color="inherit">Register</Button>
            <Button color="inherit">Logout</Button>
            <Button color="inherit">
              <ShoppingCartTwoToneIcon></ShoppingCartTwoToneIcon>Cart
            </Button>
          </Toolbar>
        </AppBar>
      </div>
      );
  };

  export default Nav;
