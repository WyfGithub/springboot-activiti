package com.springactiviti.service.impl;

import com.springactiviti.service.ProcessService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 描述 :
 *
 * @autor wangyf
 * @create 2018/10/25
 */
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessInstance processInstance;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    RepositoryService repositoryService;


    @Override
    public Map startProcess(Map map) {
        Task task;
        Map process = new HashMap();
        repositoryService.createDeployment().addClasspathResource("processes/ExclusiveProcess.bpmn").deploy();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess_Exclusive",map);
        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        process.put("taskId",pi.getId());
        System.out.println("当前节点为："+task.getName());
        taskService.complete(task.getId(),map);
        return process;
    }

    @Override
    public Map executeProcess(Map map) {
        Task task;
        Map process = new HashMap();
        task = taskService.createTaskQuery().processInstanceId(map.get("taskId").toString()).singleResult();

        taskService.complete(task.getId(),map);
        return process;
    }


}
