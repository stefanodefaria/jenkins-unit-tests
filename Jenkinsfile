node() {
    stage("test") {
        parallel(["a": { myfunction() }, "b": { myfunctionWithStatus() }])
    }
}

def myfunction() {
    sh("ls -la")
}

def myfunctionWithStatus(arg) {
    def retStatus = sh(script: "pwd", retStatus: true)
    println("retstatus=${retStatus}")
}