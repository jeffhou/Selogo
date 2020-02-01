package util;

public class Tuple {
  public double x, y;

  public Tuple() {
    this.x = 0;
    this.y = 0;
  }

  public static Tuple mod(Tuple t1, Tuple t2) {
    double newX = t1.x % t2.x;
    if (newX < 0) {
      newX += t2.x;
    }
    double newY = t1.y % t2.y;
    if (newY < 0) {
      newY += t2.y;
    }
    return new Tuple(newX, newY);
  }

  public static Tuple scalarMultiply(Tuple t1, double d1) {
    return new Tuple(t1.x * d1, t1.y * d1);
  }

  public static Tuple subtract(Tuple t1, Tuple t2) {
    return new Tuple(t1.x - t2.x, t1.y - t2.y);
  }

  public static Tuple sum(Tuple t1, Tuple t2) {
    return new Tuple(t1.x + t2.x, t1.y + t2.y);
  }

  public Tuple(double d1, double d2) {
    this.x = d1;
    this.y = d2;
  }

  public Tuple copy() {
    return new Tuple(x, y);
  }

  public double distanceTo(Tuple other) {
    return Math.sqrt(((x - other.x) * (x - other.x))
        + ((y - other.y) * (y - other.y)));
  }

  public boolean equals(Tuple other) {
    return (this.x == other.x) && (this.y == other.y);
  }

  @Override
  public String toString() {
    return String.format("(%1$.2f, %2$.2f)", this.x, this.y);
  }
}
