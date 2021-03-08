package quizweb.domain.instruct.valueobject.base;

import java.util.HashMap;
import java.util.Map;

import quizweb.common.enums.HttpRequestMethodEnum;

public abstract class RequestObject {
    protected String url;

    protected HttpRequestMethodEnum httpMethod;

    protected Map<String, String> param = new HashMap<>();

}
