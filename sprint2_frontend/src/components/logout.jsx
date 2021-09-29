import React, { useEffect } from "react";
import { Typography } from "@material-ui/core";
import { logoutAction } from "../actions/loginAction";
import { useSelector, useDispatch } from "react-redux";
import { Redirect } from "react-router-dom";

const Logout = () => {
  const dispatch = useDispatch();
  const login = useSelector((state) => state.login);
  useEffect(() => {
    dispatch(logoutAction(login.email));
  });
  return <Redirect to='/'></Redirect>
};

export default Logout;
