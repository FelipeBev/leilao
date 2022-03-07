pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                slackSend channel: 'jenkins', message: 'teste'
            }
        }
    }
}