package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
  public static <T> void serialize(String path, T serializee) throws IOException{
    FileOutputStream fileOut =
        new FileOutputStream(path);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(serializee);
    out.close();
    fileOut.close();
  }
  public static Object deserialize(String path) throws IOException{
    Object o;
    try {
      FileInputStream fileIn = new FileInputStream(path);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      o = in.readObject();
      in.close();
      fileIn.close();
    } catch(IOException i) {
      i.printStackTrace();
      return null;
    } catch(ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
      return null;
    }
    return o;
  }
}
