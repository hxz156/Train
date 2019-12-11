var x= 2;
function test() {
	console.log('hello!');
}

exports.ex=x; // can omit module

this.test = test; // 以前的 this 都是在 function 里面， 现在在 file 里面
// this in nodejs file is pointing to the module.exports object

console.log(this === module.exports); // true

var y = 2;
console.log(this.y); // undefined
console.log(this.test());







