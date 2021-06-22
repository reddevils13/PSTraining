def repo = "PSTraining"
pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                dir("${repo}/java-project") {
                    bat """mvn clean install"""
                }
            }
        }
        stage('Compile'){
            steps{
                dir("${repo}/java-project") {
                    bat """mvn compile"""
                }
            }
        }
        stage('Package'){
            steps{
                dir("${repo}/java-project") {
                    bat """mvn package"""
                }
            }
        }
        stage('Test'){
            steps{
                dir("${repo}/java-project/target") {
                    bat """java -cp projectadd-1.0-SNAPSHOT.jar com.sapient.App"""
                }
            }
        }
    }
}