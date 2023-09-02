package main.sealed;

public sealed class Rectangle extends Shape
    permits FilledRectangle, TransparentRectangle{
}
