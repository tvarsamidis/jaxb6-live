package gr.codehub.xml.s01reflection;

public class Dog {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    public void showTag() {
        System.out.println("I am a rare breed of dog.");
        System.out.println("My name is " + name + ".");
    }
    
    void makeSound() {
        System.out.println("Woof woof!");
    }

    protected void bringNewspaper() {
        System.out.println("I will bring the newspaper for you!");
    }

    private void shareSecret() {
        System.out.println("I like ice cream!");
    }
}
