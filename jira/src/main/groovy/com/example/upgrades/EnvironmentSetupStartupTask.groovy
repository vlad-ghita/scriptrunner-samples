package com.example.upgrades

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.config.properties.APKeys
import com.atlassian.sal.api.message.Message
import com.atlassian.sal.api.upgrade.PluginUpgradeTask
import groovy.util.logging.Log4j
import org.apache.log4j.Level
import org.apache.log4j.Logger

@Log4j
class EnvironmentSetupStartupTask extends AbstractUpgradeTask implements PluginUpgradeTask {

    @Override
    int getBuildNumber() {
        return 1
    }

    @Override
    String getShortDescription() {
        "Make sure that the base URL configuration matches the JVM System Property"
    }

    @Override
    Collection<Message> doUpgrade() throws Exception {
        //Set logging levels to debug
        ["com.onresolve", "com.example"].each{
            Logger.getLogger(it).setLevel(Level.DEBUG)
        }

        //Set base URL
        def applicationProperties = ComponentAccessor.applicationProperties
        log.debug "Trying to update base URL with $buildNumber"
        def configuredUrl = applicationProperties.getString(APKeys.JIRA_BASEURL)
        log.debug "Application property base URL: $configuredUrl"
        String propertyBaseUrl = System.getProperty("baseurl")
        log.debug "System property base URL: $propertyBaseUrl"
        if (propertyBaseUrl && propertyBaseUrl != configuredUrl) {
            log.debug "Resetting base URL to correct value"
            applicationProperties.setString(APKeys.JIRA_BASEURL, propertyBaseUrl)
        }
        return null
    }
}