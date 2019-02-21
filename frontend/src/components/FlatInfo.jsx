import React, {Component} from 'react';
import PropTypes from "prop-types";
import axios from "axios";

class FlatInfo extends Component {

    state = {
        flats: []
    };

    getFlats = () => {
        axios.get('http://localhost:8080/get-flats')
            .then(response => this.setState({flats: response.data}));
    };

    render() {
        return (
            <div>
                <button onClick={() => this.getFlats()} type={"button"} className={<button></button>}>Click</button>
                <button onClick={() => console.log(this.state.flats)} type={"button"}
                        className={<button></button>}>LogFlats
                </button>
                <div className="jumbotron">
                    <h1 className="display-4">Hello, flatters!</h1>
                    <p className="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra
                        attention to featured content or information.</p>
                    <hr className="my-4"/>
                    <div>
                        <h1>{this.state.flats.length}</h1>
                    </div>
                </div>
            </div>
        );
    }
}

export default FlatInfo