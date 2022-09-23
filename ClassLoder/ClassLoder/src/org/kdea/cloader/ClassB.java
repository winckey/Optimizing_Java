package org.kdea.cloader;

public class ClassB
{
    static{	System.out.println("* ClassB 로드 완료 *"); }

    public ClassB()
    {
        System.out.println("ClassB 인스턴스 생성");
    }
}
