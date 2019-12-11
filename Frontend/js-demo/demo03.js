// js object properties

// 	property name : property value
//	key : value
var bob = {
	name : 'bob',
	age : 21
};

// how to print all the properties of an object?
// 1. Object.keys(obj) 	-> return an array of all enumerable property 
// 							names for the object
var bobKeys = Object.keys(bob);
console.log(bobKeys); // [ 'name', 'age' ]

for(var i=0; i<bobKeys.length; i++){
	var key = bobKeys[i];
	console.log(key + ": " + bob[key]);
}

// 2. for in loop (similar to enhanced for loop)
for(var key in bob){ // not in bobKeys
	console.log(key + ": " + bob[key]);
}

// array is also an object
var arr = ['a', 'b', 'c'];
console.log(arr[0]);
// var arrObj = {0:'a', 1:'b', 2:'c', length: 3}
// arrObj['0'] -> arrObj[0] 如果 key 是数字，可以忽略引号
// arrObj.0 不行，因为 js 分不清楚 . 是否是小数点。
console.log(arr.length);

// length of arr is not an enumerable property
console.log(Object.keys(arr)); // [ '0', '1', '2' ]
for(var i in arr){
	console.log(arr[i]);
}

//====================================================================

// how to create an non-enumerable property for object?
bob.score = 99; // we can dynamically add property in bob
				// then score is enumerable

console.log(Object.keys(bob)); // [ 'name', 'age', 'score' ]

// 3rd parameter: property descripters(configuration for property)
Object.defineProperty(bob, 'salary', {
	configurable: true, // 用 Object.defineProperty,的就能够被修改
	enumerable: false,
	value: 2000
});

console.log(Object.keys(bob)); // [ 'name', 'age', 'score' ]
console.log(bob.salary); // 2000
// console.log(bob[salary]); // ReferenceError: salary is not defined

//===================================================================
// how to prevent a property to be changed?

Object.defineProperty(bob, 'gender', {
	writable: false,
	value: "male"
});
console.log(bob['gender']); // male
bob['gender'] = 'female';
console.log(bob['gender']); // male


// object status
// 1. extensible: add new property on object
var obj1 = {};
obj1.x = 1;
Object.preventExtensions(obj1);

obj1.y = 2;
console.log(obj1); // { x: 1 }

// 2.sealed: can not add/remove any property on object
var obj2 = {x : 1};
obj2.y = 2;
delete obj2.x;
console.log(obj2); // { y: 2 }

Object.seal(obj2); 
obj2.z = 3;
delete obj2.y;
obj2.y = 3;
console.log(obj2); // { y: 3 }

// 3. frozen: can't add/remove/update any property on object
var obj3 = {x:1, y:2};
Object.freeze(obj3);
obj3.z = 3;
delete obj3.x;
obj3.y = 0;
console.log(obj3);

console.log(Object.isExtensible(obj1));
console.log(Object.isSealed(obj2));
console.log(Object.isFrozen(obj3));















































