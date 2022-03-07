pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-1.8' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}