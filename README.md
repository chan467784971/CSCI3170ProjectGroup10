# CSCI3170ProjectGroup10

1155143814 Lam Tsz Hoi

1155126922 Chan Kai Yan

1155111816 Anshul Ghanshala


## This is a car renting system.


* upload folder to linux1 by scp command

`scp -r "Loca path" "linux1 path"`

How to run the program
-------------------------------------------------------------------

* Compile ->

`javac crs/*.java model/db/*.java model/file/*.java model/*.java`

* Run the program ->

`java -cp .:mysql-connector-java-5.1.47.jar main.java`

-------------------------------------------------------------------


* if any error on .class file

> it is because the java version in own computer and linux are different
>
> remove them and use javac in linux to complie it again


* If you find any error in dataset, try following function under Admin operation to reset the Database:

`deleteAll -> CreateAll -> LoadAll`

-------------------------------------------------------------------

* References: all the material from CSCI3170's Lecture, Tutorial, and https://github.com/YuChaoGithub/CSCI3170-Project
