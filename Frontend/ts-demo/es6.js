var __spreadArrays = (this && this.__spreadArrays) || function () {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};
// 9/30/2019
// let vs const
var x1 = 1;
x1 = 2;
// if const variable is pointing to a primitive value, the variable
// can not be assigned with another value.
var x2 = 1;
// x2 = 2; //  Cannot assign to 'x2' because it is a constant, similar to java final
// if const variable is pointing to a reference type(object), the variable
// can not be assigned with another reference.
var x3 = {
    count: 0
};
x3.count = 100; // 常量里面的东西可以修改，和java的final相似。指向的对象内容可以修改。
//                  只是不能把 x3 指向新的对象。
// for let/const variable, there is no hoisting:
// console.log(x4); // error
// let x4 = 1;
//========================================================================
for (var i = 0; i < 5; i++) { // ES5 这里没有产生 scope，for loop 就会在file scope 里面创建 i。
}
;
console.log(i); // 5
// block scope, ES6: use let/const to declare variable
for (var j = 0; j < 5; j++) {
}
;
// console.log(j); // Cannot find name 'j'
{
    var i1 = 1;
    var i2 = 2;
}
// console.log(i1); // Cannot find name 'j'
console.log(i2); // 2
//----------------------------------------------------------------------
for (var i = 0; i < 5; i++) {
    setTimeout(function () {
        console.log(i);
    }, 0);
}
; //5 5 5 5 5. for loop 执行完毕后，才会执行setTimeout。最后执行Queue里面的方法。 setTimeout在 API
var _loop_1 = function (i_1) {
    setTimeout(function () {
        console.log(i_1);
    }, 0);
};
// 里面等待，然后进入 queue， 最后进入 stack。
//----------------------------------------------------------------------
for (var i_1 = 0; i_1 < 5; i_1++) {
    _loop_1(i_1);
}
; // 0 1 2 3 4. 用 let 意味着产生了一个 block scope。类似于 closure，缓存了 i
//----------------------------------------------------------------------
// 自己创建一个 closure：
console.log("---------------my set time out----------------------");
for (var i = 0; i < 5; i++) {
    var outer = function (i) {
        return function () {
            console.log(i);
        };
    };
    var inner = outer(i); // closure: {i: 0} 当invoke的时候，会有 closure
    setTimeout(inner, 0); // inner 代表一个function, 这里不需要 inner(),因为不需要执行，
    // setTimeOut() 会帮你执行。对比上面的代码。
}
// module pattern (不需要记住)
for (var i = 0; i < 5; i++) {
    setTimeout((function (i) {
        return function () {
            console.log(i);
        };
    })(i), 0);
}
//==========================================================================
// template string
// back-tic: `
// `I'm "bob".`
// 1. allow multi-lines of string
var hiTest = "ll\n               ll";
// 2. easy string concatenation with variables
var helloName = 'Bob';
var helloText = 'Hello ' + helloName + ', Welcome!';
var helloText1 = "Hello " + helloName + ", Welcome"; // 不需要 +， 更方便。
//==========================================================================
// rest/spread operators
// ...
var a1 = [1, 2, 3];
var a2 = [5, 6, 7];
var a3 = __spreadArrays(a1, [4], a2); // 包含a1所有内容，一个4，a2所有的内容。
// arguments
function add() {
    var arr = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        arr[_i] = arguments[_i];
    }
    return arr.reduce(function (prev, cur) {
        return prev + cur;
    }, 0);
}
add(1);
add(1, 2);
add(1, 2, 3);
//==========================================================================
// destructuring
var hobbies = ['swimming', 'fishing'];
// const hb1 = hobbies[0];
// const hb2 = hobbies[1];
var hb1 = hobbies[0], hb2 = hobbies[1]; // 一行相当于两行
var adam = {
    name: 'Adam',
    age: 23
};
// const adamName = adam.name;
// const adamAge = adam.age;
var adamName = adam.name, adamAge = adam.age; // 一行相当于两行
//==========================================================================
// arrow function
var subtract = function (a, b) {
    return a - b;
};
var subtract1 = function (a, b) {
    return a - b;
};
var subtract2 = function (a, b) { return a - b; }; // 变成一行，效果一样。
//------------------------------------
// 第三种方法
var order = {
    //              file 里面 this 指向 exports
    price: 100,
    calculate: function () {
        var _this = this;
        // this -> order
        return {
            getTotal: function (qty) {
                //              如果用 arrow function，以前的this 就变了。
                // arrow function 的scope 变成他外面一层的 scope，就是 calculate
                // 所以 this 指向和 calculate this 一样。
                return qty * _this.price;
            }
        };
    }
};
order.calculate().getTotal(5); // 500
//==========================================================================
// nodejs, this
// console.log(this === module.exports);
// browser, this
// console.log(this === window);
// no file scope in browser
// var x = 1; // (==) this.x = 1 (==) window.x=1; under window browser
// 浏览器没有 file scope, module system.
