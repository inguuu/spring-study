package com.example.study3.service.impl;

import com.example.study3.model.Board;
import com.example.study3.model.DefaultRes;
import com.example.study3.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    private static List<Board> boardList = new ArrayList<>();

    @Override
    public DefaultRes<List<Board>> findAll() {
        if(boardList.isEmpty()){
            return  DefaultRes.res(HttpStatus.NO_CONTENT.value(),"유저 정보가 없습니다.");
        }else{
            return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", boardList);
        }
    }

    @Override
    public DefaultRes<Board> findIdx(int boardIdx) {
        log.info("idx: "+boardIdx);
        int i =0;
        for(i=0;i<boardList.size();i++) {
            if (boardList.get(i).getIdx() == boardIdx) {
                break;
            }
        }
        if(i<boardList.size()){
            return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", boardList.get(i));
        }else{
            return DefaultRes.res(HttpStatus.OK.value(), "인덱스와 맞는 유저가 없습니다.");
        }

    }

    @Override
    public DefaultRes insert(Board board) {
        Board newBoard = new Board(board.getIdx(),board.getTitle(),board.getContent());
        boardList.add(newBoard);
        
        return DefaultRes.res(HttpStatus.OK.value(), "등록 성공");
    }
}
