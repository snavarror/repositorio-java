#!groovy?
def GIT_COMMIT = ""
def GIT_REPOSITORY = ""
def GIT_URL = ""

node {
deleteDir()
stage('Descargar Fuentes') {
checkout scm
script {
	GIT_COMMIT = sh (
        script: 'git rev-parse HEAD',
        returnStdout: true
    ).trim()
    GIT_COMMIT = GIT_COMMIT.substring(0,8)

    GIT_URL = sh (
        script: 'git config --get remote.origin.url',
        returnStdout: true
    ).trim()
    GIT_REPOSITORY = GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')

}
}
stage('Build')
{	
def mvnHome = tool 'jenkinsmvn';
sh "${mvnHome}/bin/mvn clean install"
}

stage('Test')
{	
sh "echo Test"
}

stage('Build And Push')
{	

	script {
		withDockerRegistry([ credentialsId: "account-azure-registry", url: "https://${env.AZURE_REGISTRY}" ]){

			sh "docker build -t ${GIT_REPOSITORY}:${GIT_COMMIT} ."
			sh "docker tag ${GIT_REPOSITORY}:${GIT_COMMIT} ${env.AZURE_REGISTRY}/${GIT_REPOSITORY}:${GIT_COMMIT}"
			sh "docker push ${env.AZURE_REGISTRY}/${GIT_REPOSITORY}:${GIT_COMMIT}"

		}
	}


}

stage('Deploy')
{	

script {
      sh "sed -i 's/#{TAG}/${GIT_COMMIT}/g' $WORKSPACE/k8s/deployment.yaml"
	  sh "kubectl apply -f $WORKSPACE/k8s/deployment.yaml"	
	  sh "kubectl -n sapia get svc"	
}

}

}