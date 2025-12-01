package ru.utegulov.geometry;


public class LineShift {

    public static final double SHIFTX = 10;

    public static <T extends Point> LineWithArgs<T> shift(LineWithArgs<T> line) {
        try {

            T start = (T) line.getStart().clone();
            T end   = (T) line.getEnd().clone();

            start.setX((int) (start.getX() + SHIFTX));
            end.setX((int) (end.getX() + SHIFTX));

            return new LineWithArgs<>(start, end);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

