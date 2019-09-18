public class BSTNodeMain {

    public static void main(String[] args) {

        Profile testProfile = new Profile(
                "test", "bob", 28, 06, 1999,
                "s", "a", "s", "s", new String[0]);
        Profile testProfile2 = new Profile(
                "test2", "bob", 28, 06, 1999,
                "s", "a", "s", "s", new String[0]);
        Profile testProfile3 = new Profile(
                "test3", "bob", 28, 06, 1999,
                "s", "a", "s", "s", new String[0]);


        // All profiles turn into nodes
        ProfileRepository.PROFILES.stream()
                .map(BSTNode::new)
                .map(BSTNode::getProfile)
                .forEach(System.out::println);

        System.out.println("");


        // Testing setters & getters
        BSTNode node1 = new BSTNode(testProfile);
        BSTNode node2 = new BSTNode(testProfile2);
        BSTNode node3 = new BSTNode(testProfile3);

        node1.setL(node2);
        node1.setR(node3);

        System.out.println(node1.getL().getProfile());
        System.out.println(node1.getR().getProfile());

    }
}
