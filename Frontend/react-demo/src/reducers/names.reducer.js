
// 想要改变 store 里面的数据，必须通过 reducer 操作，所以怎么改变都是在 reducer 里面写。
// oldState = ['Bob', 'Alex', 'Alice'] -> initial state
// 如果没有 parameter 进来，这个就是 default parameter.
export function namesReducer(oldState = ['Bob', 'Alex', 'Alice', 'Josh'], action) {
    // action: {type: 'ADD/EDIT/DELETE', payload: 'TOM'}
    switch(action.type) {
        case 'ADD_NAME':
            const newName = action.payload;
            return [...oldState, newName];
        case 'EDIT_NAME':
            return oldState;
        case 'DELETE_NAME':
            return oldState;
        default:
            return oldState;
    }
    // action.payload: 携带新数据，如果有新数据，那么这个就会执行。
    // action: {type: 'ADD/EDIT/DELETE', payload: 'TOM'}
    // if (action.payload) {
    //     const newName = action.payload;
    //     return [...oldState, newName];
    // } else {
    //     return oldState;
    // }

}













