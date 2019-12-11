var x = 1;
function test() {
	console.log('hi');
}

// export
// module.exports = {};
module.exports.ex = x; // other file who requires can access ex
module.exports.test = test;






















