Spring And AspectJ Load Time Weaving
====================================

Spring 3.x Load Time Weaving with Aspectj

This is a simple maven project to demonstrate AspectJ Load Time Weaving for a standalone java application with aspects packaged in a different jar

Artifact Versions
=================

spring - 3.1.0.RELEASE
asjectj (rt and weaver) - 1.6.8

Setup
=====

Maven project "ltw" is the parent module which has two child modules
"aspectj-jar": where the aspect/advice is packaged
"spring-app": command line app which uses the aspect/advice defined in "aspectj-jar"

How to run?
===========

1. mvn clean package
2. java -javaagent:C:\Users\amit.misra\.m2\repository\org\aspectj\aspectjweaver\1.6.8\aspectjweaver-1.6.8.jar \
		-javaagent:C:\Users\amit.misra\.m2\repository\org\springframework\spring-instrument\3.1.0.RELEASE\spring-instrument-3.1.0.RELEASE.jar \
		-Djava.ext.dirs="C:\Program Files\Java\jdk1.7.0_17\jre\lib\ext";"F:\Users\amit.misra\aspectj\ltw\workspace\ltw\lib" \
		-jar F:\Users\amit.misra\aspectj\ltw\workspace\ltw\spring-app\target\spring-app-0.0.1-SNAPSHOT.jar
3. Check the app.log file to see the aspect log messages associated with the around advice


