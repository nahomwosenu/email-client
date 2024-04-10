pipeline {
    agent any
    stages {
        stage("read-env"){
            steps {
                script {
                    echo "Working Dir: ${WORKSPACE}"
                    def environments = readJSON(text: readTrusted("environments.json"))
                    def target = "development"
                    env.target=target
                    env.sonar_projectName=environments.sonar_qube_config.projectName
                    env.sonar_projectKey=environments.sonar_qube_config.projectKey
                    env.sonar_hostname=environments.sonar_qube_config.target[target].hostname
                    env.sonar_token=environments.sonar_qube_config.target[target].token
                    env.sonar_source=environments.sonar_qube_config.source
                    env.sonar_image=environments.sonar_qube_config.image
                }
            }
        }
        stage("Checkout"){
            steps {
                checkout scm
                // sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} -Dsonar.projectName=${SONAR_PROJECT_NAME} -Dsonar.host.url=${SONAR_HOST_URL} -Dsonar.token=${env.SONAR_ACCESS_TOKEN}"
            }
        }
        stage("Sonar Analysis") {
            steps{
                script {
                    echo "Environment: ${env.target}"
                    def scannerHome = tool 'sonarqube-scanner';
                    withSonarQubeEnv('SonarQube-Local') {
                        sh scannerHome + '/bin/sonar-scanner' +
                               ' -Dsonar.projectName=' + env.sonar_projectName +
                               ' -Dsonar.projectKey=' + env.sonar_projectKey +
                               ' -Dsonar.host.url=' + env.sonar_hostname +
                               ' -Dsonar.token=' + env.sonar_token +
                               ' -Dsonar.sources=' + env.sonar_source +
                               ' -Dsonar.verbose=true'
                    }
                }
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