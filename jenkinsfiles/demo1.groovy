#!/usr/bin/env groovy

@Library('pipeline-library-demo')_

import com.qikqiak.GlobalEnv
import com.qikqiak.GlobalVars



pipeline {
    agent any 

    stages{
        stage('demo global vars') {
            steps {
                script {
                    Log.info('test_script')
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
                    Log.warning('Logged you in')
                }
            }
        }
    }
}
