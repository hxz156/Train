// arguments
function add() { // 因为 hoisting, 这个function会被覆盖。
    console.log(arguments);
}
add(1);
add(1, 2);
add(1, 2, 3);

// [Arguments] { '0': 1 }
// [Arguments] { '0': 1, '1': 2 }
// [Arguments] { '0': 1, '1': 2, '2': 3 }

function add() { // arguments is array like Object, 转换成 array
    return Array.from(arguments).reduce(function(acc,arr){
        return acc + arr;
    },0);
}

// function add() {
//     var count = 0;
//     for(var key in arguments){
//         count += arguments[key];
//     }
//     console.log(count);
// }
console.log(add(1));
console.log(add(1, 2));
console.log(add(1, 2, 3));









