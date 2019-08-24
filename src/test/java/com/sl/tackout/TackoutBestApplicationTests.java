package com.sl.tackout;

import com.sl.tackout.mapper.BusinessMapper;
import com.sl.tackout.mapper.PermissionMapper;
import com.sl.tackout.pojo.BusinessTable;
import com.sl.tackout.pojo.PermissionTable;
import com.sl.tackout.pojo.UserTable;
import com.sl.tackout.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TackoutBestApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private BusinessMapper businessMapper;

	@Test
	public void contextLoads() {
//		Date date = new Date();
////		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//		System.out.println(date);
//		String a="userName";
//		if (!StringUtils.isEmpty(a)){
//			System.out.println("666");
//		}else {
//			System.out.println("违反");
//		}
//		UserTable aa = userService.findUserByLoginName("aa");
//		System.out.println(aa);
//		List<PermissionTable> aa = permissionMapper.findAllPermissionByUna("aa");
//		for (PermissionTable p:aa
//			 ) {
//			System.out.println(p);
//		}
		BusinessTable asd = businessMapper.findBusinessByLoginName("asd");
		System.out.println(asd);
	}

}
