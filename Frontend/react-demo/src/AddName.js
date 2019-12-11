import React from 'react';
import {Names} from "./Names";
import {addNameAC} from './actions/names.action';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

class AddName extends React.Component {
    // 成员变量：
    // newName = `Tom`;

    constructor(props) { // 为了引进 state.
        super(props); // 因为这一行就会： this.props = props; 所以下面才就能用 this.props.
        this.state = {
            // 不把 newName 放在成员变量里面，这里放在 state 里面。newName 改变，会触发 re-render.
            // 这里就会立刻更新 newName.
            newName: `Tom`
        };
    }

    // 如果不想改 this 就把 function 变成 arrow function。
    handleAdd() {
        // const newName = `Tom`;
        // this.props.addName(this.state.newName); // 拿到从 APP.js 传递下来的函数:addName()。
        //===========================================================
        // action will be created but will not be dispatched to reducer! (wrong! : )
        // addNameAC(this.state.newName);
        //===========================================================
        // create an action and dispatch to reducer.
        // 写这个是为了连接到 store,并且能够 manipulate store.
        this.props.addNameACAndDispatch(this.state.newName);
    }

    updateNewName(event) { // React 没有双向绑定，需要自己写这一部分。
        // event.target.value： 拿到最新的值
        // this.state.newName = event.target.value; // 把最新的值更新上去。
        // this.forceUpdate(); // 键盘输入没有变化，因为没有渲染。但是 forceUpdate() 不是一个好办法。

        // ========================================================================
        // update state and auto trigger re-render
        // 保证改变名字，并且自动触发 re-render. (key)
        this.setState({
            newName: event.target.value
        });
    }

    render() {
        return (
            <React.Fragment>
                <h2>Add Name</h2>
                <p>
                    <input type="text" value={this.state.newName} onChange={this.updateNewName.bind(this)}/>
                </p>
                <p>
                    <button onClick={this.handleAdd.bind(this)}>Add</button>
                </p>
            </React.Fragment>
        );
    }
}

// ask store to provide action dispatch functionality
// 拿下来之后，可以通过 props 访问。
// generate a new action creator by combining old action creator and store's dispatch function.
// component will be able to access the new action creator through props.
function mapDispatchToProps(dispatch) {
    // addNameAC + dispatch => addNameACAndDispatch (new action creator)
    return bindActionCreators({
        // new action creator: old action creator
        addNameACAndDispatch: addNameAC
    }, dispatch);
}

// AddName 不需要使用 store 里面的数据，所以 null:
// 第二个参数是： new action creator
export default connect(null, mapDispatchToProps)(AddName); // import 的时候不加 {},因为是 default






