import com.geek.study.week01.DateUtils;

public class Person {

    public void test1(){
        System.out.println("this is a test1 method");
    }

    public void test2(){
        System.out.println("this is a test2 method");
    }
    public String test3(){
        System.out.println("this is a test3 method: " + DateUtils.getDate());
        return "test3 method sucess";
    }



}
