pipeline {
    agent any
    options {
     //   gitLabConnection('rndgitlab-connection')
        //calling gitlabCommitStatus makes jenkins to report even failed builds as success to GitLab
        //gitlabCommitStatus(name: 'master-build')
        disableConcurrentBuilds()
    }
    triggers {
        githubPush()
    }
    stages {
        stage ('ds-initial-build') {
            steps {
                checkout ([
                    $class: 'GitSCM',
                    branches:[[name: 'origin/master']],
                    browser: [
                        $class: 'GithubWeb',
                        repoUrl: 'https://github.com/knadikari/JenkinsTest',
                        version: '10.82'
                    ],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [
                        [$class: 'CleanBeforeCheckout']
                    ],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        name: 'origin',
                        url: 'https://github.com/knadikari/JenkinsTest.git'
                    ]]
                ])
                script {
                    sh "mvn clean install"
                }
            }
        }
        //parallel {
        //    stage ('ds-deploy-staging') {

        //    }
        //    stage ('ds-docs-publish-staging-app10') {

         //   } 
        //}
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archive '**/*.jtl'
        }
        success {
            emailext ([
                attachLog: true,
                body: '${JELLY_SCRIPT,template="html"}',
                subject: '[NB82] $PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!',
                to: 'kushan.adikari@ifsworld.com'
        ])
        }
        // failure {
        //     emailext ([
        //         attachLog: true,
        //         body: '$DEFAULT_CONTENT',
        //         subject: '$Default_Subject',
        //         to: 'kushan.adikari@ifsworld.com'
        //     ])
        // }
        // unstable {
        //     script {
        //         currentBuild.result = 'UNSTABLE'
        //     }
        //     emailext ([
        //         attachLog: true,
        //         body: '$DEFAULT_CONTENT',
        //         subject: '$Default_Subject',
        //         to: 'kushan.adikari@ifsworld.com'
        // ])
        // }
    }
}
