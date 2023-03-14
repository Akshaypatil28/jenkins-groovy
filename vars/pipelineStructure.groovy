def call(body) {

  pipeline {

    agent any

    environment {
      VERSION = '1.2.1'
      // SERVER_CREDENTIALS = credentials('server-app') // install a seperate plugin to support this - Credentials Binding
    }

    // tools {

    // }

  //   parameters {
  //     string(name: 'VERSION', defaultValue: '', description: 'Vers')
  //     choice(name: 'VERSION', choices: ['1.1.1', '1.2', '2.3'], description: 'Vers')
  //     booleanParam(name: 'executeTests', defaultValue: true, description: 'Vers')
  //   }

    stages {

      stage("build") {

        steps {
          echo "Installing the dependiences - ${VERSION}"
          nodejs('NodeJs 12.22.9') {
              sh 'node --version'
              sh 'npm --version'
              sh 'npm install'
          }
        }
      }

      stage("Dependency Check & SonarQube Code Analysis") {
        parallel {
          stage("test stage 1") {
            steps {
              echo "Entering into test stage 1"
            }
          }
          stage("test stage 2") {
             steps {
              echo "Entering into test stage 2"
            }
          }
          stage("test stage 3") {
             steps {
              echo "Entering into test stage 3"
            }
          }
          stage("test stage 4") {
             steps {
              echo "Entering into test stage 4"
            }
          }
        }
      }

      stage("test") {
        when {
          expression {
            params.executeTests == 'true'
          }
        }
        // when {
        //   expression {
        //     BRANCH_NAME == 'dev' || BRANCH_NAME == 'Master'
        //   }
        // }
        steps {
          echo "Running testcases"
        }
      }

      stage("deploy") {

        steps {
          echo "Deploying the app...."
        }
      }
    }

    post {
      always {
        echo "Build Status Notifaction Email Sent"
      }
      failure {
        echo "Build Failed"
      }
      success {
        echo "Build Successfully"
      }
    }
  }
}
