job('sparefant-fe-master') {
    wrappers {
        nodejs('NodeJS 1.2.4')
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
