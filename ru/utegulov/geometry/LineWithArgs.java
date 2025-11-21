package ru.utegulov.geometry;

import java.util.Objects;

public class LineWithArgs {


    private int x1, x2, y1, y2;
    private Point start;
    private Point end;
    public LineWithArgs(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        start.x = x1;
        start.y = y1;
        end.x = x2;
        end.y = y2;
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

    public String toString(){
        return "Start: {" + x1 + "; " + y1 + "} End: {" + x2 + "; " + y2 + "} ";
    }

}


