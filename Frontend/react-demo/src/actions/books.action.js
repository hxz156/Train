import axios from 'axios';

export const EDIT_BOOK = 'EDIT_BOOK';
export const ADD_BOOK = 'ADD_BOOK';
export const DELETE_BOOK = 'DELETE_BOOK';
export const LOAD_BOOKS = 'LOAD_BOOKS';

export function addBookAC(newBook) {
    return {
        type: ADD_BOOK,
        payload: newBook
    }
}

export function editBookAC(editBook) {
    return {
        type: EDIT_BOOK,
        payload: editBook
    }
}

export function deleteBookAC(deleteBook) {
    return {
        type: DELETE_BOOK,
        payload: deleteBook
    }
}

export function loadBooks() {
    const promise = axios.get('http://localhost:3000/books');
    return {
        type: LOAD_BOOKS,
        payload: promise
    }
}
