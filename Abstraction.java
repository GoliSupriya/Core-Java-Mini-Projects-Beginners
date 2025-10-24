public class Abstraction {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.makeSound();
        cat.makeSound();
    }
}

abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bow bow");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow meow");
    }
}
