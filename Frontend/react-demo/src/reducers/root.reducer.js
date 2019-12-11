import {combineReducers} from "redux";
import {namesReducer} from "./names.reducer";
import {productsReducer} from "./products.reducer";
import {authReducer} from "./auth.reducer";
import {reducer as formReducer} from "redux-form"; // as formReducer : 取的别名
import {booksReducer} from "./books.reducer";

// root.reducer.js -> 把所有的 reducer 整合到一起。 一个 reducer 对应一个数据。
// store 是由 rootReducer 创建出来的。
export const rootReducer = combineReducers({
    names: namesReducer,
    products: productsReducer,

    // is LoggedIn is combined in his class
    isLoggedIn: authReducer,
    books: booksReducer,

    // 配置 redux form , 因为 redux form 是储存在 store 里面的。
    // configure redux form reducer in our redux store.
    form: formReducer
});
