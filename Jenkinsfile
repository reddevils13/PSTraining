def repo = "java-project"
pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                dir("${repo}") {
                    bat """mvn clean install"""
                }
            }
        }
        stage('Compile'){
            steps{
                dir("${repo}") {
                    bat """mvn compile"""
                }
            }
        }
        stage('Package'){
            steps{
                dir("${repo}") {
                    bat """mvn package"""
                }
            }
        }
        stage('Test'){
            steps{
                dir("${repo}/target") {
                    bat """java -cp projectadd-1.0-SNAPSHOT.jar com.sapient.App"""
                }
            }
        }
    }
}