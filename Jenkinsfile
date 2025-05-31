pipeline {
    agent any
     tools {
        maven 'maven' 
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        }
    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('gitclone') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkins-cred', url: 'https://github.com/malleshdevops/devops-us-maven.git']])
            }
        }
        stage('maven build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
