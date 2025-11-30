package ru.utegulov.main;

import ru.utegulov.mathematic.Fraction;
import ru.utegulov.animals.*;
import ru.utegulov.cities.*;
import ru.utegulov.connection.*;
import ru.utegulov.geometry.*;
import ru.utegulov.house.*;
import ru.utegulov.human.*;
import ru.utegulov.student.*;
import ru.utegulov.weapon.*;


public class Main{
    public static void main(String[] args) throws CloneNotSupportedException{


        //задача 1.4.1
        PointWithArgs point = new PointWithArgs(3, 5);
        System.out.println(point);
        System.out.println("\n");

        //задача 1.4.2
        //LineWithArgs line = new LineWithArgs(1, 3 ,23, 8);
//        System.out.println(line);
//        System.out.println("\n");

        //задача 1.4.3

        //PolylineV2 polyline1 = new PolylineV2();


        //System.out.println(polyline1);

        PointWithArgs[] points = {new PointWithArgs(3, 5), new PointWithArgs(25, 6), new PointWithArgs(7, 8)};
        PolylineV2 polyline2 = new PolylineV2(points);
        System.out.println(polyline2);
        System.out.println("\n");

        //задача 1.4.4
        HouseWithArgs house = new HouseWithArgs(2);

        //house.floors =3; // горит красным!
        System.out.println(house);
        System.out.println("\n");

        //задача 1.4.5

        Names name1  = new Names("Клеопатра");
        System.out.println(name1);
        Names name2 = new Names("Александр", "Сергеевич", "Пушкин");
        System.out.println(name2);
        Names name3 = new Names("Владимир", "Маяковский");
        System.out.println(name3);
        Names name4 = new Names("Христофор", "Бонифатьевич");
        System.out.println(name4);

        System.out.println("\n");

        // задача 1.4.6

        HumanConstruct human = new HumanConstruct("Лев");
        System.out.println(human);

        Name name5 = new Name("Пушкин", "Сергей");
        HumanConstruct human2 = new HumanConstruct(name5, "Лев");
        System.out.println(human2);

        HumanConstruct human3 = new HumanConstruct("Александр", "Сергей");
        System.out.println(human3);
        System.out.println("\n");

        //Задача 1.4.7

        Student student = new Student("Вася", 3, 4, 5);
        System.out.println(student);
        Student student2 = new Student("Максим");
        System.out.println(student2);
        System.out.println("\n");

        //задача 1.4.8

        City tumen = new City("Тюмень");
        System.out.println(tumen);

        City tagil = new City("Тагил", tumen, 100);
        System.out.println(tagil);
        System.out.println("\n");


        //Задача 1.5.1
        Gun gun = new Gun(3);
        for(int i=5;i>0;i--){
            gun.fire();
        }
        System.out.println("\n");

        //Задача 1.5.2

        Cat cat = new Cat("Барсик");
        cat.sayMeow();
        cat.sayMeowNcnt(3);
        System.out.println("\n");

        //Задача 1.5.3

        LenOfLine newLine = new LenOfLine(1, 1, 10, 15);
        System.out.println(newLine);
        System.out.println("\n");

        //Задача 1.5.4
        HumanWithName lev = new HumanWithName("Лев");
        System.out.println(lev);
        NameConstructor pushkin = new NameConstructor("Сергей", "Пушкин");
        HumanWithName sergey = new HumanWithName(lev, pushkin);
        System.out.println(sergey);
        HumanWithName alex = new HumanWithName(sergey, "Александр");
        System.out.println(alex);
        System.out.println("\n");
        System.out.println("Лев (фамилия): " + lev.getLastName());
        System.out.println("Сергей (фамилия): " + sergey.getLastName());
        System.out.println("Александр (фамилия): " + alex.getLastName());
        System.out.println("\n");

        //Задача 1.5.5
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 10);
        Fraction fraction3 = new Fraction(1, 3);
        Fraction fraction4 = new Fraction(2, 5);

