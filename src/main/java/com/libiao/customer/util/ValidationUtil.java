package com.libiao.customer.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtil {

	private static Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * @Description: 校验方法
	 * @param t 将要校验的对象
	 */
	public static <T> String validate(T t) {
		Set<ConstraintViolation<T>> set = validator.validate(t);
		if (set.size() > 0) {
			for (ConstraintViolation<T> val : set) {
				return val.getMessage();
			}
		}
		return null;
	}
}
