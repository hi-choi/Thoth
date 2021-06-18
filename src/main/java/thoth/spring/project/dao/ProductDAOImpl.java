package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pdao")
public class ProductDAOImpl implements ProductDAO{

    @Autowired private SqlSession sqlSession;

    // 상품 조회 - snum부터 n개의 게시물 출력(현재는 10개로 설정)
    @Override
    public List<Product> selectProduct(int snum) {

        return sqlSession.selectList("product.selectProduct",snum);
    }

    // 상품 조회 - 전체 상품 수 구하기
    @Override
    public int selectCountProduct() {
        return sqlSession.selectOne("product.countProduct");
    }

    // 상품 조회 - 검색 기능
    @Override
    public List<Product> findSelectProduct(Map<String, Object> param) {
        return sqlSession.selectList("product.findSelect",param);
    }

    // 상품 조회 - 검색된 상품 수
    @Override
    public int selectCountProduct(Map<String, Object> param) {
        return sqlSession.selectOne("product.findSelectCount",param);
    }

    // 상품 상세 조회
    @Override
    public Product selectOneProduct(String tnum) {
        return sqlSession.selectOne("product.selectOne",tnum);
    }

    // 상품 등록
    @Override
    public int insertProduct(Product p){
        return sqlSession.insert("product.insertProduct",p);
    }
}