//package browserSetup;
//import java.util.regex.Pattern;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//public class StepDefinitionfilename {
//	
//	 private static final Pattern fileNamePattern = Pattern.compile("[-_.A-Za-z0-9,]*");
//	 @When("^Chriss-Mac-Pro% java InputValidationSolution test$")
//	 public void chriss_Mac_Pro_java_InputValidationSolution_test() throws Throwable {
//	
//	}
//
//	 @Then("^Your filename is \"([^\"]*)\" type\\.$")
//	 public void your_filename_is_type(String arg1) throws Throwable {
//		System.out.println("Send filetype name " +arg1);
//		 try { 
//	            if (fileNamePattern.matcher(arg1).matches() ) {
//	                System.out.println("Your filename is "+arg1);      
//	            } else {
//	                throw new Exception( "Improper filename format." );
//	            }
//	        } catch(Exception e ) {
//	            System.out.println("Filename contains invalid characters");
//	        }
//	    } 
//
//		 
//		       
//		 
//	}


