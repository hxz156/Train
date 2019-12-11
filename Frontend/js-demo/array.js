// JS array

var arr = [10, 20, 30];
var newArr =  arr.filter(function (elem) {
	// 对数组里面的元素都执行一次
	return elem > 20; // 保留 >20 的元素
});
// filter will not change original array
// it will filter element in the array on by one using your logic
// and return a new array

console.log(arr); // [ 10, 20, 30 ]
console.log(newArr); // [ 30 ]


//==========================================================================


//===============================================================================

// concat
// The concat() method is used to merge two or more arrays. 
// This method does not change the existing arrays, but instead returns a new array.
var array1 = ['a', 'b', 'c'];
var array2 = ['d', 'e', 'f'];
console.log(array1.concat(array2)); // [ 'a', 'b', 'c', 'd', 'e', 'f' ]

const num1 = [1, 2, 3];
const num2 = [4, 5, 6];
const num3 = [7, 8, 9];
const numbers = num1.concat(num2, num3);
console.log(numbers); // [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ]

//==============================================================================

// find
// The find() method returns the value of the first element in 
// the provided array that satisfies the provided testing function.
// const num3 = [7, 8, 9];
console.log("------------find-------------");
const found = num3.find(function(elem) {
	return elem > 5;
});
console.log(found);

//=============================================================================
// findIndex
// The findIndex() method returns the index of the first element in the array 
// that satisfies the provided testing function. Otherwise, it returns -1, 
// indicating that no element passed the test.
var array1 = [5, 12, 8, 130, 44];

function isLargeNumber(element) {
  return element > 13;
}

console.log(array1.findIndex(isLargeNumber));
// expected output: 3


//==============================================================================

// forEach
// The forEach() method executes a provided function once for each array element.
var array3 = ['a', 'b', 'c'];
array3.forEach(function(elem) {
	console.log("for each : " + elem);
});

//===============================================================================

// indexOf
// The indexOf() method returns the first index at which a given element 
// can be found in the array, or -1 if it is not present.
var beasts = ['ant', 'bison', 'camel', 'duck', 'bison'];

console.log(beasts.indexOf('bison'));
// expected output: 1

// start from index 2
console.log(beasts.indexOf('bison', 2));
// expected output: 4

console.log(beasts.indexOf('giraffe'));
// expected output: -1


//==============================================================================


// join
// The join() method creates and returns a new string by concatenating 
// all of the elements in an array (or an array-like object), separated by 
// commas or a specified separator string. If the array has only one item, 
// then that item will be returned without using the separator.

var elements = ['Fire', 'Air', 'Water'];

console.log(elements.join());
// expected output: "Fire,Air,Water"

console.log(elements.join(''));
// expected output: "FireAirWater"

console.log(elements.join('-'));
// expected output: "Fire-Air-Water"


//===============================================================================


// map
// The map() method creates a new array with the results of calling a provided 
// function on every element in the calling array.
var array1 = [1, 4, 9, 16];

// pass a function to map
const map1 = array1.map(x => x * 2);

console.log(map1);
// expected output: Array [2, 8, 18, 32]


// map
var doubleArr = arr.map(function(elem) {
	return elem * 2;
});
console.log(doubleArr); // [ 20, 40, 60 ]

//===========================================================================

// pop
// The pop() method removes the last element from an array and returns 
// that element. This method changes the length of the array.
var plants = ['broccoli', 'cauliflower', 'cabbage', 'kale', 'tomato'];

console.log(plants.pop());
// expected output: "tomato"

console.log(plants);
// expected output: Array ["broccoli", "cauliflower", "cabbage", "kale"]

plants.pop();

console.log(plants);
// expected output: Array ["broccoli", "cauliflower", "cabbage"]

//=============================================================================

// push
// The push() method adds one or more elements to the end of an array 
// and returns the new length of the array.
const animals = ['pigs', 'goats', 'sheep'];

const count = animals.push('cows');
console.log(count);
// expected output: 4
console.log(animals);
// expected output: Array ["pigs", "goats", "sheep", "cows"]

animals.push('chickens', 'cats', 'dogs');
console.log(animals);
// expected output: Array ["pigs","goats","sheep","cows","chickens","cats","dogs"]


//============================================================================

// reduce
// The reduce() method executes a reducer function (that you provide) 
// on each element of the array, resulting in a single output value.
const array1 = [1, 2, 3, 4];
const reducer = (accumulator, currentValue) => accumulator + currentValue;

// 1 + 2 + 3 + 4
console.log(array1.reduce(reducer));
// expected output: 10

// 5 + 1 + 2 + 3 + 4
console.log(array1.reduce(reducer, 5));
// expected output: 15


// 10 + 20 + 30
var sum = arr.reduce(function(acc, cur) { // acc -> accumulate value
								// cur -> current value
	return acc + cur;
}, 0); // 0 是初始值，因为 acc 最开始没有值
console.log(sum);

//=========================================================================


// revserse
// The reverse() method reverses an array in place. The first array element 
// becomes the last, and the last array element becomes the first.
var array1 = ['one', 'two', 'three'];
console.log('array1: ', array1);
// expected output: Array ['one', 'two', 'three']

var reversed = array1.reverse(); 
console.log('reversed: ', reversed);
// expected output: Array ['three', 'two', 'one']

/* Careful: reverse is destructive. It also changes
the original array */ 
console.log('array1: ', array1);
// expected output: Array ['three', 'two', 'one']


//=========================================================================

// shift/unshift
// The unshift() method adds one or more elements to the beginning of an 
// array and returns the new length of the array.
var array1 = [1, 2, 3];

console.log(array1.unshift(4, 5));
// expected output: 5

console.log(array1);
// expected output: Array [4, 5, 1, 2, 3]

//--------------------------------------------------------------------

// The shift() method removes the first element from an array and returns 
// that removed element. This method changes the length of the array.
var array1 = [1, 2, 3];

var firstElement = array1.shift();

console.log(array1);
// expected output: Array [2, 3]

console.log(firstElement);
// expected output: 1

//===============================================================================

// slice
// The slice() method returns a shallow copy of a portion of an array 
// into a new array object selected from begin to end (end not included) 
// where begin and end represent the index of items in that array. 
// The original array will not be modified.

var animals = ['ant', 'bison', 'camel', 'duck', 'elephant'];

console.log(animals.slice(2));
// expected output: Array ["camel", "duck", "elephant"]

console.log(animals.slice(2, 4));
// expected output: Array ["camel", "duck"]

console.log(animals.slice(1, 5));
// expected output: Array ["bison", "camel", "duck", "elephant"]


//=====================================================================


// sort
// The sort() method sorts the elements of an array in place and 
// returns the sorted array. The default sort order is built upon 
// converting the elements into strings, then comparing their sequences 
// of UTF-16 code units values.

var months = ['March', 'Jan', 'Feb', 'Dec'];
months.sort();
console.log(months);
// expected output: Array ["Dec", "Feb", "Jan", "March"]

var array1 = [1, 30, 4, 21, 100000];
array1.sort();
console.log(array1);
// expected output: Array [1, 100000, 21, 30, 4]


//========================================================================

// splice
// The splice() method changes the contents of an array by removing or 
// replacing existing elements and/or adding new elements in place.

var months = ['Jan', 'March', 'April', 'June'];
months.splice(1, 0, 'Feb');
// inserts at index 1
console.log(months);
// expected output: Array ['Jan', 'Feb', 'March', 'April', 'June']

months.splice(4, 1, 'May');
// replaces 1 element at index 4
console.log(months);
// expected output: Array ['Jan', 'Feb', 'March', 'April', 'May']

























