import React from 'react';
import ReactDOM from 'react-dom';
import {Name} from "./Name";
import {Names} from "./Names";
import {App} from "./App";
import 'bootstrap/dist/css/bootstrap.min.css'; // React 中引用 css 文件. webpack
import {BrowserRouter} from "react-router-dom";
import {Route, Switch} from "react-router";
import {AddName} from "./AddName";
import {Products} from "./Products";

//const text = 'Hello React!';

// DOM API: DOM elements
// const rootElem = document.getElementById('root');
// const h1Elem = document.createElement('h1');
// const h1Text = document.createTextNode(text);
// h1Elem.appendChild(h1Text);
// rootElem.appendChild(h1Elem);

// ===========================================================================

// React Way: React Elements
// 下面这个太复杂：
// const h1ReactElem = React.createElement('h1', null, 'Hello React!');

// JSX(javascript with extensions): javascript + HTML. (combine)
// <Name></Name> -> 如果中间没有内容，可以： <Name/>
// const NAME = 'Alex';
// <Name name={NAME}/>: 左边是接受变量的。
// const h1ReactElem = <h1>Hello React! <Name name={NAME} x={1}/></h1>;

//=======================================================================

// ReactDOM.render(h1ReactElem, document.getElementById('root'));
// const NAMES = ['Bob', 'Alex', 'Alice', 'Lebron'];
// ReactDOM.render(<Names names={NAMES}/>, document.getElementById('root'));

// 这里传下去的 NAMES 没有使用，在APP里面又 hard code 了
// ReactDOM.render(<App names={NAMES}></App>, document.getElementById('root'));

//========================================================================

let NAMES= ['Bob', 'Alex', 'Alice', 'Lebron'];

// HOC: high order component.
// 创建一个 component, 这个 component 是 Names 包含了数据后的 component,然后再用这个。
function NamesWithData() {
    return <Names names={NAMES}></Names>
};

// 需要传递这个方法给 AddNameWithData component
// 这里没有 class, 都是全局变量，不需要 this 出现。
function addName(newName) {
    NAMES.push(newName);
}

function AddNameWithData() {
    return <AddName addName={addName}></AddName>
}

// 在 BrowserRouter 下面渲染 App component:
// BrowserRouter 控制 APP 的路由。Route path 配置路由：
// 最后一个 route 没有 path, 默认上面的不匹配，就会进入这个。
// component={}: 必须跟一个 component reference.
ReactDOM.render(<BrowserRouter>
    <App>
        <Switch>
            <Route path="/add-name" component={AddNameWithData}/>
            <Route path="/names" component={NamesWithData}/>
            <Route component={Products}/>
        </Switch>
    </App>
</BrowserRouter>, document.getElementById('root'));






