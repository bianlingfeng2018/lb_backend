package com.libiao.customer.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制记录商品的服务，使用的时候注意INT的范围，以及符号位
 * */
public class CredentialByteUtil {


	//CNAS
	public static final int SERVICE_1 = 1;//01 1
	//CMA
	public static final int SERVICE_2 = 2;//10 2



    /**
     * @param productService 商品的服务代码
     * @param targetService  需要查询的服务代码
     * @return boolean 返回商品是否包含该服务
     */
	private static boolean getServiceStatus(int productService, int targetService){
		return (productService&targetService) == targetService;
	}

	/**
	 * 返回商品包含的服务
	 *
	 * @param productService
	 * @return
	 */
	public static List<Integer> getServiceString(int productService) {
		List<Integer> list = new ArrayList<>();
		if (productService == 0) {
			return list;
		}
		if (getServiceStatus(productService, SERVICE_1)) {
			list.add(SERVICE_1);
		}
		if (getServiceStatus(productService, SERVICE_2)) {
			list.add(SERVICE_2);
		}
		return list;
	}


}
