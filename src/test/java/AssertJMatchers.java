import org.assertj.core.api.AbstractAssert;

public class AssertJMatchers extends AbstractAssert<AssertJMatchers, Friendships> {
    public AssertJMatchers(Friendships actual) {
        super(actual, AssertJMatchers.class);
    }
    public static AssertJMatchers assertThat(Friendships actual) {
        return new AssertJMatchers(actual);
    }

    public AssertJMatchers areFriends(String person1, String person2) {
        isNotNull();
        if(!actual.friendships.get(person1).contains(person2) && actual.friendships.get(person2).contains(person1))
            failWithMessage("Those people are not friends");
        return this;
    }

    public AssertJMatchers areFriendsCapital(String person1) {
        isNotNull();
        for(String s : actual.friendships.get(person1)) {
            if(!s.matches("(?!^.*[A-Z]{2,}.*$)^[A-Za-z]*$")) {
                failWithMessage("This person have at least one friend with lower case letter in name");
            }

        }
        return this;
    }



}
