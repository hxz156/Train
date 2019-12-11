// commonjs module system

// b: module.exports object in file b.
var b = require('./b'); // ./ in current folder, ../ in parent folder

console.log(b.ex);
b.test();

var c = require('./c');
console.log(c.ex);
c.test(); // hello!

























