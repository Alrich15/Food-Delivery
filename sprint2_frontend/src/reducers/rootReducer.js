import { combineReducers } from "redux";
import QuantityReducer from "./quantityReducer";
import LoginReducer from "./loginReducer";


const rootReducer = combineReducers({
  login: LoginReducer,
  quantity : QuantityReducer,
});

export default rootReducer;
