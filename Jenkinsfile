pipeline {
    agent any
    stages {
        stage("read-env"){
            steps {
                script {
                    echo "Working Dir: ${WORKSPACE}"
                    env.local = readJSON(text: readTrusted("environments.json"))
                    echo "${env.local}"
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
            steps {
                echo "Env: ${env}"
                sh "docker pull ${env.local.sonar_qube_config.image}"
                sh """
                                    docker run --rm \
                                        -v \${WORKSPACE}:/opt/project \
                                        ${env.local.sonar_qube_config.image} \
                                        -Dsonar.host.url=${env.local.sonar_qube_config.target['development'].hostname} \
                                        -Dsonar.login=${env.local.sonar_qube_config.target['development'].token} \
                                        -Dsonar.projectKey=${env.local.sonar_qube_config.projectKey} \
                                        -Dsonar.projectName=${env.local.sonar_qube_config.projectName} \
                                        -Dsonar.sources=${env.local.sonar_qube_config.source} \
                                        -Dsonar.verbose=true \
                                        /opt/project
                                """
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