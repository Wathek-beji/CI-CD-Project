pipeline {

    agent any
   
    stages {
    

        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean package"
                
            }
        }
        
        stage("Sonar") {
            steps {
                sh "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                sh "mvn deploy -DskipTests"
            }
        }
    }
   
    post {
        always {

	emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            cleanWs()
        }
    }
    
}
