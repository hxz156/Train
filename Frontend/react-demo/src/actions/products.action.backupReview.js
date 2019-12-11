// 不用字符串，用变量。在 products.reducer 里面也是使用字符串。可以避免 type 错误。
export const ADD_PRODUCT = 'ADD_PRODUCT';
export const EDIT_PRODUCT = 'EDIT_PRODUCT';

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


