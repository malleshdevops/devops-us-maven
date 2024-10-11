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
        stage('archive artifact'){
            steps{
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
       
    }
}
