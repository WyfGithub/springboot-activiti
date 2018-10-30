package com.springactiviti.service;

import java.util.Map;

public interface ProcessService {
    Map startProcess(Map map);

    Map executeProcess(Map map);
}
