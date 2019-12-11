// JS objects

// object property -> name(String): value(anything)
var bob = {
	'name' : 'bob',
	age : 20,
	'first name' : 'lee' // 如果两个之间有空格，需要加 ''，才行
							// 并且必须用 bracket notation
};

// how to access object property?
// 1. dot notation
console.log(bob.name);
console.log(bob.age);

// 2. bracket notation
// when property name contains special characters
// when property name is a variable
console.log(bob['name']);
// console.log(bob[name]); // "ReferenceError: name is not defined"
console.log(bob['first name']); // property name contains special 
								// characters like space, quotes.

var propertyToPrint = 'name'; // 'age'
console.log(bob.propertyToPrint); // undefined
console.log(bob['propertyToPrint']); // undefined  -----> 'bob.propertyToPrint'
console.log(bob[propertyToPrint]); // bob 	----> 'bob['age']'
									// 不用去判断， propertyToPrint 是否和
									// 里面的变量相等

// Before ES6, class is not supported, but we can use constructor-function to
// simulate a class
// JS does not support overloading
// if your declare a function twice, later declared will
// replace previous one.

// arguments "array": ["bob", 21]
// var name = arguments[0]; var age = arguments[1];
function Student(name, age) {
	this.name = name;
	this.age = age;
}
var s = new Student("bob", 21); // 1. create {} of Student
								// 2. resolve the parameter
								// 3. this -> {} : this point to object
								// 4. execute all the code in function
								// {name: "bob", age: 21}
								// 5. return this;
console.log(s);
console.log(s instanceof Student); // true

// for "this" in JS function, if we use new keyword to invoke the function
// as a constructor function, this in the function will point to newly
// created object.


var s1 = new Student("aclice");
console.log(s1); // Student { name: 'aclice', age: undefined }

var s1 = new Student(undefined, 22);
console.log(s1); // Student { name: undefined, age: 22 }

//=======================================================================
console.log("------alex.print()-----------")
// if we directly invoke a function wihout new, this in the function will
// point to the caller of the function.
// caller: everything on the left of function name. If nothing there,
// caller will be set to global object.
var alex = {
	name: 'alex',
	age: 30,
	print: function(){
		console.log(this.name); // this -> alex

		// console.log(name); 	// ReferenceError: name is not defined
								// alex is not function, alex object will not 
								// create scope. So outside of this function
								// scope is file scope
	}
};
alex.print(); // "alex"

//====================================================================
console.log("--------caller: global------------")
var s2 = Student("kevin Hart", 999999); // caller: global
console.log(s2); // undefined. Because there is no new, steps will
				// not happend, the return step will no happend.
				// so It is undefined.
console.log(name); // kevin Hart. -> global.name
console.log(age); // 999999
// 没有caller caller就是global
// Stduent方法里
// this.name=
// This这边就指向global

//====================================================================

var order1 = {
	price: 100,
	calculate: function(){
		return {
			getTotal: function(qty) {
				return qty * this.price; // 500 * this.price; this->calc
										// this.price = calc.price
										// 500 * undefined = undefined
			}
		};
	}
};
var calc = order1.calculate();
console.log(calc.getTotal(500)); // NaN

//======================================================================

// how to change the binding of this?
// 1. function.call(newThis, param1, param2, ...);
console.log("---------1. function.call----------")
console.log(calc.getTotal.call(order1)); // then in getTotal, this point to order1
											// NaN
console.log(calc.getTotal.call(order1, 500)); // then in getTotal, 
//												this point to order1. 
//												参数，按照顺序放在后面 (50000)

// 2. function.apply(newThis, [param1, param2, ...])
console.log(calc.getTotal.apply(order1, [500]));

// unlike call/apply which will execute the function immediately,
// bind will change binding of this and return a new function
// 3. function.bind(newThis)(param1, param2, ...)
var goodGetTotal = calc.getTotal.bind(order1);
console.log(goodGetTotal(400));

//=========================================================================

// that trick/self trick (not prefer method)
var order2 = {
	price: 100,
	calculate: function(){
		var that = this; // that -> this -> order2
							//通过这个方法把 this 指向转换。
		return {
			getTotal: function(qty) {
				return qty * that.price; 
			}
		};
	}
};
var calc2 = order2.calculate();
console.log(calc2.getTotal(200)); 






















