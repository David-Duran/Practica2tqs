public class Belly {
  private int cukes;
  
  public Belly() {
    this.cukes = 1;
  }

  public void eat(int cukes) {
    this.cukes += cukes;
  }
  
  public void digest(int hour) {
    this.cukes -= hour;
  }
  
  public int getCukes() {
    return cukes;
  }
}
