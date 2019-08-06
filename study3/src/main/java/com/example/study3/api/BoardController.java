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


//
//    private static List<Board> boardList = new ArrayList<>();
//
//    @RequestMapping(method = RequestMethod.POST, value = "/board")
//    public ResponseEntity postBoard(@RequestBody Board board) {
//        Board board1 = new Board(board.getIdx(),board.getTitle(),board.getContent());
//        boardList.add(board1);
//
//        DefaultRes defaultRes = new DefaultRes<>(HttpStatus.OK,"등록성공");
//        return new ResponseEntity<>(defaultRes,HttpStatus.OK);
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET, value = "/board")
//    public ResponseEntity getAllBoard() {
//        if(boardList.isEmpty()){
//            DefaultRes defaultRes = new DefaultRes<>(HttpStatus.NO_CONTENT,"유저 정보가 없습니다.");
//            return new ResponseEntity<>(defaultRes,HttpStatus.OK);//여기는 무조건 StatusCode OK로
//        }else{
//            DefaultRes<List<Board>> defaultRes = new DefaultRes<List<Board>>(HttpStatus.OK.value(), "조회성공", boardList);
//            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
//        }
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET, value = "/board/{idx}")
//    public ResponseEntity getBoard(@PathVariable(value = "idx") int idx) {
//        log.info("idx: "+idx);
//        int i =0;
//        for(i=0;i<boardList.size();i++) {
//            if (boardList.get(i).getIdx() == idx) {
//                break;
//            }
//        }
//        if(i<boardList.size()){
//            DefaultRes<Board> defaultRes = new DefaultRes<Board>(HttpStatus.OK.value(), "조회성공", boardList.get(i));
//            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
//        }else{
//            DefaultRes defaultRes = new DefaultRes<>(HttpStatus.NO_CONTENT,"인덱스와 맞는 유저가 없습니다.");
//            return new ResponseEntity<>(defaultRes,HttpStatus.OK);//여기는 무조건 StatusCode OK로
//        }
//
//    }
}
