
BDKSUPPORTJAR= \
	F:\BDK\beanbox\lib\support.jar

JARS= \
	$(BDKSUPPORTJAR) \
	../ScrollWord.jar

JARPATH=../support.jar:../ScrollWord.jar

JARFILE= \
	../myApplet.jar

HOOKUPS=

##

all:	$(JARFILE)

$(JARFILE): MyApplet.class MyAppletData $(HOOKUPS)
	echo "Name: MyApplet.class" >> manifest.tmp
	echo "Java-Bean: True" >> manifest.tmp
	jar cfm $(JARFILE) manifest.tmp MyApplet.class MyAppletData $(HOOKUPS)
	@/bin/rm manifest.tmp

MyApplet.class: MyApplet.java $(JARS)
	export CLASSPATH; CLASSPATH=.:$(JARPATH):$(CLASSPATH); \
	javac MyApplet.java

../support.jar: $(BDKSUPPORTJAR)
	/bin/cp $(BDKSUPPORTJAR) ../support.jar

../ScrollWord.jar: F:\BDK\jars\ScrollWord.jar
	/bin/cp F:\BDK\jars\ScrollWord.jar ../ScrollWord.jar

