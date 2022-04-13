# CSCI3170ProjectGroup10

1155143814 Lam Tsz Hoi
1155126922 Chan Kai Yan
1155111816 Anshul Ghanshala

This is a car renting system.

upload folder to linux1 by scp command
scp -r <Loca path> <linux1 path>

run main.java together with  .jar file by 
java -cp .:mysql-connector-java-5.1.47.jar main.java

if anyerror on .class file, 
it is because the java version in own computer and linux are different

remove them and use javac to complie it again
java under crs may need to compile w/ Database, use
javac -cp <path to Database, .. is ok> *.java
