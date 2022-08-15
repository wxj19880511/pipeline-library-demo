#!/usr/bin/env groovy

def log = new Log()

def call() {
    log.info("Try to fetching parameters for type")
    sh "pwd"
    return ['a', 'b', 'c']
}
