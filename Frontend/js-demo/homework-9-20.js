function MyClass() { // this -> {}
    this.x = 100;   // {x: 100}
    var y = "abc";  
    var getX = function() { // this -> global
        console.log(this.x); // undefined (because no x in blobal)
        console.log(y); // "abc"
    }
    getX();
    this.getY = function() { // {x: 100, getY: function} (new object will be created 
                             // a getY function)
        console.log(this.x); // 100 (myClass has x=100)
        console.log(y); // "abc"
    }
    // return {x: 100, getY: function}
}
var myClass = new MyClass(); // {}. closure: {y : "abc"}
myClass.getY(); // this -> myClass






// undefined
// abc
// 100
// abc







