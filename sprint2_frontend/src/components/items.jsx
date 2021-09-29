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
  ImageList ,
  ImageListItem ,
  ImageListItemBar ,
  IconButton ,
  StarBorderIcon ,

} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import ItemService from "../services/ItemService";
import { Link } from "react-router-dom";
const useStyles = makeStyles({
  root: {
    maxWidth: 250,
  },
  media: {
    height: 140,
  },
});


const Item = () => {
  const [items, setItems] = useState([]);
  useEffect(() => {
    ItemService.getItems().then((res) => {
      setItems(res.data);
    });
  });
  const classes = useStyles();
  return (
    <Container style={{ marginTop: "30px" }}>
      <Grid container spacing={3}>
        {/* <Grid item sm={2} style={{ border: "1px solid green" }}>
          <List>
            {[
              "Chinese",
              "Indian",
              "Italian",
              "Contiental",
            ].map((text, index) => (
              <ListItem button key={text}>
                <ListItemText primary={text} />
              </ListItem>
            ))}
          </List>
        </Grid> */}
        <Grid item sm={12}>
          <Grid container spacing={3}>
            {items.map((item) => (
              <Grid item xs={12} sm={6} md={4} lg={3}>
                 <Link to={`/byId/${item.itemId}`}>
                <Card
                  style={{
                    margin: "10px",
                    height: "250px",
                  }}
                >
                  <CardActionArea>
                    <CardMedia
                       className={classes.media}
                      // image={item.itemImage}
                      image="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTV123YSWK7TAjzSHz7W3IWSiZl5Y5MTwSEKw&usqp=CAU"
                      title={item.itemName}
                    />
                    <CardContent>
                      <Box textAlign="left">
                        <Typography gutterBottom variant="subtitle2">
                          {item.itemName}
                        </Typography>
                      </Box>
                      <Box textAlign="right">
                        <Typography>INR.{item.cost}</Typography>
                      </Box>
                    </CardContent>
                  </CardActionArea>
                </Card>
                </Link>
              </Grid>
            ))}
          </Grid>
        </Grid>
      </Grid>

    
    </Container>
  );
};

export default Item;