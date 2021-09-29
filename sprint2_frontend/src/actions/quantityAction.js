
//incr action, returns obj
export const increment= ( ) =>{
    return{
        type:"INCREMENT",
    };
};


//decrement action
export const decrement= () =>{
    return{
        type: "DECREMENT",
        payload: 1,
    };
};