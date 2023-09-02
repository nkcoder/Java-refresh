package my.playground.sealed;

public sealed class Rectangle extends Shape
    permits FilledRectangle, TransparentRectangle{
}
