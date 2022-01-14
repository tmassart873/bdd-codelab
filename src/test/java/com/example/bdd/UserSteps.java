package com.example.bdd;

import com.example.bdd.domain.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserSteps {

    private UserClient userClient;

    private List<User> userList;


    @Autowired
    public UserSteps(UserClient userClient) {
        this.userClient = userClient;
    }

    @Given("a user named {string} {string} in the system")
    public void addUserToSystem(String firstName, String lastName) {
        userClient.addUser(new User(firstName, lastName));
    }

    @When("getting a list of users")
    public void getUsersList(){
        userList =  userClient.getAllUsers();
    }

    @Then("this list will contain")
    public void thisListWillContain(DataTable dataTable) {
        Assertions.assertThat(userList).containsAll(convertToPersonList(dataTable));
    }

    private List<User> convertToPersonList(DataTable dataTable) {
        List<User> result = new ArrayList<>();
        for(List<String> userAsString: dataTable.<String>asLists(String.class)) {
            result.add(new User(userAsString.get(0), userAsString.get(1)));
            System.out.println(result);
        }
        return result;
    }



}
