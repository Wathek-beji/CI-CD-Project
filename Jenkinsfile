pipeline {

    agent any
        tools { 
      maven 'maven 3.5.0' 
    }


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "main", 
                    url: "https://github.com/Wathek-beji/ci_project.git",
                    credentialsId: "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"; 
            }
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