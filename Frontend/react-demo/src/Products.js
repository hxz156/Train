import React from 'react';
import {connect} from "react-redux";
import {Product} from "./Product";
import {bindActionCreators} from "redux";
import {addProductAC, loadProducts} from "./actions/products.action";
import './Products.css';
import {Link} from "react-router-dom"; // import css file

class Products extends React.Component {

    // 必须用这个去加载 products.
    componentDidMount() {
        this.props.loadProducts();
    }

    newProduct = {
        name: 'B2',
        brand: 'B2',
        stock: 'B2',
        price: 100,
        image: 'https://i.ytimg.com/vi/3Mt6F57D9bo/maxresdefault.jpg'
    };
    // 自己写的，正确的在 AddProduct component 里面
    // addProduct() {
    //     this.props.addProductACAndDispatch(this.newProduct);
    // }
    render() {
        return (
            <div>
                <h2>Product</h2>
                {/*<button onClick={this.addProduct.bind(this)}>Add Product</button>*/}
                {/*/!*<p>Names count: {this.props.names.length}</p>*!/*/}
                {/*{*/}
                {/*    this.props.products.map((product) => {*/}
                {/*        return (*/}
                {/*            <Product product={product}></Product>*/}
                {/*        );*/}
                {/*    })*/}
                {/*}*/}
                {/*className="table table-bordered table-striped" -> bootstrap*/}
                <table className="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Price</th>
                            <th>Stock</th>
                            <th>Image</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.props.products.map((product) => {
                            return (
                                <tr key={product.name}>
                                    <td>
                                        <Link to={`/edit-product/${product.name}`} >
                                            {product.name}
                                        </Link>
                                    </td>
                                    <td>{product.brand}</td>
                                    <td>{product.price}</td>
                                    <td>{product.stock}</td>
                                    <td>{product.image}</td>
                                    <td>
                                        <img src={product.image} />
                                    </td>
                                </tr>
                            );
                        })
                    }
                    </tbody>
                </table>
            </div>
        );
    }
}

// appState 是由 Redux 自己调用。
function mapStateToProps(appState) {
    return {
        // names: appState.names
        products: appState.products
    };
}

// function mapDispatchToProps(dispatch) {
//     return bindActionCreators({
//         addProductACAndDispatch: addProductAC
//     }, dispatch);
// }

// export default connect(mapStateToProps, mapDispatchToProps)(Products);

// {loadProducts} === {loadProducts: loadProducts} -> 语法糖，react 会自动帮助生成 function...
// {loadProducts} used to get data from serve.
export default connect(mapStateToProps, {loadProducts})(Products);
