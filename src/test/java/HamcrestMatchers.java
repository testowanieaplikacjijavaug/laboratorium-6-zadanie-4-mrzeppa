import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
public class HamcrestMatchers {

    public static Matcher<Friendships> areFriends(final String person1, final String person2) {
        return new TypeSafeMatcher<Friendships>() {
            @Override
            protected boolean matchesSafely(Friendships friendships) {
                if(!friendships.friendships.get(person1).contains(person2) && friendships.friendships.get(person2).contains(person1))
                    return false;
                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Those people are not friends");
            }
        };


    }

    public static Matcher<Friendships> isCapital(final String person) {
        return new TypeSafeMatcher<Friendships>() {
            @Override
            protected boolean matchesSafely(Friendships friendship) {
                boolean cond = true;
                for(String s : friendship.friendships.get(person)) {
                    if(!s.matches("(?!^.*[A-Z]{2,}.*$)^[A-Za-z]*$")) {
                        cond = false;
                    }

                }
                return cond;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("This person have at least one friend with lower case letter in name");
            }
        };


    }
}
