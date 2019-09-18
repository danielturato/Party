public class FileReaderMain {

    public static void main(String[] args) {
        BST tree = FileReader.readProfileSet("users.txt");

        System.out.println("");
        tree.printAlphabetical();
    }
}
