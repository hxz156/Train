

function mySetTimeout() {
	setTimeout(function() {
		console.log(new Date());
		mySetTimeout();
	}, 1000);
}
mySetTimeout();












