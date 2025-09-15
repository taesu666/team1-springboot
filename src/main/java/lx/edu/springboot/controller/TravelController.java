package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lx.edu.springboot.dao.TravelDAO;
import lx.edu.springboot.vo.TravelVO;

@Controller
public class TravelController {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	TravelDAO dao;
	
	@RequestMapping("travel.do")
	public ModelAndView travel(/*@RequestParam("maxFive") String maxFive*/) throws Exception {
		ModelAndView result = new ModelAndView(); 
		
		//TravelVO mf = dao.getMaxFiveByResultFateId(resultFateID);
		//(유저네임 추가시)TravelVO un = dao.getUserNameByResultFateId(resultFateID);
		String maxFive = "화";
		List<TravelVO> recoList = dao.getRecommendedByMaxFive(maxFive);
		String bad = dao.getBadByMaxFive(maxFive);
		List<TravelVO> avList = dao.getAvoidByBad(bad);
		result.addObject("recommended", recoList);
		result.addObject("avoid", avList);
		result.setViewName("travel");
		return result;
	}
	
	@Value("${maps.api.key:}")
	private String mapsApiKey;
	
	@RequestMapping("travel/map.do")
	public ModelAndView map(@RequestParam("travelId") int travelId) throws Exception {
		ModelAndView result = new ModelAndView();
		TravelVO vo = dao.selectTravelDB(travelId);
		
		result.addObject("travel", vo);
		result.addObject("mapsApiKey", mapsApiKey);
		result.setViewName("travel_map");
		return result;
	}
	
	@RequestMapping("/conversation_select.do")
	public String conversation() {
		return "conversation_select";
	}
	
}

