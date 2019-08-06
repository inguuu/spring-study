package com.example.study3.api;

import com.example.study3.model.Board;
import com.example.study3.model.DefaultRes;
import com.example.study3.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public ResponseEntity findAllBoards() {
        try {
            return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Board> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/board/{boardIdx}")
    public ResponseEntity findIdxBoard(@PathVariable int boardIdx) {
        try {
            return new ResponseEntity<>(boardService.findIdx(boardIdx), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Board> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/board")
    public ResponseEntity findAllBoards(@RequestBody Board board) {
        try {
            return new ResponseEntity<>(boardService.insert(board), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Board> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
