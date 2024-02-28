package org.example.service;

import org.example.pojo.PageBean;
import org.example.pojo.Report;
import org.example.pojo.ReportView;

public interface ReportService {
    void addreport(Report report);

    void deletereport(Report report);

    void show(Report report);

//    PageBean<ReportView> selectreport(Integer pageNum, Integer pageSize, String nickname, String contents);

    PageBean<ReportView> selectReport(Integer pageNum, Integer pageSize, String nickname, String contents);

    PageBean<ReportView> selectselfReport(Integer pageNum, Integer pageSize, String nickname, String contents);
}
