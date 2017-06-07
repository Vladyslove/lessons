package template;

  abstract public class AbstractApp {
    int i = 15;
  public AbstractApp() {
    inittt();
    // mustBeSpecial();
    // mustBeSpecial1ButItIsVirtual();
    // mustBeSpecial2();
  }

  abstract protected void inittt();
  public void run(){
    configure();
    invoke();
    destroy();
  }
    abstract protected void configure();
    abstract protected void invoke();
    abstract protected void destroy();
  // private void mustBeSpecial() {
  //
  // }
  // final void mustBeSpecial1ButItIsVirtual() {
  //
  // }
  // private final void mustBeSpecial2() {
  //
  // }
}
