pipeline {
    agent any

    stages {
        stage('git clone ') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-ssh-key', url: 'git@github.com:malleshdevops/devops-us-maven.git']])
            }
        }
        stage('maven build ') {
            steps {
               sh 'mvn clean package'
            }
        }
        stage('archite artifact ') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
    }
}
