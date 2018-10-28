import org.junit.Test;

public class first {
    static int i = 5;
    static {
        System.out.println("First Static code i="+i++);
    }
    static {
        System.out.println("Second Static code i="+i++);
    }
    public static void main(String[] args){
        first f1 = new first();
        first f2 = new first();
        System.out.println("At Last, i="+i++);
    }
}
