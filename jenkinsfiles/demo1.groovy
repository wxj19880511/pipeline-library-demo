#!/usr/bin/env groovy

@Library('pipeline-library-demo')_

import com.qikqiak.GlobalEnv
import com.qikqiak.GlobalVars



pipeline {
    agent any 

    stages{
        stage('demo global vars') {
            steps {
                echo 'Hello world'
                sayHi '阳明'
                println GlobalVars.foo
            }
        }

        stage('demo function calls') {
            steps {
                script {
                    g =  new GlobalEnv(this)
                    println g.login()
                }
            }
        }
    }
}
