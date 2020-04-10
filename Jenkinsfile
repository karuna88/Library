node {
	stage('Build') {
		sh '"$MAVEN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
	}
}