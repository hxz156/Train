import express from 'express';
import bodyParser from 'body-parser';
import cors from 'cors';

import {getProducts, getProduct, postProducts, putProducts, deleteProducts} from './controllers/products.controller';
import {postLogin, postRegister} from "./controllers/users.controller";
import {getBooks, getBook, postBooks, putBooks, deleteBooks} from './controllers/books.controller';


const app = express();

app.use(cors());
app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

app.post('/login', postLogin);
app.post('/register', postRegister);


app.get('/products', getProducts);
app.get('/products/:name', getProduct);
app.post('/products', postProducts);
app.put('/products', putProducts);
app.delete('/products/:name', deleteProducts);

app.get('/books', getBooks);
app.get('/books/:id', getBook);
app.post('/books', postBooks);
app.put('/books/:id', putBooks);
app.delete('/books/:id', deleteBooks);

// error handling
app.use((err, req, res, next) => {
  res.json({
    success: false,
    err: err
  })
});

app.listen(process.env.PORT || 3000);
console.log("server started");