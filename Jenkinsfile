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
                //echo 'Estoy en sonar'
                sh 'mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.99.100:9000/sonar -Dsonar.host.url=http://192.168.99.100:9000'
                
            }
        }
        stage('Proximo paso'){
            steps{
                echo 'aqui se pone el proximo paso'
                //sh ''
            }
        }
    }
    post {  
         always {  
             echo 'This will always run'  
         }  
         success {  
             echo 'This will run only if successful'  
         }  
         failure {  
             mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "foo@foomail.com";  
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
