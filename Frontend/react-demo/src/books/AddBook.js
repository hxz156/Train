import React from 'react';
import {connect} from "react-redux";
import {addBookAC} from "../actions/books.action";

const BOOKS_CONTROLS = [
    {label: 'ID', type: 'text', name: 'id'},
    {label: 'Name', type: 'text', name: 'name'},
    {label: 'Price', type: 'number', name: 'price'},
    {label: 'Author', type: 'text', name: 'author'}
];
class AddBook extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            newBook: {
                id: '',
                name: '',
                price: 0,
                author: ''
            }
        }
    }

    handleInputChange(event) {
        const {name, value} = event.target;
        this.state.newBook[name] = value;
        this.setState({
                newBook: this.state.newBook
            }
        );
    }

    handleControl(control) {
        return (
            <div className="form-group">
                <label>{control.label}
                <input type={control.type}
                       className="form-control"
                       name={control.name}
                       value={this.state[control.name]}
                       onChange={this.handleInputChange.bind(this)}/>
                </label>
            </div>
        );
    }

    handleSubmit(event) {
        event.preventDefault();
        this.props.addBookAC(this.state.newBook);
        this.props.history.push('/books');
    }

    render() {
        return (
            <div className="container">
                <h2>Add Book</h2>
                <form onSubmit={this.handleSubmit.bind(this)}>
                    {
                        BOOKS_CONTROLS.map((control) => this.handleControl(control))
                    }
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        );
    }
}

export default connect(null, {addBookAC})(AddBook);
