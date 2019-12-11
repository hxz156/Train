// js data types

// primitive data types:
// String, number, boolean, null, undefined, Symbol(ES6) (but in Java String is reference)
console.log("abc");
console.log('abc');

// ES6 template String
console.log(`abc`);
console.log("I`m bob"); // I`m bob.
console.log("I\"m bob"); // escaping
console.log('He is "tall"'); // He is "tall".

// true/false
console.log(true);

// falsy values: 0, "", false, null, undefined, NaN(not a number)
if(false){	// you can put any thing in if statement, diffenrent from JAVA.
			// And in JS anything not a falsy value is true.
	console.log('falsy');
}


// undefined: the default value JS will assign to a variable which is declared
// but not yet initialized
var x; // -> var x = undefined;


// null: is used by developer to assign on a variable which indicates the variable
// has no value!
var y = 1;
y = null; // y has no value associated.

console.log(1 + "1"); 	// -> "1" + "1" = "11"
console.log(1 + true); 	// -> 1 + 1 = 2;
console.log(1 + false); // -> 1 + 0 = 1;
console.log(1 - "1"); 	// -> 1 - 1 = 0;
console.log(1 / "1"); 	// -> 1 / 1 = 1;
console.log(1 / "abc"); // -> NaN
console.log(1 * "abc"); // -> NaN
console.log(NaN == NaN);// -> false
console.log(1/"abc" == NaN);// -> false

// how to check if a variable is NaN?
console.log(isNaN(1 / "abc"));

// how to check a variable type
var v = "1";
console.log(typeof v);	// "string"

v = 1;
console.log(typeof v);	// "number"

v = true;
console.log(typeof v); // "boolean"

console.log(typeof(undefined)); // "undefined"

console.log(typeof null); // "object" (a bug of the language)

//===========================================
console.log(null == undefined); // "true"
console.log("--------null === undefined---------: ");
console.log(null === undefined);	// false
//===========================================

var t = null;	// 分辨 null 和 undefined 的目的
if (t == null && typeof t == "object"){
	console.log("do something when t is null");
}

v = NaN;
console.log(typeof v); // "number"


// reference data types - objects
// how to create a object?

// 1. object constructor
var o1 = new Object();

// 2. object literal
var o2 = {};
console.log(typeof o2); // "object"

// Array: dynamic length. (ArrayDeque)
var arr1 = new Array();
arr1.push(1);		// -> add at end of array
console.log(arr1); // -> "[ 1 ]"
console.log(arr1.pop()); // -> "1" , remove last element in array

var arr2 = [1, 2, 3];
arr2.unshift(0); // -> add at front of array
console.log(arr2); // [ 0, 1, 2, 3 ]

arr2.shift(); 	// remove 1st element
console.log(arr2);

console.log(new Date()); 

// == vs ===
var str1 = "abc"; //String primitive contains "abc"
var str2 = new String("abc"); // String object contains "abc"

console.log(str1 == str2);	// true
console.log(str1 === str2); // false

// "==": compare value of two variables, for any non-primitive 
// variables, JS will use valueOf() to get value and then compare
console.log("---------str2.valueOf()------------");
console.log(str2.valueOf());

// "===": compare both types and values of two variable

// if we compare values of two objects, JS will compare references with two objects:
var str3 = new String("abc");
console.log(str2 == str3); // false, different from above, there is no primitive between.
console.log(str2 === str3); // false -> (typeOf(str2)==typeOf(str3) && str2 == str3)


// variable scope is designed to restrict where a variable can be used.
// 3 scopes: function local scope, file scope, global scope.

// file scope variable: you can use this in the entire file
var v2 = 1;

// global scope variable
// create a property on global object to create a global scope variable
// declare a variable without var and assign it a value
global.v3 = 1;
v4 = 1; // bad practice. == global.v4 = 1;

function test(){
	// how to create a local variable under function local scope
	var v1 = 1; // can only be used in current function

	v1 = 3; // assignment

	return 1;
}
console.log(test());

// variable scope search chain
// when you try to use(access) a variable, JS will try to search for
// that variable in a chain. (current scope -> outer scope -> global scope -> not defined)

// for assignment, JS will also search in the scope chain for the variable.
// if variable can be found, new value will be assigned to the variable, otherwise,
// if the variable can not be found even reached global scope, JS will create that global
// variable

// It is allowed to define a function inside another function
function outer() {

	// similar to: var inner = function() {};
	function inner (){

	}
	inner();
}
outer();

// hoisting: When JS execute a function, it will scan the function first to find all
// the variables, and move declarations of the variables to the top of current function 
// local scope. (Only local variable)
// variable delarition: var a;
// variable delarition with innitialization: var a = 1;
console.log("------ hoisting -----------");

function hoisting() {

	console.log(h1); // this is allowed, "undefined". Move declaration not initialization
	var h1 = 1; // "var h1" will move to the top.

	t1(); // the entire below function t1() will move to the top
	function t1() {
		console.log("t1 function");
	}

	// t2();	// error. "TypeError: t2 is not a function"
	// var t2 = function() { // only "var t2" will move to the top

	// }

}
hoisting();






























