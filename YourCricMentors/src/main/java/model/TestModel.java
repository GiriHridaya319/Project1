package model;

import java.time.LocalDate;

/**
 * Servlet implementation class TestModel
 */
public class TestModel  {
	

String testID;
String testName;
String location_of_Test;
LocalDate test_Date;
String test_Status;
String testDescription;




public TestModel(){
	
}




public TestModel(String testID, String testName, String location_of_Test, LocalDate test_Date, String test_Status,
		String testDescription) {
	super();
	this.testID = testID;
	this.testName = testName;
	this.location_of_Test = location_of_Test;
	this.test_Date = test_Date;
	this.test_Status = test_Status;
	this.testDescription = testDescription;
}




public String getTestID() {
	return testID;
}




public void setTestID(String testID) {
	this.testID = testID;
}




public String getTestName() {
	return testName;
}




public void setTestName(String testName) {
	this.testName = testName;
}




public String getLocation_of_Test() {
	return location_of_Test;
}




public void setLocation_of_Test(String location_of_Test) {
	this.location_of_Test = location_of_Test;
}




public LocalDate getTest_Date() {
	return test_Date;
}




public void setTest_Date(LocalDate test_Date) {
	this.test_Date = test_Date;
}




public String getTest_Status() {
	return test_Status;
}




public void setTest_Status(String test_Status) {
	this.test_Status = test_Status;
}




public String getTestDescription() {
	return testDescription;
}




public void setTestDescription(String testDescription) {
	this.testDescription = testDescription;
}



}
