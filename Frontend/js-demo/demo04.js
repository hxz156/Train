// closure
// a function(inner) inside another function(outer)
// After outer function finishes execution, the returned 
// inner function can still access the local variable which are
// declared in outer function and used in inner function.
// JS creates a closure to store those variables after outer executed.

function outer() {
	var x = 1;
	var y = 2; // will not be putted in closure, because it is not used
	var inner = function() {
		console.log(x);
	};
	return inner; // a function return a function
}
var returnedInner = outer();
returnedInner(); // outer 执行完毕了，java里面应该不会打出 x。局部变量在
//				method 执行完之后，还能被访问，所以 x 没有被销毁。
//				closure: {x: 1}
// A new closure will be created for every function execution.
// closure is scoped to returned inner function which means only
// returned inner function can access data in closure.
// 但是 JAVA 不允许一个 function 在另一个 function 里面定义。~

// advantage: avoid to create too many global variables.
// disadvantage: may lead memory leak.

//====================================================================
console.log("============= 3 increase: ===================")
function increaseGo() {
	var x = 1;
	var print = function() {
		console.log(x);
		x++;
	}
	return print;
}
var increase = increaseGo();
increase();
increase();
increase();

//=========================================================================

// simulate encapsulation (类似 java，把 field 设为 private, then getter, setter)
function counterFactory() {
	var count = 0;
	return { // counter object
		getCount: function() {
			return count;
		},
		setCount: function(c) {
			if(c < 10){
				throw new Error('count can\'t be negative! ');
			}
			count = c;
		}
	};
}

var counter = counterFactory(); // closure: {count: 0}
counter.getCount();
counter.setCount(10);
console.log(counter.getCount());	// 10
// counter.count ??? can not access count this way （闭包）
counter.count = 7;
console.log(counter.getCount()); 	// 10
console.log(counter.count);			// 7

//=============================================================================

// self invoke function(immediate invoke function express)
// module pattern
// how to create a JS function which will be used once and will be executed
// immediately after creation?

(function() {
	console.log("this is IIFE");
})();		


// create a singleton in JS:
var singletonCounter = (function() { // remove the name of the function
									// anonymous function
									// 不能创建无数个 counter
									// 只存在一个 counter
	var count = 0;
	return { // counter object
		getCount: function() {
			return count;
		},
		setCount: function(c) {
			if(c < 10){
				throw new Error('count can\'t be negative! ');
			}
			count = c;
		}
	};
})();
//  = new function() 创建一个对象
//	如果 function 里面 return 一个对象，那么一般不需要写 new，直接 =function（）

//===========================================================================

// in JS, pass by reference or by value?
// for primitive value, JS will pass by value (copy value)
// for reference type, JS will pass by reference
var p1 = 1;
var p2 = p1;
function ptest(param) { // var param = 1; 值会被直接拷贝上去

}
ptest(p1);


var p3 = {}; // p3 is a reference to object.
ptest(p3);	// JS will pass reference of the object to function, 指的是同一个对象









































