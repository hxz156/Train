import React from 'react';
import {connect} from "react-redux";

// High Order Component (hoc)High Order Component (hoc)
// auth(ExistingComponent)
// ExistingComponent -> ExistingComponent with route protection
// auth 只能写成 function
export default function auth(ExistingComponent) {

    class WrapperComponent extends React.Component {

        // getDerivedStateFromProps execute before render, React function:
        // function execute whenever props changes
        static getDerivedStateFromProps(props) {
            // static 里面不用 this, 因为没有 instance. but this should point to instance.
            if (!props.isLoggedIn) {
                // if user does not login, re-direct to login.
                props.history.push('/login');
            }
            return null;
        }

    // {...this.props}: 把 parent 的 props 里面的所有都传递下去，因为这一层是自己添加的。
    // {...this.props}: spread
        render() {
            return <ExistingComponent {...this.props}/>
        }
    }

    // 为了拿到 props 里面的 isLoggedIn:
    function mapStateToProps({isLoggedIn}){
        return {isLoggedIn};
    }

    return connect(mapStateToProps)(WrapperComponent);
}
