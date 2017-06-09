package com.xhsmart.ssmcxf.ws.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.List;

/**
 * AuthInterceptor
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 上午10:29:11
 */
public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    public AuthInterceptor() {
        /** 指定该拦截器调用操作之前起效 */
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        System.out.println("==handleMessage===");
        /**
         * <header>
         <auth>
         <auth_id>test</auth_id>
         <auth_pwd>111111</auth_pwd>
         </auth>
         </header>
         */
        /** 获取所有的 Header头*/
        List<Header> headers = soapMessage.getHeaders();
        if (headers == null || headers.size() != 1) {
            throw new Fault(new IllegalArgumentException("您没有携带Header头，不能访问！"));
        }
        /** 获取第一个Header头 */
        Header header = headers.get(0);
        /** 获取auth的这个元素 */
        Element authEle = (Element) header.getObject();
        /** 获取auth_id */
        NodeList idNode = authEle.getElementsByTagName("auth_id");
        /** 获取auth_pwd */
        NodeList pwdNode = authEle.getElementsByTagName("auth_pwd");
        if (idNode == null || idNode.getLength() != 1
                || pwdNode == null || pwdNode.getLength() != 1) {
            throw new Fault(new IllegalArgumentException("您携带Header头格式不正确，不能访问！"));
        }
        /** 获取内容 */
        String authId = idNode.item(0).getTextContent();
        String authPwd = pwdNode.item(0).getTextContent();
        if (!"test".equals(authId) || !"111111".equals(authPwd)) {
            throw new Fault(new IllegalArgumentException("鉴权失败，不能访问！"));
        }
    }
}