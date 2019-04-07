import React, {Component} from 'react';
import 'jquery'
import 'materialize-css/dist/js/materialize.js'
import 'materialize-css/dist/css/materialize.css'
import './App.css';
import ReallySmoothScroll from 'really-smooth-scroll'
import Welcome from "./components/Welcome";
import {BrowserRouter as Router, Route} from "react-router-dom";
import UserPage from "./components/UserPage"
import auth0 from "auth0-js"
import {Button, Col, Container, Icon, Parallax, Row} from "react-materialize";
import image1 from "./static/opening1.jpg";
import image2 from "./static/opening2.jpg";

ReallySmoothScroll.shim();

class App extends Component {


    constructor(props) {
        super(props);
        this.login = this.login.bind(this);
        this.setSession = this.setSession.bind(this);
        this.logout = this.logout.bind(this);
        this.handleAuthentication = this.handleAuthentication.bind(this);
        this.isAuthenticated = this.isAuthenticated.bind(this);
        this.getAccessToken = this.getAccessToken.bind(this);
        this.getIdToken = this.getIdToken.bind(this);
        this.renewSession = this.renewSession.bind(this);
        this.getIsLoggedIn = this.getIsLoggedIn.bind(this);
        this.render = this.render.bind(this);

        this.state = {
            accessToken:"",
            idToken:"",
            expiresAt:"",
            isLoggedIn:"",
            display: "none",
            auth0 : new auth0.WebAuth({
                domain: 'flat-manager-app.eu.auth0.com',
                clientID: 'gmJqgGK0W08Eu3dbWWkLWNjONvh090LR',
                redirectUri: 'http://localhost:3000/',
                audience: 'https://flatmanager/api',
                responseType: 'token id_token',
                scope: 'openid admin resident landlord'

            })
        }

    }

    login() {
        this.state.auth0.authorize();
        this.handleAuthentication(this.setSession());
    }

    handleAuthentication(callback) {
        try {
            this.state.auth0.parseHash(function(err, authResult){
                if (authResult && authResult.accessToken && authResult.idToken) {
                    window.location.hash = '';
                    callback(authResult);
                } else if (err) {
                    console.log(err);
                    console.log(
                        'Error: ' + err.error + '. Check the console for further details.'
                    );
                    window.location.href = "/home";
                }
            });
        }catch(TypeError){
            console.log("not yet authenticated")
        }
    }

    getAccessToken() {
        return this.state.accessToken;
    }

    getIdToken() {
        return this.state.idToken;
    }

    getIsLoggedIn() {
        return this.state.isLoggedIn;
    }

    setSession(authResult) {
        sessionStorage.setItem('isLoggedIn', 'true');
        this.setState({
            isLoggedIn: true});

        this.setState({
            expiresAt : authResult.expiresIn * 1000 + new Date().getTime()
        });
        this.setState({
            accessToken : authResult.accessToken
        });

        this.setState({
            idToken : authResult.idToken
        });
        sessionStorage.setItem("accessToken",authResult.accessToken);
        sessionStorage.setItem("idToken",authResult.idToken);
        sessionStorage.setItem("display","block");
    }

    renewSession() {
        this.state.auth0.checkSession({}, (err, authResult) => {
            if (authResult && authResult.accessToken && authResult.idToken) {
                this.setSession(authResult);
            } else if (err) {
                this.logout();
                console.log(err);
                alert(`Could not get a new token (${err.error}: ${err.error_description}).`);
            }
        });
    }

    logout() {
        // Remove tokens and expiry time
        this.state.accessToken = null;
        this.state.idToken = null;
        this.state.expiresAt = 0;
        sessionStorage.setItem('isLoggedIn', 'false');
        this.state.isLoggedIn = false;
        sessionStorage.removeItem('accessToken');
        sessionStorage.removeItem('idToken');
        sessionStorage.setItem("display","none");
        document.location.href = 'https://dszendrei.eu.auth0.com/v2/logout?returnTo=http://localhost:3000';
    }

    isAuthenticated() {
        // Check whether the current time is past the
        // access token's expiry time
        let expiresAt = this.state.expiresAt;
        return new Date().getTime() < expiresAt;
    }



    isLoggedIn = ()=>{
        console.log(sessionStorage.getItem("isLoggedIn"));
        return sessionStorage.getItem("isLoggedIn")
    };


    renderHomePage = () =>{
        if (sessionStorage.getItem("isLoggedIn") === "true") {

            return(
                <React.Fragment>
                    <UserPage/>
                </React.Fragment>
            )
        }

        return (
            <React.Fragment>
                <Welcome />
                <div>
                    <Parallax imageSrc={image1}/>
                    <div className="section deep-orange darken-4" id="parallax-scroll2">
                        <Row>
                            <Container>
                                <Row>
                                    <Col s={12}>
                                        <h6 className="white-text">If you got interested in, join our community!</h6>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col s={12}>
                                        <Button waves='light'
                                                className="deep-orange darken-1 more-btn"
                                                onClick={()=>this.login()}
                                        ><Icon left>account_circle</Icon> LOGIN</Button>
                                    </Col>
                                </Row>
                            </Container>
                        </Row>
                    </div>
                    <Parallax imageSrc={image2}/>


                </div>
            </React.Fragment>
        );
    };


    render() {
        return (
            <div className="App">
                <Router>
                    <Route exact path="/" render={props =>(
                        <React.Fragment>
                            {this.renderHomePage()}
                        </React.Fragment>
                    )}>
                    </Route>
                </Router>
            </div>
        );
    }
}

export default App;
