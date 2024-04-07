pipeline {
    agent any
    environment {
        HOST_URL = "http://localhost:7000"
        SPRING_PROFILES_ACTIVE = "jenkins"
        SONAR_PROJECT_KEY = "EmailClient-Local"
        SONAR_ACCESS_TOKEN = "squ_7bbd3b0868e189d09d2861bab38b6c70a9ec5978"
    }
    stages {
        stage("Checkout"){
            steps {
                checkout scm
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} -Dsonar.projectName='Email Client' -Dsonar.host.url=http://192.168.0.31:9000 -Dsonar.token=${env.SONAR_ACCESS_TOKEN}"
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