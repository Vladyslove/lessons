import casting.Animal;
import casting.Cat;
import casting.Dog;
import casting.Hamster;
import casting.MegaHamster;

public class Main {
  static int a;

    static  { // first initializator look up in Shildt
      a = 10;
    }

    {

    }  // second initializator
    int b;
    {
      b = 20;
    }
    public static void main(String[]  args) {
        System.out.println("Lesson 11");

        System.out.println(a);
        // System.out.println(b); // won't compile
        Dog dog = new Dog();
        Cat cat = new Cat();

        // Dog dog2 = (Dog) dog;
        // Cat dog2 = (Cat) dog;
        // dog2.makeNoise();
        dog.makeNoise();
        cat.makeNoise();

        // Dog pets[] = new Dog[2];
        Animal pets[] = new Animal[4];
        pets[0] = dog;
        pets[1] = cat;
        pets[2] = new Hamster();
        pets[3] = new MegaHamster();
        ((Dog)pets[0]).makeNoise();
        ((Cat)pets[1]).makeNoise();

        for (int i = 0; i < pets.length; i++) {
          pets[i].makeNoise();
          // pets[i].getName();
        }
        System.out.println(Animal.HELLO);
        // Animal.HELLO = "KKK"; // // will not compile // cannot assign a value to final variable HELLO

        // Animal a = new Animal(); // will not compile
        // a.makeNoise();// will not compile
        //>>>>>>>>>>>>>>>>>>>>>>>>>
        System.out.println(dog instanceof Dog);
        System.out.println(pets[0] instanceof Dog);
        System.out.println(pets[1] instanceof Dog);
        System.out.println(pets[2] instanceof Animal);
        System.out.println(pets[3] instanceof Hamster);
        System.out.println(pets[3] instanceof MegaHamster);
        System.out.println(pets[2] instanceof MegaHamster);
        // System.out.println(cat instanceof Dog); // will not compile

        if (pets[0] instanceof Dog) {
          ((Dog)pets[0]).makeNoise();
        }
        for (int i = 0; i < pets.length; i++) {
          if (pets[i] instanceof Dog) {
            System.out.println("I'm a dog");
          } else if (pets[i] instanceof Cat) {
            System.out.println("I'm a cat");
          } else if (pets[i] instanceof Hamster) {
            System.out.println("I'm a hamster");
          } /*  else if (pets[i] instanceof MegaHamster) {
            System.out.println("I'm a megaHamster");
          } */ else {
            System.out.println("I'am ???");
          }
        }


    }
        // All below is my training
//   static int d;
//   static int b;
//
//   Main (int d, int b) {
//     System.out.println(d*b*b);
//
//   }
//
//   public static int hi (int f, int g) {
//     int res = f+g;
//   return res;
//   }
//
//   public static void hi2 (int h, int v) {
//     int res2 = h*v;
//     System.out.println(res2);
//   // return res2;
//   }
//
// int c = 1213;
// static int a;
//
//   static  { // first initializator look up in Shildt
//     a = 10;
//   }
//
//   {
//
//   }  // second initializator
//   public static void main(String[]  args) {
//       System.out.println("Lesson 11");
//       Main m = new Main(12,5);
//       System.out.println(m.c + " "+ m.hi(2,3));
//       m.hi2(22,33);
//       System.out.println(m.a);
//       System.out.println(m.d + m.b);
//       System.out.println(a);
//   }
}
