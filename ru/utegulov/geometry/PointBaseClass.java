package ru.utegulov.geometry;

abstract class PointBaseClass {
    protected String color;
    protected Integer size;
    protected String shape;
    protected String borderColor;


    public PointBaseClass() {
        this.color = null;
        this.size = null;
        this.shape = null;
        this.borderColor = null;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }


    public abstract String getCoordinates();

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(getCoordinates());

        if (color != null) {
            description.append(", color: ").append(color);
        }

        if (size != null) {
            description.append(", size: ").append(size);
        }

        if (shape != null) {
            description.append(", shape: ").append(shape);
        }

        if (borderColor != null) {
            description.append(", border: ").append(borderColor);
        }

        return description.toString();
    }

    public String getColor() { return color; }
    public Integer getSize() { return size; }
    public String getShape() { return shape; }
    public String getBorderColor() { return borderColor; }
}
