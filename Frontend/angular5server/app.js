import express from 'express';
import bodyParser from 'body-parser';
import cors from 'cors';

import {getProducts, getProduct, postProducts, putProducts, deleteProducts} from './controllers/products.controller';
import {postLogin, postRegister} from "./controllers/users.controller";


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

// error handling
app.use((err, req, res, next) => {
  res.json({
    success: false,
    err: err
  })
});

app.listen(process.env.PORT || 3000);
console.log("server started");