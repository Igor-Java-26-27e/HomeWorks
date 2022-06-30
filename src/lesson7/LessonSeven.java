package lesson7;

public class LessonSeven {
    public static void main(String[] args) {
        SimpleBox<Integer> box1 = new SimpleBox<>(5);
        SimpleBox<Integer> box2 = new SimpleBox<>(6);
       /* SimpleBox<String> box3 = new SimpleBox<>("Hello");
        SimpleBox<String> box4 = new SimpleBox<>("Java!");
        if(box1.getObj() instanceof Integer&& box2.getObj() instanceof Integer){*/
        System.out.println(box1.getObj() + box2.getObj());
        System.out.println(box1.getType());
    /* }
      System.out.println(box3.getObj() + " "+ box4.getObj());
        System.out.println(box3.getType());
      box1.setObj("Hello");
        box2.setObj("Java!");
        System.out.println(((String)box1.getObj()) +" "+ (String)box2.getObj());
        System.out.println(""+ box1.getObj() + " " + box2.getObj());*/
    }
    }

    class SimpleBox<T extends Number> {
        private T obj;

        public SimpleBox(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public String getType() {
            return obj.getClass().getName();
        }
    }
