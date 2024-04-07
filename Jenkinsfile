pipeline {
    agent any
    environment {
        SONAR_HOST_URL = "http://192.168.0.31:9000"
        SPRING_PROFILES_ACTIVE = "jenkins"
        SONAR_PROJECT_KEY = "EmailClient-Local"
        SONAR_ACCESS_TOKEN = "sqp_9d39fc723db3f4b0256522883973391187b69fef"
        SONAR_PROJECT_NAME = "EmailClient"
    }
    stages {
        stage("Checkout"){
            steps {
                checkout scm
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} -Dsonar.projectName=${SONAR_PROJECT_NAME} -Dsonar.host.url=${SONAR_HOST_URL} -Dsonar.token=${env.SONAR_ACCESS_TOKEN}"
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
            sh "mvn compile package"
        }
       }
    }
}