Scenario: remove existing task in un-empty to-do list

Given an to-do list contains 1 task: do laundry
When you remove an existed task: do laundry
Then the number of tasks into removed to-do list should be 0


Scenario: remove un-existing task in un-empty to-do list

Given an to-do list contains 1 task: do laundry
When you remove an existed task: do homework
Then the number of tasks into removed to-do list should be 1

