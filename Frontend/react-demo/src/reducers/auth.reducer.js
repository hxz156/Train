import {LOGIN, LOGOUT} from "../actions/auth.action";

export function authReducer(oldstate = false, action) {

    switch (action.type) {
        // isLogin, if it is login, then it is true, if it is logout it is false
        // combine two situation together:
        case LOGIN:
        case LOGOUT:
            return action.payload;
        default:
            return oldstate;
    }
}
