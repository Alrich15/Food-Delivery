
import React, { useEffect, useState } from "react";
import {
  Typography,
  Container,
  Paper,
  Button,
  Box,
  Grid,
  TableContainer,
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
  Divider,
} from "@material-ui/core";
import { Link } from "react-router-dom";
import CartService from "../services/cartService";
// handleAddQuantity = (id)=>{
//   this.props.addQuantity(id);
// }
// //to substruct from the quantity
// handleSubtractQuantity = (id)=>{
//   this.props.subtractQuantity(id);
// }
const Cart = (props) => {
  const [cart, setCart] =  useState([]);
  useEffect(() => {
    CartService.viewCart("CAR501")
    .then((res)=>{
      console.log(res.data.cartItems);
      setCart(res.data.cartItems);
    });
  }, []);
  return (   
    <Box mt={3}>
     <Container>
        <Grid container>
          <Grid item xs={12} sm={9} >
            <Paper elevation={3}>
              <TableContainer>
                <Table>
                 <TableHead align="left">
                   <TableRow>
                      <TableCell width="50%">Item Name </TableCell>
                       <TableCell width="10%">Quantity</TableCell>
                       <TableCell  width="10%">Price  </TableCell>
                      <TableCell  width="50%">Total Price</TableCell>
                      </TableRow> 
                  </TableHead>
                  <TableBody align="left">
                  {cart.map((cartItem) =>(
                    <Link to={`/view/${cart.cartId}`}>
                      <TableRow>
                      <TableCell width="100%">{cartItem.itemName}</TableCell>
                      <TableCell></TableCell>
                      <TableCell width="100%">{cartItem.qty}</TableCell> 
                      <TableCell></TableCell>
                      <TableCell width="100%">{cartItem.cost}</TableCell>
                      <TableCell></TableCell>
                      <TableCell width="100%">{cartItem.qty*cartItem.cost}</TableCell>
                      </TableRow>
                    </Link>
                     ))}
                     
                 
                  </TableBody>
                </Table>
              </TableContainer>
            </Paper>
            </Grid>
            <Grid item xs={12} sm={3}>
            <Box ml={3} textAlign="left">
              <Paper elevation={3}>
                <Box p={3}>
                  <Typography variant={"h6"}>Price Details</Typography>
                </Box>
                <Box my={3} mt={2}>
                  <Divider></Divider>
                </Box>
                <Box pl={3}>
                  <Typography>Total Amount: </Typography>
                </Box>
                <Box p={3} mt={3} textAlign="center">
                  <Button
                    color="primary"
                    variant={"contained"}
                    component={Link}
                    to="/bill/payment"
                  >
                    Checkout
                  </Button>
                </Box>
              </Paper>
            </Box>
          </Grid>
        </Grid>
        
      </Container>
    </Box>
    
   
  );
};

export default Cart;