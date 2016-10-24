package org.thiki.kanban.board;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.thiki.kanban.foundation.common.Response;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xubitao on 05/26/16.
 */
@RestController
public class BoardsController {
    @Resource
    private BoardsService boardsService;

    @RequestMapping(value = BoardResource.URL, method = RequestMethod.GET)
    public HttpEntity findById(@PathVariable String boardId, @PathVariable String userName) throws Exception {
        Board board = boardsService.findById(boardId);
        return Response.build(new BoardResource(board, userName));
    }

    @RequestMapping(value = BoardResource.URL, method = RequestMethod.PUT)
    public HttpEntity update(@RequestBody Board board, @PathVariable String boardId, @PathVariable String userName) throws Exception {
        board.setId(boardId);
        Board updatedBoard = boardsService.update(userName, board);
        return Response.build(new BoardResource(updatedBoard, userName));

    }

    @RequestMapping(value = BoardResource.URL, method = RequestMethod.DELETE)
    public HttpEntity deleteById(@PathVariable String boardId, @PathVariable String userName) throws Exception {
        boardsService.deleteById(boardId);
        return Response.build(new BoardResource(userName));
    }

    @RequestMapping(value = "/{userName}/boards", method = RequestMethod.POST)
    public HttpEntity create(@RequestBody Board board, @PathVariable String userName) throws Exception {
        Board savedBoard = boardsService.create(userName, board);
        return Response.post(new BoardResource(savedBoard, userName));
    }

    @RequestMapping(value = "/{userName}/boards", method = RequestMethod.GET)
    public HttpEntity loadByUserName(@PathVariable String userName) throws Exception {
        List<Board> boards = boardsService.loadByUserName(userName);
        return Response.build(new BoardsResource(boards));
    }
}
