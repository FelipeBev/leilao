pipeline {
    agent any
    stages {
        stage('Code checkout') {
            steps {
                dir("${env.HG_NODE_DIRECTORY}") {
                    checkout poll: false,
                        scm: [$class: 'GitSCM',
                               branches: [[name: 'master']],
                               doGenerateSubmoduleConfigurations: false,
                               extensions: [[$class: 'GitLFSPull'],
                                           [$class: 'LocalBranch', localBranch: 'master']],
                               ubmoduleCfg: [],
                               userRemoteConfigs: [url: 'https://github.com/FelipeBev/leilao']]
                            }
                        }
                    }
        stage('build') {
            steps {
                sh 'mvn clean test'
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
}