package javaassignment;

class Animal {
    String name;

    // Class constructor
    public Animal(String name) {
        this.name = name;
    }

    // Method overloading
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    public void makeSound(String sound) {
        System.out.println("Animal makes " + sound);
    }
}

// Inheritance
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Method overriding
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Interface
interface Swim {
    void swim();
}

// Abstract class
abstract class Bird {
    abstract void fly();
}

// Generalization and Specialization
class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrow flies");
    }
}

// Composition and Aggregation
class Person {
    private String name;
    private Dog pet;

    public Person(String name, Dog pet) {
        this.name = name;
        this.pet = pet;
    }

    public void playWithPet() {
        System.out.println(name + " plays with " + pet.name);
    }
}

// Abstraction and Encapsulation
interface Shape {
    void draw();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

 class FirstAnswer {
    public static void main(String[] args) {
        // Class and Object
        Animal animal = new Animal("Leo");

        // Method overloading
        animal.makeSound();
        animal.makeSound("meow");

        // Inheritance
        Dog dog = new Dog("Buddy");
        dog.makeSound();

        // Interface
        Swim fish = new Swim() {
            @Override
            public void swim() {
                System.out.println("Fish swims");
            }
        };
        fish.swim();

        // Abstract class
        Bird bird = new Sparrow();
        bird.fly();

        // Composition and Aggregation
        Person person = new Person("Alice", dog);
        person.playWithPet();

        // Abstraction and Encapsulation
        Shape shape = new Circle(5.0);
        shape.draw();
    }
}
