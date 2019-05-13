package com.lovegis.mapper;

import java.sql.Timestamp;
import java.util.List;

public interface PageViewCounterMapper {
	int getLastNum();
	boolean store( String ip,Timestamp timestamp, String userAgent);
}
