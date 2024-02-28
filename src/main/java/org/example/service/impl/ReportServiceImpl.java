package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.ReportMapper;
import org.example.pojo.PageBean;
import org.example.pojo.Report;
import org.example.pojo.ReportView;
import org.example.service.ReportService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Override
    public void addreport(Report report) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        report.setUserid(userid);
        reportMapper.addreport(report);
    }

    @Override
    public void deletereport(Report report) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        report.setUserid(userid);
        reportMapper.deletereport(report);
    }

    @Override
    public void show(Report report) {
        reportMapper.show(report);
    }

//    @Override
//    public PageBean<ReportView> selectreport(Integer pageNum, Integer pageSize, String nickname, String contents) {
//        PageBean<ReportView> pb=new PageBean<>();
//        PageHelper.startPage(pageNum,pageSize);
//        List<ReportView> reports=reportMapper.selected(nickname,contents);
//        PageInfo<ReportView> pageInfo=new PageInfo<>(reports);
//        pb.setTotal(pageInfo.getTotal());
//        pb.setItems(reports);
//        return pb;
//    }

    @Override
    public PageBean<ReportView> selectReport(Integer pageNum, Integer pageSize, String nickname, String contents) {
        PageBean<ReportView> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<ReportView> report=reportMapper.selectReport(nickname,contents);
        PageInfo<ReportView> pageInfo=new PageInfo<>(report);
        pb.setTotal(pageInfo.getTotal());
        pb.setItems(report);
        return pb;
    }

    @Override
    public PageBean<ReportView> selectselfReport(Integer pageNum, Integer pageSize, String nickname, String contents) {
        PageBean<ReportView> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        List<ReportView> report=reportMapper.selectselfReport(nickname,contents,userid);
        PageInfo<ReportView> pageInfo=new PageInfo<>(report);
        pb.setTotal(pageInfo.getTotal());
        pb.setItems(report);
        return pb;
    }
}
