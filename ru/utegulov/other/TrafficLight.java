package ru.utegulov.other;

interface Light {
    void light(TrafficLight tf);
}

class NightLight implements Light{
    @Override
    public void light(TrafficLight tf) {
        System.out.println("Желтый");
        tf.setLight(new NightLight());
    }
}

class RedLight implements Light{
    @Override
    public void light(TrafficLight tf) {
        System.out.println("Красный");
        tf.setLight(new YellowLight());
    }
}

class YellowLight implements Light{
    @Override
    public void light(TrafficLight tf) {
        System.out.println("Желтый");
        tf.setLight(new GreenLight());
    }
}

class GreenLight implements Light{

    @Override
    public void light(TrafficLight tf) {
        System.out.println("Зеленый");
        tf.setLight(new RedLight());
    }
}

public class TrafficLight{

    private Light state = new RedLight();

    public void setLight(Light light) {
        this.state = light;
    }
    public void next(){
        state.light(this);
    }


}

