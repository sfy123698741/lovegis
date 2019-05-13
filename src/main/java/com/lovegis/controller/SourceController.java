package com.lovegis.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.heygis.service.CreateHTMLService;
import com.lovegis.pojo.SourceFour;
import com.lovegis.pojo.SourceOne;
import com.lovegis.pojo.SourceThree;
import com.lovegis.pojo.SourceTwo;
import com.lovegis.service.SourceServie;

@Controller
public class SourceController {
	@Resource SourceServie sourceServie;
	public String source( Model model,String index) {
//		String index = request.getParameter("index");
		
		SourceServie sourceService = new SourceServie();
		List<SourceOne> sourceOneList = sourceService.getSourceOneList("%");
		List<SourceTwo> sourceTwoList = sourceService.getSourceTwoList("%");
		List<SourceThree> sourceThreeList = sourceService.getSourceThreeList("%");
		List<SourceFour> sourceFourList = sourceService.getSourceFourList("%");;
		
		model.addAttribute("sourceOneList",sourceOneList);
		model.addAttribute("sourceTwoList",sourceTwoList);
		model.addAttribute("sourceThreeList",sourceThreeList);
		model.addAttribute("sourceFourList",sourceFourList);
		model.addAttribute("index",index);
		return "forward:/source1.jsp";
//		request.getRequestDispatcher("/source1.jsp").forward(request, response);
	}
	public void Search() {
	/*	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		String sourceType = request.getParameter("sourceType");
		String searchCtx = request.getParameter("searchCtx");
		int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));
		Boolean loged = (Boolean)request.getAttribute("loged");
		List list = new SourceServie().searchByCtx(sourceType, searchCtx);
		if(list.size()==0){
			out.print("<div class='container'><h1 style='color:white;text-align:center'>啥也没有找到！</h1></div>");
		}else{
			int maxIndex = list.size()/15+1;
			String script = null;
			if(currPageNo > maxIndex){
				currPageNo = maxIndex;
				script ="<script>currPageNo"+sourceType+"="+maxIndex+"</script>";
			}
			String html = new CreateHTMLService(loged).createHTML(list, sourceType, currPageNo);	
			out.print(html+script);	  
		}*/
	}
}
