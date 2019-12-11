import React from 'react';
import {connect} from "react-redux";
import {editBookAC} from "../actions/books.action";

const BOOKS_CONTROLS = [
    {label: 'ID', type: 'text', name: 'id'},
    {label: 'Name', type: 'text', name: 'name'},
    {label: 'Price', type: 'number', name: 'price'},
    {label: 'Author', type: 'text', name: 'author'},
];
class EditBook extends React.Component {

    constructor(props) {
        super(props);
        const editBookName = this.props.match.params.name;
        const initialBook = this.props.books.find((book) => book.name === editBookName);
        this.state = {
            editBook: initialBook
        }
    }

    handleInputChange(event) {
        const{name, value} = event.target;
        this.state.editBook[name] = value;
        this.setState({
                editBook: this.state.editBook
            }
        );
    }

    handleInputContent(control) {
        return (
            <form>
                <label>
                    {control.label}
                    <input type={control.type}
                    name={control.name}
                    disabled={control.name === 'id'}
                    onChange={this.handleInputChange.bind(this)}
                    value={this.state.editBook[control.name]}
                    />
                </label>
            </form>
        );
    }

    handleSubmit(event) {
        event.preventDefault();
        this.props.editBookAC(this.state.editBook);
        this.props.history.push('/books');
    }

    render() {
        return (
            <div>
                <h2>Edit Book</h2>
                <form onSubmit={this.handleSubmit.bind(this)}>
                    {
                        BOOKS_CONTROLS.map((control) => this.handleInputContent(control))
                    }
                    <button type="submit">Submit</button>
                </form>
            </div>
        );
    }
}

function mapStateToProps(appState){
    return {
        books: appState.books
    };
}

export default connect(mapStateToProps, {editBookAC})(EditBook);
