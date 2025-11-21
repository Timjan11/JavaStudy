package ru.utegulov.geometry;

import java.util.Arrays;

public class PolylineWihtArrOfPoints {
    private Point[] points;

    public PolylineWihtArrOfPoints() {
        this.points = new Point[0];
    }

    public PolylineWihtArrOfPoints(Point[] points) {
        if (points == null) {
            this.points = new Point[0];
        } else {
            this.points = Arrays.copyOf(points, points.length);
        }
    }

    public PolylineWihtArrOfPoints addPoints(Point[] newPoints) {
        if (newPoints == null || newPoints.length == 0) {
            return new PolylineWihtArrOfPoints(this.points);
        }

        Point[] combinedPoints = new Point[this.points.length + newPoints.length];
        System.arraycopy(this.points, 0, combinedPoints, 0, this.points.length);
        System.arraycopy(newPoints, 0, combinedPoints, this.points.length, newPoints.length);
        return new PolylineWihtArrOfPoints(combinedPoints);
    }

    public PolylineWihtArrOfPoints addPoints(Point[]... newPoints) {
        return addPoints(newPoints);
    }

    // Метод для изменения точки по индексу
    public PolylineWihtArrOfPoints setPoint(int index, Point newPoint) {
        if (index < 0 || index >= points.length || newPoint == null) {
            return new PolylineWihtArrOfPoints(this.points);
        }

        Point[] newPoints = Arrays.copyOf(points, points.length);
        newPoints[index] = newPoint;
        return new PolylineWihtArrOfPoints(newPoints);
    }

    public double getLength() {
        if (points.length < 2) {
            return 0.0;
        }

        double totalLength = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            totalLength += points[i].distanceTo(points[i + 1]);
        }
        return totalLength;
    }

    public Point[] getPoints() {
        return Arrays.copyOf(points, points.length);
    }

    // Метод для получения последней точки
    public Point getLastPoint() {
        if (points.length == 0) {
            return null;
        }
        return points[points.length - 1];
    }

    @Override
    public String toString() {
        if (points.length == 0) {
            return "Line: {}";
        }
        StringBuilder res = new StringBuilder("Line: {");
        for (int i = 0; i < points.length; i++) {
            res.append(points[i]);
            if (i < points.length - 1) {
                res.append(", ");
            }
        }
        res.append('}');
        return res.toString();
    }
}

