package test;

/**
 * Created by eric on 02/06/2017.
 */
public class Test2 {

    public String calc(Number i){
        return "number";
    }

    public String calc(Long i){
        return "Long";
    }

    public String calc(Integer i){
        return "int";
    }
    public static void main(String[] args) {

        Short aShort = 1;
        Test2  test2 = new Test2();

       System.out.print(test2.calc(aShort));

    }


}
