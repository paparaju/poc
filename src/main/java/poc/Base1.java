package poc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Base1{
  @Autowired
  private Base10 base10;

  @Autowired
  private Base11 base11;

  public void printBaseClasses() throws Exception {
    System.out.println(base10.getData());
    System.out.println(base11.getData());
  }

}
