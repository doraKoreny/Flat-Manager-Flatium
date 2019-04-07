import React, {Component} from 'react';
import NavigationBar from "./NavigationBar";
import Forum from "./Forum";
import Registration from "./Registration";

class UserPage extends Component {

    componentDidMount() {
        sessionStorage.setItem("accessToken",window.location.hash.replace("#access_token=",""))
    }

    state = {
      firstLogin: "true"
    };

    firstLogin = () => {
        if (this.state.firstLogin === "true") {
            return(
                <React.Fragment>
                    <Registration/>
                </React.Fragment>
            )
        }

        return (
            <React.Fragment>
                <Forum/>
            </React.Fragment>
        )
    };

    render() {
        return (
            <div>
                <NavigationBar/>
                <React.Fragment>
                    {this.firstLogin()}
                </React.Fragment>
            </div>
        );
    }
}

export default UserPage;