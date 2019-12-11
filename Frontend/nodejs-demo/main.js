// 9/27/2019 (搭建一个 server 来接受各种请求，代替原来的那个java servlet)
var express = require('express'); // import express lib, express under node_modules
var bodyParser = require('body-parser'); //body-parser will parse http request 
//											body data as js object and then set 
//											on req.body。分辨解析 json，format
//											encoded 内容，并且用object发送回来。

var app = express(); // use express to implement an application

app.use(express.static(__dirname + "/public")); //serve static content
//									__dirname: 当前目录
//									__dirname + "/public" -> 绝对路径
//									node main.js -> 运行

// 使用 body parser 解析 json 数据 和 format encoded数据
//body-parser will parse http request body data as js object and then set 
//on req.body
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

//=======================================================
// app.use('/users', function(req, res, next) {
// 	if(Math.random() > 0.5){	// 一段逻辑，需要在别的middleware之前执行
// 		//						模拟用户登陆，然后才能进行CRUD操作。调用了next
// 		//						其他的才能继续运行。对后面的进行保护。
// 		next();
// 	} else {
// 		res.send(' You must login!');
// 	}
// });
//========================================================


var USERS = [
	{name: 'bob', age: 21},
	{name: 'alice', age: 22},
	{name: 'alex', age: 23}
];

//=======================================================================
// Postman APP 用来发送 get，post...method 请求。测试使用。
// GET /users
// middleware funciton
var getUsers = function(req, res){ // 每次用户发一个get请求，把users发回去
	// req.method 拿到方法种类：get,put,delete...
	// 这个 function 一般可以写在 method 后面
	res.send(USERS);
};


// app.use('/users', getUsers); // 当发出'/users'请求， 就会用 getUsers() handle 请求。
//								handle 所有请求：put,get,delete...
//								所以有了下面的 get()，分清楚方法。
//								http://localhost:3000/users

// app will use getUsers() middleware to handle any GET request sent to '/users'
app.get('/users', getUsers); 

//--------------------------------------------------------------------------
// POST /users
app.post('/users', function(req, res) {
	var newUser = req.body; // 拿到请求中的新用户。
	USERS.push(newUser);
	res.send({success: true});
});

//---------------------------------------------------------------------
// PUT /users (repalce or create)
app.put('/users', function(req, res) {

	var putUser = req.body;
	var index = USERS.findIndex(function(user) {
		return user.name === putUser.name;
	}); // 找到一个元素满足的所有条件(array.findIndex)
		// 不是 indexOf()
	if(index == -1){
		USERS.push(putUser);
	}else {
		USERS.splice(index, 1, putUser); // index: start index
//										1: count (删掉几个，从start 开始)
//										替换。
	}
	res.send({success : true});
	
});
//-------------------------------------------------------------------
// DELETE /users/:name
// :name 表示这是一个变量名字。在url里面明确delete确定的人。
app.delete('/users/:name', function(req, res){
	var name = req.params.name; // name 对应 (:name)
	USERS.forEach(function(user, index) { // user 对应自己的当前 index
		if(user.name === name){
			USERS.splice(index, 1); // forEach() 里面知道 index
			//							利用 splice 实现 delete
		}
	});
	// TODO: return false if user doesn't exist
	res.send({success: true});
});

//=======================================================================
// 如果没有 next, 两个 middleware， res.send：我们请求已经处理完，结束。代码结束，不会再往下
// Hello 2 不会出现。如果把第一个 middleware 的res.send 删掉，这个middleware就会一直
// 等待处理，页面一直处于等待状态，不会出去。
// next 会传递下去。
app.get('/hello',function(req, res, next) {
	// res.send('Hello 1');
	next(); // forward request to next middleware for further handling
});

app.get('/hello',function(req, res) {
	res.send('Hello 2');
});


//====================================================================
app.listen(3000); // working on port 3000









































