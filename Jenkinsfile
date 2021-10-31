pipeline {

    agent any
    
    tools { 
      maven 'maven 3.5.0' 
    }


    stages {
    

        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package"
                
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn deploy -DskipTests"
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}