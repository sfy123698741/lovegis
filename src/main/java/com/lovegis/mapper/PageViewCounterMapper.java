package com.lovegis.mapper;

import java.util.List;

public interface PageViewCounterMapper {
	int getLastNum();
	boolean store(int num, List<String> ip, List<Long> time, List<String> userAgent);
}
