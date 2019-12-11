import React from 'react'; // 相当于 @Component in Angular

// functional component
export function Name(props) { // {name: 'ALEX', x: 1}, receive from Parent, props is object

    let {name} = props; // let {name: name} = props;

    // how to create inline style in react component?
    let styles = {
        color: 'blue',
        fontSize: '14pt'
    };

    // {} -> write javascript in JSX HTML.
    return <span style={styles}>{name}</span>
}










