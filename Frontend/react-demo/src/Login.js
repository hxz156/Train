import React from 'react';
import {connect} from "react-redux";
import {login} from "./actions/auth.action";
class Login extends React.Component {

    handleClick = () => {
        this.props.login();
    }

    render() {
        return (
            <div className="container">
                <h2>Login</h2>
                <p>Current login status: {this.props.isLoggedIn + ''}</p>
                <p>
                    <button className="btn btn-primary" onClick={this.handleClick}>Login</button>
                </p>
            </div>
        );
    }

}
function mapStateToProps({isLoggedIn}) {
    return {isLoggedIn};
}
export default connect(mapStateToProps, {login})(Login);
