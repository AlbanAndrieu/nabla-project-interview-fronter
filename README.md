# nabla-project-interview-fronter
Java project for an interview request for fronter

The challenge
================

You can implement the programming challenge using any language and any tools you prefer.
If there is anything you would like me to clarify, please feel free to ask.

Here is the programming challenge:

### Kata Bowling

Problem Description

    Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game. Here are some things that the program will not do:
    We will not check for valid rolls.
    We will not check for correct number of rolls and frames.
    We will not provide scores for intermediate frames.
    Depending on the application, this might or might not be a valid way to define a complete story, but we do it here for purposes of keeping the kata light. I think you'll see that improvements like those above would go in readily if they were needed for real.
    We can briefly summarize the scoring for this form of bowling:
    Each game, or "line" of bowling, includes ten turns, or "frames" for the bowler.
    In each frame, the bowler gets up to two tries to knock down all the pins.
    If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
    If in two tries he knocks them all down, this is called a "spare" and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
    If on his first try in the frame he knocks down all the pins, this is called a "strike". His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
    If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
    The game score is the total of all frame scores.

More info on the rules at: www.topendsports.com/sport/tenpin/scoring.htm

### Clues

What makes this game interesting to score is the lookahead in the scoring for strike and spare. At the time we throw a strike or spare, we cannot calculate the frame score: we have to wait one or two frames to find out what the bonus is.

### Suggested Test Cases

