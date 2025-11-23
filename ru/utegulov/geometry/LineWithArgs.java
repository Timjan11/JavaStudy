package ru.utegulov.geometry;

import java.util.Objects;

public class LineWithArgs implements Cloneable{


    private int x1, x2, y1, y2;
    private Point start;
    private Point end;
    public LineWithArgs(Point start, Point end){
//        this.x1 = x1;
//        this.y1 = y1;
//        this.x2 = x2;
//        this.y2 = y2;
//        start.x = x1;
//        start.y = y1;
//        end.x = x2;
//        end.y = y2;
        this.start = start;
        this.end = end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o)  {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        LineWithArgs line = (LineWithArgs) o;
        if(!((this.start.equals(line.start) && this.end.equals(line.end))||(this.start.equals(line.end) && this.end.equals(line.start)))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, x1, x2, y1, y2);
    }

    public Object clone() throws CloneNotSupportedException{
        LineWithArgs line = (LineWithArgs) super.clone();
        line.start = (Point) this.start.clone();
        line.end = (Point) this.end.clone();
        return line;
    }

    public String toString(){
        return "Start: {" + start+ "} End: {" + end + "} ";
    }

}


