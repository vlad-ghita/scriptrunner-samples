package com.example.upgrades

import com.atlassian.bitbucket.server.ApplicationPropertiesService
import com.atlassian.bitbucket.user.SecurityService
import com.atlassian.bitbucket.user.UserService
import com.atlassian.bitbucket.util.Operation
import com.atlassian.plugin.osgi.util.OsgiHeaderUtil
import com.atlassian.sal.api.upgrade.PluginUpgradeTask
import groovy.util.logging.Log4j
import org.osgi.framework.Bundle
import org.osgi.framework.FrameworkUtil
import org.slf4j.LoggerFactory
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.Level

@Log4j
class EnvironmentSetupStartupTask implements PluginUpgradeTask {
    ApplicationPropertiesService applicationPropertiesService
    UserService userService
    SecurityService securityService

    EnvironmentSetupStartupTask(ApplicationPropertiesService applicationPropertiesService,
                                UserService userService, SecurityService securityService ) {
        this.applicationPropertiesService = applicationPropertiesService
        this.userService = userService
        this.securityService = securityService
    }

    @Override
    int getBuildNumber() {
        return 1
    }

    @Override
    String getShortDescription() {
        "Make sure that the base URL configuration matches the JVM System Property and that logging level is set to DEBUG"
    }

    @Override
    String getPluginKey() {
        Bundle bundle = FrameworkUtil.getBundle(EnvironmentSetupStartupTask)
        OsgiHeaderUtil.getPluginKey(bundle)
    }

    Collection doUpgrade() {
        //Set logging levels to DEBUG
        ["com.onresolve", "com.example"].each{
            def logger = (Logger) LoggerFactory.getLogger(it)
            logger.setLevel(Level.DEBUG)
        }

        //Set base URL
        def user = userService.getUserByName('admin')
        if (!user) {
            log.warn("User name: admin doesn't exist ")
            return [:]
        }

        securityService.impersonating(user, "Running script job as $user.slug").call(new Operation() {
            @Override
            Object perform() throws Throwable {
                def configuredUrl = applicationPropertiesService.baseUrl
                String propertyBaseUrl = System.getProperty("baseurl")
                def parsedProperty = new URI(propertyBaseUrl)
                if (parsedProperty != configuredUrl) {
                    applicationPropertiesService.baseURL = parsedProperty
                }
            }
        })
        return null
    }
}
