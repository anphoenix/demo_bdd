package com.kinisoftware.bdd.jbehave.tasks;

import com.kinisoftware.bdd.jbehave.Task;
import com.kinisoftware.bdd.jbehave.ToDoList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RemoveTasksSteps {

	private ToDoList toDoList;

	@Given("an to-do list contains 1 task: $task")
	public void createToDoListwithOneTask(String task) {
        toDoList = new ToDoList();
        toDoList.addTask(new Task(task));
    }

	@When("you remove an existed task: $task")
    public void removeTask(String task) {
        toDoList.removeTask(new Task(task));
    }

	@Then("the number of tasks into removed to-do list should be $numberOfTasks")
	public void the_number_of_tasks_into_to_do_list_should_be(int numberOfTasks) {
		assertThat(toDoList.getNumberOfTasks(), is(numberOfTasks));
	}



}
