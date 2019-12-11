function MyClass(){
  this.x = 100; 
  console.log(x); 
  x = "def";    
  this.getX = function(){ 
    console.log(this.x); 
  };
  var x = "abc ";
  var getX = function(){
    console.log(this.x); 
    console.log(x); 
  };
  return {
    getX: getX, 
    x: "ghi"   
  };
}
MyClass().getX();
x = 300;
getX();






