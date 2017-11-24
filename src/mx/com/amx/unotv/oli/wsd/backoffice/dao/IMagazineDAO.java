/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.dao;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.exception.IMagazineDAOException;
import mx.com.amx.unotv.oli.wsd.backoffice.model.IMagazine;


/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IMagazineDAO {
	
	private static Logger logger = Logger.getLogger(IMagazineDAO.class);
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public List<IMagazine> findAll() throws IMagazineDAOException {
		logger.info("--- findAll  [IMagazineDAO] ---- ");
		
		List<IMagazine> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_i_nota_magazine  ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<IMagazine>(IMagazine.class));

		} catch (Exception e) {
			logger.error(" Error findAll  [ IMagazineDAO ] ", e);
			throw new IMagazineDAOException(e.getMessage());
		}
		
		if(lista ==  null || lista.isEmpty()) {
			
			return Collections.emptyList();
		}

		return lista;
	}


	
	
	public void delete(String idMagazine) throws IMagazineDAOException {
		logger.info("--- delete  [IMagazineDAO] ---- ");
		
		StringBuilder query = new StringBuilder();
		query.append(" DELETE FROM oli_mx_i_nota_magazine  WHERE FC_ID_MAGAZINE = '"+idMagazine+"'");

		try {

			jdbcTemplate.execute(query.toString());

		} catch (Exception e) {
			logger.error(" Error delete  [ IMagazineDAO ] ", e);
			throw new IMagazineDAOException(e.getMessage());
		}
	}

	
	public IMagazine findById(String idMagazine) throws IMagazineDAOException {
		logger.info("--- findById  [IMagazineDAO] ---- ");
		List<IMagazine> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_i_nota_magazine   WHERE FC_ID_MAGAZINE = '"+idMagazine+"' ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<IMagazine>(IMagazine.class));

		} catch (Exception e) {
			logger.error(" Error findById  [ IMagazineDAO ] ", e);
			throw new IMagazineDAOException(e.getMessage());
		}
		
		if (lista.isEmpty() || lista == null) {
			return null;
		}


		return lista.get(0);
	}


	
	public int insert(IMagazine imagazine) throws IMagazineDAOException {
		logger.info("--- insert  [IMagazineDAO] ---- ");
		int res=0;
		try {

			res = jdbcTemplate.update("INSERT INTO oli_mx_i_nota_magazine (FC_ID_MAGAZINE,FC_ID_CONTENIDO,FC_URL_EXTERNA,FI_ORDEN) VALUES (?,?,?,?)", 
										imagazine.getFcIdMagazine(),imagazine.getFcIdContenido(),imagazine.getFcUrlExterna(),imagazine.getFiOrden());

		} catch (Exception e) {
			logger.error(" Error insert  [ MagazineDAO ] ", e);
			throw new IMagazineDAOException(e.getMessage());
		}

		return res;
	}


}
