package com.springactiviti.controller;

import com.springactiviti.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述 : 流程控制
 *
 * @autor wangyf
 * @create 2018/10/25
 */
@RestController
@RequestMapping("/process")
public class ProcessController {

    ProcessService processService;

    /**
     * 启动流程
     * @param applyId
     * @param dataId
     * @param type
     * @return
     */
    @RequestMapping("/startProcess")
    public ModelAndView startProcess(String applyId,String dataId,String type) {
        ModelAndView model = new ModelAndView();
        Map map = new HashMap();
        map.put("applyId",applyId);
        map.put("dataId",dataId);
        map.put("type",type);
        Map process = processService.startProcess(map);
        model.setViewName("frist");
        return model;
    }
    @RequestMapping("/executeProcess")
    public ModelAndView executeProcess(String taskId,String dataId,String type) {
        Map map = new HashMap();
        map.put("taskId",taskId);
        map.put("dataId",dataId);
        map.put("type",type);
        Map process = processService.executeProcess(map);
        return new ModelAndView("frist");
    }

}
