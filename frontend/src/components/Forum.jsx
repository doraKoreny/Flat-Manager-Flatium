import React, {Component} from 'react';
import axios from "axios";
import ForumPosts from "./ForumPosts"

class Forum extends Component {
    state ={
        postMessage:""
    };

    onChange = (e) => this.setState({ postMessage: e.target.value});

    onSubmit = (e) =>{
        e.preventDefault();
        this.submitPost();
    };

    submitPost = () => {
        axios.post('http://localhost:8080/add-comment',{
            "flatUserId":0,
            "message":this.state.postMessage
        })
            .then(response => {
                console.log(response);
                this.setState({postMessage:""})
            });
    };

    render() {
        return (
            <div>
                <div className="header">
                    <h1>Forum</h1>
                </div>
                <form onSubmit={this.onSubmit}>
                    <div className="form-group">
                        <div className="container">
                            <div className="row">
                                <div className="col-10">
                                    <input className="form-control input-lg"
                                           id="inputlg"
                                           type="text"
                                           placeholder="Enter your forum post here..."
                                           value={this.state.postMessage}
                                           onChange={this.onChange}
                                    />
                                </div>
                                <div className="col-2">
                                    <button className="btn btn-lg btn-block btn-dark">POST</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <div className="container">
                    <div className="row contactsheader">
                        <div className="col-6">Message</div>
                        <div className="col-6">Time</div>
                    </div>
                </div>
                <ForumPosts/>
            </div>
        );
    }
}

export default Forum;
