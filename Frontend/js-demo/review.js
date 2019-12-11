[] -> new Array();
{} -> new Object();
// var test = new Function();
// Function.prototype.call
function test() {
    this.hello = function() {}
}
test.hi = function() {
    console.log('hi');  
};
test();
test.call(); // 可以
test.hi(); // 可以
var t = new test();
t.hi(); // ?	 不行
test.hello(); // ? 不行

// JS 中函数也可以成为对象，但是 java 里面 对象是对象，函数是函数。