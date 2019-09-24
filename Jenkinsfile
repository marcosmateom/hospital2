pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK8'
    }
    withSonarQubeEnv {
    SONAR_HOST_URL = '192.168.99.100:9000'
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
                sh 'mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.99.100:9000/sonar -Dsonar.host.url=http://192.168.99.100:9000'
                
            }
        }
        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        stage('deploy if dev'){
            when {
                branch 'dev'
            }
            steps{
                echo 'Esta branch es dev'
                deploy adapters: [tomcat8(credentialsId: 'admintom', path: '', url: 'http://192.168.99.100:8888/')], contextPath: null, war: 'target/proyectoDB2-Hospital1.war'
            }
        }
    }
    post {  
         always {  
             echo 'This will always run'  
         }  
         success {  

             echo 'This will run only if successful'
             emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
             
         }  
         failure {  
             echo 'This will run only if FAILS'
             emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
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
