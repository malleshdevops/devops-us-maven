pipeline{
  agent any;
  options { 
    timestamps()
    buildDiscarder(logRotator(numToKeepStr: '10'))
    
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
