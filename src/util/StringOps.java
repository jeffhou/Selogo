package util;

import java.util.ArrayList;

public class StringOps {
  public static ArrayList<String> deepCopy(ArrayList<String> l) {
    ArrayList<String> newList = new ArrayList<String>();
    for (String i : l) {
      newList.add(i);
    }
    return newList;
  }
}
