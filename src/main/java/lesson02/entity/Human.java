package lesson02.entity;

public class Human {
    private String name;
    private int age;
    private String sex;
    private double height, weight;
    private boolean merried;
    private char bloodGroup;
    private int childs;
    private int friends;
    private int pets;

    // Constructors
    public Human() {
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int age, String sex, double height, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    public Human(String name, int age, String sex, double height, double weight, boolean merried, char bloodGroup, int childs, int friends, int pets) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.merried = merried;
        this.bloodGroup = bloodGroup;
        this.childs = childs;
        this.friends = friends;
        this.pets = pets;
    }

    // Methods. Getters, setters
    // setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    //getters

    public boolean isMerried() {
        return merried;
    }

    public void setMerried(boolean merried) {
        this.merried = merried;
    }

    public char getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(char bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getChilds() {
        return childs;
    }

    public void setChilds(int childs) {
        this.childs = childs;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public int getPets() {
        return pets;
    }

    public void setPets(int pets) {
        this.pets = pets;
    }

    public void engageWashingMachine(WashingMachine washingMachine, int mode) {
        washingMachine.performWashing(mode);
    }

    public void say(String speech) {
        System.out.println(name + ": " + speech);
    }

}
