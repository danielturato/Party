import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Graph.java - Uses a process called triadic closure to create friend recommendations for each user profile
 * @author danielturato
 */

public class Graph {

    /**
     * The BST containing all user profiles
     */
    private BST profiles;

    /**
     * The Graph Constructor
     * @param fileName The file path used to view the friend relationships
     * @param profiles The BST containing all user profiles
     */
    public Graph(String fileName, BST profiles) {
        this.profiles = profiles;
        populateFriends(fileName);
    }

    /**
     * Get each user profiles friend recommendations
     * @param users All user profiles stored in an Array
     * @return A list of Binary Search Tree's with each tree containing each profiles recommendations
     */
    public BST[] friendRecommendations(Profile[] users) {
        List<BST> trees = new ArrayList<>();
        List<Profile> tempFriends;
        // Used to compare if the user has already been recommended a particular user, save search up time
        List<Profile> tempRecommendations;

        // For each profile in the profiles array
        for (Profile p : users) {
            int t = p.numOfFriends();
            BST tree = new BST();
            tempFriends = getFriendsOf(p);
            tempRecommendations = new ArrayList<>();

            // Loop over each profiles friends list
            for (int i = 0; i < p.numOfFriends(); i++) {
                Profile tempProfile = p.getFriend(i);
                // For each friend in each profiles friends list, loop over their friends
                for (int j = 0; j < tempProfile.numOfFriends(); j++) {
                    Profile newRec = tempProfile.getFriend(j);
                    // If the original profile the loop is currently at isn't already a friend of this user and
                    // they've not already been added to the recommendations and it's not them
                    if (!(tempFriends.contains(newRec)) &&
                            !(tempRecommendations.contains(newRec)) &&
                            !(p.equals(newRec))) {

                        // then add to the current profiles tree & local recommendations list
                        tempRecommendations.add(newRec);
                        tree.insert(newRec);
                    }
                }
            }

            // If you've been recommended profiles...
            if (tempRecommendations.size() > 0) {
                trees.add(tree);
            }
        }

        return trees.toArray(new BST[0]);
    }

    /**
     * Populate each profiles friends in the BST - relationships located in the file
     * @param fileName The filename of the friends relationships
     */
    private void populateFriends(String fileName) {
        Scanner file = null;

        try {
            file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found at the path provided. Try again.");
            System.exit(0);
        }

        while (file.hasNext()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            String personOne = line.next();
            String personTwo = line.next();

            connect(personOne, personTwo);

        }

        file.close();
    }

    /**
     * Create a friend relationship between two user profiles
     * @param personOne User profile 1
     * @param personTwo User profile 2
     */
    private void connect(String personOne, String personTwo) {
        // Search for the names in the file and grab the Profile instances from the tree
        Profile p1 = profiles.searchFor(personOne);
        Profile p2 = profiles.searchFor(personTwo);

        // Create the friend relationship
        p1.addFriend(p2);
        p2.addFriend(p1);
    }

    /**
     * Get a list of friends from a user profile
     * @param p The user profile
     * @return A list of user profiles (friends)
     */
    private List<Profile> getFriendsOf(Profile p) {
        List<Profile> friends = new ArrayList<>();

        for (int i=0; i < p.numOfFriends(); i++) {
            friends.add(p.getFriend(i));
        }

        return friends;
    }
}