- (When scoring "X" indicates a strike, "/" indicates a spare, "-" indicates a miss)
- "XXXXXXXXXXXX" (12 rolls: 12 strikes) = 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 = 300
- "9-9-9-9-9-9-9-9-9-9-" (20 rolls: 10 pairs of 9 and miss) = 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 = 90
- "5/5/5/5/5/5/5/5/5/5/5" (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 = 150

------------------

### Result

Please find below output of this sample:

- Source code repository : [github](https://github.com/AlbanAndrieu/nabla-project-interview-fronter)

- Jenkins : [jenkins](http://home.nabla.mobi:8380/jenkins/job/nabla-project-interview-fronter/) 

- Sonar metrics : [sonar](http://home.nabla.mobi:9000/dashboard/index/2831)

Remarks : fronter installer is produced during the jenkins build , especially [here](http://home.nabla.mobi:8380/jenkins/job/nabla-installer-fronter/).
In order to install, double click on the [FRONTERInstaller.jar](http://home.nabla.mobi:8380/jenkins/job/nabla-installer-fronter/lastSuccessfulBuild/artifact/fronter-installer/target/FRONTERInstaller.jar)

On unix, please make sure you can execute the installer :

    chmod 777 FRONTERInstaller.jar
    sudo ./FRONTERInstaller.jar
    
Once installed :

    cd /usr/local/fronter-installer-1.0.1-SNAPSHOT
    sudo chmod 777 ./run.sh
    sudo ./run.sh start
    
You can find a basic GUI at http://localhost:9090/rolls.xhtml
Enjoy!!!

------------------

### My resources

Other resources can be found on my [googlecode](https://code.google.com/p/alban/w/list) wiki:

Below resources are available from outside my network :

- Set up your workstation : [workstation](https://github.com/AlbanAndrieu/ansible-workstation) 

- Set up your build environment : [servers](https://github.com/AlbanAndrieu/ansible-nabla) 

- Nexus : [nexus](http://home.nabla.mobi:8081/nexus/index.html#welcome)

- Phpmyadmin : [phpmyadmin](http://home.nabla.mobi:7070/phpmyadmin)

Only for local users to the network :

- Elasticsearch / Logstash / Kibana: [logstash](http://192.168.0.29:80/)

- Monit monitoring: [monit](http://192.168.0.29:3737)

- Mon monitoring: [mon](http://192.168.0.29:7070/cgi-bin/mon.cgi)

- Supervisor: [supervisor](http://192.168.0.29:9042/)

- Statistic : [awstats](http://192.168.0.29:7070/cgi-bin/awstats.pl?config=home.nabla.mobi)

- Disk usage : [philesight](http://192.168.0.29:7070/cgi-bin/philesight.cgi)

------------------

### My opensource projects

On [GitHub](https://github.com/AlbanAndrieu) I have mostly [Ansible](http://www.ansible.com/home) roles. 

I am trying to contribute as much as possible (instead of creating new projects). The projects I have created are shared on the Ansible repository [ansible-galaxy](https://galaxy.ansible.com/list#/users/1487)

All the roles I am using are gathered inside a main role [ansible-nabla](https://github.com/AlbanAndrieu/ansible-nabla).

The main project provides a continuous delivery build farm and everything needed for a dev, systems admin, QA, UI, or a release manager.

You will also have stuff like :

 - [jenkins](http://jenkins-ci.org/) (scheduler)
 - [sonar](http://www.sonarqube.org/) (metrics)
 - [nexus](http://www.sonatype.org/nexus/) (repository)
 - [docker](https://www.docker.com/) (provisioning)
 - [vagrant](https://www.vagrantup.com/) (provisioning)
 - [virtualbox](https://www.virtualbox.org/) (provisioning)
 - [logstash](http://logstash.net/) (monitoring)
 - [eclipse](https://eclipse.org/home/index.php) (with basic plugins), 
 - [za-proxy](https://code.google.com/p/zaproxy/) (security)
 - [jmeter](http://jmeter.apache.org/) (performance)
 - [visualVM](http://visualvm.java.net/) (performance)
 - [selenium](http://www.seleniumhq.org/) and Xvfb (End2End test)
 
There is also a FrontEnd [apache](http://httpd.apache.org/) with mod [pagespeed](https://developers.google.com/speed/pagespeed/), [fail2ban](http://www.fail2ban.org/wiki/index.php/Main_Page), DeniedOfService, [AWStats](http://www.awstats.org/), a [Varnish](https://www.varnish-cache.org/) load balancer, [Zabbix](http://www.zabbix.com/), Mon, [Monit](http://mmonit.com/monit/), [Supervisor](http://supervisord.org/), [Jboss](http://www.jboss.org/), [Tomcat](http://tomcat.apache.org/) ready and more.

Essentially, there is a bit more than the basic tools for a production, staging, dev environment all configured to work together with as much security as possible.

My "old" project [nabla](https://code.google.com/p/alban/) which is using [andromda](http://www.andromda.org/index.html) as an UML code generator. 
I am now using this project more because it generates a lot of code and it is resource-demanding for my devops environment. 
This project is using JBoss, Seam, Hibernate, Spring,GWT, JSF, Arquillian, ... So it was quite hard to get Jacoco with mutation testing to work with it.
In this repo there's also some sample projects used as ProofOfConcept

 - Database best pratices [nabla-databases-integration](http://home.nabla.mobi:8380/jenkins/job/nabla-databases-integration/)
 
 - Server integration best pratices [nabla-uml-integration](http://home.nabla.mobi:8380/jenkins/job/nabla-servers-integration/)
 
 - UML best pratices [nabla-uml-integration](http://home.nabla.mobi:8380/jenkins/job/nabla-uml-integration/)
 
The goal is mostly to ensure that any of my code will be able to work with any [database](http://home.nabla.mobi:8380/jenkins/job/nabla-databases-matrix/) on any [servers/browsers](http://home.nabla.mobi:8380/jenkins/job/nabla-browsers-matrix/) using [selenium](http://home.nabla.mobi:8380/jenkins/job/nabla-servers-jsf-simple-selenium/).
 
------------------

### VISMA : An opensource project to showcase best pratices

You're invited to have a quick look at the project below (it has some of the quality metrics that I am using at work, like unit tests, integration tests, mutation tests, performance tests, load tests, end2end tests, functional tests)
 - [Jenkins](http://home.nabla.mobi:8380/jenkins/job/nabla-project-interview-visma/)
 - [Sonar](http://home.nabla.mobi:9000/dashboard/index/418)

Visma is a very basic code done for an interview that you can easily install using [IZPack](http://izpack.org/) at [installer](http://home.nabla.mobi:8380/jenkins/job/nabla-installer-visma/lastSuccessfulBuild/artifact/visma-installer/target/)
The goal is to provide an easy Maven starter with basic integration and metrics for any code interview working.
The goal is also to have as many testing tools ready to work altogether (like junit, mock, selenium, cucumber). 
because there is always some form of incompatiblity between them...
The GUI is working on jetty! It is basic, but it has coverage, debug mode, monitoring (JMX and NewRelic) and even some perf testing.
The code is not yet using the best tool like REST, and AngularJS and has no database. 
So like this, a dev can mesure the quality of his work.
It takes 1 hour to build for 1000 lines of code on an old laptop...

Writing code is just one step among many others: building, testing, documenting, releasing, packaging, deploying, monitoring

Thanks for reading!

***

Alban Andrieu

[linkedin](fr.linkedin.com/in/nabla/)
