pipeline {
    agent any

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
                sshPublisher failOnError: true, publishers: [sshPublisherDesc(configName: 'webserver-oracle', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/var/www/html', remoteDirectorySDF: false, removePrefix: 'app', sourceFiles: 'app/index.html')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)]
            }
        }
    }
}
