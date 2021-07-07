package poc;

import org.springframework.beans.factory.*;
import org.springframework.context.annotation.*;

public class AppMain {
  public static void main(String[] args) throws Exception {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("poc");
    ObjectProvider<Base1> base1S= context.getBeanProvider(Base1.class);
    Base1 base1 = base1S.getIfAvailable();
    base1.printBaseClasses();
  }
}
