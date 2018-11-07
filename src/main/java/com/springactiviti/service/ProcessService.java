package com.springactiviti.service;

import java.util.Map;

/**
 * @author wangyf
 * @date
 *
 */
public interface ProcessService {
    /**
     * 描述：启动流程，返回Map
     * @param map
     * @return
     */
    Map startProcess(Map map);

    /**
     * 执行流程
     * @param map
     * @return
     */
    Map executeProcess(Map map);
}
