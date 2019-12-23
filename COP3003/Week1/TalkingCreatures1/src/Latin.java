public class Latin {

  public String sayHello() {
    return "Salve Mundi";
  }

  public String sayGoodbye() {
    return "Vale";
  }

  public String sayHelloOrGoodbye(String helloGoodbye) {
    // Example of using ternary operator for the return (not called directly used in demo)
    return helloGoodbye.equals("morning") ? "Salve Mundi" : "Vale";

  }

}
