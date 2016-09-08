package com.acme.jira.actions

import com.atlassian.jira.project.ProjectManager
import com.atlassian.jira.security.PermissionManager
import com.atlassian.jira.web.action.ProjectActionSupport
import org.apache.log4j.Logger
import webwork.action.PrepareAction

class SampleAction extends ProjectActionSupport implements PrepareAction {

    protected final Logger log = Logger.getLogger(this.getClass());

    SampleAction(ProjectManager projectManager, PermissionManager permissionManager) {
        super(projectManager, permissionManager)
    }

    @Override
    String doDefault() throws Exception {
        return super.doDefault()
    }

    @Override
    void prepare() throws Exception {
        log.warn("i am ready")
    }
}
