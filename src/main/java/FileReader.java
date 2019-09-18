import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileReader.java - Used to read in a file and convert into new user profiles
 * @author danielturato
 */

public class FileReader {

    /**
     * Read in a file and convert into a BST stored with user profiles
     * @param fileName The file path to be read
     * @return A new BST containing Profile nodes of all users
     */
    public static BST readProfileSet(String fileName) {
        Scanner file = null;
        BST tree = new BST();

        try {
            file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found at the path provided. Exiting program.");
            System.exit(0);
        }

        while (file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            Profile p = createProfile(line);
            tree.insert(p);
            System.out.printf("Inserted: %s%n", p.getName());
        }

        file.close();

        return tree;
    }

    /**
     * Creates a profile from the information given per line in a file
     * @param line The Scanner instance pointing to an individual line in the file
     * @return A new profile instance
     */
    private static Profile createProfile(Scanner line) {
        String[] name = readName(line);
        int[] date = readDate(line);
        String[] info = readAdditionalInfo(line);
        String[] interests = readInterests(line);

        return new Profile(name[1], name[0], date[0], date[1], date[2], info[0], info[1], info[2], info[3], interests);
    }

    /**
     * Read the date and send back as an array
     * @param line The current line of the file
     * @return An array containing : Day, Month, Year
     */
    private static int[] readDate(Scanner line) {
        return new int[]{line.nextInt(), line.nextInt(), line.nextInt()};
    }

    /**
     * Read the additional info of the file and send back as an array
     * @param line The current line of the file
     * @return An array containing : Town, Country, Nationality, Email
     */
    private static String[] readAdditionalInfo(Scanner line) {
        return new String[]{line.next(), line.next(), line.next(), line.next()};
    }

    /**
     * Read the name in the line of the file
     * @param line The current line of the file
     * @return An array containing : Last Name, First Name
     */
    private static String[] readName(Scanner line) {
        return new String[]{line.next(), line.next()};
    }

    /**
     * Read the interests in the line of the file
     * @param line The current line of the file
     * @return A list containing each interests found on that line
     */
    private static String[] readInterests(Scanner line) {
        List<String> interests = new ArrayList<>();
        line.skip(",");
        line.useDelimiter(";");
        while (line.hasNext()) {
            interests.add(line.next());
        }

        return interests.toArray(new String[0]);
    }

}
