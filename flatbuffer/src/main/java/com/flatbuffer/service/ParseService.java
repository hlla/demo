package com.flatbuffer.service;

import com.flatbuffer.model.MMAConfig;

import java.io.InputStream;
import java.util.List;

public interface ParseService {
    /**
     * 对XML进行解析
     *
     * @param in 输入流
     * @return 集合
     */
    public List<MMAConfig> doParse(InputStream in);
}
