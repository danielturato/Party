public class GraphMain {

    /*
        daniel turato is friends with : billy a, rita c
        billy a is friends with: daniel turato, rita c, phillip turato, katie b, daniel ell, aaron b, marco turato
        rita c is friends with: daniel turato, billy a
        phillip turato is friends with: billy a
        katie b is friends with: billy a
        daniel ell is friends with: billy a
        aaron b is friends with: billy a
        marco turato is friends with: billy a

     */

    public static void main(String[] args) {

        BST tree = new BST();
        ProfileRepository.PROFILES.forEach(tree::insert);

        Graph graph = new Graph("friends.txt", tree);
        BST[] connections = graph.friendRecommendations(ProfileRepository.PROFILES.toArray(new Profile[0]));

        System.out.printf("%n%n");
        for (BST t : connections) {
            t.printAlphabetical();
            System.out.printf("%n%n%n");
        }

    }
}
