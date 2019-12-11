import React from 'react';
import {connect} from "react-redux";
import {editProductAC} from "./actions/products.action";
const Edit_PRODUCT_FORM_CONTROLS = [
    {label: 'Name', type: 'text', field: 'name'},
    {label: 'Brand', type: 'text', field: 'brand'},
    {label: 'Price', type: 'number', field: 'price'},
    {label: 'Stock', type: 'number', field: 'stock'},
    {label: 'Image', type: 'text', field: 'image'},
];
class EditProduct extends React.Component {

    constructor(props) {
        super(props);

        // 试一试 console.log(props): 当前的商品名字,拿到名字，然后去所有的对比，找出来。
        const initialProductName = props.match.params.name;
        console.log(props);

        // props.products 里面来自 store
        const initialProduct = props.products.find(p => p.name === initialProductName);
        this.state = {
            // 拿到当前 product, 并且放在 form 里面。
            // 怎么把当前点击的 product 的信息拿到，并且传递到 form.
            editProduct: initialProduct
        };

        this.handleEdit = this.handleEdit.bind(this);
        this.handleControlChange = this.handleControlChange.bind(this);
    }

    handleEdit(event) {
        event.preventDefault();
        this.props.editProductAC(this.state.editProduct);
        // 自动跳转页面：
        this.props.history.push('/products');
    }

    handleControlChange(event) {
        // name 就是对应的 field, 每次改变不同的 field 都会触发：
        const {name, value} = event.target;
        this.state.editProduct[name] = value;
        this.setState({
            editProduct: this.state.editProduct
        });
    }

    renderControl(control) {
        // disabled={control.field === 'name'}: 不让name 被修改
        return (
            <div className="form-group" key={control.field}>
                <label>
                    {control.label}
                    <input type={control.type}
                           name={control.field}
                           className="form-control"
                           value={this.state.editProduct[control.field]}
                           onChange={this.handleControlChange}
                           disabled={control.field === 'name'}
                    />
                </label>
            </div>
        );
    }

    render() {
        return (
            <div className="container">
                <h2>Edit Product</h2>
                <form onSubmit={this.handleEdit}>
                    {
                        Edit_PRODUCT_FORM_CONTROLS.map(control => this.renderControl(control))
                    }
                    <p>
                        <button className="btn btn-primary" type="submit">Edit</button>
                    </p>
                </form>
            </div>
        );
    }

}

// {products} -> 使用：destructuring
function mapStateToProps({products}) {
    return {
        // === products: products
        products
    }
}

export default connect(mapStateToProps, {editProductAC})(EditProduct);
