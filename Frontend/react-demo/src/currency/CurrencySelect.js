import React from 'react';

export class CurrencySelect extends React.Component{

    render() {
        return(
            <React.Fragment>
                <label>Price</label>
                <input type="number" onChange={this.props.handleInputBox}/>
                <select onChange={this.props.handleSelectBox}>
                    <option value='USD'>
                        USD
                    </option>
                    <option value='CNY'>
                        CNY
                    </option>
                    <option value='JPY'>
                        JPY
                    </option>
                </select>
            </React.Fragment>

        );
    }
}
