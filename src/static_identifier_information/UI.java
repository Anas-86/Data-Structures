package static_identifier_information;

class UI {
    int a;
    int b;
    int c;

    public UI(int a, int b, int c) {          //you can call al static and non_static methods from the constructor, when these methods are within the class.
        this.a = doubling(a);
        this.b = multi(a, b);
    }


    public static void main(String[] args) {
        UI a = new UI(1, 2, 3);
        System.out.println(doubling(a.b));
        System.out.println(multi(a.a, a.b));
        System.out.println(donoth(a.a, a.b));
        System.out.println(suming(a.a,a.b));
    }

    public static int doubling(int a) {     //methods can call each other in the same class, when they are non-static methods.
        return a * 2;                 //a static method needs to call a static method. otherwise it is not going to work.
    }                               //because main is static, if it calls a method a(), then a() must be static. in its turn, if a() calls a method b(), then b() must be static and so on.

                                    //in order to understand the difference, try removing the identifir static form the methods doubling, multi, suming, donoth.
    public static int multi(int a, int b) {
        return a * b;
    }

    public static int suming(int a, int b) {
        return multi(a, b) + doubling(a);
    }

    public static int donoth(int a, int b) {
        return suming(a, b);
    }

}
