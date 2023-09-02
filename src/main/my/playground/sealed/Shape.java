package my.playground.sealed;

public abstract sealed class Shape
        permits Circle, Rectangle, Square {
}