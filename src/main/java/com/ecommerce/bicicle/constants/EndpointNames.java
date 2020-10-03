package com.ecommerce.bicicle.constants;

public class EndpointNames {

    public EndpointNames() { }

    public static final String ITEM_CATEGORY_CONTROLLER = "/itemCat";
    public static final String ITEM_FLOATING_CHARS_CONTROLLER = "/itemFloatingChars";
    public static final String ITEM_FLOATING_CHARS_CAT_CONTROLLER = "/itemFloatingCharsCat";

    public static final String ITEM_COLOR_CAT_CONTROLLER = "/itemColorCat";
    public static final String ITEM_COMMENTS_CONTROLLER = "/itemComments";
    public static final String ITEM_IMG_URLS_CONTROLLER = "/itemImgUrl";
    public static final String ITEM_CONTROLLER = "/item";
    public static final String ITEM_TRANSACTION_HISTORY_CONTROLLER = "/itemTransactionHistory";
    public static final String ITEM_TRANSACTION_CONTROLLER = "/itemTransaction";
    public static final String ITEM_TYPE_CAT_CONTROLLER = "/itemTypeCat";
    public static final String USER_ADDRESS_CONTROLLER = "/userAddress";
    public static final String USER_BALANCE_HISTORY_CONTROLLER = "/userBalanceHistory";
    public static final String USER_RATE_HISTORY_CONTROLLER = "/userRateHistory";
    public static final String USER_CONTROLLER = "/user";


    public static final String URI = "/ecommerce/bicicle/api/v1";

    /** API INFO **/
    public static final String API_VERSION = "0.0.1";
    public static final String API_LICENSE = "Apache License Version 2.0";
    public static final String API_LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0\"";
    public static final String API_CONTAC = "Bicicle Item";
    public static final String API_CONTAC_URL_ORG = "https://www.alaMode.com";
    public static final String API_CONTAC_URL_MAIL = "alamode@alamode.com";
    public static final String API_TITLE = "Item api for Ecommerce";
    public static final String API_DSC = "\"Item manage appi\"";

    /** SWAGGER DOCUMENTATION **/
    public static final String SWAGGER_PACKAGE_CONTROLLERS =  "com.ecommerce.bicicle";
    public static final String SWAGGER_OP_PAGE =  "swagger-ui.html";
    public static final String SWAGGER_OP_JARS =  "/webjars/**";
    public static final String SWAGGER_OP_RESOURCES =  "classpath:/META-INF/resources/";
    public static final String SWAGGER_OP_RESOURCES_WEB =  "classpath:/META-INF/resources/webjars/";
    public static final String SWAGGER_MSG_200 =  "Suceess|OK";
    public static final String SWAGGER_MSG_401 =  "not authorized!";
    public static final String SWAGGER_MSG_403 =  "Accessed forbidden";
    public static final String SWAGGER_MSG_404 =  "Request not found";
}
