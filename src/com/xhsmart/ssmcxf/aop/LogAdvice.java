package com.xhsmart.ssmcxf.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志切面类
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2015-12-10 上午9:19:52
 */
public class LogAdvice {
    /**
     * 定义日志对象
     */
    private Logger logger = Logger.getLogger(LogAdvice.class);

    /**
     * 在业务层方法、前后织入
     */
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        logger.info("开始调用[" + pj.getSignature().getName() + "]方法！");
        /** 记录开始调用的时间毫秒数 */
        long beginMillSeconds = System.currentTimeMillis();

        /** 调用目标方法 */
        Object res = pj.proceed(pj.getArgs());
        logger.info("结束调用[" + pj.getSignature().getName() + "]方法，它的返回值为：" + res);
        /** 记录结束调用的时间毫秒数 */
        long endMillSeconds = System.currentTimeMillis();
        logger.info("调用[" + pj.getSignature().getName() + "]该方法，一共花费了[" + (endMillSeconds - beginMillSeconds) + "]毫秒！");
        return res;
    }

    /**
     * 记录业务层方法的异常信息
     */
    public void error(JoinPoint jp, Throwable ex) {
        logger.error("调用[" + jp.getSignature().getName() + "]方法，出现了异常!");
        logger.error(ex.getMessage(), ex);
    }
}
