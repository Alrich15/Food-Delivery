const quantity=1;

//const CountReducer = (state,action) =>{};
const QuantityReducer = (state = quantity, action) => {
    switch( action.type){
        case "INCREMENT":
            return state + 1;
        case "DECREMENT":
            return state - 1;
        default:
            return state;
    }
};

export default QuantityReducer;