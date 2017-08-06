import org.junit.Test;

import java.io.*;

public class DataIOtest {


  @Test
  public void test_dataInput() throws Exception {
    DataInput input = new DataInputStream
            (new FileInputStream ("items.ser")
    );

    Item item = new Item ();

    item.description = input.readUTF ();
    item.price = input.readDouble ();
    item.isForSold = input.readBoolean ();
    item.name = input.readUTF ();

    System.out.println (item);

    Item item2 = new Item ();
    item2.description = input.readUTF ();
    item2.price = input.readDouble ();
    item2.isForSold = input.readBoolean ();
    item2.name = input.readUTF ();

    System.out.println (item2);

  }

  @Test
  public void test_dataOutput() throws Exception {

    DataOutput output = new RandomAccessFile ("items.ser", "rw");

    Item item = new Item ();

    item.name = "Apple";
    item.description = "Fruit" ;
    item.price = 10.0;
    item.isForSold = true;

    output.writeUTF (item.description);
    output.writeDouble (item.price);
    output.writeBoolean (item.isForSold);
    output.writeUTF (item.name);

    Item item2 = new Item ();
    item.name = "Watermelon";
    item.description = "BERRRY" ;
    item.price = 19.99;
    item.isForSold = false;

    output.writeUTF (item.description);
    output.writeDouble (item.price);
    output.writeBoolean (item.isForSold);
    output.writeUTF (item.name);
  }

  private class Item {
    String description;
    double price;
    boolean isForSold;
    String name;

    @Override
    public String toString() {
      return "Item{" +
              "description='" + description + '\'' +
              ", version=" + price +
              ", isForSold=" + isForSold +
              ", payload='" + name + '\'' +
              '}';
    }
  }
}
