import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Проверяемые: деление на ноль, отсутствие ссылки на объект
        getArithmeticException();
        getNullPointException();
        //Непроверяемые: отсутстует файл для чтения
        getFileNotFoundException();
    }

    private static void getArithmeticException() {
        for (int i = -1; i < 2; i++) {
            if (i == 0) {
                System.out.println("Деление на ноль!");
            } else {
                System.out.println(1 / i);
            }
        }
    }

    private static void getNullPointException() {
        Object[] o = new Object[3];
        o[1] = "Привет!";
        for (int i = 0; i < o.length; i++) {
            if (o[i] == null) {
                System.out.println("Нет ссылки на объект!");
            } else {
                System.out.println(o[i]);
            }
        }
    }

    private static void getFileNotFoundException() {
        try(FileReader reader = new FileReader("tryCatch.txt")) {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
