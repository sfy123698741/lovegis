package com.lovegis.mapper;

import org.apache.ibatis.annotations.Param;

import com.heygis.beans.NewMember;

public interface MemberMapper {
	public int addMember(@Param("newMember") NewMember M);
}
