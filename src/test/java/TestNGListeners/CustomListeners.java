package TestNGListeners;

import org.testng.*;

public class CustomListeners implements ITestListener , IExecutionListener  , IInvokedMethodListener {

    public void onTestSuccess(ITestResult result)
    {
        System.out.println(result.getMethod().getMethodName() + "Passed");
    }


    public void onTestFailure(ITestResult result)
    {
        System.out.println(result.getMethod().getMethodName() + "Failed");

    }
    public void onExecutionStart()
    {

        System.out.println("Test Suite Start Now");
    }

    public void onExecutionFinish()
    {
        System.out.println("Test Suite Finish Now");
    }
    public void beforeInvocation(
            IInvokedMethod method, ITestResult testResult, ITestContext context)
    {
        if (method.isTestMethod())
        {
            System.out.println(method.getTestMethod().getMethodName() + "Test Case Start");
        }

    }

    public void afterInvocation(
            IInvokedMethod method, ITestResult testResult, ITestContext context)
    {
        System.out.println(method.getTestMethod().getMethodName() + "Test Case Finished");

    }

}
