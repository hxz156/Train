import React from 'react';
import ReactDOM from 'react-dom';
import {Name} from "./Name";
import Names from "./Names";
import {App} from "./App";
import 'bootstrap/dist/css/bootstrap.min.css'; // React 中引用 css 文件. webpack
import {BrowserRouter} from "react-router-dom";
import {Route, Switch} from "react-router";
import AddName from "./AddName";
import Products from "./Products";
import {applyMiddleware, createStore} from "redux";
import {Provider} from "react-redux";
import {rootReducer} from "./reducers/root.reducer";
import {Header} from "./Header";
import AddProduct from "./AddProduct";
import EditProduct from "./EditProduct";
import Login from "./Login";
import Logout from "./Logout";
import auth from "./auth.hoc";
import ReduxPromise from 'redux-promise';
import BookMainPage from "./books/BookMainPage";
import AddBook from "./books/AddBook";
import EditBook from "./books/EditBook";
import AddUser from "./AddUser";
import {Currency} from "./currency/Currency";

//========================================================================
// createStore -> createStoreWithMiddleWare, 得到一个新的 createStore 方法。
// used to handle promise, when we get data from server, the .then() function exists.
const createStoreWithMiddleWare = applyMiddleware(ReduxPromise)(createStore);

// create a store，把数据都放在一个文件夹里面。但是如果没有上面的代码，这个 store does not have middleware
// const store = createStore(rootReducer);

// use new creator to create store which has middleware.
// window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(): 使用 redux devtools
const store = createStoreWithMiddleWare(rootReducer, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

//========================================================================

ReactDOM.render(
    // Provider 下面所有 component 连接到 store 上面。
    <Provider store={store}>
        {/*在 BrowserRouter 下面渲染 App component:*/}
        {/*BrowserRouter 控制 APP 的路由。Route path 配置路由：*/}
        {/*最后一个 route 没有 path, 默认上面的不匹配，就会进入这个。*/}
        {/*component={}: 必须跟一个 component reference.
            Switch 里面会选择一个，然后放在里面。

            component={auth(AddName)}: 把 AddName 给 auth，得到一个被保护的 component.
            这样就不用每一个 Component 都写 isLoggedIn. */}
        <BrowserRouter>
            <App>
                <Switch>
                    <Route path="/add-name" component={auth(AddName)}/>
                    <Route path="/names" component={auth(Names)}/>
                    <Route path="/add-product" component={AddProduct}/>
                    <Route path="/edit-product/:name" component={EditProduct}/>
                    <Route path="/login" component={Login}/>
                    <Route path="/logout" component={Logout}/>
                    <Route path="/books" component={BookMainPage}/>
                    <Route path="/add-book" component={AddBook}/>
                    <Route path="/edit-book/:name" component={EditBook}/>
                    <Route path="/add-user" component={AddUser}/>
                    <Route path="/currency" component={Currency}/>
                    <Route component={Products}/>
                </Switch>
            </App>
        </BrowserRouter>
    </Provider>
    , document.getElementById('root'));
