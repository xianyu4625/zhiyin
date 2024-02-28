package org.example.service;

import org.example.pojo.PageBean;
import org.example.pojo.Switch;
import org.example.pojo.SwitchView;

public interface SwitchService {
    void add(Switch switchs);

    void delete(Switch switchs);

    PageBean<SwitchView> list(Integer pageNum, Integer pageSize, String username, String goodname);

    PageBean<SwitchView> alllist(Integer pageNum, Integer pageSize, String username, String goodname);
}
