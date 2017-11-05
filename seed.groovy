job('sparefant-fe-master') {
    wrappers {
        preBuildCleanup()
    }
    scm {
        github(ownerAndProject = 'pederpus/sparefant-fe', branch = 'master',  protocol = 'git')
    }
    triggers {
        githubPush()
    }
    steps {
        shell('npm i')
        shell('npm run build')
    }
    publishers {
        githubCommitNotifier()
    }
}