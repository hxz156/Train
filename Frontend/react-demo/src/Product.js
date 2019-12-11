import React from 'react'


export class Product extends React.Component {

    render() {
        return (
            <React.Fragment>
                <p>name: {this.props.product.name}</p>
                <p>brand: {this.props.product.brand}</p>
                <p>price: {this.props.product.price}</p>
                <p>stock: {this.props.product.stock}</p>
                <img src={this.props.product.image} alt="" width="160" height="160" />
            </React.Fragment>
        );
    }
}

