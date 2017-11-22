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

import mx.com.amx.unotv.oli.wsd.backoffice.dao.exception.NNotaDAOException;
import mx.com.amx.unotv.oli.wsd.backoffice.model.NNota;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NNotaDAO {
	private static Logger logger = Logger.getLogger(NNotaDAO.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<NNota> findAll() throws NNotaDAOException {
		List<NNota> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM OLI_MX_N_NOTA  ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {

			logger.error(" Error findAll  [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

	public List<NNota> findByIdCategoria(String idCategoria) throws NNotaDAOException {
		logger.info("--- findByIdCategoria  [NNotaDAO] ---- ");

		List<NNota> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM OLI_MX_N_NOTA WHERE FC_ID_CATEGORIA ='" + idCategoria + "'");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {

			logger.error(" Error findByIdCategoria [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

	public List<NNota> findByTipoNota(String tipoNota) throws NNotaDAOException {
		logger.info("--- findByTipoNota  [NNotaDAO] ---- ");

		List<NNota> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM OLI_MX_N_NOTA WHERE FC_TIPO_NOTA ='" + tipoNota + "'");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {

			logger.error(" Error findByTipoNota [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

	public List<NNota> findByIdClassVideo(String idClassVideo) throws NNotaDAOException {
		logger.info("--- findByIdClassVideo  [NNotaDAO] ---- ");

		List<NNota> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM OLI_MX_N_NOTA WHERE FC_ID_CLASS_VIDEO ='" + idClassVideo + "'");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {

			logger.error(" Error findByIdClassVideo [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

}
