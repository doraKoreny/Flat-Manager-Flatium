import React, {Component} from 'react';
import axios from "axios";

class ForumPosts extends Component {

    componentDidMount() {
        this.getPosts()
    };

    state = {
        forumPosts:[]
    };

    getPosts = () =>{
        axios.get("http://localhost:8080/get-comments")
            .then(response =>{
                this.setState({forumPosts:response.data});
            });
    };

    render() {
        return this.state.forumPosts.map((forumPost,index)=>(
            <div key={index} className="container">
                <div className="row contact">
                    <div className="col-6">
                        {forumPost.message}
                    </div>
                    <div className="col-6">
                        {forumPost.timeStamp}
                    </div>
                </div>
            </div>
        ))
        ;
    }
}

export default ForumPosts;
