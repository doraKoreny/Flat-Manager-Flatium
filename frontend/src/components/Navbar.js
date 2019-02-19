import React, {Component} from 'react';


class Navbar extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
                            </li>
                            <li className="nav-item active">
                                <a className="nav-link" href="#">Community Info</a>
                            </li>
                            <li className="nav-item active">
                                <a className="nav-link" href="#">Contact Page</a>
                            </li>
                            <li className="nav-item active">
                                <a className="nav-link" href="#">My Flat</a>
                            </li>
                        </ul>
                        <form className="form-inline my-2 my-lg-0">
                            <input className="form-control mr-sm-2" type="search" placeholder="Search"
                                   aria-label="Search">
                            </input>
                            <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </nav>
            </div>
        );
    }
}

export default Navbar;