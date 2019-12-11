export const LOGIN = 'LOGIN';
export const LOGOUT = 'LOGOUT';

// 方法名字小写： login()
export function login() {
    return {
        type: LOGIN,
        payload: true
    };
}

export function logout() {
    return {
        type: LOGOUT,
        payload: false
    };
}
