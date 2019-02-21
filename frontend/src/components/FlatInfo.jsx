import React, {Component} from 'react';
import PropTypes from "prop-types";
import axios from "axios";

class FlatInfo extends Component {

    state = {
        flats: [],
        bills:[]
    };

    componentDidMount() {
        this.getFlats();
    }

    getFlats = () => {
        axios.get('http://localhost:8080/get-flats')
            .then(response =>{
                this.setState({flats: response.data[0]});
                this.setState({bills: response.data[0].bills[0]});
            });
    };

    render() {
        return (
            <div>
                <div className="header">
                    <h1>Details of my Flat</h1>
                </div>

                <div className="container">
                    <div className="row">
                        <h2 className="col-6">Size of my flat: {this.state.flats.squareMeter}</h2>
                        <h2 className="col-6"><h2>Number of rooms: {this.state.flats.roomNum}</h2></h2>
                    </div>
                </div>

                <div className="bills">
                    <h2>Bills:</h2>
                </div>

                <div className="container">
                    <div className="row">
                        <div className="col-4">BillType</div>
                        <div className="col-4">Price</div>
                        <div className="col-4">Is paid?</div>
                    </div>
                    <div className="row">
                        <div className="col-4">{this.state.bills.billType}</div>
                        <div className="col-4">{this.state.bills.price}</div>
                        <div className="col-4">{this.state.bills.paid===true?"yes":"no"}</div>
                    </div>
                </div>

            </div>
        );
    }
}

export default FlatInfo