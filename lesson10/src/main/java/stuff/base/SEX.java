package stuff.base;
public enum SEX {
    MALE("M"), FEMLAE("F"), NOT_DEFINED("N/D");
    // MALE(100), FEMLAE(50), NOT_DEFINED(0);

    private String asString;
    // SEX() {} // Construcor of enum, он же класс, SEX
    SEX (String asString) {  // Construcor of enum, он же класс, SEX
        this.asString = asString;
      }

      public String toString() {
        return asString;
      }
}
