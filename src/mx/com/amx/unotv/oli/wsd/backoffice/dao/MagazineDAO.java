/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.exception.MagazineDAOException;
import mx.com.amx.unotv.oli.wsd.backoffice.model.Magazine;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class MagazineDAO  {

	private static Logger logger = Logger.getLogger(MagazineDAO.class);
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Magazine> findAll() throws MagazineDAOException {
		logger.info("--- findAll  [MagazineDAO] ---- ");
		List<Magazine> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_c_magazine  ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Magazine>(Magazine.class));

		} catch (Exception e) {
			logger.error(" Error findAll  [ MagazineDAO ] ", e);
			throw new MagazineDAOException(e.getMessage());
		}

		return lista;
	}


	
	
	public void delete(String id) throws MagazineDAOException {
		logger.info("--- delete  [MagazineDAO] ---- ");
		StringBuilder query = new StringBuilder();
		query.append(" DELETE FROM oli_mx_c_magazine  WHERE FC_ID_MAGAZINE = '"+id+"'");

		try {

			jdbcTemplate.execute(query.toString());

		} catch (Exception e) {
			logger.error(" Error delete  [ MagazineDAO ] ", e);
			throw new MagazineDAOException(e.getMessage());
		}

		
	}

	
	public Magazine findById(String id) throws MagazineDAOException {
		logger.info("--- findById  [MagazineDAO] ---- ");
		List<Magazine> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_c_magazine   WHERE FC_ID_MAGAZINE = '"+id+"' ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Magazine>(Magazine.class));

		} catch (Exception e) {
			logger.error(" Error findById  [ MagazineDAO ] ", e);
			throw new MagazineDAOException(e.getMessage());
		}
		
		if (lista.isEmpty() || lista == null) {
			return null;
		}


		return lista.get(0);
	}
	
	
	public int insert(Magazine magazine) throws MagazineDAOException {
		logger.info("--- insert  [MagazineDAO] ---- ");
		int res=0;
		try {

			res = jdbcTemplate.update("INSERT INTO oli_mx_c_magazine (FC_ID_MAGAZINE,FC_DESCRIPCION,FC_URL_EXTERNA,FI_ORDEN,FI_ESTATUS) VALUES (?,?,?,?,?)", 
										magazine.getFcIdMagazine(),magazine.getFcDescripcion(),magazine.getFcUrlExterna(),magazine.getFiOrden(),magazine.getFiEstatus());

		} catch (Exception e) {
			logger.error(" Error insert  [ MagazineDAO ] ", e);
			throw new MagazineDAOException(e.getMessage());
		}

		return res;
	}


	
	public int update(Magazine magazine) throws MagazineDAOException {
		logger.info("--- update  [MagazineDAO] ---- ");
		int res=0;
		try {

			res = jdbcTemplate.update("UPDATE oli_mx_c_magazine SET FC_DESCRIPCION = ? , FC_URL_EXTERNA = ? , FI_ORDEN = ? , FI_ESTATUS = ? WHERE FC_ID_MAGAZINE = ?", 
									magazine.getFcDescripcion(),magazine.getFcUrlExterna(),magazine.getFiOrden(),magazine.getFiEstatus(),magazine.getFcIdMagazine());

		} catch (Exception e) {
			logger.error(" Error update  [ MagazineDAO ] ", e);
			throw new MagazineDAOException(e.getMessage());
		}

		return res;
	}

}
