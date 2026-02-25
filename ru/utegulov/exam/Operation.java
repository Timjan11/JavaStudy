package ru.utegulov.exam;

import java.util.Objects;

public interface Operation {
    byte[] execute(byte[] input);
    String getName();
    String getType();
}


class CommandType{
    private final String name;
    private final int maxUsage;
    private final int executionOrder;

    public CommandType(String name, int maxUsage, int executionOrder){
        this.executionOrder = executionOrder;
        this.name = name;
        this.maxUsage = maxUsage;
    }

    public String getName() {
        return name;
    }

    public int getMaxUsage() {
        return maxUsage;
    }

    public int getExecutionOrder() {
        return executionOrder;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null)return false;
        if(getClass() != o.getClass()) return false;
        CommandType that = (CommandType)o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }



}