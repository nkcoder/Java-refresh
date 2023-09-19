package my.playground.afterjava8.sealed;

public sealed class Rectangle extends Shape
    permits FilledRectangle, TransparentRectangle{
}
