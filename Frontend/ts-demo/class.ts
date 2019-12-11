// 9/30/2019
// ES6 可以用 class 了
class Shape{
    public type: string = 'No Type'; // default accessor is public
    private x: number = 1; // can only be accessed within class
    protected y: number = 2; // can be accessed within class and child class

    // js/ts does not support overloading
    // optional parameter 穿和不穿都是可以的: type?, 加一个？表示 optional parameter
    constructor(type?: string) {
        this.type = type;
    }

    getX(): number{
        let x = 77777;
        return this.x; // 1 ->必须写this，否则就会 通过scope寻找了。
        // return x; // 77777
    }
};
let s: Shape = new Shape();
// console.log(s.x); // error, private field
console.log(s.getX());


class Rectangle extends Shape{
    width: number;
    height: number;

    // default parameters
    constructor(width: number = 100, height: number = 100) {
        // 参数定义的时候，给一个初始值。如果没有传进去值，默认是100.
        // 提升？ 的，加一个默认值。

        // call the super class constructor and pass in the type parameter:
        super('Rectangle'); // 子类继承一个父类，js必须要用 super。js 不会像java自动生成。
        this.width = width;
        this.height = height;
    }

    printY() {
        console.log(this.y); // 没有y，就去 父类里面寻找。
    }
}
let r: Rectangle = new Rectangle();
console.log("---------printY-----------");
r.printY();
























