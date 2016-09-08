package com.acme.rest

import com.onresolve.scriptrunner.runner.rest.common.CustomEndpointDelegate
import groovy.json.JsonBuilder
import groovy.transform.BaseScript

import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.core.Response

@BaseScript CustomEndpointDelegate delegate

xxPickRemoteIssue() { MultivaluedMap queryParams ->

    return Response.ok(new JsonBuilder([aaa: 31]).toString()).build()
}
