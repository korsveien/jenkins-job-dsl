job('sparefant-fe-master') {
    scm {
        github(ownerAndProject = 'pederpus/sparefant-fe', branch = 'master',  protocol = 'git')
    }
    triggers {
        githubPush()
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('registry.heroku.com/sparefant-fe')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            forcePull(true)
            skipDecorate()
        }
    }
    publishers {
        githubCommitNotifier()
        wsCleanup()
    }
}