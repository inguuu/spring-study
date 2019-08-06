package com.example.study3.service;

import com.example.study3.model.Board;
import com.example.study3.model.DefaultRes;

import java.util.*;

public interface BoardService {

    DefaultRes<List<Board>> findAll();

    DefaultRes<Board> findIdx(int boardIdx);

    DefaultRes insert(Board board);

}
