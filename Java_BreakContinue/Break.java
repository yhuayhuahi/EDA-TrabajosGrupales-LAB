public class Break {
    public static void main(String[] args) {
        //Stop the loop if i is 5.
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
    }
}
