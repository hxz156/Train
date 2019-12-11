var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// 9/30/2019
// ES6 可以用 class 了
var Shape = /** @class */ (function () {
    // js/ts does not support overloading
    // optional parameter 穿和不穿都是可以的: type?, 加一个？表示 optional parameter
    function Shape(type) {
        this.type = 'No Type'; // default accessor is public
        this.x = 1; // can only be accessed within class
        this.y = 2; // can be accessed within class and child class
        this.type = type;
    }
    Shape.prototype.getX = function () {
        var x = 77777;
        return this.x; // 1 ->必须写this，否则就会 通过scope寻找了。
        // return x; // 77777
    };
    return Shape;
}());
;
var s = new Shape();
// console.log(s.x); // error, private field
console.log(s.getX());
var Rectangle = /** @class */ (function (_super) {
    __extends(Rectangle, _super);
    // default parameters
    function Rectangle(width, height) {
        if (width === void 0) { width = 100; }
        if (height === void 0) { height = 100; }
        var _this = 
        // 参数定义的时候，给一个初始值。如果没有传进去值，默认是100.
        // 提升？ 的，加一个默认值。
        _super.call(this, 'Rectangle') || this;
        _this.width = width;
        _this.height = height;
        return _this;
    }
    Rectangle.prototype.printY = function () {
        console.log(this.y); // 没有y，就去 父类里面寻找。
    };
    return Rectangle;
}(Shape));
var r = new Rectangle();
console.log("---------printY-----------");
r.printY();
