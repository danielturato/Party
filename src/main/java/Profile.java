import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Profile.java - Represents a user's profile
 * @author danielturato
 */

public class Profile {

    /**
     * The user's first name
     */
    private String firstName;

    /**
     * The user's last name
     */
    private String lastName;

    /**
     * The day the user was born
     */
    private int day;

    /**
     * The month the user was born
     */
    private int month;

    /**
     * The year the user was born
     */
    private int year;

    /**
     * The town where the user lives
     */
    private String town;

    /**
     * The country in which the user lives
     */
    private String country;

    /**
     * The nationality of the user
     */
    private String nationality;

    /**
     * The email of the user
     */
    private String email;

    /**
     * A list of the users interests
     */
    private String[] interests;

    /**
     * A list of the users friends
     */
    private List<Profile> friends;


    /**
     * The constructor used to create a new user Profile
     *
     *
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param day The day the user was born
     * @param month The month the user was born
     * @param year The year the user was born
     * @param town The town where the user lives
     * @param country The country where the user lives
     * @param nationality The nationality of the user
     * @param email The email of the user
     * @param interests A list of interests of the user
     */
    public Profile(String firstName, String lastName, int day, int month, int year, String town, String country, String nationality, String email, String[] interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.town = town;
        this.country = country;
        this.nationality = nationality;
        this.email = email;
        this.interests = interests;
        friends = new ArrayList<>();
    }

    /**
     * Get the town where the user lives
     * @return The town where the user lives
     */
    public String getTown() {
        return town;
    }

    /**
     * Set the town where the user lives
     * @param town The new town where the user lives
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Get the country where the user lives
     * @return The country where the user lives
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country where the user lives
     * @param country The new country where the user lives
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the nationality of the user
     * @return The nationality of the user
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Set the nationality of the user
     * @param nationality The new nationality of the user
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Get the email of the user
     * @return The email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the user
     * @param email The new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get all of the interests of the user
     * @return An array storing each interest of the user
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     * Set the interests of the user
     * @param interests The new list of interests that the user has
     */
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    /**
     * Get the combined first and last name of the user
     * @return The users full name
     */
    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }

    /**
     * Get the combined date of birth of the user
     * @return The users date of birth
     */
    public String getDateOfBirth() {
        return String.format("%d %d %d", day, month, year);
    }

    /**
     * Add a new friend to the users friends list
     * @param p The new friend
     */
    public void addFriend(Profile p) {
        friends.add(p);
    }

    /**
     * Get the Profile of a users friend
     * @param i The index position of the friend
     * @return The profile of the friend
     */
    public Profile getFriend(int i) {
        return friends.get(i);
    }

    /**
     * Get the total number of the friends the user has
     * @return The total number of friends
     */
    public int numOfFriends() {
        return friends.size();
    }

    /**
     * Represents a Profile as in english (String)
     * @return The user profile as a String
     */
    @Override
    public String toString() {
        return "Profile {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", town='" + town + '\'' +
                ", country='" + country + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", interests=" + Arrays.asList(interests) +
                ", friends=" + friends +
                '}';
    }
}
