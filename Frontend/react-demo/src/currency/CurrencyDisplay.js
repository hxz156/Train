import React from 'react';

export function CurrencyDisplay(props) {

    const totalPrice = props.price * props.rate
    return(

            <p>Your Price in {props.selectedCurrency}: {totalPrice}</p>

    );
}
