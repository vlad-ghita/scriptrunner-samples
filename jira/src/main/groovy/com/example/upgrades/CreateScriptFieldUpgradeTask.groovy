package com.example.upgrades

import com.atlassian.jira.issue.context.GlobalIssueContext
import com.atlassian.sal.api.message.Message
import com.atlassian.sal.api.upgrade.PluginUpgradeTask
import com.onresolve.scriptrunner.runner.ScriptRunnerImpl
import com.onresolve.scriptrunner.test.ScriptFieldCreationInfo
import groovy.util.logging.Log4j

@Log4j
class CreateScriptFieldUpgradeTask extends AbstractUpgradeTask implements PluginUpgradeTask {

    @Override
    int getBuildNumber() {
        return 1
    }

    @Override
    String getShortDescription() {
        "This upgrade task creates a scripted field"
    }

    @Override
    Collection<Message> doUpgrade() throws Exception {
        // create managed script fields, behaviours, and anything else not covered by the YAML file
        log.warn("upgrading with build number $buildNumber")

        def scriptFieldCreation = ScriptFieldCreationInfo.Builder.newBuilder()
            .setName("TestScriptFieldSimpleNumberX")
            .setSearcherKey(ScriptRunnerImpl.PLUGIN_KEY + ":exactnumber")
            .setTemplate("float")
            .setContexts([GlobalIssueContext.instance])
            .setScript('return 10 as Double')
            .build()

        scriptFieldCreation.create()

        return null
    }

    /*
     This method isn't necessary, but is handy for testing the upgrade task via the Script Console,
     so you don't have to restart your local Jira instance to test it out.
    */
    static void main(String[] args) {
        new CreateScriptFieldUpgradeTask().doUpgrade()
    }
}
