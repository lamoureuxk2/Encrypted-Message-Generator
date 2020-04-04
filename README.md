# Implementation Description

This application will generate emails with a unique template for 5 different categories of customer: Business; VIP; Returning; Frequest; and New. One class: EmailGenerationSystem, will function as an abstract factory (software pattern) that can create custom emails that are different depending on what subclass of customer they are going to. Each there will be one version of the method for generating emails per subclass of customer.

There will be 9 total classes: One abstract class for customer; One subclass for each customer categorey; KeyGenerator, Encryption, and EmailGenerationSystem.

The customer class will have a data field for first name, last name, and email address, represented by Strings. There will be standard getters and setters. There will also be a method for getting the full name.

In this application, the classes for the 5 categories of customer will have no unique data fields or methods, they simply extend the base customer class.. The reason they are separated into 5 classes instead of having one class, despite the similarity, is because that was a requirement for the application. If this were not a requirement I would be inclined to just make one customer class with a data field representing the kind of customer. However, I can how future projects that use this code could benefit from having 5 subclasses made.

The KeyGenerator class has a main that creates a java PublicKey and PrivateKey object that are saved as files. These Key files are included in the project and do not need to be produced again. In future iterations of the app, this class could be used to generate new keys.

The Encryption class makes use of the Key files. There is a method for Encrypting a string and returning an encrypted byte array. There is a method for Decrypting a byte array and returning a String. 

The EmailGenerationSystem will have a method for generating an email that will take in a customer Object. This method will check what specific subclass of customer the argument is, and will call a respective method: there will be one method for each corresponding subclass that will generate an email with a corresponding template. 
The EmailGenerationSystem class will have a String saved for Header, body, and footer; 5 of each, one for each subclass of customer. The method will then call another method, generateBody, that allows the user to add the text they want for the body. This method will ultimately return a String for the body. But before this, the generateBody will ask the user if they want to spell check the message, and if so, will run a spell check and allow the user to retype the message. Then the final message is returned back to the calling method. After this the user will be prompted for their name for the email signature.
The 3 parts of the email will be combined into one string, and then the user will be asked if they want the message encrypted. If so, it will be encrypted. 


# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

We recommand the above command for running the project. 

Alternativly, you can run the following command. It will generate a single jar file with all of the dependencies. 

```bash
mvn clean compile assembly:single

java -Dlog4j.configuration=file:log4j.properties -classpath ./target/JavaProjectTemplate-1.0-SNAPSHOT-jar-with-dependencies.jar  edu.bu.met.cs665.Main
```


# Run all the unit test classes.


```bash
mvn clean compile test

```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```


For more info about FindBugs see 

http://findbugs.sourceforge.net/

And about Maven Findbug plugin see 
https://gleclaire.github.io/findbugs-maven-plugin/index.html


You can install Findbugs Eclipse Plugin 

http://findbugs.sourceforge.net/manual/eclipse.html



SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

You can find more info about coveralls 

https://coveralls.io/

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


