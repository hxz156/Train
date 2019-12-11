// JS setTimeout vs setInterval


// how JS executes functions(syn/async)?
function a() {

}
function b() {
	a();
}
function c() {
	b();
}
c();

//=======================================================================

// JS is running in single thread node(no multi-threading)
// JS only has one thread which is never suspended!!

// setTimeout REGISTERs a function which will be executed after specific
// time duration.
setTimeout(function() { // callback function -> asynchronous function
	console.log("hi");
}, 3000);	// 10:27:30 JS will count down for 3s

setTimeout(function() {
	console.log("hello");
}, 2000); // 10:27:30 JS will count down for 2s immediately after above count

// In JAVA will take 5 seconds, but in JS it takes 3 seconds

console.log("end of file");	// 10:27:30

//=========================================================================

// // setInterval: will execute callback function for every period
// // of time continuously
console.log("----------setInterval-----------");
var id = setInterval(function() {
	console.log(new Date());
}, 1000);

//========================================================================
// // clearInterval(idOfIntervalFunctionToStop): stop interval function
setTimeout(function() {
	clearInterval(id);
}, 10000); // 打到第10秒的时候就停止


//==========================================================================


// how to use setTimeout to implement setInterval()?
// output current time for every 1s
console.log("------------ how to use setTimeout to implement setInterval()?");
var go = setTimeout(function h1() {
	console.log(new Date());
	go;
}, 1000);





























