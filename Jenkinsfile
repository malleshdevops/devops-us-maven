pipeline{
  agent any;
  tools {
        maven 'maven16' 
    }
  stages{
	stage('build'){
	  steps{
	   sh 'mvn clean package'
	  }
    }
	}
}

