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
             nexusArtifactUploader(
        nexusVersion: 'nexus3',
        protocol: 'http',
        nexusUrl: '34.145.32.132:8081',
        groupId: 'com.mycompany.app',
        version: 1.0,
        repository: 'pipeline-maven-repo',
        credentialsId: 'jenkins-nexus-id',
        artifacts: [
            [artifactId: my-app,
             classifier: '',
             file: 'my-app-' + 1.0 + '.jar',
             type: 'jar']
        ]
     )
            }
        }
        stage('archive artifact'){
            steps{
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
       
    }
}
