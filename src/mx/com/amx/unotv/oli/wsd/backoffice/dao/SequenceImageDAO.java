/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.exception.SequenceImageDAOException;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class SequenceImageDAO {

	private Logger LOG = Logger.getLogger(SequenceImageDAO.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int seq_NextVal() throws SequenceImageDAOException {
		LOG.debug("Inicia seq_NextVal en UtilDAO");
		try {
			final String query = "INSERT INTO  oli_seq_imagenes (id) value (null)";
			LOG.debug("query: " + query);

			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
					return pst;
				}
			}, keyHolder);
			return keyHolder.getKey().intValue();
		} catch (Exception e) {
			LOG.error("Error en seq_NextVal", e);
			throw new SequenceImageDAOException(e.getMessage());
		}
	}

}
