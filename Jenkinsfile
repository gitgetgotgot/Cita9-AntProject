pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\Program Files\Java\jdk-21'
        ANT_HOME = 'C:\Program Files\apache-ant-1.10.14-bin\apache-ant-1.10.14'
        PATH = "${ANT_HOME}\\bin;${JAVA_HOME}\\bin;${env.PATH}"
    }

    tools {
        ant 'Apache Ant 1.10.14' // Reference to a configured Ant tool
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/gitgetgotgot/Cita9-AntProject.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Using Ant from: ${env.ANT_HOME}"
                    bat "ant -f build.xml clean compile jar"
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Добавьте команды для запуска тестов, если они есть
            }
        }

        stage('Package') {
            steps {
                script {
                    def jarExists = fileExists('dist/Lab9.jar')
                    if (!jarExists) {
                        error("JAR file not found!")
                    }
                }
                echo "JAR file successfully built."
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy stage (optional)..."
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
