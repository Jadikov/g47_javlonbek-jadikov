package mashq3;
/*Loglarni faylga
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberFinder {
    public static void main(String[] args) {
        String folderPath = "src/mashq3";
        String fileName = "PhoneNumbers.txt";

        File folder = new File(folderPath);
        File file = findFileInFolder(folder, fileName);

        if (file != null) {
            System.out.println("Fayl topildi: " + file.getAbsolutePath());
            try {
                findAndPrintUzbekPhoneNumbers(file);
            } catch (FileNotFoundException e) {
                System.out.println("Faylni o'qishda xatolik yuz berdi: " + e.getMessage());
            }
        } else {
            System.out.println("Fayl topilmadi!");
        }
    }

    public static File findFileInFolder(File folder, String fileName) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                File found = findFileInFolder(file, fileName);
                if (found != null) {
                    return found;
                }
            } else if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public static void findAndPrintUzbekPhoneNumbers(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile("\\+998\\d{2}\\d{7}");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println("Topilgan raqam: " + matcher.group());
            }
        }
        scanner.close();
    }
}
