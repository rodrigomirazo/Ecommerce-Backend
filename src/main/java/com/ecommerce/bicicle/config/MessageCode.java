package com.ecommerce.bicicle.config;

public interface MessageCode {

    String APPLICATION_HOME = "application.name";
    String REQUEST_SUCCESS = "application.successfully";

    String USER_ID_NOTFOUND = "user.idNotFound";
    String USER_LIST_NOTFOUND = "user.listNotFound";

    String BOOK_ID_NOTFOUND = "book.idNotFound";
    String BOOK_LIST_NOTFOUND = "book.listNotFound";

    String NOTFOUND_ERROR = "exception.notFound";
    String UNEXPECTED_ERROR = "exception.unexpected";
    String PARAMETER_NULL_ERROR = "exception.nullParameter";

}
