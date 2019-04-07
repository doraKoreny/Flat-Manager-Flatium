import React, {Component} from 'react';
import axios from "axios";
import {Row,Input,Col,Button,Card,Icon} from 'react-materialize'

class Registration extends Component {
    state = {
        name:"",
        birthDate:"",
        phoneNumber:"",
        email:"",
        flatRoomNumber:"",
        flatSquareMeter:"",
        buildingIdentifier:""
    };

    handleNameChange = (e) => {this.setState({name: e.target.value})};
    handleBirthDateChange = (e) => {this.setState({birthDate: e.target.value})};
    handlePhoneNumberChange = (e) => {this.setState({phoneNumber: e.target.value})};
    handleEmailChange = (e) => {this.setState({email: e.target.value})};
    handleFlatRoomNumber = (e) => {this.setState({flatRoomNumber: e.target.value})};
    handleFlatSquareMeterChange = (e) => {this.setState({flatSquareMeter: e.target.value})};
    handleBuildingIdentifierChange = (e) => {this.setState({buildingIdentifier: e.target.value})};

    onSubmit = (e) => {
        e.preventDefault();
        this.submitForm();
    };

    submitForm = () => {
        const headers = {'Authorization':`Bearer ${sessionStorage.getItem("accessToken")}`};
        axios.post('http://192.168.163.71:8080/create-flatuser',
            {
                "name":this.state.name,
                "birthDate":this.state.birthDate,
                "phoneNumber":this.state.phoneNumber,
                "email":this.state.email,
            },
            headers)
            .then(response => {
                console.log(response);
                this.setState({name:"",
                    birthDate:"",
                    phoneNumber:"",
                    email:"",
                    flatRoomNumber:"",
                    flatSquareMeter:"",
                    buildingIdentifier:""}
                )
            });
        axios.post("http://192.168.163.71.8080/create-flat",
            {
                "squareMeter":this.state.squareMeter,
                "roomNum":this.state.roomNum
            })
    };

    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit}>
                    <Card className='deep-orange darken-2 card-registration card-header'>
                        <span className="card-title white-text text-darken-4">Registration</span>
                        <Input type='text'
                               label='Name'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.name}
                               onChange={this.handleNameChange}
                        ><Icon>mode_edit</Icon>
                        </Input>
                        <Input type='text'
                               label='Birth Date'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.birthDate}
                               onChange={this.handleBirthDateChange}
                        ><Icon>mode_edit</Icon>
                        </Input>
                        <Input type='text'
                               label='Phone Number'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.phoneNumber}
                               onChange={this.handlePhoneNumberChange}
                        ><Icon>mode_edit</Icon>
                        </Input>
                        <Input type='text'
                               label='Email'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.email}
                               onChange={this.handleEmailChange}
                        ><Icon>mode_edit</Icon>
                        </Input>
                        <Input type='text'
                               label='Flat Square Meter'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.flatSquareMeter}
                               onChange={this.handleFlatSquareMeterChange}
                        ><Icon>mode_edit</Icon>
                        </Input>
                        <Input type='text'
                               label='Flat Room Number'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.flatRoomNumber}
                               onChange={this.handleFlatRoomNumber}
                        ><Icon>mode_edit</Icon>
                        </Input>
                        <Input type='text'
                               label='Building Identifier'
                               className="text-lighten-1 grey lighten-1"
                               value={this.state.buildingIdentifier}
                               onChange={this.handleBuildingIdentifierChange}
                        ><Icon>mode_edit</Icon>
                        </Input>


                        <div className="to-the-right">
                            <Button waves='orange'
                                    className="white black-text"
                                    onClick = {()=>console.log("registration")}>SUBMIT</Button>
                        </div>
                    </Card>
                </form>
            </div>
        );
    }
}

export default Registration;