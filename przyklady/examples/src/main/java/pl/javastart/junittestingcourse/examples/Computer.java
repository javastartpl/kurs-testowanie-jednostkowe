package pl.javastart.junittestingcourse.examples;

public class Computer{

    private int cpu;
    private int memory;
    private String name;

    public Computer(int cpu, int memory, String name) {
        this.cpu = cpu;
        this.memory = memory;
        this.name = name;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", memory=" + memory +
                ", name='" + name + '\'' +
                '}';
    }
}
