e:
cd "E:\automation\webdrivertraining\lib"
java ^
-Dwebdriver.ie.driver="E:\automation\webdrivertraining\test\resources\IEDriverServer.exe" ^
-jar selenium-server-standalone-3.141.59.jar -role node ^
-hub http://192.168.0.111:4444/grid/register ^
-browser "browserName=internet explorer,maxInstances=3" ^
-maxSession 4
pause