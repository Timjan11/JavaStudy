package ru.utegulov.geometry;


public class LineWithStartAndEnd {

    public PointWithArgs start;
    public PointWithArgs end;


    public LineWithStartAndEnd(PointWithArgs start, PointWithArgs end){
        this.start = new PointWithArgs(start.x, start.y);
        this.end = new PointWithArgs(end.x, end.y);;
    }

    public void setStart(int a, int b){
        start.x = a;
        start.y = b;
    }
    public void setEnd(int a, int b){
        end.x = a;
        end.y = b;
    }

    public String getStart(){
        return "Start: {" + start.x + "; " + start.y + "}";
    }

    public String getEnd(){
        return "End: {" + end.x + "; " + end.y + "}";
    }



    public String toString(){
        return "Start: {" + start.x + "; " + start.y + "} End: {" + end.x + "; " + end.y + "} ";
    }

}
