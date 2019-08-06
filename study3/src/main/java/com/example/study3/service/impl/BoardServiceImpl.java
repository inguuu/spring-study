package com.example.study3.service.impl;

import com.example.study3.model.Board;
import com.example.study3.model.DefaultRes;
import com.example.study3.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private static List<Board> boardList = new ArrayList<>();

    @Override
    public DefaultRes<List<Board>> findAll() {
        if(boardList.isEmpty()){
            return  DefaultRes.res(HttpStatus.NO_CONTENT.value(),"유저 정보가 없습니다.");
        }else{
            return DefaultRes.res(HttpStatus.OK.value(), "조회성공", boardList);
        }
    }

    @Override
    public DefaultRes<Board> findIdx(int boardIdx) {
        return null;
    }

    @Override
    public DefaultRes insert(Board board) {
        return null;
    }
}
