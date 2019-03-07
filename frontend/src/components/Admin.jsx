import React, {Component} from 'react';
import PropTypes from 'prop-types';
import axios from "axios"

export class Admin extends Component {
    state = {
        building: ''
    };

    onChange = (e) => this.setState({[e.target.name]: e.target.value});

    onSubmit = (e) => {
        e.preventDefault();
        this.submitPost();
    };

    submitPost = () => {
        axios.post('http://localhost:8080/create-building',{
            "commonCost":5000,
            "residentalMeetupDate":"2020-12-12",
            "grabageCollectionDay":"MONDAY"
        })
            .then(response => {
                console.log(response);
                this.setState({building:""})
            });
    };


    render() {
        return (
            <div>
                <h1>Admin page</h1>
                <form onSubmit={this.onSubmit} style={{display: 'flex'}}>
                    <input
                        type="text"
                        name="building"
                        style={{flex: '10', padding: '5px'}}
                        placeholder="Add Building"
                        value={this.state.building}
                        onChange={this.onChange}
                    />
                    <input type="submit"
                           value="New building"
                           className="btn"
                           style={{flex: '1'}}
                    />

                </form>
            </div>
        );
    }
}

Admin.propTypes = {
    addBuilding: PropTypes.func.isRequired
}


export default Admin;