job('sparefant-fe-master') {
    wrappers {
        nodejs('NodeJS 9.3.0')
    }
    scm {
        github(ownerAndProject = 'pederpus/sparefant-fe', branch = 'master',  protocol = 'git')
    }
    triggers {
        githubPush()
    }
    steps {
        shell("npm i ")
        shell("npm run build")
        shell("cp -r build/* /var/www/sparefant.no/html")
    }
    publishers {
        githubCommitNotifier()
        wsCleanup()
    }
}
