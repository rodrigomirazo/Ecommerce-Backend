package com.ecommerce.bicicle.constants;

public class TransactionStatus {

    public TransactionStatus() { }
    /**
     *
     */
    public static final String TRANSACT_STATUS_BEFORE_TRANSACTION = "BEFORE_TRANSACTION";
    public static final String TRANSACT_STATUS_AFTER_TRANSACTION_SUCCESS = "AFTER_TRANSACTION_SUCCESS";
    public static final String TRANSACT_STATUS_AFTER_TRANSACTION_FAILED = "AFTER_TRANSACTION_FAILED";
    public static final String TRANSACT_STATUS_USER_VENDOR_NOTIFIED = "USER_VENDOR_NOTIFIED";
    public static final String TRANSACT_STATUS_USER_SALER_NOTIFIED = "USER_SALER_NOTIFIED";
    public static final String TRANSACT_STATUS_USER_ADMINISTRATORS_NOTIFIED = "USER_ADMINISTRATORS_NOTIFIED";


    public static final String TRANSACT_STATUS_USER_VENDOR_INCLUSE_TRACK_ID = "USER_VENDOR_INCLUSE_TRACK_ID";
}
