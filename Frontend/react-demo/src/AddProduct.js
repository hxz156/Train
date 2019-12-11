import React from 'react';
import {connect} from "react-redux";
import {addProductAC} from "./actions/products.action";

// 想要动态生成 for，所以创建一个 array object:
const ADD_PRODUCT_FORM_CONTROLS = [
    {label: 'Name', type: 'text', field: 'name'},
    {label: 'Brand', type: 'text', field: 'brand'},
    {label: 'Price', type: 'number', field: 'price'},
    {label: 'Stock', type: 'number', field: 'stock'},
    {label: 'Image', type: 'text', field: 'image'},
];

// 下面 export 了，这里不 export, 下面 export default, import 的时候不加{}
class AddProduct extends React.Component {

    constructor(props) {
        super(props);

        // 把 bind this 提到前面写：
        this.handleAdd = this.handleAdd.bind(this);
        this.handleControlChange = this.handleControlChange.bind(this);
        this.state = {
            newProduct: {
                name: 'B2',
                brand: 'B2',
                stock: 0,
                price: 100,
                image: 'https://www.lockheedmartin.com/content/dam/lockheed-martin/aero/photo/f22/f-22_2.jpg.pc-adaptive.full.medium.jpeg'
            }
        };
    }

    handleAdd(event) {
        // 防止页面刷新：
        event.preventDefault();

        const newProduct = {
            name: 'B2',
            brand: 'B2',
            stock: 'B2',
            price: 100,
            image: 'https://i.ytimg.com/vi/3Mt6F57D9bo/maxresdefault.jpg'
        };
        // use action
        this.props.addProductAC(this.state.newProduct);

        // submit 之后，跳转到 Products
        this.props.history.push('/products');
    }

    handleControlChange(event) {
        // 1. which control is changed?
        // 2. changes, name 拿到对应的 field
        // destructuring:
        const {name, value} = event.target;
        this.state.newProduct[name] = value;

        // 更新页面，触发 rerender:
        this.setState({
            newProduct: this.state.newProduct
        });
    }

    // 想要动态生成 input form, 创建一个 function:
    renderControl(control) {
        return (
            // map 里面调用，加 key 防止 warning
            <div className="form-group" key={control.field}>
                <label>
                    {control.label}
                    <input type={control.type}
                        // 给input box 一个名字,用来知道更新哪一个 field:
                        name={control.field}
                        className="form-control"

                        // newProduct[control.field] 必须用 []，因为 control.field 是变量。
                        value={this.state.newProduct[control.field]}
                        onChange={this.handleControlChange}
                    />
                </label>
            </div>
        );
    }

    render() {
        {/*<div className="container">: 为了使用 bootstrap*/}
        return(
            <div className="container">
                <h2>Add Product</h2>
                <form onSubmit={this.handleAdd}>
                    {
                        ADD_PRODUCT_FORM_CONTROLS.map(control => this.renderControl(control))
                    }
                    <p>
                        <button type="submit" >Submit</button>
                    </p>
                </form>

            </div>
        );
    }
}


// 语法糖： addProductAC: addProductAC。 props 里面的名字一样。
export default connect(null, {addProductAC})(AddProduct);

