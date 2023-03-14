// import hudson.model.Result;
// static main(args) {
// 	def body = {}
// 	body.resolveStrategy = Closure.DELEGATE_FIRST
// 	body.delegate = [:]
// 	call(body)
// }	

def call() {
  // def pipelineParams= [:]
  // def deployTimeouts
  // body.resolveStrategy = Closure.DELEGATE_FIRST;
  // body.delegate = pipelineParams
  // body()
  pipeline{
    agent any
    stages {
      stage('Build'){
        steps{
            // sh 'first'
            sh 'echo working'
            printAnother()
        }
      }

      stage('Dependency Check & SonarQube Code Analysis'){
        parallel{
            stage("stage 1"){
              sh 'echo stage 1'
              // printAnother()
            }

             stage("stage 2"){
              sh 'echo stage 2'
              // printAnother()
            }
        }
      }

      stage("test") {
        when {
          expression {
            'false' == 'true'
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
    }
  }
}
