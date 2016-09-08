package com.acme.actions

import groovy.util.logging.Log4j

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Log4j
class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType "text/html;charset=UTF-8"
        resp.writer.write("Hello sailor")
        resp.status = 200
    }
}
