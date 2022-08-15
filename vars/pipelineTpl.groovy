#!/usr/bin/env groovy

import com.qikqiak.GlobalEnv
import com.qikqiak.GlobalVars


def call() {

    def log = new Log()

    pipeline {
        agent any 

        stages{

            stage('Setup parameters') {
                steps {
                    script { 
                        properties([
                            parameters([
                                choice(
                                    // dynamic parameters
                                    // make a test
                                    choices: myParameters(), 
                                    name: 'PARAMETER_01'
                                ),
                                booleanParam(
                                    defaultValue: true, 
                                    description: '', 
                                    name: 'BOOLEAN'
                                ),
                                text(
                                    defaultValue: '''
                                    this is a multi-line 
                                    string parameter example
                                    ''', 
                                    name: 'MULTI-LINE-STRING'
                                ),
                                string(
                                    defaultValue: 'scriptcrunch', 
                                    name: 'STRING-PARAMETER', 
                                    trim: true
                                )
                            ])
                        ])
                    }
                }
            }


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
                    
                    }
                }
            }
        }
    }
}