        Fraction res = fraction1.addition(fraction1);
        res.example(fraction1, "addition");


        Fraction res2 = fraction4.subtraction(fraction2);
        res2.example(fraction2, "subtraction");

        Fraction res3 = fraction1.subtraction(fraction3);
        res3.example(fraction3, "multiplication");

        Fraction res4 = fraction2.subtraction(fraction4);
        res4.example(fraction4, "division");

        Fraction res5 = fraction1.addition(fraction2).division(fraction3).subtraction(fraction4);
        System.out.println(res5);
        System.out.println("\n");


        //Задача 1.5.6
        Excellent vasya =new Excellent("Вася", 3, 4, 5, 4);
        Excellent petya =new Excellent("Петя", 5, 5, 5, 5);

        System.out.println(vasya.mean());
        System.out.println(vasya.isExcelent());
        System.out.println(petya.mean());
        System.out.println(petya.isExcelent());
        System.out.println("\n");

        //Задача 1.5.7
        Point[] points1 = {new Point(1, 5), new Point(2, 8), new Point(5, 3)};
        PolylineAdd polylineAdd = new PolylineAdd(points1);
        System.out.println(polylineAdd);
        double len = polylineAdd.getLength();
        System.out.println(len);

        Point[] addPoints = { new Point(5, 15), new Point(8, 10)};
        PolylineAdd extendPolyline = polylineAdd.addPoints(addPoints);

        System.out.println(extendPolyline);
        double extendLength = extendPolyline.getLength();
        System.out.println("Длина расширенной ломаной: " + extendLength);
        System.out.println("\n");

        //Задача 1.5.8
        Square square = new Square(5, 3, 23);
        System.out.println("1. " + square);

        PolylineWihtArrOfPoints polyline = square.getPolyline();
        System.out.println("2. Полученная ломаная: " + polyline);

        double initialLength = polyline.getLength();
        System.out.println("3. Длина ломаной: " + initialLength);

        Point[] points3 = polyline.getPoints();
        if (points3.length > 0) {

            Point newLastPoint = new Point(15, 25);
            PolylineWihtArrOfPoints modifiedPolyline = polyline.setPoint(points3.length - 1, newLastPoint);
            System.out.println("4. Измененная ломаная: " + modifiedPolyline);

            double modifiedLength = modifiedPolyline.getLength();
            System.out.println("5. Длина измененной ломаной: " + modifiedLength);
        }
        System.out.println("\n");

        //Задача 1.6.1

        HouseOnSky house1 = new HouseOnSky(4);
        HouseOnSky house2 = new HouseOnSky(13);
        //HouseOnSky house3 = new HouseOnSky(-2);
        System.out.println(house1);
        System.out.println(house2);
        house1.setFloors(1);
        System.out.println(house1);
        //System.out.println(house3);
        System.out.println("\n");

        //Задача 1.6.2

        NotEmptyNames name8 = new NotEmptyNames("Колобанов", "Артем","АкадемикаАнтонович");
        //NotEmptyNames name9 = new NotEmptyNames("");
        //name8.lastname = "Мананго";
        System.out.println(name8);
        //System.out.println(name9);
        System.out.println("\n");

        //Задача 1.6.3

        SideOfSquare square1 = new SideOfSquare(3, 4, 10);
        System.out.println(square1);
        System.out.println("\n");

        //Задача 1.6.4

        Fraction fr = new Fraction(12, 6);
        System.out.println(fr);
        System.out.println("\n");

        //Задача 1.6.5

        GunReload gun1 = new GunReload(7);
        gun1.gunReloading(3);
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.gunReloading(8);
        gun1.fire();
        gun1.fire();
        gun1.unreloading();
        gun1.fire();
        System.out.println("\n");


        //Задача 1.6.6
        PointWithArgs point2 = new PointWithArgs(5, 3);
        PointWithArgs point3 = new PointWithArgs(6, 9);
        LineWithStartAndEnd line1 = new LineWithStartAndEnd(point2, point3);

