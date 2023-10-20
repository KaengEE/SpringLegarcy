package com.demo.sample;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//요청을 받는 컨트롤러
@Controller
@RequestMapping("/book") 
public class BookController {
	
	@Autowired
	BookService bookService;
	
	//localhost:808/create 주소로 GET 요청 매핑
	@GetMapping("/create")
	public String create() {
		//요청시 이 메서드 실행하고 아래 JSP 뷰페이지 표시
		return "book/create";
	}
	
	@PostMapping("/create")
	public String createPost(@RequestParam Map<String, Object> map) {
		String bookId = bookService.create(map);
		if(bookId == null) {
			return "redirect:/book/create"; //redirect 이 주소로 다시 요청
		} else {
			return "redirect:/book/detail?bookId=" + bookId;
		}
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailMap = bookService.detail(map);
		//화면에 데이터를 전달하기 위해 Model 객체를 이용!
		model.addAttribute("data", detailMap); //data라는 이름으로 전달(request)
		
		String bookId = map.get("bookId").toString();
		model.addAttribute("bookId", bookId); //bookId는 따로 전달
		return "/book/detail";
	}
	
	//업데이트 하기전 책의 정보를 update페이지에 보여줌
	@GetMapping("/update")
	public String update(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailMap = bookService.detail(map);
		model.addAttribute("data", detailMap);
		return "/book/update";
	}
	
	//post 수정메서드
	@PostMapping("/update")
	public String updatePost(@RequestParam Map<String, Object> map, Model model) {
		boolean isUpateSuccess = bookService.edit(map);
		if(isUpateSuccess) {
			String bookId = map.get("bookId").toString();
			return "redirect:/book/detail?bookId="+bookId;
		} else {
			return "/book/update"; //다시 수정화면으로 되돌아감
		}
	}
	
	//post 삭제메서드
	@PostMapping("/delete")
	public String delete(@RequestParam Map<String, Object> map) {
		boolean isDeleteSuccess = bookService.remove(map);
		if(isDeleteSuccess) {
			return "redirect:/book/list";
		} else {
			String bookId = map.get("bookId").toString();
			return "redirect:/book/detail?bookId="+bookId;
		}
	}
	
	//목록
	@GetMapping("/list")
	public String list(@RequestParam Map<String, Object> map, Model model) {
		List<Map<String, Object>> list = bookService.list(map);
		model.addAttribute("data", list);
		if(map.containsKey("keyword")) {
			model.addAttribute("keyword", map.get("keyword"));
		}
		return "/book/list";
	}
}
