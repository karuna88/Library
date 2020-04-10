node {
	stage('Build') {
		git 'https://github.com/karuna88/Library.git'
		sh '"/Users/karuna/Documents/Maven/apache-maven-3.6.2/bin/mvn" -Dmaven.test.failure.ignore clean package'
	}
}