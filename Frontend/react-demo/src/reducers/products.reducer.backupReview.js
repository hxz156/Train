// 把字符串换成变量，防止输错字符串找不出 bug.
import {ADD_PRODUCT, EDIT_PRODUCT} from "../actions/products.action";


export function productsReducer(
    oldProducts = [
        { name: 'iPhone', brand: 'Apple', price: 100, stock: 22, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone.jpg' },
        { name: 'iPhone3G', brand: 'Apple', price: 200, stock: 33, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone3G.jpg' },
        { name: 'iPhone3GS', brand: 'Apple', price: 300, stock: 11, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone3GS.jpg' },
        { name: 'iPhone4', brand: 'Apple', price: 400, stock: 22, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone4.jpg' },
        { name: 'iPhone4S', brand: 'Apple', price: 500, stock: 33, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone4S.jpg' },
        { name: 'iPhone5', brand: 'Apple', price: 600, stock: 11, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone5.jpeg' },
        { name: 'iPhone5C', brand: 'Apple', price: 700, stock: 222, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone5c.png' },
        { name: 'iPhone5S', brand: 'Apple', price: 800, stock: 333, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone5s.jpg' },
        { name: 'iPhone6', brand: 'Apple', price: 900, stock: 111, image: 'https://s3.us-east-2.amazonaws.com/msi-tech-2019/iphone6.jpg' },
    ],
    action) {

    switch (action.type) {
        case ADD_PRODUCT:
            return [action.payload, ...oldProducts];
        case EDIT_PRODUCT:
            const editProduct = action.payload;
            const index = oldProducts.findIndex(p => p.name === editProduct.name);
            if (index !== -1) {
                oldProducts.splice(index, 1, editProduct);
            }
            return oldProducts;
        default:
             return oldProducts;
    }
}




