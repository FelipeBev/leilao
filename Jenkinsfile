pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
        post {
            always {
                script {
                        def subject = "JENKINS EXECUTION REPORT - ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}"
                        def content = 'Teste'

                        emailext(body: content, mimeType: 'text',
                                subject: subject, to: 'felipe.bevilacqua@maps.com.br')
                }
            }
        }
}