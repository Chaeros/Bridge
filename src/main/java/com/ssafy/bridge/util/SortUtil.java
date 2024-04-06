package com.ssafy.bridge.util;

import java.util.List;

import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;

public class SortUtil {

	private static SortUtil sortUtil;

	private SortUtil() {

	}

	public static SortUtil getInstance() {
		if (sortUtil == null) {
			sortUtil = new SortUtil();
		}
		return sortUtil;
	}

	public void quickSort(List<FreeBoardResponse> list) {
		sort(list, 0, list.size() - 1);
	}

	private void sort(List<FreeBoardResponse> list, int low, int high) {
		if (low >= high)
			return;

		int mid = partition(list, low, high);
		sort(list, low, mid - 1);
		sort(list, mid, high);
	}

	private int partition(List<FreeBoardResponse> list, int low, int high) {
		int pivot = list.get((low + high) / 2).getHit();
		while (low <= high) {
			while (list.get(low).getHit() > pivot)
				low++;
			while (list.get(high).getHit() < pivot)
				high--;
			if (low <= high) {
				swap(list, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private void swap(List<FreeBoardResponse> list, int i, int j) {
		FreeBoardResponse tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
}
