package com.product;

import java.sql.Connection;
import java.util.ArrayList;

import com.vo.Product;

import com.frame.Biz;
import com.frame.Dao;
public class ProductBiz extends Biz<Integer, Product> {
	Dao<Integer, Product> dao;
	public ProductBiz() {
		dao = new ProductDao();
	}

	@Override
	public void register(Product v) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.insert(v, con);
			// dao.insert(v, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public void remove(Integer k) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.delete(k, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public void modify(Product v) throws Exception {
		Connection con = null;
		try {
			con = getcon();
			dao.update(v, con);
			con.commit();
		} catch (Exception e) {
			
			con.rollback();
			throw e;

		} finally {
			close(con);
		}

	}

	@Override
	public Product get(Integer k) throws Exception {
		Connection con = null;
		Product u = null;
		try {
			con = getcon();
			u = dao.select(k, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
		return u;
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		ArrayList<Product> u = null;
		Connection con = null;
		try {
			con = getcon();
			u = dao.select(con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
		return u;
	}

}
