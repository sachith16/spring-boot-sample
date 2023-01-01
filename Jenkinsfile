pipeline {
  agent any
  stages {
    stage('test') {
      parallel {
        stage('test') {
          steps {
            echo 'testing demo'
            echo 'testing demo 2'
          }
        }

        stage('write_log') {
          environment{
            LocalVariable = "Hello Local"
          }
          steps {
            writeFile(file: 'Log.txt', text: "This is an automation file ${LocalVariable}")
          }
        }

      }
    }

    stage('build') {
      parallel {
        stage('build') {
          steps {
            input(message: 'Do you want to build? Y/N', id: 'Y')
            echo 'Starting Building Demo'
          }
        }

        stage('archive') {
          steps {
            archiveArtifacts 'Log.txt'
          }
        }

      }
    }

  }
}