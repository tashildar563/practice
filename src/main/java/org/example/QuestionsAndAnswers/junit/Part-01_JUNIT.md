### what is test suite 
* a test suite is a bundle of multiple unit test cases

### what is Unit testing ?
*  unit testing is a software testing strategy that test single entities like methods or classes at a time.

### Features of junit ?
* open source framework.
* supports automated testing of test suites.
* provides annotations for identifying the test methods.
* provides assertions to test expected result or exceptions to the methods under test.
* provides a platform for running test cases automatically and checking their results and giving feedback.

### imp annotations provided by junit?
* @Test : this annotation over a public method of void return type can be run as test case.
* @Before : this is used when we want to execute the preconditions or any initialisation based statements before running every test case.
* @BeforeClass : this is used when we want to execute statements before all test cases. this statements may include test connections, common setup initialisation etc.
* @After : this is sued when we want to execute statements after each test case. this statements can be resetting the variable, deleting extra memory used etc.
* @AfterClass : this is used when certain statements are requried to be executed after all the test cases of the class are run.
* @ignores: this is used when some statements are required to be ignored during the executing of test cases.
* 