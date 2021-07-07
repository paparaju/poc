package poc;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.*;

@Component
public class Base10{

  private String data;

  public Base10(String temp) {
    System.out.println("Instantiating Base 10");
    data = temp;
  }

  @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 100))
  public String getData() throws Exception {
    System.out.println("Retrying base10");
    if(true){
      throw new Exception("stopping the data call");
    }
    return data;
  }

  public void setData(String data){
    this.data = data;
  }

}
