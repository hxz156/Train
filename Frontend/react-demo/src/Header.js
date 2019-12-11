import React from 'react'
import {Link} from "react-router-dom";


export class Header extends React.Component {
    render() {
        return (
            <header>
                <nav className="navbar navbar-default navbar-light">
                    <ul className="nav navbar-nav">
                        {/* Link  升级的 <a>， 改变url，通知界面更改内容 */}
                        <li className="nav-item">
                            <Link to="/names">Names</Link>
                            {/*<a href="/names"></a>*/}
                        </li>
                        <li className="nav-item">
                            <Link to="/add-name">Add Name</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/products">Products</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/add-product">Add Product</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/login">Login</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/logout">Logout</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/books">Books</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/add-book">Add Book</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/add-user">Add User</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/currency">Currency</Link>
                        </li>
                    </ul>
                </nav>
            </header>
        );
    }
}


