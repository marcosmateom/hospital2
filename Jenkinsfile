pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK8'
    }
    stages {
        stage('Obtener proyecto de GIT') {
            steps {
                git 'https://github.com/marcosmateom/hospital2.git'
            }
        }
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Build') {
            steps {
                //sh 'mvn package'
                sh 'mvn install'
                
            }
        }
        stage('Examinar con SonarQube') {
            steps {
                echo 'Estoy en sonar'
                //sh 'mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.99.100:9000/sonar -Dsonar.host.url=http://192.168.99.100:9000'
                
            }
        }
        stage('Proximo paso'){
            steps{
                echo 'aqui se pone el proximo paso'
                //deploy adapters: [tomcat8(credentialsId: 'admintom', path: '', url: 'http://192.168.99.100:8888/')], contextPath: '/var/jenkins_home/workspace/prueba24_master/target/', war: 'proyectoDB2-Hospital1-1.0-SNAPSHOT.war'
            }
        }
    }
    post {  
         always {  
             echo 'This will always run'  
         }  
         success {  
             echo 'This will run only if successful' 
             deploy adapters: [tomcat8(credentialsId: 'admintom', path: '', url: 'http://192.168.99.100:8888/')], contextPath: null, war: 'target/proyectoDB2-Hospital1-1.0-SNAPSHOT.war'
         }  
         failure {  
             echo 'This will run only if FAILS'
         }  
         unstable {  
             echo 'This will run only if the run was marked as unstable'  
         }  
         changed {  
             echo 'This will run only if the state of the Pipeline has changed'  
             echo 'For example, if the Pipeline was previously failing but is now successful'  
         }  
     } 
}
