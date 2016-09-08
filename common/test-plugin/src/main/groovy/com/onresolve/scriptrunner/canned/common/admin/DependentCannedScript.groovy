package com.onresolve.scriptrunner.canned.common.admin

import com.onresolve.scriptrunner.canned.CannedScript
import com.onresolve.scriptrunner.canned.util.BuiltinScriptErrors

/**
 * A sample built-in script - no additional configuration is required in the yaml file
 */
class DependentCannedScript implements CannedScript {
    @Override
    String getName() {
        "Sample built-in script"
    }

    @Override
    String getDescription() {
        "An example from the Sample scripts plugin"
    }

    @Override
    List getCategories() {
        return null
    }

    @Override
    List getParameters(Map map) {
        return null
    }

    @Override
    BuiltinScriptErrors doValidate(Map<String, String> stringStringMap, boolean b) {
        return null
    }

    @Override
    Map doScript(Map<String, Object> stringObjectMap) {
        return null
    }

    @Override
    String getDescription(Map<String, String> stringStringMap, boolean b) {
        return null
    }

    @Override
    Boolean isFinalParamsPage(Map map) {
        true
    }
}
