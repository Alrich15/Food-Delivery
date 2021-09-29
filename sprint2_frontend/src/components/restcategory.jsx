import React, { useEffect, useState } from "react";
import {
  Grid,
  Paper,
  Box,
  Container,
  Drawer,
  List,
  ListItem,
  ListItemText,
} from "@material-ui/core";
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardActionArea from "@material-ui/core/CardActionArea";
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import { red } from '@material-ui/core/colors';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import RestaurantCategoryService from '../services/RestaurantCategoryService';
import { Redirect, useHistory } from "react-router-dom";
import Images from './Images.js'


const useStyles = makeStyles({
  root: {
    maxWidth: 250,
  },
  media: {
    height: 180,
    padding:10,
    margin:10
  },
});
const RestCategory = () => {
  const [restCats, setRestCats] = useState([]);
  useEffect(() => {
    RestaurantCategoryService.getRestaurantCategory().then((res) => {
      setRestCats(res.data);
    console.log(restCats)
    });
  },[]);
  const history = useHistory();
const handleSubmit=(id)=>{
    console.log("hi");
   history.push("/restaurant/display/"+id)
  };

  const classes = useStyles();
return (
  
<Container style={{ marginTop:"30px" }}>

<Grid item sm={16}>
<Grid container spacing={3} >
{restCats.map((res)=>(
  <Grid item xs={6} sm={3} >
      <Card
                style={{
                  margin: "10px",
                  height: "250px",
              
                }}
              >
<CardActionArea>
<CardMedia
                     className={classes.media}
                   
                    
                    
                  ><Images vegName={res.restaurantCategoryName}></Images>
</CardMedia>
                  <CardContent>
                    <Box textAlign="left">
                      <Typography gutterBottom  onClick={()=>handleSubmit(res.restaurantCategoryId)} variant="subtitle2" style={{marginTop:16,fontFamily:"sans-serif",textAlign:"center"}}>
                        <b>{res.restaurantCategoryName}</b>
                      </Typography>
                    </Box>
             
                  </CardContent>

</CardActionArea>


              </Card>
  </Grid>

))}
</Grid>
</Grid>

</Container>

);
}
export default RestCategory;