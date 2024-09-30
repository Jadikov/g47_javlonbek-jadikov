package mashq4;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        Handler handler = new FileHandler("log.txt");
        handler.setFormatter(new CustomFormatter());
        handler.


    }
}
