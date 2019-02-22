import React, {Component} from 'react';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'
import {Link} from 'react-router-dom'

class Navbar extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <div className="container">
                            <div className="row">
                                <div className="col-6">
                                    <div className="nav-link logo">Flatium Flat Manager</div>
                                </div>
                                <div className="col-6">
                                    <ul className="navbar-nav mr-auto">
                                        <li className="nav-item active">
                                            <Link to="/" className="nav-link">Home <span
                                                className="sr-only">(current)</span></Link>
                                        </li>
                                        <li className="nav-item active">
                                            <Link to="/cominfo" className="nav-link">Community Info</Link>
                                        </li>
                                        <li className="nav-item active">
                                            <Link to="/contacts" className="nav-link">Contact Page</Link>
                                        </li>
                                        <li className="nav-item active">
                                            <Link to="/myflat" className="nav-link">My Flat</Link>
                                        </li>
                                        <li className="nav-item active">
                                            <Link to="/forum" className="nav-link">Forum</Link>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </nav>
            </div>
        );
    }
}

export default Navbar;
