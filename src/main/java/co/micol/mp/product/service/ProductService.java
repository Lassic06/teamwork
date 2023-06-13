package co.micol.mp.product.service;

import java.util.List;

public interface ProductService {
	List<ProductVO> productList();
	
	ProductVO product(ProductVO vo);
	
	int productInsert(ProductVO vo);
}
