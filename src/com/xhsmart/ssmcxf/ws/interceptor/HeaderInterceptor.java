package com.xhsmart.ssmcxf.ws.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;

/**
 * HeaderInterceptor
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 上午10:56:02
 */
public class HeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private String authId;
    private String authPwd;

    public HeaderInterceptor(String authId, String authPwd) {
        /** 指定该拦截器在发送SOAP之前起作用 */
        super(Phase.PREPARE_SEND);
        this.authId = authId;
        this.authPwd = authPwd;
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        /**
         * <header>
         <auth>
         <auth_id>test</auth_id>
         <auth_pwd>111111</auth_pwd>
         </auth>
         </header>
         */
        /** 创建文档 */
        Document doc = DOMUtils.createDocument();
        Element authEle = doc.createElement("auth");
        Element authId = doc.createElement("auth_id");
        authId.setTextContent(this.getAuthId());
        Element authPwd = doc.createElement("auth_pwd");
        authPwd.setTextContent(this.getAuthPwd());

        authEle.appendChild(authId);
        authEle.appendChild(authPwd);

        /** 创建Header头 */
        Header header = new Header(new QName("it"), authEle);
        /** 添加Header头 */
        soapMessage.getHeaders().add(header);
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthPwd() {
        return authPwd;
    }

    public void setAuthPwd(String authPwd) {
        this.authPwd = authPwd;
    }

}
