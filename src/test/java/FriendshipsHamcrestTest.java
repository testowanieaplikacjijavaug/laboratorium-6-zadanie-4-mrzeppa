import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class FriendshipsHamcrestTest {
    private static Friendships f = new Friendships();


    @BeforeEach
    public void setup() {
        f.friendships = new HashMap<>();
    }
    @AfterEach
    public void teardown() {
        f.friendships = null;
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.makeFriends(null, "x");
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.makeFriends("X", null);
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.makeFriends("", "x");
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.makeFriends("X", "");
        });
    }

    @Test
    public void ShouldMakeRecordInMapWhenThereIsNoGivenKeyInMap() {
        f.makeFriends("x", "y");
        assertThat(f.friendships.get("x").get(0), is(equalTo("y")));
        assertThat(f.friendships.get("x").size(), is(equalTo(1)));
    }

    @Test
    public void ShouldAppendToListOfGivenKey() {
        f.makeFriends("x", "y");
        f.makeFriends("x", "z");
        assertThat(f.friendships.get("x").get(0), is(equalTo("y")));
        assertThat(f.friendships.get("x").get(1), is(equalTo("z")));

        assertThat(f.friendships.get("x").size(), is(equalTo(2)));
    }

    @Test
    public void AfterAddingFriendToOnePersonSecondOneShouldHaveFriendshiptoo() {
        f.makeFriends("x", "y");
        assertThat(f.friendships.get("y").get(0), is(equalTo("x")));
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsNullInAreFriends() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.areFriends(null, "x");
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsNullInAreFriends() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.areFriends("X", null);
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson1IsEmptyInAreFriends() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.areFriends("", "x");
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPerson2IsEmptyInAreFriends() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.areFriends("X", "");
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenThereIsNoGivenKey() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.areFriends("X", "Y");
        });
    }

    @Test
    public void ShouldReturnTrueIfTwoPeopleAreFriends () {
        f.makeFriends("x", "y");
        assertThat(f.areFriends("x", "y"), is(true));
    }

    @Test
    public void ShouldReturnFalseIfTwoPeopleAreNotFriends () {
        f.makeFriends("x", "y");
        assertThat(f.areFriends("x", "a"), is(false));
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPersonIsEmptyCallingGetFriendshipList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.getFriendsList("");
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPersonIsNullCallingGetFriendshipList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.getFriendsList(null);
        });
    }

    @Test
    public void ShouldRaiseAnExceptionWhenPersonDoNotExistInMapCallingGetFriendshipList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            f.getFriendsList("a");
        });
    }

    @Test
    public void ShouldReturnFriendshipList() {
        f.makeFriends("x", "t");
        assertThat(f.getFriendsList("x"), hasSize((greaterThan(0))));
    }


    @Test
    public void ShouldReturnTrueWhenTwoPeopleAreFriends() {
        f.makeFriends("Xavier", "Jessica");
        assertThat(f, HamcrestMatchers.areFriends("Xavier", "Jessica"));
    }

    @Test
    public void ShouldReturnTrueWhenPersonHaveOnlyCapitalLetterNamesInFriendLisT() {
        f.makeFriends("Xavier", "Jessica");
        f.makeFriends("Xavier", "Veronika");
        f.makeFriends("Xavier", "Vladimir");
        assertThat(f, HamcrestMatchers.isCapital("Xavier"));
    }





}