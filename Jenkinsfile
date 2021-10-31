pipeline {

    agent any
        tools { 
      maven 'maven 3.5.0' 
    }


        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package"
                // sh "mvn clean package -DskipTests" pour une machine linux
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