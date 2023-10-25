package useOfAnnotations;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupingEx {
	
	@BeforeGroups("regression")
	public void beforeGroup() {
		System.out.println("Before Group");
	}
	
	@BeforeGroups("smoke")
	public void beforeGroup1() {
		System.out.println("before group 2");
	}
	@AfterGroups("sanity")
	public void afterGroup() {
		System.out.println("After Group");
	}
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("Sanity");
	}
	@Test(groups = {"sanity"})
	public void test2() {
		System.out.println("Sanity");
	}
	@Test(groups = {"regression"}, invocationCount = 3)
	public void test3() {
		System.out.println("regression");
	}
	@Test(groups = {"smoke"})
	public void test4() {
		System.out.println("smoke");
	}
	@Test(groups = {"regression"})
	public void test5() {
		System.out.println("regression");
	}
	
}
