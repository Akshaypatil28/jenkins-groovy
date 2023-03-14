import hudson.model.Result;
static main(args) {
	// def body = {}
	// body.resolveStrategy = Closure.DELEGATE_FIRST
	// body.delegate = [:]
	call()
}	

def call() {
  def pipelineParams= [:]
	def deployTimeouts;
  pipeline{

    stages {
      stage('Initialize Default Build Parameters'){
				steps{
          sh 'first'
          sh 'echo working'
          printAnother();
        }
			}
    }
  }
}
