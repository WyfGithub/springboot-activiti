package com.springactiviti.service.impl;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;


/**
 * 描述 :
 *
 * @author wangyf
 * @create 2018/11/01
 */
public class TaskLisenter implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("灭绝师太");
    }
}
