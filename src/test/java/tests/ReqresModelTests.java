package tests;

import models.SingleUserResponse;
import models.UserResponse;
import org.junit.jupiter.api.Test;
import steps.ReqresSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReqresModelTests {

    ReqresSteps steps = new ReqresSteps();

    @Test
    void createUserTest() {
        UserResponse response = steps.createUser("morpheus", "leader");

        assertThat(response.getName(), equalTo("morpheus"));
        assertThat(response.getJob(), equalTo("leader"));
        assertThat(response.getId(), notNullValue());
    }

    @Test
    void getSingleUserTest() {
        SingleUserResponse user = steps.getSingleUser(2);

        assertThat(user.getId(), notNullValue());
        assertThat(user.getEmail(), containsString("@reqres.in"));
    }
}
