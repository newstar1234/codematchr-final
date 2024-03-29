package com.project.codematchr.controller;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.codematchr.dto.request.board.PatchBoardRequestDto;
import com.project.codematchr.dto.request.board.PostBoardRequestDto;
import com.project.codematchr.dto.request.board.PostcommentRequestDto;
import com.project.codematchr.dto.response.board.DeleteBoardResponseDto;
import com.project.codematchr.dto.response.board.DeleteCommentResponseDto;
import com.project.codematchr.dto.response.board.GetBoardListResponseDto;
import com.project.codematchr.dto.response.board.GetBoardResponseDto;
import com.project.codematchr.dto.response.board.GetCommentListResponseDto;
import com.project.codematchr.dto.response.board.GetFavoriteListResponseDto;
import com.project.codematchr.dto.response.board.GetSearchBoardResponseDto;
import com.project.codematchr.dto.response.board.GetTop3CommentListResponseDto;
import com.project.codematchr.dto.response.board.GetTop3CurrentListResponseDto;
import com.project.codematchr.dto.response.board.GetTop3FavoriteListResponseDto;
import com.project.codematchr.dto.response.board.GetTop3ViewListResponseDto;
import com.project.codematchr.dto.response.board.GetUserListResponseDto;
import com.project.codematchr.dto.response.board.PatchBoardResponseDto;
import com.project.codematchr.dto.response.board.PostBoardResponseDto;
import com.project.codematchr.dto.response.board.PostCommentResponseDto;
import com.project.codematchr.dto.response.board.PutFavoriteResponseDto;
import com.project.codematchr.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @AuthenticationPrincipal String boardWriterEmail,
        @RequestBody @Valid PostBoardRequestDto requestBody
    ){
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(boardWriterEmail, requestBody);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
        @AuthenticationPrincipal String boardWriterEmail,
        @PathVariable Integer boardNumber, 
        @RequestBody @Valid PatchBoardRequestDto dto
    ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(boardWriterEmail, boardNumber, dto);
        return response;
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
        @AuthenticationPrincipal String userEmail,
        @PathVariable Integer boardNumber
    ){
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(userEmail, boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
        @PathVariable Integer boardNumber
    ){
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PostMapping("/{commentBoardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
        @AuthenticationPrincipal String commentUserEmail,
        @PathVariable Integer commentBoardNumber,
        @RequestBody @Valid PostcommentRequestDto requestbody
    ){
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(commentBoardNumber, commentUserEmail, requestbody);
        return response;
    }

    @PutMapping("/{favoriteBoardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
        @AuthenticationPrincipal String favoriteUserEmail,
        @PathVariable Integer favoriteBoardNumber
    ){
        ResponseEntity<? super PutFavoriteResponseDto> response = boardService.putFavorite(favoriteBoardNumber, favoriteUserEmail);
        return response;
    }

    @GetMapping("/user-board-list/{writerEmail}")
    public ResponseEntity<? super GetUserListResponseDto> getUserBoardList(
        @PathVariable String writerEmail
    ){
        ResponseEntity<? super GetUserListResponseDto> response = boardService.getUserBoardList(writerEmail);
        return response;
    }

    @GetMapping("/{commentBoardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
        @PathVariable Integer commentBoardNumber
    ){
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(commentBoardNumber);
        return response;
    }

    @GetMapping("/{favoriteBoardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(
        @PathVariable Integer favoriteBoardNumber
    ){
        ResponseEntity<? super GetFavoriteListResponseDto> response = boardService.getFavoriteList(favoriteBoardNumber);
        return response;
    }
    
    @GetMapping("/search/{searchWord}")
    public ResponseEntity<? super GetSearchBoardResponseDto> getSearchBoard(
        @PathVariable String searchWord
    ){
        ResponseEntity<? super GetSearchBoardResponseDto> response = boardService.getSearchBoard(searchWord);
        return response;
    }
    
    @GetMapping("/top-3/current")
    public ResponseEntity<? super GetTop3CurrentListResponseDto> getTop3Current(){
        ResponseEntity<? super GetTop3CurrentListResponseDto> response = boardService.getTop3Current();
        return response;
    }

    @GetMapping("/top-3/comment")
    public ResponseEntity<? super GetTop3CommentListResponseDto> getTop3Comment(){
        ResponseEntity<? super GetTop3CommentListResponseDto> response = boardService.getTop3Comment();
        return response;
    }

    @GetMapping("/top-3/favorite")
    public ResponseEntity<? super GetTop3FavoriteListResponseDto> getTop3Favorite(){
        ResponseEntity<? super GetTop3FavoriteListResponseDto> response = boardService.getTop3Favorite();
        return response;
    }

    @GetMapping("/top-3/view")
    public ResponseEntity<? super GetTop3ViewListResponseDto> getTop3View(){
        ResponseEntity<? super GetTop3ViewListResponseDto> response = boardService.getTop3View();
        return response;
    }
    
    @GetMapping("/board-list/{section}")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList(
        @PathVariable Integer section
    ){
        ResponseEntity<? super GetBoardListResponseDto> response = boardService.getBoardList(section);
        return response;
    }

    @GetMapping("/board-list/view/{section}")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardViewList(
        @PathVariable Integer section
    ){
        ResponseEntity<? super GetBoardListResponseDto> response = boardService.getBoardViewList(section);
        return response;
    }

    @GetMapping("/board-list/favorite/{section}")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardFavoriteList(
        @PathVariable Integer section
    ){
        ResponseEntity<? super GetBoardListResponseDto> response = boardService.getBoardFavoriteList(section);
        return response;
    }
    
    @GetMapping("/board-list/comment/{section}")
    public ResponseEntity<? super GetBoardListResponseDto> getBoardCommentList(
        @PathVariable Integer section
    ){
        ResponseEntity<? super GetBoardListResponseDto> response = boardService.getBoardCommentList(section);
        return response;
    }

    @DeleteMapping("/comment/{commentNumber}")
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(
        @AuthenticationPrincipal String userEmail,
        @PathVariable Integer commentNumber
    ){
        ResponseEntity<? super DeleteCommentResponseDto> response = boardService.deleteComment(userEmail, commentNumber);
        return response;
    }

}

