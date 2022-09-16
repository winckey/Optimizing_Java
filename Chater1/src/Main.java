
public class Main
{
    static{	System.out.println("* Main 로드  완료 *"); }

    public static void main(String[] args)
    {
        ClassA a = new ClassA();
        a.createB();

        ClassA a2 = new ClassA();
        a2.createB();
    }
}
