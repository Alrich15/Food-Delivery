import React, { useEffect, useState } from 'react';
import Container from '@material-ui/core/Container';
import Box from '@material-ui/core/Box';
import Grid from '@material-ui/core/Grid';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';
import { makeStyles } from '@material-ui/core/styles';
import FoodItemService from '../services/FoodItemService';
import { Link } from 'react-router-dom';

import ItemCategoryService from '../services/ItemCategoryService';

const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
      margin : '5px',
    },
    paper: {
      padding: theme.spacing(2),
      textAlign: 'center',
      color: theme.palette.text.secondary,
      
    },
    cardroot: {
      maxWidth: 345,
    },
}));


const FoodItem = (props) => {

    const classes = useStyles();

    //const location = useLocation();
    const receivedId = props.location.state.restId;
    const receivedName = props.location.state.restName;

    const[items, setItems] = useState([]);
    const[itemCategory, setItemCategory] = useState([]);
    const selectedCategory = [];
    const allCategories = [];


    useEffect( () => {
        FoodItemService.getItemsByRestId(receivedId).then( (response) =>{
            setItems(response.data);;
            
        });

        ItemCategoryService.getItemCategories().then( (response) =>{
            setItemCategory(response.data);
        });
        
    }, []);

    
    const handleSelection = (selectedValues) => {
        selectedCategory.push(selectedValues);    
        console.log("Categories After ",selectedCategory);
    }

    const handleChangeAscending = (id) => {
        FoodItemService.getItemsByRestIdAndSortedByPriceAscending(id).then( (response) =>{
            setItems(response.data)
        });
    }

    const handleChangeDescending = (id) => {
        FoodItemService.getItemsByRestIdAndSortedByPriceDescending(id).then( (response) =>{
            setItems(response.data)
        });
    }


    
    return ( 
        <Container className="border border-dark mt-3">
            <Paper elevation={3} className="border border-dark mt-3" >

            <Box display="flex" justifyContent="flex-end">
                <h6 style={{marginRight:"auto", marginTop:"auto", marginBottom:"auto",marginLeft:"10px"}}>
                {receivedName}  Restaurant
                </h6>
                <Button size="small" textAlign="center">
                    <p className="my-auto mx-3" onClick={handleChangeAscending.bind(this,receivedId)}>Cost: Low to High</p>
                </Button>
                <Button size="small">
                    <p className="my-auto mx-3" onClick={handleChangeDescending.bind(this,receivedId)}>Cost: High to Low</p>
                </Button>
                
                {/*
                <FilterPopover className="mx-3 my-auto" itemCategory ={allCategories} />
                    */}
            </Box>
    
            </Paper>
            
            <Grid container spacing={2} className="mt-1">

                <Grid item>
                    <Paper className={classes.paper}>
                    
                    <Grid container spacing={2}>

                    {items.map( (item) => 
                    
                    
                    <Grid item>
                        <Card className={classes.cardroot}>
                            <Link to={`/byId/${item.itemId}`} style={{textDecoration:'none', color:'black'}}>
                                <CardActionArea>
                                   <CardMedia
                                    component="img"
                                    alt={item.itemName}
                                    height="140"
                                    image={item.image}
                                    title={item.itemName}
                                   /> 
                                   
                                <CardContent>
                                    <Box textAlign="left">
                                        <Typography component="p">
                                            {item.itemName}
                                        </Typography>
                                        <small>{item.itemCategory.itemCategoryName}</small>
                                    </Box>
                                    <Box display="flex" justifyContent="flex-end" textAlign="right">
                                        <Typography style={{fontSize:"16px"}} component="p" className="mx-1">
                                            ₹
                                            {
                                                item.cost - ((item.cost*20)/100)
                                            }
                                        </Typography>
                                        <Typography style={{fontSize:"14px"}} component="p" className="mx-1">
                                            ₹
                                            <s>
                                            {
                                                item.cost
                                            }</s>
                                        </Typography>
                                        <Typography style={{fontSize:"15px"}} component="p" className="mx-1">
                                            20% off
                                        </Typography>
                                    </Box>
            
                                </CardContent>
                                </CardActionArea>
                            </Link>

                            <CardActions>
                            {/* <Link to="/bill/payment">
                                <Button size="small" variant="outlined" color="primary">
                                    Order now
                                </Button>
                            </Link> */}
                            <Link to={`/byId/${item.itemId}`}>
                                <Button size="small" variant="outlined" color="primary">
                                    Details
                                </Button>
                            </Link>
                            </CardActions>
                        </Card>
                    </Grid>
                    
                    )}

                    </Grid>

                    </Paper>
                </Grid>

                

                    
            </Grid>

        </Container>
    );
}
 
export default FoodItem;