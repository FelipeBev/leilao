pipeline {
    agent any

        stage('build') {
            steps {
                sh 'mvn clean test'
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