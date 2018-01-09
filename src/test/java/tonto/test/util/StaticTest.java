package tonto.test.util;

public class StaticTest {
	public static void main(String[] args){
        
       staticFunection();     
            
    }
     
    static StaticTest st = new StaticTest();
   
    static{
        System.out.println("1");
    }
      
    {
        System.out.println("2");
    }
     
    public StaticTest() {
        // TODO Auto-generated constructor stub
        System.out.println("3");
        System.out.println("a ="+ a +", b="+b);
    }
    
   
     
    public static void staticFunection(){
        System.out.println("4");
    }
     
    int a = 110;
    static int b = 112;
}
