pipeline {
    agent any
    tools {
        maven 'maven'
    }
    options {
                timeout(time: 1, unit: 'HOURS')
                timestamps()
                buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    triggers {
        cron('H */4 * * 1-5')
    }

    stages {
        stage('maven build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('junit') {
            steps {
                junit allowEmptyResults: true, keepProperties: true, stdioRetention: 'ALL', testResults: 'target/surefire-reports/*.xml'
            }
        }
        stage('upload nexus') {
            steps {
                nexusArtifactUploader artifacts: [[artifactId: 'my-app', classifier: '', file: 'target/my-app-1.2.jar', type: 'jar']], credentialsId: 'nexus-cred-id', groupId: 'com.mycompany.app', nexusUrl: '34.93.61.216:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'dev23-java-springapp', version: '1.2'
            }
        }
        stage('archive artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, onlyIfSuccessful: true
            }
        }
    }
}
