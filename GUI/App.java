package GUI;

public class App {
    public static void main(String[] args) {
        ChessGameView view = new ChessGameView();
        ChessGameController controller = new ChessGameController(view);
    }

}
