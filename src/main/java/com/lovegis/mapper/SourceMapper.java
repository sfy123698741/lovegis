package com.lovegis.mapper;

import java.util.List;

import com.lovegis.pojo.SourceFour;
import com.lovegis.pojo.SourceOne;
import com.lovegis.pojo.SourceThree;
import com.lovegis.pojo.SourceTwo;



public interface SourceMapper {
	public List<SourceOne> getSourceOne( String searchCtx);
	public List<SourceTwo> getSourceTwo(String searchCtx);
	public List<SourceThree> getSourceThree(String searchCtx);
	public List<SourceFour> getSourceFour(String searchCtx);
	public boolean addCount(String sourceName,String sourceType);
}
