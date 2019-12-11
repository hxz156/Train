var a;
var num10 = 10;
var num20 = 20;
var numEmpty;
a = num10 || num20;
console.log("a = b | c: " + a); // 10
a = num10 || Number.MIN_VALUE;
console.log(a); // 10
a = numEmpty || Number.MAX_VALUE;
console.log(a); // 1.7976931348623157e+308
a = Number.MIN_VALUE || num20;
console.log(a); // 5e-324
