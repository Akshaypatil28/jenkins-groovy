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
    stages {
      stage('Initialize Default Build Parameters'){
	    steps{
          sh 'first'
          sh 'echo working'
          printAnother()
        }
      }
    }
  }
}
