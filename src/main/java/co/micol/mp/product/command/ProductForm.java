package co.micol.mp.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mp.common.Command;

public class ProductForm implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 상품상세보기 호출
		return "product/productForm";
	}
}
