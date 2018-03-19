package controller;


import models.ErrorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";

    private boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().
            getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;

    @Autowired
    private ErrorAttributes errorAttributes;
    /**
     * Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
     * We just handle the response body
     * @param PATH
     */
    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        return new ErrorJson(response.getStatus(), getErrorAttributes(request, isDebug));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    /**
     * GetErrorAttributes while handling the execution mode for stacktraceValues
     * @param  request           Type: HttpServletRequest
     * @param  includeStackTrace Type: boolean
     * @return                   Type: Map<String, Object>
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
