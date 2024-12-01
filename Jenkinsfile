pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ваш_репозиторий.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    ant 'clean compile jar'
                }
            }
        }
        stage('Deploy') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(
                    configName: 'remote-server',
                    transfers: [sshTransfer(
                        sourceFiles: 'dist/Lab9.jar',
                        removePrefix: 'dist',
                        remoteDirectory: '/путь/на/сервере',
                        execCommand: 'java -jar /путь/на/сервере/Lab9.jar'
                    )]
                )])
            }
        }
    }
}
