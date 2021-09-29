import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Popover from '@material-ui/core/Popover';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import { ListItem, List, FormGroup,FormControlLabel, Checkbox } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  typography: {
    padding: theme.spacing(2),
  },
}));

export default function FilterPopover(props) {
  
  const selectedCat = [];

  const [anchorEl, setAnchorEl] = React.useState(null);

  console.log("Categories : ",props.itemCategory);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleChange = (event) =>{
    console.log(" Event ",event.currentTarget.name);
    selectedCat.push(event.currentTarget.name);
  }
  
  const handleClose = () => {
    setAnchorEl(null);
    props.onSelection(selectedCat);
  };

  const open = Boolean(anchorEl);
  const id = open ? 'simple-popover' : undefined;

  return (
    <>
      <Button className="my-auto me-3" color="primary" onClick={handleClick}>
        Filters
      </Button>
      <Popover
        id={id}
        open={open}
        anchorEl={anchorEl}
        onClose={handleClose}
        anchorOrigin={{
          vertical: 'bottom',
          horizontal: 'center',
        }}
        transformOrigin={{
          vertical: 'top',
          horizontal: 'center',
        }}
      >
        
      <List row>
        <FormGroup className="p-3">
        { props.itemCategory.map( (itemCat) =>
        
        <FormControlLabel
          control={
            <Checkbox
              onChange={handleChange}
              name={itemCat}
              color="primary"
            />
          }
          label={itemCat}
        />
        )}     

        </FormGroup>
      </List>

      </Popover>
    </>
  );
}
