job('sparefant-fe-master') {
    scm {
        github(ownerAndProject = 'pederpus/sparefant-fe', branch = 'master',  protocol = 'git')
    }
    triggers {
        githubPush()
    }
    steps {
        shell("npm i ")
        shell("npm run build")
        shell("cp -r build/* /etc/www/sparefant.no/html")
    }
    publishers {
        githubCommitNotifier()
        wsCleanup()
    }
}