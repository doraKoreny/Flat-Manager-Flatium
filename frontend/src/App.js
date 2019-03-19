import React, {Component} from 'react';
import Navbar from './components/Navbar';
import FlatInfo from './components/FlatInfo';
import axios from 'axios'
import {BrowserRouter as Router, Route} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'
import './App.css';
import ComInfo from "./components/ComInfo";
import ContactInfo from "./components/ContactInfo";
import Forum from "./components/Forum";
import Admin from "./components/Admin";
import { Jumbotron } from "mdbreact";


class App extends Component {
    state = {
        building: []
    }

    addBuilding = (building) => {
        axios.post('http://localhost:3001/admin', {
            building
        })
            .then(response => this.setState({building: [...this.state.building, response.data]}));
    }

    render() {
        return (
            <Router>
                <div className="App">
                    <Route path="/" component={Navbar}/>
                    <Route path="/myflat" render={props =>(
                        <React.Fragment>
                            <div className="jumbotron">
                                <FlatInfo/>
                            </div>
                        </React.Fragment>
                    )}/>
                    <Route path="/admin" render={props =>(
                        <Jumbotron>
                            <React.Fragment>
                                <Admin />
                            </React.Fragment>
                        </Jumbotron>
                    )}/>
                    <Route path="/cominfo" render={props =>(
                        <React.Fragment>
                            <div className="jumbotron">
                                <ComInfo/>
                            </div>
                        </React.Fragment>
                    )}/>
                    <Route path="/contacts" render={props =>(
                        <React.Fragment>
                            <div className="jumbotron">
                                <ContactInfo/>
                            </div>
                        </React.Fragment>
                    )}/>
                    <Route path="/forum" render={props =>(
                        <React.Fragment>
                            <div className="jumbotron">
                                <Forum/>
                            </div>
                        </React.Fragment>
                    )}/>

                </div>
            </Router>
        );
    }
}

export default App;
