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
       
        stage('maven build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
