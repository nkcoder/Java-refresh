package my.playground.afterjava8.sealed;

public abstract sealed class Shape
        permits Circle, Rectangle, Square {
}