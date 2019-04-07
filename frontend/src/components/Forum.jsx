import React, {Component} from 'react';
import {Row,Input,Col,Button,Card,Icon} from 'react-materialize'
import AOS from 'aos';
import Post from "./Post";

class Forum extends Component {

    componentDidMount() {
        AOS.init();
    }

    state = {
      message:""
    };


    onChange = (e) => this.setState({ message: e.target.value});

    render() {
        return (
            <div>
                    <Card className='deep-orange darken-2 card-forum card-header'
                          data-aos="fade-up">

                        <span className="card-title white-text text-darken-4">Forum</span>

                        <Input type='textarea'
                               className="text-lighten-1 grey lighten-1"
                                value={this.state.message}
                               onChange={this.onChange}
                        >
                            <Icon>mode_edit</Icon>
                        </Input>
                        <div className="to-the-right">
                            <Button waves='orange'
                                    className="white black-text"
                                    onClick = {()=>console.log("test")}>SUBMIT</Button>
                        </div>
                    </Card>

                <Post userName="Kis Pista"
                      date="2015-02-03"
                      message="első"/>

            </div>
        );
    }
}

export default Forum;