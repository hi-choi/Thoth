package thoth.spring.project.dao;

import thoth.spring.project.vo.Notice;

import java.util.List;

public interface NoticeDAO {

    List<Notice> selectBoard(int snum);

}
