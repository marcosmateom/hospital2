// Powered by Infostretch 

timestamps {

node () {

	stage ('tets - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/marcosmateom/hospital2.git']]]) 
	}
	stage ('tets - Build') {
 	
// Unable to convert a build step referring to "hudson.plugins.timestamper.TimestamperBuildWrapper". Please verify and convert manually if required.
// Unable to convert a build step referring to "hudson.plugins.sonar.SonarBuildWrapper". Please verify and convert manually if required.		// Maven build step
	withEnv(["PATH+MAVEN=${tool 'M3'}/bin:JAVA_HOME/bin"]) { 
 			if(isUnix()) {
 				sh "mvn clean " 
			} else { 
 				bat "mvn clean " 
			} 
 		}		// Maven build step
	withEnv(["PATH+MAVEN=${tool 'M3'}/bin:JAVA_HOME/bin"]) { 
 			if(isUnix()) {
 				sh "mvn package " 
			} else { 
 				bat "mvn package " 
			} 
 		}		// Maven build step
	withEnv(["PATH+MAVEN=${tool 'M3'}/bin:JAVA_HOME/bin"]) { 
 			if(isUnix()) {
 				sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.99.100:9000/sonar -Dsonar.host.url=http://192.168.99.100:9000 " 
			} else { 
 				bat "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.99.100:9000/sonar -Dsonar.host.url=http://192.168.99.100:9000 " 
			} 
 		} 
	}
	stage ('tets - Post build actions') {
/*
Please note this is a direct conversion of post-build actions. 
It may not necessarily work/behave in the same way as post-build actions work.
A logic review is suggested.
*/
		// Mailer notification
		step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'marcosmateom@gmail.com', sendToIndividuals: false])

// Unable to convert a post-build action referring to "hudson.plugins.emailext.ExtendedEmailPublisher". Please verify and convert manually if required. 
	}
}
}
