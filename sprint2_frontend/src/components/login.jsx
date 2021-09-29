import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { makeStyles } from "@material-ui/core/styles";
import Alert from '@material-ui/lab/Alert';
import {
  TextField,
  Container,
  Typography,
  Select,
  InputLabel,
  FormControl,
  MenuItem,
  Grid,
  Paper,
  Button,
  Box,
} from "@material-ui/core";
import { Link } from "react-router-dom";
import { loginAction } from "../actions/loginAction";

const theme = { spacing: 8 };
const useStyles = makeStyles((theme) => ({
  root: {
    "& > *": {},
  },
}));
const Login = (props) => {

  const [user, setUser] = useState({
    email: "",
    password: "",
    role: "",
  });

  const dispatch = useDispatch();
  const login = useSelector((state) => state.login);
  const classes = useStyles();

  const handleChange = (event) => {
    console.log("HandleChange");
    const usr = { ...user };
    usr[event.target.name] = event.target.value;
    setUser(usr);

    login.errMsg = "";
  
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    
    console.log("Handle submit : ",login.loggedIn);
    dispatch(loginAction(user));

    if (login.loggedIn && login.role == "customer") {
      props.history.push("/restCategory/display");
    }else if(login.loggedIn  && login.role == "admin"){
      props.history.push("/adminpage");
    }
  
  };

  useEffect( () =>{
    if (login.loggedIn  && login.role == "customer") {
      props.history.push("/restCategory/display");
    }else if(login.loggedIn  && login.role == "admin"){
      props.history.push("/adminpage");
    }
  })

  return (
    <Container>
      <Box my={2}>
        <Typography variant="h4">Login</Typography>
      </Box>
      <Grid
        item
        xs={12}
        sm={6}
        style={{ marginLeft: "auto", marginRight: "auto" }}
      >

        {login.errMsg && <Alert severity="error">{login.errMsg}</Alert>}
  
        <Paper elevation={3} style={{ padding: "15px" }}>
          <form
            onSubmit={handleSubmit}
            className={classes.root}
            noValidate
            autoComplete="off"
          >
            <Box mb={3}>
              <TextField
                id="outlined-basic"
                fullWidth
                label="Email"
                type="email"
                variant="outlined"
                name="email"
                value={user.email}
                onChange={handleChange}
              />
            </Box>
            <Box mb={3}>
              <TextField
                id="outlined-password-input"
                label="Password"
                type="password"
                autoComplete="current-password"
                variant="outlined"
                fullWidth
                name="password"
                value={user.password}
                onChange={handleChange}
              />
            </Box>
            <FormControl
              variant="outlined"
              fullWidth
              className={classes.formControl}
            >
              <InputLabel id="demo-simple-select-outlined-label">
                Role
              </InputLabel>
              <Select
                labelId="demo-simple-select-outlined-label"
                id="demo-simple-select-outlined"
                onChange={handleChange}
                name="role"
                value={user.role}
                label="Role"
              >
                <MenuItem value="">
                  <em>None</em>
                </MenuItem>
                <MenuItem value="admin">Admin</MenuItem>
                <MenuItem value="customer">Customer</MenuItem>
              </Select>
            </FormControl>
            <Box mt={3}>
              <Button
                variant="contained"
                color="primary"
                type="submit"
              >
                Login
              </Button>
            </Box>
          </form>

          <Box display="flex" justifyContent="center" className="mt-3">
            Don't have account? &nbsp;  <Link to="/customer/add"> Register Now</Link>
          </Box>

        </Paper>
      </Grid>
    </Container>
  );
};

export default Login;
