

public class CircularReferenceCounting {
    public static class Obj{
        private Obj other;
        private int value;

        public Obj(int value){
            this.other = null;
            this.value = value;
        }

        public Obj getOther() {
            return other;
        }

        public void setOther(Obj other) {
            this.other = other;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
        Obj obj1 = new Obj(1);
        Obj obj2 = new Obj(2);
        obj1.setOther(obj2);
        obj2.setOther(obj1);
        obj1 = new Obj(3);
        obj2 = new Obj(4);
    }
}