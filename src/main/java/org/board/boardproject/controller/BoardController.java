package org.board.boardproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.board.boardproject.domain.Board;
import org.board.boardproject.dto.BoardDeleteDto;
import org.board.boardproject.dto.BoardRegisterDto;
import org.board.boardproject.dto.BoardUpdateDto;
import org.board.boardproject.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(@RequestParam(name = "page", defaultValue = "1") int page,
                            @RequestParam(name = "size", defaultValue = "5") int size,
                            Model model) {

        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Board> boardList = boardService.findPaginated(pageable);

        model.addAttribute("boardList", boardList);
        model.addAttribute("currentPage", page);

        return "board/list";
    }

    @GetMapping("/view")
    public String getBoard(@RequestParam("id") Long id,
                          Model model) {

        Board board = boardService.findById(id);

        model.addAttribute("board", board);

        return "board/view";
    }

    @GetMapping("/writeform")
    public String registerBoardForm(Model model) {
        model.addAttribute("boardRegisterDto", new BoardRegisterDto());

        return "board/writeform";
    }

    @PostMapping("/write")
    public String registerBoard(@Valid @ModelAttribute("") BoardRegisterDto boardRegisterDto,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/writeform";
        }

        boardService.saveBoard(boardRegisterDto);

        return "redirect:/list";
    }

    @GetMapping("/deleteform")
    public String deleteBoardForm(@RequestParam("id") Long id,
                                  @ModelAttribute("msg") String msg,
                                  Model model) {

        BoardDeleteDto boardDeleteDto = new BoardDeleteDto();
        boardDeleteDto.setId(id);

        model.addAttribute("boardDeleteDto", boardDeleteDto);
        model.addAttribute("msg", msg);

        return "board/deleteform";
    }

    @PostMapping("/delete")
    public String deleteBoard(@ModelAttribute("boardDeleteDto") BoardDeleteDto boardDeleteDto,
                              RedirectAttributes redirectAttributes) {

        if (!boardService.verifyPassword(boardDeleteDto.getId(), boardDeleteDto.getPassword())) {
            redirectAttributes.addFlashAttribute("msg", "비밀번호가 잘못되었습니다. 다시 입력해주세요.");
            return "redirect:/deleteform?id=" + boardDeleteDto.getId();
        }

        boardService.deleteById(boardDeleteDto.getId());

        return "redirect:/list";
    }

    @GetMapping("/updateform")
    public String updateBoardForm(@RequestParam("id") Long id,
                                  Model model) {

        Board board = boardService.findById(id);

        BoardUpdateDto boardUpdateDto = new BoardUpdateDto();
        boardUpdateDto.setId(board.getId());
        boardUpdateDto.setName(board.getName());
        boardUpdateDto.setTitle(board.getTitle());
        boardUpdateDto.setContent(board.getContent());

        model.addAttribute("boardUpdateDto", boardUpdateDto);

        return "board/updateform";
    }

    @PostMapping("/update")
    public String updateBoard(@Valid @ModelAttribute("boardUpdateDto") BoardUpdateDto boardUpdateDto,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "board/updateform";
        }

        if (!boardService.verifyPassword(boardUpdateDto.getId(), boardUpdateDto.getPassword())) {
            return "board/updateform";
        }

        boardService.update(boardUpdateDto);

        return "redirect:/view?id="+boardUpdateDto.getId();
    }

}
