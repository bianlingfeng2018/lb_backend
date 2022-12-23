package com.libiao.customer.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public class BeanCopyUtil {

	private static final MapperFacade mapperFacade;

	static {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().useAutoMapping(true).mapNulls(true).build();
		mapperFacade = mapperFactory.getMapperFacade();
	}

	public static <S, D> void copy(S from, D to) {
		mapperFacade.map(from, to);
	}

	public static <S, D> D copy(S from, Class<D> clazz) {
		return mapperFacade.map(from, clazz);
	}

	public static MapperFacade getMapperFacade() {
		return mapperFacade;
	}

	public static <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
		return mapperFacade.mapAsList(source, destinationClass);
	}


	public static <S, D> List<D> copy(List<S> from, Class<D> clazz) {
		if (from == null || from.size() == 0) {
			return new ArrayList<>();
		}
		List<D> list = new ArrayList<>(from.size());
		from.forEach(source -> list.add(copy(source, clazz)));
		return list;
	}
}
