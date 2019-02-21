import React, {Component} from 'react';
import logo from './logo.svg';
import Navbar from './components/Navbar';
import FlatInfo from './components/FlatInfo';
import axios from 'axios'
import {BrowserRouter as Router, Route} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'
import './App.css';


class App extends Component {

    render() {
        return (
            <div className="App">
                <Navbar/>
                <div className="jumbotron">
                    <FlatInfo/>
                </div>
            </div>
        );
    }
}

export default App;
