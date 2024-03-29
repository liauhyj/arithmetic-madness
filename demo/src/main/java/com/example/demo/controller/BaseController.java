package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Question;
import com.example.demo.service.GameService;

@Controller
public class BaseController 
{
	private List<Question> questionList = new ArrayList<>();
	private int score;
	
	@GetMapping("/game")
	public String game(Model model) 
	{
		score = 0;
		// arguments in the line below can be changed to increase the floor or ceiling of the integers present in the game.
		questionList = GameService.initializeQuestions(0, 12);
		model.addAttribute("question", questionList.get(0));
		model.addAttribute("score", score);
		return "game";
	}
	
	@ResponseBody
	@PostMapping("/validate")
	public ResponseEntity<?> validate(@ModelAttribute Question question, Model model)
	{
		if (GameService.isAnswerCorrect(question))
		{
			score++;
			questionList.remove(0);
			if (questionList.isEmpty())
			{
				model.addAttribute("question", new Question());
			}
			else
			{
				model.addAttribute("question", questionList.get(0));
			}
		}
		else
		{
			score--;
			model.addAttribute("question", questionList.get(0));
		}
		model.addAttribute("isAnswerCorrect", question.isAnswerCorrect());
		model.addAttribute("score", score);
		return ResponseEntity.ok(model);
	}
	
	@ResponseBody
	@PostMapping("/skip")
	public ResponseEntity<?> skip(@ModelAttribute Question question, Model model)
	{
		questionList.remove(0);
		if (questionList.isEmpty())
		{
			model.addAttribute("question", new Question());
		}
		else
		{
			model.addAttribute("question", questionList.get(0));
		}
		
		model.addAttribute("score", score);
		return ResponseEntity.ok(model);
	}
	
	@GetMapping("/complete")
	public String complete(Model model)
	{
		model.addAttribute("score", score);
		return "complete";
	}
	
	@GetMapping("/error")
	public String error(Model model)
	{
		return "error";
	}
}