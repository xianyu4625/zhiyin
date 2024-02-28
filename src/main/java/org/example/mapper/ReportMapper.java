package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Report;
import org.example.pojo.ReportView;

import java.util.List;

@Mapper
public interface ReportMapper {

    @Insert("insert into report(userid,reportcontent,timestamp) values (#{userid},#{reportcontent},now())")
    void addreport(Report report);
    @Delete("update report set deleted=1 where reportid=#{reportid}")
    void deletereport(Report report);
    @Update("update report set `show`=#{show} where reportid=#{reportid}")
    void show(Report report);

//    List<ReportView> selected(String nickname, String contents);

    List<ReportView> selectReport(String nickname, String contents);

    List<ReportView> selectselfReport(String nickname, String contents, Integer userid);
}
