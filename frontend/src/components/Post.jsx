import React, {Component} from 'react';
import {Card,Row,Col} from 'react-materialize'
import PropTypes from 'prop-types'

class Post extends Component {
    render() {
        return (
            <div>
                <Card className='deep-orange darken-2 card-forum' textClassName='white-text' data-aos="fade-up">
                    <div className="to-the-left">
                        <div className="user-name">
                            {this.props.userName}
                        </div>
                        <Card className="deep-orange lighten-3 card-post" textClassName="white-text">
                            <div className="message">
                                {this.props.message}
                            </div>
                        </Card>
                    </div>
                    <div className="to-the-right">
                        <div className="date">
                            {this.props.date}
                        </div>
                    </div>
                </Card>
            </div>
        );
    }
}

Post.propTypes = {
    userName: PropTypes.object.isRequired,
    date: PropTypes.object.isRequired,
    message: PropTypes.object.isRequired
};

export default Post;