package poc;

public class Temp {

    public static void main(String[] args) {
        Temp temp = new Temp();
        String set = "original";
        System.out.println(set);
    }

    public void test(String set){
        set = "changed";
    }
}
