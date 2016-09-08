package com.onresolve.scriptrunner.canned.confluence.macros

import com.acme.PluginConstants
import com.atlassian.confluence.content.render.xhtml.ConversionContext
import com.atlassian.confluence.macro.Macro
import com.atlassian.confluence.macro.MacroExecutionException
import com.atlassian.confluence.macro.browser.beans.MacroCategory
import com.atlassian.confluence.macro.browser.beans.MacroFormDetails
import com.atlassian.confluence.macro.browser.beans.MacroMetadata
import com.atlassian.confluence.macro.browser.beans.MacroMetadataBuilder
import com.onresolve.scriptrunner.confluence.macro.SelfDescribingScriptMacro

/**
 * Self-describing macros don't need any configuration in Admin -> Script Macros, as they provide that information
 *
 * NOTE: They DO though need to be in this package, or a sub-package
 */
class SampleSelfDescribingMacro implements SelfDescribingScriptMacro {

    public static final String MACRO_KEY = "sr-self-describing-macro"

    @Override
    MacroMetadata getMacroMetadata() {

        def macroMetadataBuilder = new MacroMetadataBuilder().
            setPluginKey(PluginConstants.PLUGIN_KEY).
            setMacroName(MACRO_KEY).
            setTitle("Sample self describing ScriptRunner macro").
            setFormDetails(MacroFormDetails.makeParameterFormDetails(MACRO_KEY, null, false, [])).
            setDescription("blah blah").
            setCategories([MacroCategory.CONFLUENCE_CONTENT.name] as Set)

        macroMetadataBuilder.build()
    }

    @Override
    boolean registerByDefault() {
        return true
    }

    @Override
    String execute(Map<String, String> parameters, String body, ConversionContext context) throws MacroExecutionException {
        "Sample self describing ScriptRunner macro output"
    }

    @Override
    Macro.BodyType getBodyType() {
        Macro.BodyType.NONE
    }

    @Override
    Macro.OutputType getOutputType() {
        Macro.OutputType.BLOCK
    }
}
