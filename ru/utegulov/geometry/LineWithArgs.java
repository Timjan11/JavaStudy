package ru.utegulov.geometry;

import java.util.Objects;

public class LineWithArgs<T extends Point> implements Cloneable{

    private T start;
    private T end;
    public LineWithArgs(T start, T end){

        this.start = start;
        this.end = end;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
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
        return Objects.hash(start, end);
    }

    public Object clone() throws CloneNotSupportedException{
        LineWithArgs line = (LineWithArgs) super.clone();
        line.start = (T) this.start.clone();
        line.end = (T) this.end.clone();
        return line;
    }

    public String toString(){
        return "Start: {" + start+ "} End: {" + end + "} ";
    }

}


