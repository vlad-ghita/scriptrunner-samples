package com.onresolve.scriptrunner.canned.jira.workflow

import com.onresolve.scriptrunner.canned.CannedScript
import com.onresolve.scriptrunner.canned.util.BuiltinScriptErrors
import com.onresolve.scriptrunner.canned.util.SimpleBuiltinScriptErrors
import com.onresolve.scriptrunner.runner.customisers.ScriptListener
import groovy.util.logging.Log4j

@ScriptListener
@Log4j
class SampleScriptListener implements CannedScript {

    public static String FIELD_MY_PARAM = "FIELD_MY_PARAM"

    @Override
    String getName() {
        "Sample listener"
    }

    @Override
    String getDescription() {
        "Sample listener from a plugin"
    }

    @Override
    List getCategories() {
        [] // unused
    }

    @Override
    List getParameters(Map params) {
        [
            [
                name       : FIELD_MY_PARAM,
                label      : "Some parameter",
                description: "Description of this parameter"
            ]
        ]
    }

    @Override
    BuiltinScriptErrors doValidate(Map<String, String> params, boolean forPreview) {
        def errors = new SimpleBuiltinScriptErrors()

        errors
    }

    @Override
    Map doScript(Map<String, Object> params) {
        log.warn("ScriptRunner listener: do something here")

        [:]
    }

    @Override
    String getDescription(Map<String, String> params, boolean forPreview) {
        "preview description"
    }

    @Override
    Boolean isFinalParamsPage(Map params) {
        true // unused
    }
}
