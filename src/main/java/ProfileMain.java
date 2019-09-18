import java.util.List;

public class ProfileMain {

    public static void main(String[] args) {
        // See ProfileRepository class for instances -> Was easier to save time copying new instances per test class
        List<Profile> profiles = ProfileRepository.PROFILES;
        Profile testProfile = new Profile(
                "test", "bob", 28, 06, 1999,
                "s", "a", "s", "s", new String[0]);

        System.out.printf("Testing getters & setters%n%n");

        System.out.println(testProfile.getName());
        System.out.println(testProfile.getCountry());
        System.out.println(testProfile.getDateOfBirth());
        System.out.println(testProfile.getNationality());
        System.out.println(testProfile.getTown());
        System.out.println(testProfile.getEmail());
        System.out.print("Interests: ");
        for (String i : testProfile.getInterests()) {
            System.out.print(i + ", ");
        }

        System.out.printf("%nChanged country, town, email, interests%n%n");
        testProfile.setCountry("Wales");
        testProfile.setTown("Swansea");
        testProfile.setEmail("dt@outlook.com");
        testProfile.setInterests(new String[]{"coding", "computer science"});
        System.out.println(testProfile.getCountry());
        System.out.println(testProfile.getTown());
        System.out.println(testProfile.getEmail());
        System.out.print("Interests:");
        for (String i : testProfile.getInterests()) {
            System.out.print(i + ", ");
        }

        System.out.printf("%n%nAdded new friend...%n%n");

        Profile me = profiles.get(0);
        me.addFriend(testProfile);

        System.out.println(me);

        System.out.println("******All profiles******");
        profiles.forEach(System.out::println);
    }
}
