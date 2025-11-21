package ru.utegulov.geometry;

public class LenOfLine {

    int x1, y1, x2, y2;

    public LenOfLine(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    int lenght(){
        int dx = x2 - x1;
        int dy = y2 - y1;
        double res = Math.sqrt(dx*dx+dy*dy);
        return (int) res;
    }

    @Override
    public String toString() {
        return "Длина линии - {"+ x1 + ";" + y1 + ";" + x2 + ";" + y2 + "}: "+lenght();
    }
}
