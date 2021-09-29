import axios from "axios";

export const loginAction = (user) => (dispatch) => {
  axios
    .post("http://localhost:8081/login", user)
    .then((res) =>
      dispatch({
        type: "LOGIN",
        payload: res.data,
      }),
    )
      
};

export const logoutAction = (email) => async (dispatch) => {
  const result = await axios.patch(`http://localhost:8081/logout/${email}`);
  console.log(result);
  console.log(result.data);
  dispatch({
    type: "LOGOUT",
    payload: result.data,
  });
};
