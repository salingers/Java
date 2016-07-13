
BDKSUPPORTJAR= \
	F:\BDK\beanbox\lib\support.jar

JARS= \
	$(BDKSUPPORTJAR) \
	..\ScrollWord.jar

JARPATH=..\support.jar;..\ScrollWord.jar

JARFILE= \
	..\myApplet.jar

HOOKUPS=

##

all:	$(JARFILE)

$(JARFILE): MyApplet.class MyAppletData $(HOOKUPS)
	jar cfm $(JARFILE) <<manifest.tmp MyApplet.class MyAppletData $(HOOKUPS)
Name: MyApplet.class
Java-Bean: True
<<

MyApplet.class: MyApplet.java $(JARS)
	set CLASSPATH=.;$(JARPATH);%CLASSPATH%
	javac MyApplet.java

..\support.jar: $(BDKSUPPORTJAR)
	copy $(BDKSUPPORTJAR) ..\support.jar

..\ScrollWord.jar: F:\BDK\jars\ScrollWord.jar
	copy F:\BDK\jars\ScrollWord.jar ..\ScrollWord.jar

