// 9/30/2019
let x: number = 1; // indicate x is a number
console.log(x); // Terminal: （tsc typing.ts  typing） --> transform 生成一个成es5文件(可以在所有浏览器运行)
// 把 ts 文件转换成 js 文件，然后运行js文件。
//                  （tsc typing.ts  typing -w） -->  Starting compilation in watch mode...
//                  (-w : 自动 compile,watch mode)

let y: string = 'abc';
let z: boolean; // var z, 初始值就是 undefined
console.log(z); // undefined

let arr: number[] = [];
arr.push(1);

//===============================================================
// inferred typing(字符串推断)
let bob = {
    name: 'Bob',
    age: 21
};
// bob.name = 31; // error Type '31' is not assignable to type 'string'.

let alice: {name: string, age: number};
// alice.name = 31; // error Type '31' is not assignable to type 'string'.

alice = bob;

//=================================================================

let obj = {
    user: {
        name: 'Bob',
        age:21
    },
    score: [100, 90, 80]
};

let obj2: {user:{
        name: string,
        age: number
    },score:number[]} = obj;

//=================================================================
// type alias
type MyObj = {user:{ // 这样就不用每次复制一大段的定义
        name: string,
        age: number
    },score:number[]};

let obj1: MyObj;

//=================================================================
// enum
enum Direction{
    EAST,
    SOUTH,
    WEST,
    NORTH
};
let car: {speed: number, direction: Direction};
car.speed = 100;
car.direction = Direction.SOUTH; // 只能从 enum 里面选择。


//=================================================================

function add(a: number, b: number) : number { // 接受数字，返回数字
    return a + b;
}
let sum: number = add(1,2);
//=================================================================
// any type
let d: any; // 如果不定义，默认是 any
d = 1;
d = true;
let e = 1; // inferred type: number


// union type
let f: number | boolean; // number 或者 boolean
f = 1;
f = true;





