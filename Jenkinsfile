pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('slack'){
            steps {
                slackSend message: "*SUCCESS:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}",
                          channel: 'slack---teste'
            }
        }
    }
        post {
            always {
                script {
                        def subject = "JENKINS EXECUTION REPORT - ${env.JOB_NAME} - Build #${env.BUILD_NUMBER} - ${currentBuild.currentResult}"
                        def content = '${SCRIPT,template="html-template-resume-junit.template"}'

                        def attachLog = (currentBuild.currentResult != "SUCCESS")
                        emailext(body: content, mimeType: 'text/html',
                                subject: subject, to: 'felipe.bevilacqua@maps.com.br',
                                attachLog: attachLog)
                }
            }
        }
}