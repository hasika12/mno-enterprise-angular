package library;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class DriverScript implements IAnnotationTransformer
{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		String MethodName = testMethod.getName();
		boolean Executionstatus = genlib.getExecuteStatus(MethodName);
		int priority = genlib.getPriority(MethodName);
		
		if(Executionstatus==true)
		{
			annotation.setEnabled(true);
			annotation.setPriority(priority);
		}
		else
		{
			annotation.setEnabled(false);
		}
	}

}
