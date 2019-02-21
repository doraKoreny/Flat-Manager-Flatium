import React, {Component} from 'react';
import PropTypes from "prop-types";
import axios from "axios";

class FlatInfo extends Component {

    state = {
        flats:[]
    };

    getFlats = () => {
        axios.get('http://localhost:8080/get-flats')
            .then(response => this.setState({flats: response.data}));
    };

    render() {
        return (
            <div>
                <button onClick={()=>this.getFlats()} type={"button"}>Click</button>
                <button onClick={()=>console.log(this.state.flats)} type={"button"}>LogFlats</button>
            </div>
        );
    }
}

export default FlatInfo