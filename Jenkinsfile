


pipeline {
    agent any
    tools {
        maven 'maven3'
    }
    options {
                timeout(time: 1, unit: 'HOURS') 
                timestamps()
                buildDiscarder(logRotator(numToKeepStr: '2'))
            }

    stages {    
        stage('maven build'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('junit'){
            steps{
                junit stdioRetention: '', testResults: 'target/surefire-reports/*.xml'
            }
        }
        stage('upload nexus'){
            steps{
             nexusArtifactUploader artifacts: [[artifactId: 'my-app', classifier: '', file: 'target/my-app-1.1.jar', type: 'jar']], credentialsId: 'jenkins-nexus-id', groupId: 'com.mycompany.app', nexusUrl: '35.234.137.115:32000', nexusVersion: 'nexus3', protocol: 'http', repository: 'devops-maven-test', version: '1.1'
            }
        }
        stage('archive artifact'){
            steps{
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
       
    }
}
