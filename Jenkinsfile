pipeline{
  agent any;
  options { 
    buildDiscarder(logRotator(numToKeepStr: '10'))
    timestamps()
   }
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
