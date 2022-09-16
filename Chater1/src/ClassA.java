public class ClassA
{
    static{	System.out.println("* ClassA 로드 완료 *"); }

    public ClassA(){
        System.out.println("ClassA 인스턴스 생성");
    }

    public void createB()
    {
        System.out.println("ClassA.createB() 실행됨");
        ClassB b = new ClassB();
    }
}
