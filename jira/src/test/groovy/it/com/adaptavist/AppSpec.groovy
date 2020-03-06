package it.com.adaptavist

import com.example.App
import com.onresolve.scriptrunner.canned.common.admin.ScriptRunnerTestRunner
import org.junit.runner.RunWith
import spock.lang.Shared
import spock.lang.Specification

@RunWith(ScriptRunnerTestRunner)
class AppSpec extends Specification {

    @Shared App app

    // ********** Setup **********

    def setupSpec() {
        app = new App()
        app.boot()
    }

    // ********** Tests **********

    def "Sanity check."() {
        given:
        app.logger.info("Spec loaded.")
//        app.logger.info("Hello spec.")
    }

}
