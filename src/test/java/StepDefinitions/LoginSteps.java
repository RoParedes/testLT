package StepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    System.out.println("Inside Step-0");
	}

	@And("some other precondition")
	public void some_other_precondition() {
	    System.out.println("Inside Step-1");
	}

	@When("I complete action")
	public void i_complete_action() {
		System.out.println("Inside Step-2");
	}

	@And("some other action")
	public void some_other_action() {
		System.out.println("Inside Step-3");
	}

	@And("yet another action")
	public void yet_another_action() {
		System.out.println("Inside Step-4");
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		System.out.println("Inside Step-5");
	}

	@And("check more outcomes")
	public void check_more_outcomes() {
		System.out.println("Inside Step-6");
	}

}
