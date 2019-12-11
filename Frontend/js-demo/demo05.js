// JS OOP - inheritance ES5 -> prototype

function A() {
	// 1.5 {}._proto_ = A.prototype; // create a __proto__ object for the object
	// 2. resolve parameters
	// 3. this -> {}
	// 4. execute function codes
	this.x = 1;	
	// this.getX = function() {
	// 	return this.x;
	// }
	// 5. return new object
}
A.prototype.getX = function() { // any function in JS will have a prototype object
	return this.x;
};

//==============================================================
console.log("//========================================");
A.setA = 'this is a';
console.log(A.setA);
console.log(typeof A)
console.log("//========================================");
//==============================================================
					
					// 5 steps:
var a1 = new A(); 	// 1. {}
					
console.log(a1);	// A { x: 1, getX: [Function] }
console.log(a1.getX());	// 1 	then in function this -> a1

var a2 = new A(); // {x: 1, getX: function}
console.log(a1 == a2); // false, reference different.
console.log(a1.x == a2.x); // true
console.log(a1.getX() == a2.getX()); // true
console.log(a1.getX == a2.getX); // 如果是 prototype function,就是 true. 
//									因为指向的是同一个 function

// prototype: any JS function has a prototype property, which points to an object.
// This prototype object can be used to declare some data(variable/function) for
// sharing among all instances of the constructor function.
// function 是正方形

// __proto__: any JS object has a __proto__ object which points to its constructor function's
// prototype object.
// object 是圆形

// how does JS find a property of an object?
// search that property on prototype chain of object
// if property can't be found even reaches to end of the prototype chain, JS will
// return undefined as property value.

// if we add prototype for Object
Object.prototype.y = 100;
// a1's prototype chain: a1 -> A.prototype -> Object.prototype -> null
console.log(a1.y);
// {} -> Object.prototype -> null
console.log({}.y); // {} -> new Object();

//===================================================================================

// how to implement inheritance in JS? Version 1, 不推荐有 bug
function Parent() {
	this.x = 1;
}
Parent.prototype.getX = function() {
	return this.x;
}
function Child() {
	this.y = 2;
}

// 旧的 prototype chian -》 c: c -> Child.prototype -> Object.prototype -> null

p = new Parent();
Child.prototype = p; // 改变 Child 的prototype, 如果想要给 Child 加 prototype，需要写在这行的下面

Child.prototype.getY = function() {
	return this.y;
};

// 新的 prototype chian -》 c -> p ->Parent.prototype -> Object.prototype -> null

var c = new Child();
console.log(c.y);
console.log(c.x);
console.log(c.getX());
console.log(c.constructor); // [Function: Parent] 因为指到了 p object, 然后 p 指到 Parent
							// prototype
							// 这个是bug，因为无法判断 c 是从什么 new 出来的
							// 这个 inherirance 不好，存在 constructor 的问题，不推荐。

//==========================================================================================

// how to implement inheritance in JS? Version 2 

function Parent() {
	this.x = 1;
}
Parent.prototype.getX = function() {
	return this.x;
}
function Child() {
	Parent.call(this); 	// version 2, c.x missed, 不能访问，所以需要这一句。
						// this -> {x : 1} -> c
						// 在 c 里面添加一个 x:1
						// 因为是用的 new Child(), 所以 Child 里面的 this 指向新对象{}
						// 在 Parent 里面用this 定义的都会在 Child 里面定义
						// this points to new Child object
						// this new Child object will be used as the new "this"
						// of Parent function whatever you add on "this"
						// in parent function will be added to the new Child object.
	this.y = 2;
}

//==============================================================================
// module pattern
console.log("---------module pattern---------");
(function() {
	var p = {x: 6666}; // 在这里 define p 不会影响到上面的 p. self invoke function. 
					// 因为 function 有一个 scope
	var a = {};
	// a.__proto__ = p; // a 是object，因为 object 的是 __proto__  !!不是 prototype
						// __proto__ should not be accessed directly

	Object.setPrototypeOf(a, p); // 和上面这//句话的含义一样，更安全。因为js可能会改变proto
	//								的名字，但是这个function不会改变。
	console.log(a.x);

	//------------------------------

	var b = Object.create(p);	// 一行完成上面的操作。
								// {}.__proto__ = p;
								// 1.创建一个新对象
								// 2.更改prototype
	console.log(b.x);

	//--------------------------------
	// how to check if an object is on prototype chain of another?
	console.log(p.isPrototypeOf(a));
	console.log(a.isPrototypeOf(p));
})();

// version 2:
Child.prototype = Object.create(Parent.prototype); // inheritance for Parent prototype.
Child.prototype.constructor = Child; // constructor reset.

//================================================================================

// Implement inheritance in Javascript using ES5. Below are requirements.
// Employee(name, type, rate)
//  - name
//  - type. E.g. Fulltime, Parttime
//  - rate. E.g. 100, 200…
// FulltimeEmployee(name, rate) inherits Employee
// ParttimeEmployee(name, rate, contractLength) inherits Employee
//  - contractLength. E.g. 1 Year, 2 Years.
// function Employee(name, type, rate) {
//     this.name = name;
//     this.type = type;
//     this.rate = rate;
// }
// function FulltimeEmployee(name, rate) {
//     Employee.call(this, name, 'Fulltime', rate);
// }
// FulltimeEmployee.prototype = Object.create(Employee.prototype);
// FulltimeEmployee.prototype.constructor = FulltimeEmployee;
// function ParttimeEmployee(name, rate, contractLength) {
//     Employee.call(this, name, 'Parttime', rate);
//     this.contractLength = contractLength;
// }
// ParttimeEmployee.prototype = Object.create(Employee.prototype);
// ParttimeEmployee.prototype.constructor = ParttimeEmployee;
































