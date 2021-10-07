public class Abstraction {
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.Move();


    }
}

abstract class Animal{
  public   abstract void Move();
}

class Dog extends Animal{

    @Override
    public void Move() {
        System.out.println("Dog moves as running");
    }
}

