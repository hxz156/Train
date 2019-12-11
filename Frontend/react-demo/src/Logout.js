import React from 'react';
import {connect} from "react-redux";
import {logout} from "./actions/auth.action";
class Logout extends React.Component {

    handleClick = () => {
        this.props.logout();
    }

    render() {
        return (
            <div className="container">
                <h2>Logout</h2>
                <p>Current login status: {this.props.isLoggedIn + ''}</p>
                <p>
                    <button className="btn btn-primary" onClick={this.handleClick}>Logout</button>
                </p>
            </div>
        );
    }

}
function mapStateToProps({isLoggedIn}) {
    return {isLoggedIn};
}
export default connect(mapStateToProps, {logout})(Logout);
