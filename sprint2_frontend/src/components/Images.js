
import React, { Component } from 'react';
import axios from 'axios';

class Images extends Component {
    
    constructor(props){
        super(props);
        this.state={
            searchText:props.vegName,
            apiUrl:'https://pixabay.com/api',
            apiKey:'20032355-7215e606bb702628fec265f5a',
            images:[]
        }
    }
    async componentDidMount(){
        this.setState( ()=>{
        axios.get(`${this.state.apiUrl}/?key=${this.state.apiKey}&q=${this.state.searchText}&lang=en&image_type=photo&category=food&safesearch=true`).then(
            res=>this.setState(
             {images:res.data.hits[0]})
            );
        })
        //this.setState({img:this.state.images})
        
 }
  
    render() { 
        return ( 
            <div>
            {console.log(this.state.images)}
            <img src={this.state.images.largeImageURL} style={{width:"240px",height:"200px"}}></img>
            </div>
         );
    }
}
 
export default Images;

