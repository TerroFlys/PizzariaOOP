public class main {
    public static void main(String[] args) {
        PizzariaPanel pizzariaPanel = new PizzariaPanel();
        pizzariaPanel.run();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
