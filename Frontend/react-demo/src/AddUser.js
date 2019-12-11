import React from 'react';
import {Field, reduxForm} from "redux-form";
import {connect} from "react-redux";

const ADD_USER_FROM_CONTROLS = [
    {label: 'Email', type: 'text', field: 'email'},
    {label: 'Name', type: 'text', field: 'name'},
    {label: 'Password', type: 'password', field: 'password'},
];
class AddUser extends React.Component {

    // NO NEED to save form related in component state, so no constructor
    // since form will be controlled by redux-form and form data will be saved in store
    constructor(props) {
        super(props);
        // handleSubmit: 在 props 里面。里面需要传递我们自己的方法。
        console.log(props);

        // 初始化用户，必须用 initialize 方法。因为当前的 component 接受到了 redux form 的这个方法。
        const initialUser = {
            name: 'Bob654321',
            email: 'bob@gmail.com',
            password: 'bob123456'
        };
        props.initialize(initialUser);
    }

    // create the component we use in form, we use Redux form.
    AddUserFormControl(props) {
        // Print the content of the props. like: input, meta...
        console.log(props);

        // get the control from props.
        const {control, input, meta} = props;

        // {...input}: 不再需要写 onChang, click ...
        return (
            <div className="form-group">
                <label>
                    {control.label}
                    <input
                        type={control.type}
                        className="form-control"
                        {...input}
                    />
                    <p className="text-danger">{meta.error}</p>
                </label>
            </div>
        );
    }

    // arrow function:
    mySubmit = (values) => {
        // prevent default
        // get user's input in form
        // invoke action creator to submit form

        // 拿到 user 在 form 里面的输入。
        console.log(values);
    }

    // how to use Redux to create a form.
    render() {
        return (
            <div className="container">
                <h2>Add User</h2>
                <form onSubmit={this.props.handleSubmit(this.mySubmit)}>
                    {
                        // AddUserFormControl: is a component
                        ADD_USER_FROM_CONTROLS.map(control => {
                            return <Field
                                        component={this.AddUserFormControl}
                                        name={control.field}
                                        control={control}
                                        key={control.field}
                                    />;
                        })
                    }
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        );
    }
}

// values -> name, ...
function myValidations(values) {
    let errors = {};
    const {email, name, password} = values;
    const emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!email) {
        errors.email = 'Email must be provided!';
    } else {
        if (!emailRegex.test(email)) {
            errors.email = 'Email format is not correct!';
        }
    }

    if (!name) {
        errors.name = 'Name must be provided!';
    } else {
        if (name.length < 6){
            errors.name = 'Name must > 6 chars';
        }
    }
    return errors;
}

// User Redux-form to create form.
// AddUser -> AddUser with redux-form support and connect with redux.
export default connect(null, {})(
    reduxForm({ // a form which connects to redux form.
        form: 'AddUserForm',
        validate: myValidations
    })(AddUser)
);
