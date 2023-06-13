package co.micol.mp.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.mp.common.DataSource;
import co.micol.mp.product.service.ProductMapper;
import co.micol.mp.product.service.ProductService;
import co.micol.mp.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ProductMapper map = sqlSession.getMapper(ProductMapper.class);
	
	
	@Override
	public List<ProductVO> productList() {
		// TODO Auto-generated method stub
		return map.productList();
	}

	@Override
	public ProductVO product(ProductVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int productInsert(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productInsert(vo);
	}


}
