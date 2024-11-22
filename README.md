[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/fVuqJEGB)
# Lab 11: Mockito

In this assignment, you are asked to create a test suite of JUnit test cases that achieves 100% branch coverage and uses test doubles. You will use what you learn in this lab in the last project iteration of the course.

For this assignment you will need Gradle, Java, and IntelliJ IDEA. We suggest using a lab machine in [Keller Hall 1-250](https://cse.umn.edu/cseit/classrooms-labs/keller-1-250), as Gradle, Java, and IntelliJ IDEA are already installed on the machines. You can also access a lab machine remotely using this link https://csel-kh1250-X.cselabs.umn.edu, where X is the machine identifier. For more information on how to access the lab machines remotely, please refer to the "Lab 1: Git" instructions. You can also install Gradle, Java, and IntelliJ IDEA on your machine but we do not provide support for that. We provide instructions on how to do that in this piazza [post](https://piazza.com/class/kt6lovmquye4r?cid=71). Finally, [VOLE3D](https://cse.umn.edu/cseit/self-help-guides/virtual-online-linux-environment-vole) also has the same technologies and that is another option avaialble to you.

Before starting the lab, please remember the following important items:

**IMPORTANT: Inside the lab machine, only files saved to your home folder (e.g., `/home/mfazzini`) will be persisted across sessions. If you log out, make sure your progress is pushed to GitHub or saved in the home folder.**

One of the reasons you might not be able to log into a lab machine is that you reached your CSE Labs Account disk quota. To free space, please use these [instructions](https://cse.umn.edu/cseit/self-help-guides/disk-quota-free-your-space). (In some cases, you might need to SSH into a CSE classroom or lab machine to complete the instructions.)

Remember to log out from the lab machine when you completed your work session (especially if you are working remotely), as this operation will allow other students to use the same machine.

## Lab Instructions

In the following instructions, we use the term "REPO" to indicate the repository that the GitHub classroom created for you. **Make sure you use this repository and not a repository you created on your own.** Please contact us on Piazza in case you experience issues with the creation of the GitHub classroom repository.

In this lab, you need to create a test suite of JUnit test cases for the FiveStudents software. In its latest update, the FiveStudents software decided to handle calories and order description computation in a web server. For this reason, the test cases now need to use test doubles. You can read the new requirements of the FiveStudents software in Section "FiveStudents Requirements".

You need to use only one test class in your test suite (all tests should be focusing on `FiveStudentsWebServer.onMessage`). You can measure branch coverage by running the tests through the command `./gradlew clean test jacocoTestReport`. You can see the branch coverage achieved by your test suite by opening the `<dir>/app/build/reports/jacoco/test/html/index.html` file in a browser (branch coverage is reported in the "Cov." column next to the "Missed Branches" column in the HTML file). The video demonstration associated with this lab shows how to create a test case with tests doubles for the FiveStudents software.

### FiveStudents Requirements

A fast food store wants to create a software called FiveStudents to take care of fast food orders. The shop makes three types of fast food items: `HotDog`, `Hamburger`, and `Sandwich`. A `HotDog` has 520 calories, a `Hamburger` has 870 calories, and a `Sandwich` has 290 calories. Each fast food item can have any number of toppings (multiple toppings of the same type are allowed). The shop offers three types of toppings: `GrilledOnions`, ` GrilledMushrooms
`, and `JalapenoPeppers`. Adding toppings increases the calories of a fast food item. The `GrilledOnions` topping increases calories by 10 each time it is added to the fast food item. The `GrilledMushrooms` topping increases calories by 20 each time it is added. The `JalapenoPeppers` topping increases calories by 5 each time it is added. When the FiveStudents software creates a fast food item we want to compute the calories of the item and its description. For example, if a customer orders a hotdog with grilled mushrooms and jalapeno peppers, the calories of the item are 545 and the description for the item is `hotdog grilled mushrooms jalapeno peppers`. The `FiveStudents` system computes the calories using the `getCalories` method from the `FastFoodItem` class and generates the fast food item description using the `getDescription` method from the same class.
The FiveStudents software accepts orders using the `FiveStudentsWebServer.onMessage` method. This method takes a JSON string as input. This string has the format `{"text":"order"}` where `order` contains the fast food item type (i.e., `hotdog`, `hamburger`, or `sandwich`) and the toppings (e.g., `grilledmushrooms,jalapenopeppers`). The fast food item type and the toppings are separated by a space character (e.g., `hamburger grilledmushrooms`). The list of toppings is comma separated. An example of input for the `FiveStudentsWebServer.onMessage` method is `{"text":"hamburger grilledmushrooms"}`. The software makes the fast food items using the `makeFastFoodItem(String,String)` method.

### Performing and Submitting the Solution

* Perform and submit your solution by:
	* Implementing the test code of your solution in a branch called "tests"
	* Merge your solution into the "main" branch
	* Submitting the commit ID of your solution on Gradescope. You can get your commit ID by running `git log -1`.

### Notes
* We provide a video tutorial for this lab at this [link](https://mediaspace.umn.edu/media/t/1_9szvoy1b). The tutorial guides you through the code of one of the tests for the newly updated FiveStudents software.
* Before submitting, make sure that your code compiles
* You can perform multiple commits as you produce your solution. This is not only fine, but actually very much encouraged.