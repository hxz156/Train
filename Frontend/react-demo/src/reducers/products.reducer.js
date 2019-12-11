// 把字符串换成变量，防止输错字符串找不出 bug.
import {ADD_PRODUCT, EDIT_PRODUCT, LOAD_PRODUCTS} from "../actions/products.action";


export function productsReducer(oldProducts = [], action) {
    switch (action.type) {
        case ADD_PRODUCT:
            const newProduct = action.payload;

            return [action.payload, ...oldProducts];
        case EDIT_PRODUCT:
            const editProduct = action.payload;
            const index = oldProducts.findIndex(p => p.name === editProduct.name);
            if (index !== -1) {
                oldProducts.splice(index, 1, editProduct);
            }
            return oldProducts;
        // action.payload is a promise object, point to response from AJAX
        // which passed through middleware to make sure 异步操作在不会最后操作。
        // handle 异步操作。
        case LOAD_PRODUCTS:
            return action.payload.data;
        default:
             return oldProducts;
    }
}
