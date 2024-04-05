pipeline {
    agent any
    environment {
        HOST_URL = "http://localhost:7000"
        SPRING_PROFILES_ACTIVE = "jenkins"
        SONAR_PROJECT_KEY = credentials ('sonarqube-project-key')
        SONAR_ACCESS_TOKEN = credentials('sonarqube-access-token')
    }
    stages {
        stage("Checkout"){
            steps {
                checkout scm
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} -Dsonar.projectName='Email Client' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=${env.SONAR_ACCESS_TOKEN}"
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