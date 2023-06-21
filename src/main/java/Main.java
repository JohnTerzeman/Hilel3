class Animal {
    public void makeSound() {
        System.out.println("Издает звук");
    }
}
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cat();
        for (int i = 0; i < animals.length; i++) {
            try {
                Dog dog = (Dog) animals[i];
                dog.makeSound();
            } catch (ClassCastException e) {
                System.out.println("Ошибка: ClassCastException - невозможно привести к типу Dog");
            }
        }
    }
}