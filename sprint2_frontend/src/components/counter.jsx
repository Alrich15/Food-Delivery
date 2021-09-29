import React, { useState } from "react";
import { Container, Button, Typography } from "@material-ui/core";
import { increment, decrement } from "../actions/quantityAction";
import { useSelector, useDispatch } from "react-redux";

const Counter = () => {
    const dispatch = useDispatch();
    const count = useSelector((state) => state.counter);

     //const [count, setCount] = useState(0);
  //   const handleIncrement = () => {
  //     //setCount(count + 1);
  //   };
  //   const handleDecrement = () => {
  //     //setCount(count - 1);
  //   };

  return (
    <Container style={{ display: "flex" }}>
      <Button
        variant="contained"
        color="primary"
        onClick={() => dispatch(decrement())}
      >
        -
      </Button>
      <Typography variant="h5">Counter: {count} </Typography>
      <Button
        variant="contained"
        color="secondary"
        onClick={() => dispatch(increment())}
      >
        +
      </Button>
    </Container>
  );
};

export default Counter;