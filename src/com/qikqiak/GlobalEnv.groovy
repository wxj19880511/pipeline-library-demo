#!/usr/bin/env groovy

package com.qikqiak

class GlobalEnv implements Serializable  {
    def steps

    GlobalEnv(steps) {
        this.steps = steps
    }

    def login() {
        if (steps.fileExists("a.txt")) {
            steps.sh "ls -alt a.txt"
        } else {
            steps.sh "echo file a.txt not exits"
        }
    }
}

// make a test