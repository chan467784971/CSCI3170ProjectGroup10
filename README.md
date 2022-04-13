# CSCI3170ProjectGroup10

1155143814 Lam Tsz Hoi
1155126922 Chan Kai Yan
1155111816 Anshul Ghanshala


This is a car renting system.


upload folder to linux1 by scp command

scp -r "Loca path" "linux1 path"

=================How to run the program properly ==================

===================================================================

Compile ->

javac crs/*.java model/db/*.java model/file/*.java model/*.java

Run the program ->

java -cp .:mysql-connector-java-5.1.47.jar main.java

===================================================================


if any error on .class file, 
it is because the java version in own computer and linux are different
remove them and use javac to complie it again


if any java file need to compile with other file together, use

javac -cp "path to target file" *.java


If you find any error in dataset, try following function under Admin operation to reset the Database:

deleteAll -> CreateAll -> LoadAll
