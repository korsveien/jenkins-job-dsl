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
        dockerBuildAndPublish {
            dockerRegistryURL('registry.heroku.com')
            repositoryName('sparefant/sparefant-fe')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    publishers {
        githubCommitNotifier()
    }
}