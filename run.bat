set ProjectPath=F:\Workplase_java\nopcomerce
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\Lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\testsuite.xml