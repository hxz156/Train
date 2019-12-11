import { books as BOOKS } from '../models/books.model';

let books = BOOKS.slice();

export function getBooks(req, res) {
  res.json(books);
}

export function getBook(req, res) {
  const {id} = req.params;
  res.json(books.find((p) => p.id === +id));
}

export function postBooks(req, res) {
  const book = req.body;
  books.push(book);
  res.json({
    success: true
  });
}

export function putBooks(req, res) {
  const book = req.body;
  deleteBook(book.id);
  books.push(book);
  res.json({
    success: true
  });
}

export function deleteBooks(req, res) {
  const {id} = req.params;
  deleteBook(id);
  if(!books.length){
    books = BOOKS.slice();
  }
  res.json({
    success: true
  });
}

function deleteBook(id){
  let index;
  books.forEach((p, i) => {
    if (id === p.id) {
      index = i;
    }
  });
  books.splice(index, 1);
}