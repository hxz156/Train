import React from 'react';
import {CurrencySelect} from "./CurrencySelect";
import {CurrencyDisplay} from "./CurrencyDisplay";

export class Currency extends React.Component{
    currencyExchangeRate = {
        'USD': 1,
        'CNY': 6.9,
        'JPY': 100
    }

    constructor(props) {
        super(props);
        this.state = {
            price: 0,
            rate: 1,
            selectedCurrency: 'USD'
        }
    }

    handleInputBox(event) {
        const newPrice = event.target.value;
        this.setState({
            price: newPrice
        });
    }

    handleSelectBox(event) {
        const newSelectedCurrency = event.target.value;
        const newRate = this.currencyExchangeRate[newSelectedCurrency];
        this.setState({
            rate: newRate,
            selectedCurrency: newSelectedCurrency
        })
    }

    render() {
        return(
            <div>
                <CurrencyDisplay
                    price={this.state.price}
                    rate={this.state.rate}
                    selectedCurrency={this.state.selectedCurrency}
                />
                <hr/>
                <CurrencySelect
                    currencyExchangeRate={this.currencyExchangeRate}
                    handleInputBox={this.handleInputBox.bind(this)}
                    handleSelectBox={this.handleSelectBox.bind(this)}
                />
            </div>
        );
    }
}
