pipeline {
    agent any
    environment {
        HOST_URL = "http://localhost:7000"
        SPRING_PROFILES_ACTIVE = "jenkins"
        SONAR_PROJECT_KEY = "Email-Client"
        SONAR_ACCESS_TOKEN = "sqa_312939c578979e102927bd344429402a796010b4"
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
            sh "mvn compile package"
        }
       }
    }
}