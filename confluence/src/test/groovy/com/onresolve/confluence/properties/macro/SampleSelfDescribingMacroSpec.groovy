package com.onresolve.confluence.properties.macro

import com.atlassian.confluence.content.render.xhtml.ConversionContext
import com.atlassian.confluence.content.render.xhtml.DefaultConversionContext
import com.atlassian.confluence.xhtml.api.MacroDefinition
import com.atlassian.confluence.xhtml.api.XhtmlContent
import com.atlassian.sal.api.component.ComponentLocator
import com.onresolve.scriptrunner.canned.common.admin.SrSpecification
import com.onresolve.scriptrunner.canned.confluence.macros.SampleSelfDescribingMacro
import com.onresolve.scriptrunner.confluence.macro.ScriptMacroManager
import com.onresolve.scriptrunner.runner.ScriptRunnerImpl
import groovy.util.logging.Log4j
import spock.lang.Shared

@Log4j
class SampleSelfDescribingMacroSpec extends SrSpecification {

    @Shared
    ConversionContext conversionContext = new DefaultConversionContext(null)

    @Shared
    ScriptMacroManager scriptMacroManager = ScriptRunnerImpl.getPluginComponent(ScriptMacroManager)

    @Shared
    def xhtmlContent = ComponentLocator.getComponent(XhtmlContent)

    def setup() {
        scriptMacroManager.refreshThisNode()
    }

    def "some test"() {
        setup:

        def macroDefinition = new MacroDefinition(SampleSelfDescribingMacro.MACRO_KEY, null, null, [:])

        when:
        def html = xhtmlContent.convertMacroDefinitionToView(macroDefinition, conversionContext)

        then:
        html.contains("Sample self describing")
    }
}
