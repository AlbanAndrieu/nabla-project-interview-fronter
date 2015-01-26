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

I have also added a quick GUI, that you can find at http://localhost:9090/

------------------

Other resources can be found on my [googlecode](https://code.google.com/p/alban/w/list) wiki:

- Set up your workstation : [workstation](https://github.com/AlbanAndrieu/ansible-workstation) 

- Set up your build environement : [servers](https://github.com/AlbanAndrieu/ansible-nabla) 

- Nexus : [nexus](http://home.nabla.mobi:8081/nexus/index.html#welcome)

- Phpmyadmin : [phpmyadmin](http://home.nabla.mobi:7070/phpmyadmin)

Only for local user to the network :

- Elasticsearch / Logstash / Kibana: [logstash](http://192.168.0.29:80/)

- Monit monitoring: [monit](http://192.168.0.29:3737)

- Mon monitoring: [mon](http://192.168.0.29:7070/cgi-bin/mon.cgi)

- Supervisor: [supervisor](http://192.168.0.29:9042/)

- Statistic : [awstats](http://192.168.0.29:7070/cgi-bin/awstats.pl?config=home.nabla.mobi)

- Disk usage : [philesight](http://192.168.0.29:7070/cgi-bin/philesight.cgi)

------------------

### My opensource projects

On GitHub I have mostly Ansible roles. 

I am trying to contribute as much as possible (instead of creating new project).

All the roles I am using are gathered inside this one https://github.com/AlbanAndrieu/ansible-nabla which is using them as git submodule.

This role is creating an Continuous Delivery build farm and everything needed for a dev, sysadmin, qa, ui, release manager guy to work.

Jenkins, Sonar, Nexus, Docker, Eclipse, Logstash. 

You will even have stuff like Eclipse (with basic plugins), ZaProxy, Jmeter, VisualVM tools, and a FrontEnd Apache with mod pagespeed, fail2ban, DeniedOfService, AWStats, a Varnish load balancer, Zabbix, Mon, Monit, Supervisor, Jboss, Tomcat, Selenium and Xvfb ready and more.

Mostly, there is a bit more than the basic tools for a production, staging, dev environment all setted to work together with as much security as possible.


My "old" project https://code.google.com/p/alban/ which is using http://www.andromda.org/index.html is an UML code generator. 
I am now more using this project because it generate a lot of code and it is resource demanding for my devops environment. 
This project is using JBoss, Seam, Hibernate, Spring,GWT, JSF, Arquillian, ... So it was is quite hard to get Jacoco with mutation testing working with it.

Have a quick look at the below project (it has some of the quality metric that I am using at work, like unit test, integration test, mutation test, perf test, load testing, end2end test, functional testing)
Jenkins -> http://home.nabla.mobi:8380/jenkins/job/nabla-project-interview-visma/
Sonar -> http://home.nabla.mobi:9000/dashboard/index/418

Visma is a very basic code done for an interview that you can easilly install using IZPack at http://home.nabla.mobi:8380/jenkins/job/nabla-installer-visma/lastSuccessfulBuild/artifact/visma-installer/target/ 
Goal is to provide an easy maven starter with basic integration and metric for any code interview working.
Goal is also to have as much testing tools ready to work altogether (like junit, mock, selenium, cucumber). Because there is always one incompatiblity between them...
GUI is working on jetty! It is basic, but it has coverage, debug mode, monitoring (JMX and NewRelic) and even some perf testing.
Code is not yet using the best tool like REST, and AngularJS and has no database. 
It is just not realistic to have the cutting edge technology for an interview whithin a few hours.
So at least a dev can mesure quality of his work.
It takes 1 hour to build for 1000 line of code on an old laptop...

Because writing code is just one step among the others : building, testing, releasing, packaging, deploying, monitoring
But I keep thinking that a developer who his not using great tools cannot be a great developer.

Thanks for reading

***

Alban Andrieu
fr.linkedin.com/in/nabla/
