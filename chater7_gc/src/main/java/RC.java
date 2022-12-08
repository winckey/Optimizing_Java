public class RC {

    public static class Obj{
        int val;

        public Obj(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val){
            this.val = val;
        }
    }

    public static void func(){
        Obj obj3 = new Obj(3);
    }

    public static void main(String[] args){
        Obj obj1 = new Obj(1);
        Obj obj2 = new Obj(2);
        func();
        obj1 = new Obj(4);
        obj2 = obj1;
    }
}