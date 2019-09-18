public class AlphaMain {

    public static void main(String[] args) {
        BST tree = new BST();

        ProfileRepository.PROFILES.forEach(tree::insert);

        tree.printAlphabetical();
    }
}
