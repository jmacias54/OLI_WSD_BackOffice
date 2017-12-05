/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.oli.wsd.backoffice.dao.exception.CategoriaDAOException;
import mx.com.amx.unotv.oli.wsd.backoffice.model.Categoria;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class CategoriaDAO {
	
private static Logger logger = Logger.getLogger(IMagazineDAO.class);
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Categoria> findAll() throws CategoriaDAOException{
		logger.info("--- findall  [ CategoriaDAO ] ---- ");
		List<Categoria> lista = null;
		

		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_c_categoria ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));

		} catch (Exception e) {
			logger.error(" Error findall  [ CategoriaDAO ] ", e);
			throw new CategoriaDAOException(e.getMessage());
		}
		
		return lista;
		
	}

}
