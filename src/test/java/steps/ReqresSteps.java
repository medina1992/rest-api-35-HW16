package steps;

import io.qameta.allure.Step;
import models.SingleUserResponse;
import models.UserRequest;
import models.UserResponse;

import static io.restassured.RestAssured.given;
import utils.Specs;

public class ReqresSteps {

    @Step("Create user with name {name} and job {job}")
    public UserResponse createUser(String name, String job) {
        UserRequest request = new UserRequest();
        request.setName(name);
        request.setJob(job);

        return given()
                .spec(Specs.reqSpec)
                .body(request)
                .when()
                .post("/users")
                .then()
                .spec(Specs.respSpec201)
                .extract()
                .as(UserResponse.class);
    }

    @Step("Get single user with id {id}")
    public SingleUserResponse getSingleUser(int id) {
        return given()
                .spec(Specs.reqSpec)
                .when()
                .get("/users/" + id)
                .then()
                .spec(Specs.respSpec200)
                .extract()
                .jsonPath()
                .getObject("data", SingleUserResponse.class);
    }
    @Step("Update user with PUT id {id}, name {name}, job {job}")
    public UserResponse updateUserPut(int id, String name, String job) {
        UserRequest request = new UserRequest();
        request.setName(name);
        request.setJob(job);

        return given()
                .spec(Specs.reqSpec)
                .body(request)
                .when()
                .put("/users/" + id)
                .then()
                .spec(Specs.respSpec200)
                .extract()
                .as(UserResponse.class);
    }

    @Step("Update user with PATCH id {id}, job {job}")
    public UserResponse updateUserPatch(int id, String job) {
        UserRequest request = new UserRequest();
        request.setJob(job);

        return given()
                .spec(Specs.reqSpec)
                .body(request)
                .when()
                .patch("/users/" + id)
                .then()
                .spec(Specs.respSpec200)
                .extract()
                .as(UserResponse.class);
    }

    @Step("Delete user with id {id}")
    public int deleteUser(int id) {
        return given()
                .spec(Specs.reqSpec)
                .when()
                .delete("/users/" + id)
                .then()
                .extract()
                .statusCode();
    }

    @Step("Get single user not found with id {id}")
    public int getSingleUserNotFound(int id) {
        return given()
                .spec(Specs.reqSpec)
                .when()
                .get("/users/" + id)
                .then()
                .extract()
                .statusCode();
    }
}
