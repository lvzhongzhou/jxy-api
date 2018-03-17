package com.jxy.jxyapi.util;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * API标准输出结构
 * 支持分页模式输出
 */
public class BusinessResult extends BusinessResultBase {

    @Getter
    @Setter
    private Object bizContent;
    @Getter
    @Setter
    private long timeout;


    private JSONObject jsonObject = new JSONObject();

    public BusinessResult() {
        this.setCode(BusinessResultCode.SUCCESS);
        this.setMessage(BusinessResultCode.SUCCESS.msg());
        this.setBizContent(jsonObject);
    }

    public BusinessResult(BusinessResultCode code) {
        this.setCode(code);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(jsonObject);
    }

    public BusinessResult(BusinessResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(jsonObject);
    }

    public BusinessResult(BusinessResultCode code, Object data) {
        this.setCode(code);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(formatResultData(data, null));
    }

    public BusinessResult(BusinessResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(formatResultData(data, null));
    }

    public BusinessResult(BusinessResultCode code, Object data, Page page) {
        this.setCode(code);
        this.setBizContent(formatResultData(data, page));
    }

    public BusinessResult(BusinessResultCode code, Object data, Page page, String subCode) {
        this.setCode(code);
        this.setSubCode(subCode);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(formatResultData(data, page));
    }

    public BusinessResult(BusinessResultCode code, String message, Object data, Page page) {
        this.setCode(code);
        this.setMessage(message);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(formatResultData(data, page));
    }

    public BusinessResult(BusinessResultCode code, String message, Object data, Page page, String subCode) {
        this.setCode(code);
        this.setMessage(message);
        this.setSubCode(subCode);
        if (code.val() != BusinessResultCode.SUCCESS.val()) {
            this.messageList.put(code.subCode(), code.msg());
        }
        this.setBizContent(formatResultData(data, page));
    }


    /**
     * 格式化API标准输出结构
     *
     * @param data
     * @param page
     * @return
     */
    private Object formatResultData(Object data, Page page) {
        if (null != page) {
            jsonObject.put("totalCount", page.getTotal());
            jsonObject.put("totalPages", page.getPages());
            jsonObject.put("pageSize", page.getPageSize());
            jsonObject.put("currentPage", page.getPageNum());
        }
        if (data instanceof List) {
            jsonObject.put("resultCount", ((List) data).size());
            jsonObject.put("resultList", data);
        } else if (data instanceof Map) {
            for (Object key : ((Map) data).keySet()) {
                jsonObject.put(key.toString(), ((Map) data).get(key));
            }
        } else {
            return data;
        }
        return jsonObject;
    }

}