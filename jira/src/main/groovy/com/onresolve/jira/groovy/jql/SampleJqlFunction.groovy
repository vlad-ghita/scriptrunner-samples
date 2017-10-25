package com.onresolve.jira.groovy.jql

import com.atlassian.jira.jql.query.QueryCreationContext
import com.atlassian.query.clause.TerminalClause
import com.atlassian.query.operand.FunctionOperand
import groovy.util.logging.Log4j
import org.apache.lucene.search.MatchAllDocsQuery
import org.apache.lucene.search.Query

@Log4j
class SampleJqlFunction extends AbstractScriptedJqlFunction implements JqlQueryFunction {

    @Override
    Query getQuery(QueryCreationContext queryCreationContext, FunctionOperand operand, TerminalClause terminalClause) {
        new MatchAllDocsQuery()
    }

    @Override
    String getDescription() {
        "Just a sample function"
    }

    @Override
    List<Map> getArguments() {
        []
    }

    @Override
    String getFunctionName() {
        "sampleFunction"
    }
}
