import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class Main {
  public static void main(String[] args){
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    Plane plane = new Plane();
    Car car = new Car();
    vehicles.add(plane);
    vehicles.add(car);

    for (Vehicle obj : vehicles){
      obj.move();
    }

    String str = "Count the number of words in this sentence";
    int count = str.split("\\s").length;
    System.out.println(count);

    String[] words = str.split("\\s");
    List<List<Character>> chars = new ArrayList<>();
    for (String curStr : words){
      List<Character> word = new ArrayList<>();
      for (char c : curStr.toCharArray()){
        word.add(c);
      }
      chars.add(word);
    }

    for (List<Character> word : chars){
      for (Character character : word){
        System.out.println(character);
      }
    }

    ArrayList<String> li = new ArrayList<>();
    li.add("werqewre");
    li.add("qwe");
    li.add("asdasdasdasd");

    System.out.println(li.toString());
    Collections.sort(li, (String a, String b) -> a.length() - b.length());
    System.out.println(li.toString());

    System.out.println("impossible".indexOf("possible"));

  }
}

abstract class Vehicle {
  public abstract void move();
}

class Car extends Vehicle {
  public void move () {
    System.out.println("drive");   
  }
}

class Plane extends Vehicle {
  public void move () {
    System.out.println("fly");
  }
}
