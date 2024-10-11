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
        stage('cleaning workspace'){
            steps{
                cleanWs()
            }
        }
    
        stage('clone') {
            steps {
               checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkins-ssh-key', url: 'git@github.com:malleshdevops/devops-us-maven.git']]) 
            }
        }
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
