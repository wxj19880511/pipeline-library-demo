#!/usr/bin/env groovy



def call() {
    def log = new Log()
    log.info("Try to fetching parameters for type")
    sh "pwd"
    return ['a', 'b', 'c']
}
