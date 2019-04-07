import React, {Component} from 'react';
import video from "../video/background.mp4";
import {Button, Card, Col, Parallax, Row, Container} from "react-materialize";

class Welcome extends Component {

    componentWillMount() {
        console.log(document.getElementById("parallox-scroll"));
        console.log(document.getElementById("parallox-scroll1"));
    }

    offset = (el) => {
        var rect = el.getBoundingClientRect(),
            scrollLeft = window.pageXOffset || document.documentElement.scrollLeft,
            scrollTop = window.pageYOffset || document.documentElement.scrollTop;
        let y = rect.top + scrollTop;

        return y;
    };

    scrollTo = (el) => {
        window.scrollTo(0, this.offset(el));
    };

    render() {
        return (
            <div>

                <header className="v-header container">
                    <div className="fullscreen-video-wrap">
                        <video
                            src={video}
                            autoPlay="true" loop="true" muted="true">
                        </video>
                    </div>
                    <Container>
                        <Row className="center-align">
                            <Card className="transparent" textClassName='white-text'>
                                <div className="page-header">
                                    <h1>Flat Manager</h1>
                                </div>
                                <Row>
                                    <Button
                                        onClick={() => this.scrollTo(document.getElementById("parallax-scroll"))}
                                        waves='light'
                                        className="home-btn deep-orange darken-4">LEARN MORE</Button>
                                </Row>
                                <Row>
                                    <Button
                                        onClick={() => this.scrollTo(document.getElementById("parallax-scroll2"))}
                                        waves='light'
                                        className="home-btn deep-orange darken-4">TO THE LOGIN</Button>
                                </Row>
                            </Card>
                        </Row>
                    </Container>

                </header>


                <div className="section deep-orange darken-4" id="parallax-scroll">
                        <Container>
                            <Row>
                                <Col s={12}>
                                    <h6 className="white-text">
                                        <div>
                                            Are you a landlord? Would you like to manage your building online?
                                            Or are you living in a building which is already joined to this Flatium FlatManager Application?
                                            Wanna manage the stuff around your flat online?
                                            Would you like to paycheck your bills or share information with your neighbours?
                                            Or you just want to be updated about the latest news of your building?
                                            Then this is probably for you!
                                        </div>

                                    </h6>
                                </Col>
                            </Row>
                            <Row>
                                <Col s={12}>
                                    <Button onClick={() => this.scrollTo(document.getElementById("parallax-scroll2"))}
                                            waves='light'
                                            className="deep-orange darken-1 more-btn">GO TO LOGIN</Button>
                                </Col>
                            </Row>
                        </Container>
                </div>

            </div>
        );
    }

}

export default Welcome;