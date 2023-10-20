package com.demo.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user") //클래스에 적용 >> 모든 메서드에 적용
public class UserController {
	
	@Autowired
	UserService userService;
	
	//localhost:8080/user/create
	@GetMapping("/create")
	public String create() {
		return "user/create";
	}

	@PostMapping("/create")
	public String create(@RequestParam Map<String, Object> map) {
		String userId = userService.create(map);
		if(userId == null) {
			return "redirect:/user/create"; //redirect 이 주소로 다시 요청
		} else {
			return "redirect:/user/detail?userId=" + userId;
		}
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailMap = userService.detail(map);
		//화면에 데이터를 전달하기 위해 Model 객체를 이용!
		model.addAttribute("data", detailMap); //data라는 이름으로 전달(request)
		
		String userId = map.get("userId").toString();
		model.addAttribute("userId", userId); //userId는 따로 전달
		return "/user/detail";
	}
	
	//업데이트 하기전 유저의 정보를 update페이지에 보여줌
	@GetMapping("/update")
	public String update(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailMap = userService.detail(map);
		model.addAttribute("data", detailMap);
		return "/user/update";
	}
	
	//post 수정메서드
	@PostMapping("/update")
	public String updatePost(@RequestParam Map<String, Object> map, Model model) {
		boolean isUpateSuccess = userService.edit(map);
		if(isUpateSuccess) {
			String userId = map.get("userId").toString();
			return "redirect:/user/detail?userId="+userId;
		} else {
			return "/user/update"; //다시 수정화면으로 되돌아감
		}
	}
	
	
	//post 삭제메서드
	@PostMapping("/delete")
	public String delete(@RequestParam Map<String, Object> map) {
		boolean isDeleteSuccess = userService.delete(map);
		if(isDeleteSuccess) {
			return "redirect:/user/list";
		} else {
			String userId = map.get("userId").toString();
			return "redirect:/user/detail?userId="+userId;
		}
	}
	
	//목록
	@GetMapping("/list")
	public String list(@RequestParam Map<String, Object> map, Model model) {
		List<Map<String, Object>> list = userService.list(map);
		model.addAttribute("data", list);
		if(map.containsKey("keyword")) {
			model.addAttribute("keyword", map.get("keyword"));
		}
		return "/user/list";
	}
	
}
