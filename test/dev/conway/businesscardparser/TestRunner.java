package test.dev.conway.businesscardparser;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner{
	public static void main(String[] args){

		Result result = JUnitCore.runClasses(AppTests.class);
		System.out.println("Running");
		for(Failure fail: result.getFailures()){

			System.out.println("Running");
			System.out.println(fail.toString());

		}


	}

}