        line1.getStart();
        line1.getEnd();
        line1.setStart(1, 6);
        System.out.println(line1);
        System.out.println("\n");

        //Задача 1.6.7
        HumanWithName father1 = new HumanWithName("Колобанов");
        Parents hum = new Parents(father1, "Ваня");

        System.out.println(hum.getFather());
        System.out.println(hum.getName());
        System.out.println("\n");

        //Задача 1.6.8

        DiapasoneOfGrades grades = new DiapasoneOfGrades("Тема", 2, 4, 5, 2);
        System.out.println(grades.toString());
        System.out.println("\n");

        //Задача 1.6.9

        Roads moscow = new Roads("1");
        Roads spb = new Roads("2");
        Roads kazan = new Roads("3");
        Roads novgorod = new Roads("4");

        // Добавляем дороги
        moscow.addRoad(spb, 7);
        moscow.addRoad(kazan, 8);
        spb.addRoad(novgorod, 5);

        System.out.println(moscow);
        System.out.println(spb);
        System.out.println(kazan);
        System.out.println(novgorod);
        moscow.addRoad(spb, 3);
        System.out.println("\n");

        //Задача 1.6.10

        Department1610 itDepartment = new Department1610("IT");
        Department1610 hrDepartment = new Department1610("HR");

        Worker1610 ivanov = new Worker1610("Иван", "Иванов");
        Worker1610 petrov = new Worker1610("Петр", "Петров");
        Worker1610 sidorov = new Worker1610("Сидор", "Сидоров");

        ivanov.setDepartment(itDepartment);
        petrov.setDepartment(itDepartment);
        sidorov.setDepartment(hrDepartment);

        ivanov.becomeBoss();
        sidorov.becomeBoss();

        System.out.println("После назначения:");
        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
        System.out.println(itDepartment);
        System.out.println(hrDepartment);


        //Задача 5.2.1
        Fraction fr1 = new Fraction(12, 6);
        Fraction fr1Copy = (Fraction) fr1.clone();

        fr1Copy.setNumerator(11);
        fr1Copy.setDenominator(10);
        System.out.println(fr1);
        System.out.println(fr1Copy);

        System.out.println("\n");

        //Задача 5.2.2

        Point point1 = new Point(1, 2);
        Point pointCopy = (Point) point1.clone();
        pointCopy.setX(3);
        pointCopy.setY(4);
        System.out.println(point1);
        System.out.println(pointCopy);
        System.out.println("\n");

        //Задача 5.2.3
        Point point4 = new Point(22, 33);
        Point point5 = new Point(44, 55);
        LineWithArgs line = new LineWithArgs(point4, point5);
        LineWithArgs lineCopy  = (LineWithArgs) line.clone();
        Point point4Copy = new Point(11, 22);
        Point point5Copy = new Point(66 ,77);

        lineCopy.setStart(point4Copy);
        lineCopy.setEnd(point5Copy);
        System.out.println(line);
        System.out.println(lineCopy);
        System.out.println("\n");


        //Задача 6.1.2
        Cat cat1 = new Cat("Oleg");
        Parrot parrot  = new Parrot("riogreg");

        Warehouse warehouse = new Warehouse(parrot);
        System.out.println(warehouse.getObj().orElse("Ничего нету :( "));
        System.out.println("\n");

        //Задача 6.1.3

        Student student1 = new Student("Durak", 2, 2, 3, 4, 2);
        Student student3 = new Student("Balbes", 4, 5, 4, 5 );

        System.out.println(student1.compareTo(student3));
        System.out.println("\n");

        //Задача 6.1.5

        Point2D point6 = new Point2D(1, 3);
        Point3D point3D = new Point3D(12, 45, 11);
        LineWithArgs line2 = new LineWithArgs(point3D, point6);
        System.out.println(line2.getStart());
        System.out.println(line2);

    }
}