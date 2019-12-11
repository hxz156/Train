import React from 'react';
import {Name} from "./Name";
import {AddName} from "./AddName";
import {connect} from "react-redux";

// class component
class Names extends React.Component { // class 变成 component class needs extends

    render() { // component class 的特殊方法。 render 调用，就会返回 virtual DOM tree 的一部分。
        // const names = ['Bob', 'Alex', 'Alice'];
        // array of string -> array of li react elements
        return (
            <ul>
                { // {} 表示要开始写 js
                    this.props.names.map(name => { // this.props: 访问到 props 下面的名字，
                                                    // 类似于 function(props)
                        // return (
                        //     <li>{name}</li>
                        // );
                        return (
                            // 用 map 的时候， key 用来 identify 产品。消除 warning. React 更快。
                            <li key={name}>
                                {/*用 name component 去渲染:*/}
                                <Name name={name}/>
                            </li>
                        );
                    })
                }
            </ul>
        );
    }
}

// 只加入特定的值，防止不相关的值改变，导致 props 改变，然后刷新。(指定传什么数据到 component)
// restrict which part of application state should be passed to component through props
function mapStateToProps(appState) {
    // this.props -> {};
    // 下面 return 之后就可以使用 this.props.names
    return {
        names: appState.names,
        isLoggedIn: appState.isLoggedIn
    };
}

//==================================================================================
// const functionToConnectNamesWithStore = connect(mapStateToProps);
//
// // 和 redux 连接起来的新的 Names component。（接受旧的Names, 返回新的连接的 Names).
// const namesConnectedWithStore = functionToConnectNamesWithStore(Names);
//
// // 和 redux 连接用 default export.
// // Names -> Names connected with Redux
// export default namesConnectedWithStore;
//==================================================================================

// 上面的简便写法, export 一个和 store 连接的新的 component：
export default connect(mapStateToProps)(Names);
// 成功连接之后，能够使用： this.props.names
