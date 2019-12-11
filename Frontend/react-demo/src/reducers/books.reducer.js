import {ADD_BOOK, DELETE_BOOK, EDIT_BOOK, LOAD_BOOKS} from "../actions/books.action";

export function booksReducer (oldState=[], action){
    switch (action.type) {
        case ADD_BOOK:
            return [action.payload, ...oldState];
        case EDIT_BOOK:
            let index = oldState.findIndex((book) => {
                return action.payload.id === book.id
            });
            if (index !== -1) {
                oldState.splice(index, 1, action.payload);
            }
            return oldState;
        case DELETE_BOOK:
            let i = oldState.findIndex((book) => {
                return action.payload.id === book.id;
            });
            if (i != -1) {
                // delete the book on the i
                oldState.splice(index, 1);
            }
        case LOAD_BOOKS:
            return action.payload.data;
        default:
            return oldState;
    }
}
