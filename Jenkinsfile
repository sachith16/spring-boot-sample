pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        echo 'testing demo'
        echo 'testing demo 2'
      }
    }

    stage('build') {
      steps {
        input(message: 'Do you want to build? Y/N', id: 'Y')
        echo 'Starting Building Demo'
      }
    }

  }
}