package com.example.study2.api;

import com.example.study2.model.Board;
import com.example.study2.model.DefaultRes;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class BoardController {

    // Node처럼 model을 거치지 않고 바로 데이터 받는법
    @RequestMapping(method = RequestMethod.POST, value = "/board")
    public Object board(@RequestBody Object a,int idx,String title,String content) {
        Board board1 = new Board(idx,title,content);
        log.info(board1.getTitle().toString());
        return board1;
    }

    // MVC
    @RequestMapping(method = RequestMethod.POST, value = "/board1")
    public Object board1(@RequestBody Board board) {
        Board board1 = new Board(board.getIdx(),board.getTitle(),board.getContent());
        log.info(board1.toString());
        return board1;
    }

    //응답상태,메세지
    @RequestMapping(method = RequestMethod.GET, value = "/board")
    public ResponseEntity board() {
        Board board1 = new Board(1,"2","3");
        DefaultRes defaultRes = new DefaultRes(HttpStatus.OK,"성공");
        return new ResponseEntity<>(defaultRes,HttpStatus.OK);
    }

    //응답상태,메세지,데이터
    @RequestMapping(method = RequestMethod.GET, value = "/board1")
    public ResponseEntity board1() {
        Board board1 = new Board(1,"2","3");
        DefaultRes<Board> defaultRes = new DefaultRes<Board>(HttpStatus.OK.value(),"조회성공",board1);
        return new ResponseEntity<>(defaultRes,HttpStatus.OK);
    }

    //================== board 예제 ====================


    private static List<Board> boardList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST, value = "test/board")
    public ResponseEntity postBoard(@RequestBody Board board) {
        Board board1 = new Board(board.getIdx(),board.getTitle(),board.getContent());
        boardList.add(board1);

        DefaultRes defaultRes = new DefaultRes<>(HttpStatus.OK,"등록성공");
        return new ResponseEntity<>(defaultRes,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "test/board")
    public ResponseEntity getAllBoard() {
        if(boardList.isEmpty()){
            DefaultRes defaultRes = new DefaultRes<>(HttpStatus.NO_CONTENT,"유저 정보가 없습니다.");
            return new ResponseEntity<>(defaultRes,HttpStatus.OK);//여기는 무조건 StatusCode OK로
        }else{
            DefaultRes<List<Board>> defaultRes = new DefaultRes<List<Board>>(HttpStatus.OK.value(), "조회성공", boardList);
            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "test/board/{idx}")
    public ResponseEntity getBoard(@PathVariable(value = "idx") int idx) {
        log.info("idx: "+idx);
        int i =0;
        for(i=0;i<boardList.size();i++) {
            if (boardList.get(i).getIdx() == idx) {
                break;
            }
        }
        if(i<boardList.size()){
            DefaultRes<Board> defaultRes = new DefaultRes<Board>(HttpStatus.OK.value(), "조회성공", boardList.get(i));
            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        }else{
            DefaultRes defaultRes = new DefaultRes<>(HttpStatus.NO_CONTENT,"인덱스와 맞는 유저가 없습니다.");
            return new ResponseEntity<>(defaultRes,HttpStatus.OK);//여기는 무조건 StatusCode OK로
        }

    }
}
