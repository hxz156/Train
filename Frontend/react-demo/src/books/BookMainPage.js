import React from 'react';
import {connect} from "react-redux";
import {loadBooks} from "../actions/books.action";
import {Link} from "react-router-dom";

const BOOKS_CONTROLS = [
    {label: 'ID', type: 'text', name: 'id'},
    {label: 'Name', type: 'text', name: 'name'},
    {label: 'Price', type: 'number', name: 'price'},
    {label: 'Author', type: 'text', name: 'author'}
];

class BookMainPage extends React.Component {

    componentDidMount() {
        this.props.loadBooks();
    }

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <React.Fragment>
                <h2>Books</h2>
                <table className="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Price</td>
                            <td>Author</td>
                            <td>Operation</td>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.props.books.map((book) => {
                            return (
                                <tr>
                                    <td>{book.id}</td>
                                    <td>{book.name}</td>
                                    <td>{book.price}</td>
                                    <td>{book.author}</td>
                                    <td>
                                        <Link to={`/edit-book/${book.name}`}>Edit</Link>
                                        <span>  </span>
                                        <Link to="/book">Delete</Link>
                                    </td>
                                </tr>
                            );
                        })
                    }
                    </tbody>
                </table>
            </React.Fragment>
        );
    }
}

function mapStateToProps(appState) {
    return {
        books: appState.books
    };
}

export default connect (mapStateToProps, {loadBooks})(BookMainPage);
