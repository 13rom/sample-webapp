pipeline {
    agent worker

    stages {
        stage('Build') {
            steps {
                echo 'Executing build stage'
                sh 'sed -i "s/%INSERT-HERE%/$(date)/" app/index.html'
                sh 'sed -i "s/%BUILD-NUMBER%/${BUILD_NUMBER}/" app/index.html'
            }
        }
        stage('Test') {
            steps {
                echo 'Executing test stage'
                sh '''
                result=$(grep -c html app/index.html)
                if [ "$result" = "2" ]; then
                    echo "Test passed"
                    exit 0
                else
                    echo "Test failed!"
                    exit 1
                fi
                '''
            }
        }
        stage('Deploy') {
            steps {
                echo 'Executing deploy stage'
                sh 'hostname'
                sh 'whoami'
                sh 'pwd'
                sh 'ls -la'
            }
        }
    }
}
