pipeline {
    agent any
    environment {
        HOST_URL = "http://localhost:7000"
    }
    stages {
        stage("Checkout"){
            steps {
                checkout main
            }
        }
        stage("Build"){
            steps {
                sh "mvn clean install"
            }
        }
        stage("Test"){
            steps {
                sh "mvn test"
            }
        }
       stage("Deploy"){
        steps {
            sh "mvn spring-boot:run"
        }
       }
    }
}