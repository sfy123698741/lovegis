package com.lovegis.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heygis.util.ComparatorByAlphaImpl;
import com.heygis.util.ComparatorByDownImpl;
import com.heygis.util.ComparatorImpl;
import com.heygis.util.CompatatorByTimeImpl;
import com.lovegis.mapper.SourceMapper;
import com.lovegis.pojo.SourceFour;
import com.lovegis.pojo.SourceOne;
import com.lovegis.pojo.SourceThree;
import com.lovegis.pojo.SourceTwo;
@Service
public class SourceServie {
//	SourceDAOImpl sdi = null;
	ComparatorImpl comp = null;
	ComparatorByAlphaImpl compAlpha = null;
	ComparatorByDownImpl comDown = null;
	CompatatorByTimeImpl comTime = null;
	@Resource SourceMapper sourceMapper;
//	public SourceServie(){
//		sdi = new SourceDAOImpl();
//	}
	public List<SourceOne> getSourceOneList(String searchCtx){
		
		return sourceMapper.getSourceOne( searchCtx);
	}
	public List<SourceTwo> getSourceTwoList(String searchCtx){
		return sourceMapper.getSourceTwo( searchCtx);
	}
	public List<SourceThree> getSourceThreeList(String searchCtx){
		return sourceMapper.getSourceThree( searchCtx);
	}
	public List<SourceFour> getSourceFourList(String searchCtx){
		return sourceMapper.getSourceFour( searchCtx);
	}
	//按上传时间进行排序   
	//searchCtx 按条件查询时时 是name中包含的字符，非条件查询的时候是%  
	public List sort(String sourceType,String sortType,String searchCtx){
		//sortByTime
		List sourceList = null;
		switch(sourceType){
		case "1":
			//sourceList=new sourceon
			 sourceList = sourceMapper.getSourceOne("%"+searchCtx+"%");
			break;
		case "2":
			 sourceList = sourceMapper.getSourceTwo("%"+searchCtx+"%");
			break;
		case "3":
			sourceList = sourceMapper.getSourceThree("%"+searchCtx+"%");
			break;
		case "4":
			sourceList = sourceMapper.getSourceFour("%"+searchCtx+"%");
			break;
		}
		
		
		if (sortType=="sortByTime") {//按时间
			comTime = new CompatatorByTimeImpl();
			Collections.sort(sourceList, comTime);
			return sourceList;
		}
		if (sortType=="sortByDown"){
		comDown = new ComparatorByDownImpl();
		Collections.sort(sourceList, comDown);
		return sourceList; //按下载次数
		}
		if (sortType=="sortByFileSize"){
		comp = new ComparatorImpl();
		Collections.sort(sourceList, comp);
		return sourceList; //按文件大小
		}
		if (sortType=="sortByAlpha"){
			compAlpha = new ComparatorByAlphaImpl();
			Collections.sort(sourceList, compAlpha);
			return sourceList;//按文件名称
			}
		if (sortType=="searchByCtx"){
			/*for(SourceFour source : sourceFourList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}*/
			return sourceList;
			}
		
		
		
		
		return null;
	}
	
	
	{
	/*//按文件下载次数进行排序
	public List sortByDown(String sourceType){
		List sourceList = null;
		switch(sourceType){
		case "1":
			//sourceList=new sourceon
			 sourceList = sourceMapper.getSourceOne();
			break;
		case "2":
			 sourceList = sourceMapper.getSourceTwo();
			break;
		case "3":
			sourceList = sourceMapper.getSourceThree();
			break;
		case "4":
			sourceList = sourceMapper.getSourceFour();
			break;
		}
		comDown = new ComparatorByDownImpl();
		Collections.sort(sourceList, comDown);
		return sourceList;
			
	}
	//按文件大小进行排序
	public List sortByFileSize(String sourceType){
		List sourceList = null;
		switch(sourceType){
		case "1":
			//sourceList=new sourceon
			 sourceList = sourceMapper.getSourceOne();
			break;
		case "2":
			 sourceList = sourceMapper.getSourceTwo();
			break;
		case "3":
			sourceList = sourceMapper.getSourceThree();
			break;
		case "4":
			sourceList = sourceMapper.getSourceFour();
			break;
		}
		comp = new ComparatorImpl();
		Collections.sort(sourceList, comp);
		return sourceList;
		
		
	}
	//按文件名称进行排序
	public List sortByAlpha(String sourceType){
		List sourceList = null;
		switch(sourceType){
		case "1":
			//sourceList=new sourceon
			 sourceList = sourceMapper.getSourceOne();
			break;
		case "2":
			 sourceList = sourceMapper.getSourceTwo();
			break;
		case "3":
			sourceList = sourceMapper.getSourceThree();
			break;
		case "4":
			sourceList = sourceMapper.getSourceFour();
			break;
		}
	
			compAlpha = new ComparatorByAlphaImpl();
			Collections.sort(sourceList, compAlpha);
			return sourceList;
	
	}
	//按搜索条件进行排序
	public List searchByCtx(String sourceType,String searchCtx){
		List sourceList = null;
		switch(sourceType){
		case "1":
			//sourceList=new sourceon
			 sourceList = sourceMapper.getSourceOne();
			break;
		case "2":
			 sourceList = sourceMapper.getSourceTwo();
			break;
		case "3":
			sourceList = sourceMapper.getSourceThree();
			break;
		case "4":
			sourceList = sourceMapper.getSourceFour();
			break;
		}
		compAlpha = new ComparatorByAlphaImpl();
		Collections.sort(sourceList, compAlpha);
		return sourceList;
		
		for(SourceOne source : sourceList){
			String name = source.getName().toLowerCase();
			int result = name.indexOf(searchCtx.toLowerCase());
			if(result != -1){
				newlist.add(source);
			}
			return newlist;
			
			
			
		if(sourceType.equals("1")){
			List<SourceOne> newlist = new ArrayList<SourceOne>();
			List<SourceOne> sourceOneList = sourceMapper.getSourceOne();
			
			}
			return newlist;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> newlist = new ArrayList<SourceTwo>();
			List<SourceTwo> sourceTwoList = sourceMapper.getSourceTwo();
			for(SourceTwo source : sourceTwoList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		
		
		if(sourceType.equals("3")){
			List<SourceThree> newlist = new ArrayList<SourceThree>();
			List<SourceThree> sourceThreeList = sourceMapper.getSourceThree();
			for(SourceThree source : sourceThreeList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		if(sourceType.equals("4")){
			List<SourceFour> newlist = new ArrayList<SourceFour>();
			List<SourceFour> sourceFourList = sourceMapper.getSourceFour();
			for(SourceFour source : sourceFourList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		return null;
	}
	*
	*
	*/
	}
	
	public boolean addCount(String sourceName,String sourceType){
		//sourcefour
		if(sourceMapper.addCount(sourceName,sourceType)){
			return true;
		}
		return false;
	}
}
