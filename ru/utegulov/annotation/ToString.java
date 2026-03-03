package ru.utegulov.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ToString {
    ToStringValue value() default ToStringValue.YES;
}



class Test1{
    public static void main(String[] args) {
        Test1 test1 = new Test1("Oleg");
        System.out.println(test1);
    }
    @ToString(ToStringValue.YES)
    private String name;

    @ToString(ToStringValue.NO)
    private int secret = 42;

    private int id = 100;

    public Test1(){

    }
    public Test1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Test1{");

        boolean isFirst = true;

        Field[] fields = this.getClass().getDeclaredFields();

        for(Field field:fields){
            try{
                field.setAccessible(true);
                boolean isYes;
                ToString annotation = field.getAnnotation(ToString.class);
                ToString classAnnotation = field.getClass().getAnnotation(ToString.class);


                if(annotation != null){
                    isYes = annotation.value() == ToStringValue.YES;
                }else if((classAnnotation.value() == ToStringValue.YES)||(classAnnotation.value() == null)){
                    isYes = true;
                }else{
                    isYes = false;
                }

                if(isYes){
                    if(!isFirst){
                        st.append(", ");
                    }
                    isFirst = false;
                    st.append(field.getName()).append("=").append(field.get(this));
                }
            }catch (Exception e){

            }

        }
        st.append("}");
        return st.toString();

    }
}