public class BSTMain {

    public static void main(String[] args) {

        BST tree = new BST();

        ProfileRepository.PROFILES.forEach(tree::insert);

        tree.printAlphabetical();

    }
}
