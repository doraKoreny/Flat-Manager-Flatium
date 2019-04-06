import React, {Component} from 'react';
import PropTypes from "prop-types";
import axios from "axios";

class FlatInfo extends Component {

    state = {
        flats: [],
        bills: []
    };

    componentDidMount() {
        this.getFlats();
    }

    getFlats = () => {
        axios.get('http://localhost:8080/get-flats')
            .then(response => {
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
                    <div className="row details">
                        <div className="col-6">
                            <h2>Size of my flat: {this.state.flats.squareMeter}</h2>
                        </div>
                        <div className="col-6">
                            <h2>Number of rooms: {this.state.flats.roomNum}</h2>
                        </div>
                    </div>
                </div>

                <div className="container">
                    <div className="row">
                        <div className="bills col-12">
                            <h3>Bills:</h3>
                        </div>
                    </div>
                    <div className="row bill">
                        <div className="col-4">BillType</div>
                        <div className="col-4">Price</div>
                        <div className="col-4">Is paid?</div>
                    </div>
                    <div className="row bill lastbill">
                        <div className="col-4">{this.state.bills.billType}</div>
                        <div className="col-4">{this.state.bills.price}</div>
                        <div className="col-4">{this.state.bills.paid === true ? "yes" : "no"}</div>
                    </div>
                </div>

            </div>
        );
    }
}

export default FlatInfo
