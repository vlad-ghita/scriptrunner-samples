package com.acme.upgrades

import com.acme.PluginConstants
import com.atlassian.jira.issue.context.GlobalIssueContext
import com.atlassian.sal.api.message.Message
import com.atlassian.sal.api.upgrade.PluginUpgradeTask
import com.onresolve.scriptrunner.runner.ScriptRunnerImpl
import com.onresolve.scriptrunner.test.ScriptFieldCreationInfo
import groovy.util.logging.Log4j

@Log4j
class UpgradeTask001 implements PluginUpgradeTask {

    UpgradeTask001() {
    }

    @Override
    int getBuildNumber() {
        return 6
    }

    @Override
    String getShortDescription() {
        "A sample upgrade task"
    }

    @Override
    Collection<Message> doUpgrade() throws Exception {
        // create managed script fields and behaviours etc.
        log.warn("upgrading 003")

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

    @Override
    String getPluginKey() {
        PluginConstants.PLUGIN_KEY
    }

    // for script console testing
    static void main(String[] args) {
        new UpgradeTask001().doUpgrade()
    }
}
