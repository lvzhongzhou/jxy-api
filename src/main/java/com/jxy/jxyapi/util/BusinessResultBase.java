package com.jxy.jxyapi.util;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * API标准输出结构
 * 支持分页模式输出
 */
public class BusinessResultBase implements IBusinessResult {

    @Getter
    private int code;
    @Setter
    @Getter
    private String subCode;
    @Getter
    @Setter
    private Object message;
    @Setter
    @Getter
    public HashMap<String, String> messageList = Maps.newHashMap();
    @Setter
    private long timeout;

    public BusinessResultBase() {

    }

    public BusinessResultBase(BusinessResultCode code) {
        this.setCode(code);
    }

    public BusinessResultBase(BusinessResultCode code, HashMap<String, String> errors) {
        this.setCode(code);
        this.setMessageList(errors);
        if (errors != null && !errors.isEmpty()) {
            Iterator iter = errors.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                this.setMessage(entry.getValue());
                break;
            }
        }
    }

    public BusinessResultBase(BusinessResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);

        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(subCode, message);
        }
    }

    public BusinessResultBase(BusinessResultCode code, String message, String subCode) {
        this.setCode(code);
        this.setMessage(message);
        this.setSubCode(subCode);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(subCode, message);
        }
    }

    public void setCode(BusinessResultCode code) {
        this.code = code.val();
        this.setMessage(code.msg());
        this.subCode = code.subCode();
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(subCode, code.msg());
        }
    }
}