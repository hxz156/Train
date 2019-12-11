import axios from 'axios';

// 不用字符串，用变量。在 products.reducer 里面也是使用字符串。可以避免 type 错误。
export const ADD_PRODUCT = 'ADD_PRODUCT';
export const EDIT_PRODUCT = 'EDIT_PRODUCT';
export const LOAD_PRODUCTS = 'LOAD_PRODUCTS';

export function addProductAC(newProduct) {
    return {
        type: ADD_PRODUCT,
        payload: newProduct
    };
}

export function editProductAC(editProduct) {
    return {
        type: EDIT_PRODUCT,
        payload: editProduct
    };
}

export function loadProducts() {
    // 和 angular 的直接 return Observable 类似：
    // 不在后面写 .then ， 直接传递。
    // 发送一个请求，拿回一个 promise, 然后直接把 promise 传递到 reducer 里面去。
    const promise = axios.get('http://localhost:3000/products');

    return {
        type: LOAD_PRODUCTS,
        payload: promise
    };
}
