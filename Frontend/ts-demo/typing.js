// 9/30/2019
var x = 1; // indicate x is a number
console.log(x); // Terminal: （tsc typing.ts  typing） --> transform 生成一个成es5文件(可以在所有浏览器运行)
// 把 ts 文件转换成 js 文件，然后运行js文件。
//                  （tsc typing.ts  typing -w） -->  Starting compilation in watch mode...
//                  (-w : 自动 compile,watch mode)
var y = 'abc';
var z; // var z, 初始值就是 undefined
console.log(z); // undefined
var arr = [];
arr.push(1);
//===============================================================
// inferred typing(字符串推断)
var bob = {
    name: 'Bob',
    age: 21
};
// bob.name = 31; // error Type '31' is not assignable to type 'string'.
var alice;
// alice.name = 31; // error Type '31' is not assignable to type 'string'.
alice = bob;
//=================================================================
var obj = {
    user: {
        name: 'Bob',
        age: 21
    },
    score: [100, 90, 80]
};
var obj2 = obj;
var obj1;
//=================================================================
// enum
var Direction;
(function (Direction) {
    Direction[Direction["EAST"] = 0] = "EAST";
    Direction[Direction["SOUTH"] = 1] = "SOUTH";
    Direction[Direction["WEST"] = 2] = "WEST";
    Direction[Direction["NORTH"] = 3] = "NORTH";
})(Direction || (Direction = {}));
;
var car;
car.speed = 100;
car.direction = Direction.SOUTH; // 只能从 enum 里面选择。
//=================================================================
function add(a, b) {
    return a + b;
}
var sum = add(1, 2);
//=================================================================
// any type
var d; // 如果不定义，默认是 any
d = 1;
d = true;
var e = 1; // inferred type: number
// union type
var f; // number 或者 boolean
f = 1;
f = true;
