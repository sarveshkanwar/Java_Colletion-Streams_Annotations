package week4_assignment6;

class Animal {
    void makeSound() {
        System.out.println("Make sound");
    }
}
class Dog extends Animal{
    @Override
    void makeSound() {
        System.out.println("woof woof");
    }
}

public class Animals {
    public static void main(String[] args) {
        Animal dog = new Dog();

        dog.makeSound();
    }
}