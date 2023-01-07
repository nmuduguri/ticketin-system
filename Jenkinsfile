pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                sh "cd /home/ubuntu/projects/"
                sh "sudo touch test.txt"
                sh "sudo systemctl stop railways.service"
                sh "git clone https://github.com/nmuduguri/ticketin-system.git"
                sh "cd ticketin-system"
                sh "mvn clean -f railways"
            }
        }
        stage('install') {
            steps {
                sh "mvn install -f railways"
            }
        }
        stage('test') {
            steps {
                sh "mvn test -f railways"
            }
        }
        stage('package') {
            steps {
                sh "mvn clean package -f railways"
                sh "cp ./railways/target/railways.war ../../projects"
                sh "chmod 777 railways.war"
                sh "sudo systemctl start railways.service"
            }
        }
    }
}
