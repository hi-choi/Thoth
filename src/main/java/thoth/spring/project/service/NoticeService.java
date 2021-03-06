package thoth.spring.project.service;

import thoth.spring.project.vo.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> readBoard(String cp);

    Notice readOneBoard(String bdno);

    boolean newBoard(Notice bd);

    boolean updateBoard(Notice bd);

    boolean deleteBoard(Notice bdno);

    boolean viewCountBoard(String bdno);

    Notice nextBoard(String bdno);

    Notice backBoard(String bdno);

    int countBoard();

    List<Notice> readBoard(String cp, String ftype, String fkey);

    int countBoard(String ftype, String fkey);

    String readPrevpno(String bdno);

    String readNxtpno(String bdno);
}
