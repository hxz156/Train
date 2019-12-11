import React from 'react';
import {Name} from "./Name";
import {AddName} from "./AddName";
import {Names} from "./Names";
import {Header} from "./Header";



export class App extends React.Component {
    // 成员变量没有 const，所以不是 const NAMES...
    // NAMES = ['Bob', 'Alex', 'Alice', 'Lebron'];

    constructor(props) {
        super(props);
        this.state = {
            NAMES: ['Bob', 'Alex', 'Alice', 'Lebron']
        }
    }

    addName(newName) {
        // this.NAMES.push(newName);
        // this.forceUpdate(); // update 之后，页面没有更新，这里：force current component to re-render.
        this.setState({
            NAMES: [...this.state.NAMES, newName]
        });
    }

    render() {
        return (
            /*<React.Fragment> 表示一个虚拟的挂载点，避免创建一个 div， 因为这里就是抽象的*/
            <React.Fragment>
                <Header></Header>
                <Names names={this.state.NAMES}></Names>
                <AddName addName={this.addName.bind(this)}></AddName>
            </React.Fragment>
        // {this.addName.bind(this)} 因为传递过去会有 this point 的问题，所以要 bind
        // 这里 .bind(this), this 指向 render 的 this, render 的 this 指向 App component's this
        );
    }
}







