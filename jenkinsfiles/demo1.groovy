#!/usr/bin/env groovy

@Library('pipeline-library-demo') _

import com.qikqiak.GlobalEnv
import com.qikqiak.GlobalVars

def log = new Log()

pipeline {
    agent any 

    stages{
        stage('demo global vars') {
            steps {
                script {
                    log.info 'test_script'
                    sayHi '阳明'
                    println GlobalVars.foo
                }
            }
        }

        stage('demo function calls') {
            steps {
                script {
                    sh "touch a.txt"
                    def g = new GlobalEnv(this)
                    g.login()
                    log.warning('Logged you in')
                    log.error("some errors happens")
                }
            }
        }
    }
}
