package com.springactiviti.service.impl;

import com.springactiviti.service.HisService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.history.HistoricActivityInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述 :
 *
 * @author wangyf
 * @create 2018/11/04
 */
@Service
public class HistoryServiceImpl implements HisService {
    @Autowired
    ProcessEngine processEngine;
    @Override
    public void getHistoryTask() {
        List<HistoricActivityInstance> list = processEngine.getHistoryService()
                .createHistoricActivityInstanceQuery()
                .taskAssignee("申请人申请")
                .finished()
                .list();
        for (HistoricActivityInstance taskInstance:list) {
            System.out.println("任务ID：" + taskInstance.getId());
            System.out.println("流程实例ID：" + taskInstance.getProcessInstanceId());
            System.out.println("创建时间：" + taskInstance.getStartTime());
            System.out.println("结束时间：" + taskInstance.getEndTime());
            System.out.println("任务ID：" + taskInstance.getTaskId());
        }
    }

}
